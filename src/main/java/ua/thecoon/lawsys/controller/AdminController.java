package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.service.AdminService;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public String getIndex() {
        return "admin/admin-dashboard";
    }


    @PostMapping("/save-lawyer")
    public Lawyer saveLawyer(@RequestBody Lawyer lawyer) {
        return adminService.saveLawyer(lawyer);
    }

    @GetMapping("/lawyers")
    public String getAllLawyers(Model model) {
        List<Lawyer> allLawyers = adminService.getAllLawyers();


        model.addAttribute("data", allLawyers);
        model.addAttribute("type", "lawyers");

        return "admin/admin-dashboard";
    }

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        List<Client> allClients = adminService.getAllClients();

        model.addAttribute("data", allClients);
        model.addAttribute("type", "clients");

        return "admin/admin-dashboard";
    }

    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {
        List<Consultation> allConsultations = adminService.getAllConsultations();

        model.addAttribute("data", allConsultations);
        model.addAttribute("type", "consultations");

        return "admin/admin-dashboard";
    }

//    @RequestParam String type
    @GetMapping("/consultations/type-like")
    public String getConsultationsByTypeLike(Model model) {
        List<Consultation> allConsultations = adminService.getConsultationsByTypeLike("Cr");

        model.addAttribute("data", allConsultations);
        model.addAttribute("type", "consultationsByType");

        return "admin/admin-dashboard";
    }

    @GetMapping("/clients-consul-date")
    public String getClientByConsulDate(Model model) {
        List<Consultation> byDate = adminService.getAllClientsByConsultDate();

        model.addAttribute("data", byDate);
        model.addAttribute("type", "consultationsByDate");

        return "admin/admin-dashboard";
    }

    @GetMapping("/lawyer-schedule-may")
    public String getLawyerScheduleForMay(Model model) {
        List<Object[]> lawyerScheduleForMay = adminService.getLawyerScheduleForMay();

        model.addAttribute("data", lawyerScheduleForMay);
        model.addAttribute("type", "lawyerScheduleForMay");

        return "admin/admin-dashboard";
    }

    @GetMapping("/client-count")
    public String getClientCount(Model model) {
        long clientCount = adminService.getClientCount();
        return "admin/admin-dashboard";
    }

    @GetMapping("/consultation-count-by-lawyer")
    public String getConsultationCountByLawyer(Model model) {
        List<Object[]> countOfConsulForEachClient = adminService.getCountOfConsulForEachClient();

        model.addAttribute("data", countOfConsulForEachClient);
        model.addAttribute("type", "consulForClient");

        return "admin/admin-dashboard";
    }

    // Запит 6
    @GetMapping("/lawyer-most-consultations")
    public String getLawyerWithMostConsultations(Model model) {
        List<Lawyer> lawyerWithMostConsultations = adminService.getLawyerWithMostConsultations();

        model.addAttribute("data", lawyerWithMostConsultations);
        model.addAttribute("type", "mostLawyer");

        return "admin/admin-dashboard";
    }

    // Запит 7
    @GetMapping("/consultation-count-for-each-lawyer")
    public String getConsultationCountForEachLawyer(Model model) {
        List<Object[]> consultationCountForEachLawyer = adminService.getConsultationCountForEachLawyer();

        model.addAttribute("data", consultationCountForEachLawyer);
        model.addAttribute("type", "consulForLaw");

        return "admin/admin-dashboard";
    }

    // Запит 8.1
    @GetMapping("/clients-without-consultations-left-join")
    public String getClientsWithoutConsultationsLeftJoin(Model model) {
        List<Client> clientsWithoutConsultationsLeftJoin = adminService.getClientsWithoutConsultationsLeftJoin();

        model.addAttribute("data", clientsWithoutConsultationsLeftJoin);
        model.addAttribute("type", "leftJoin");

        return "admin/admin-dashboard";
    }

    // Запит 8.2
    @GetMapping("/clients-without-consultations-not-in")
    public String getClientsWithoutConsultationsNotIn(Model model) {
        List<Client> clientsWithoutConsultationsNotIn = adminService.getClientsWithoutConsultationsNotIn();

        model.addAttribute("data", clientsWithoutConsultationsNotIn);
        model.addAttribute("type", "notIn");

        return "admin/admin-dashboard";
    }

    // Запит 8.3
    @GetMapping("/clients-without-consultations-exists")
    public String getClientsWithoutConsultationsExists(Model model) {
        List<Client> clientsWithoutConsultationsExists = adminService.getClientsWithoutConsultationsExists();

        model.addAttribute("data", clientsWithoutConsultationsExists);
        model.addAttribute("type", "exists");


        return "admin/admin-dashboard";
    }


    // Запит 9
    @GetMapping("/clients-and-lawyers-with-role")
    public String getClientsAndLawyersWithRole(Model model) {
        List<Object[]> clientsAndLawyersWithRole = adminService.getClientsAndLawyersWithRole();

        model.addAttribute("data", clientsAndLawyersWithRole);
        model.addAttribute("type", "users");

        return "admin/admin-dashboard";
    }
}