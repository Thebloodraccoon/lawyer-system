package ua.thecoon.lawsys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.repo.ClientJpaRepo;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;
import ua.thecoon.lawsys.repo.CustomRepo;
import ua.thecoon.lawsys.repo.LawyerJpaRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final ClientJpaRepo clientJpaRepo;
    private final LawyerJpaRepo lawyerJpaRepo;
    private final ConsultationJpaRepo consultationJpaRepo;
    private final CustomRepo customRepo;

    public Lawyer saveLawyer(Lawyer lawyer) {
        return lawyerJpaRepo.save(lawyer);
    }

    @Transactional(readOnly = true)
    public List<Lawyer> getAllLawyers() {
        List<Lawyer> all = lawyerJpaRepo.findAll();

        all.forEach(lawyer -> {
            lawyer.setConsultations(null);
        });

        return all;
    }

    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        List<Client> all = clientJpaRepo.findAll();

        all.forEach(client -> {
            client.setConsultations(null);
        });

        return all;
    }

    @Transactional(readOnly = true)
    public List<Consultation> getAllConsultations() {
        List<Consultation> all = consultationJpaRepo.findAll();

        all.forEach(consultation -> {
            consultation.setPayments(null);
            consultation.setClient(null);
            consultation.setLawyer(null);
        });

        return all;
    }

    // Запит 1 вибір з декількох таблиць із сортуванням
    @Transactional(readOnly = true)
    public List<Object[]> getAllClientsByConsultDate() {
        String jpql = "SELECT c, cl.name AS client_name, l.name AS lawyer_name " +
                    "FROM Consultation c " +
                    "JOIN c.lawyer l " +
                    "JOIN c.client cl " +
                    "ORDER BY c.date DESC";


        List<Object[]> results  = customRepo.executeQuery(jpql);
        List<Consultation> consultations = new ArrayList<>();

        for (Object[] result : results) {
            Consultation consultation = (Consultation) result[0];
            consultation.setPayments(null);
            consultation.setClient(null);
            consultation.setLawyer(null);
        }

        return results;
    }

    // Запит 2 умови відбору з використанням предиката LІKE
    @Transactional(readOnly = true)
    public List<Consultation> getConsultationsByTypeLike(String type) {
        String jpql = "SELECT c FROM Consultation c WHERE c.consulType LIKE '%" + type + "%'";
        List<Consultation> types = customRepo.executeQuery(jpql);

        types.forEach(consultation -> {
            consultation.setPayments(null);
            consultation.setClient(null);
            consultation.setLawyer(null);
        });

        return types;
    }

    // Запит 3 умови відбору з використанням предиката BETWEEN
    @Transactional(readOnly = true)
    public List<Object[]> getLawyerScheduleForMay() {
        String sql = "SELECT s.date as dates, l.name AS lawyer_name, c.name AS consultation_name " +
                "FROM t_schedule s " +
                "JOIN t_consultation c ON s.consultation_id = c.id " +
                "JOIN t_lawyer l ON s.lawyer_id = l.id " +
                "WHERE s.date BETWEEN '2024-05-01' AND '2024-05-31'";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 4 агрегатна функція без угруповання
    @Transactional(readOnly = true)
    public long getClientCount() {
        String jpql = "SELECT COUNT(c) FROM Client c";
        return (long) customRepo.executeQuery(jpql).get(0);
    }

    // Запит 5 Агрегатна функція з угрупованням (кількість консультацій у юриста)
    @Transactional(readOnly = true)
    public List<Object[]> getConsultationCountByLawyer() {
        String sql = "SELECT c.lawyer_id, COUNT(*) AS consultation_count, l.name AS lawyer_name " +
                "FROM t_consultation c " +
                "JOIN t_lawyer l ON c.lawyer_id = l.id " +
                "GROUP BY c.lawyer_id, l.name " +
                "ORDER BY consultation_count DESC";

        return customRepo.executeNativeQuery(sql);
    }

    // Запит 6 використання предиката ALL або ANY
    @Transactional(readOnly = true)
    public List<Lawyer> getLawyerWithMostConsultations() {
        String sql = "SELECT id, name FROM t_lawyer WHERE id = ALL (" +
                "    SELECT lawyer_id FROM t_consultation " +
                "    GROUP BY lawyer_id " +
                "    HAVING COUNT(*) >= ALL (" +
                "        SELECT COUNT(*) FROM t_consultation " +
                "        GROUP BY lawyer_id" +
                "    )" +
                ")";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 7 Корельований підзапит
    @Transactional(readOnly = true)
    public List<Object[]> getConsultationCountForEachLawyer() {
        String sql = "SELECT name, (SELECT COUNT(*) FROM t_consultation WHERE lawyer_id = l.id) AS consultation_count " +
                "FROM t_lawyer l";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 8 LEFT JOІN
    @Transactional(readOnly = true)
    public List<Client> getClientsWithoutConsultationsLeftJoin() {
        String sql = "SELECT c.* FROM t_client c " +
                "LEFT JOIN t_consultation co ON c.id = co.client_id " +
                "WHERE co.client_id IS NULL";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 8 In
    @Transactional(readOnly = true)
    public List<Client> getClientsWithoutConsultationsNotIn() {
        String sql = "SELECT * FROM t_client WHERE id NOT IN (SELECT client_id FROM t_consultation)";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 8 EXІSTS
    @Transactional(readOnly = true)
    public List<Client> getClientsWithoutConsultationsExists() {
        String sql = "SELECT * FROM t_client c " +
                "WHERE NOT EXISTS (SELECT 1 FROM t_consultation co WHERE co.client_id = c.id)";
        return customRepo.executeNativeQuery(sql);
    }

    // Запит 9 UNІON
    @Transactional(readOnly = true)
    public List<Object[]> getClientsAndLawyersWithRole() {
        String sql = "SELECT id, name, email, 'Client' AS role FROM t_client " +
                "UNION " +
                "SELECT id, name, email, 'Lawyer' AS role FROM t_lawyer";
        return customRepo.executeNativeQuery(sql);
    }
}