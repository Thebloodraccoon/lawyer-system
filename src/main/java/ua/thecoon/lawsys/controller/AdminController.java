package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/save-lawyer")
    public Lawyer saveLawyer(@RequestBody Lawyer lawyer) {
        return adminService.saveLawyer(lawyer);
    }

    @GetMapping("/lawyers")
    public List<Lawyer> getAllLawyers() {
        List<Lawyer> allLawyers = adminService.getAllLawyers();
        return allLawyers;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        List<Client> allClients = adminService.getAllClients();
        return allClients;
    }

    @GetMapping("/consultations")
    public List<Consultation> getAllConsultations() {
        List<Consultation> allConsultations = adminService.getAllConsultations();
        return allConsultations;
    }

    @GetMapping("/consultations/type-like")
    public List<Consultation> getConsultationsByTypeLike(@RequestParam String type) {
        return adminService.getConsultationsByTypeLike(type);
    }

    @GetMapping("/clients-consul-date")
    public List<Object[]> getClientByConsulDate() {
        return adminService.getAllClientsByConsultDate();
    }

    @GetMapping("/lawyer-schedule-may")
    public List<Object[]> getLawyerScheduleForMay() {
        return adminService.getLawyerScheduleForMay();
    }

    @GetMapping("/client-count")
    public long getClientCount() {
        return adminService.getClientCount();
    }

    @GetMapping("/consultation-count-by-lawyer")
    public List<Object[]> getConsultationCountByLawyer() {
        return adminService.getConsultationCountByLawyer();
    }

    @GetMapping("/lawyer-most-consultations")
    public List<Lawyer> getLawyerWithMostConsultations() {
        return adminService.getLawyerWithMostConsultations();
    }

    @GetMapping("/consultation-count-for-each-lawyer")
    public List<Object[]> getConsultationCountForEachLawyer() {
        return adminService.getConsultationCountForEachLawyer();
    }

    @GetMapping("/clients-without-consultations-left-join")
    public List<Client> getClientsWithoutConsultationsLeftJoin() {
        return adminService.getClientsWithoutConsultationsLeftJoin();
    }

    @GetMapping("/clients-without-consultations-not-in")
    public List<Client> getClientsWithoutConsultationsNotIn() {
        return adminService.getClientsWithoutConsultationsNotIn();
    }

    @GetMapping("/clients-without-consultations-exists")
    public List<Client> getClientsWithoutConsultationsExists() {
        return adminService.getClientsWithoutConsultationsExists();
    }

    @GetMapping("/clients-and-lawyers-with-role")
    public List<Object[]> getClientsAndLawyersWithRole() {
        return adminService.getClientsAndLawyersWithRole();
    }
}