package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.ConsultationType;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.repo.LawyerJpaRepo;
import ua.thecoon.lawsys.service.AdminService;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public String getIndex(Model model) {
        String message = "Admin page with all defined requests, " +
                "requests using Jpa repositories " +
                "and admin can create a new lawyer";


        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    @PostMapping("/save/lawyer")
    public String saveLawyer(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("password") String password,
                             @RequestParam("specialization") ConsultationType specialization,
                             @RequestParam("yearsOfExperience") int yearsOfExperience,
                             @RequestParam("licenseNumber") String licenseNumber,
                             @RequestParam("officeAddress") String officeAddress,
                             @RequestParam("bio") String bio,
                             Model model) {
        LawyerJpaRepo lawyerJpaRepo = adminService.getLawyerJpaRepo();
        Lawyer lawyerByEmail = lawyerJpaRepo.findLawyerByEmail(email);

        if (lawyerByEmail != null) {
            model.addAttribute("error", "A client with this email already exists.");
            return "admin/admin-dashboard";
        }

        Lawyer lawyer = new Lawyer();

        lawyer.setName(name);
        lawyer.setEmail(email);
        lawyer.setPhoneNum(phone);
        lawyer.setPassword(password);
        lawyer.setSpecialization(specialization);
        lawyer.setYearsOfExperience(yearsOfExperience);
        lawyer.setLicenseNumber(licenseNumber);
        lawyer.setOfficeAddress(officeAddress);
        lawyer.setBio(bio);

        lawyerJpaRepo.save(lawyer);

        return "redirect:admin/lawyers";
    }

    @GetMapping("/lawyers")
    public String getAllLawyers(Model model) {
        List<Lawyer> allLawyers = adminService.getAllLawyers();


        model.addAttribute("data", allLawyers);
        model.addAttribute("type", "lawyers");
        model.addAttribute("message", "Displaying all lawyers by jpa repo");

        return "admin/admin-dashboard";
    }

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        List<Client> allClients = adminService.getAllClients();

        model.addAttribute("data", allClients);
        model.addAttribute("type", "clients");
        model.addAttribute("message", "Displaying all clients by jpa repo");


        return "admin/admin-dashboard";
    }

    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {
        List<Consultation> allConsultations = adminService.getAllConsultations();

        model.addAttribute("data", allConsultations);
        model.addAttribute("type", "consultations");
        model.addAttribute("message", "Displaying all consultations by jpa repo");

        return "admin/admin-dashboard";
    }


    @GetMapping("/clients-consul-date")
    public String getClientByConsulDate(Model model) {
        List<Consultation> byDate = adminService.getAllClientsByConsultDate();

        String message = "Query 1 select from multiple tables with sorting: " +
                " list of consultations with a lawyer " +
                "and a client sorted by date.";

        model.addAttribute("data", byDate);
        model.addAttribute("type", "consultationsByDate");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    @GetMapping("/consultations/type-like")
    public String getConsultationsByTypeLike(Model model) {
        List<Consultation> allConsultations = adminService.getConsultationsByTypeLike("Crim");

        String message = "Query 2 of the selection condition " +
                "using the LIKE predicate: " +
                "select all consultations whose " +
                "type starts with 'Cri%'";


        model.addAttribute("data", allConsultations);
        model.addAttribute("type", "consultationsByType");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    @GetMapping("/lawyer-schedule-may")
    public String getLawyerScheduleForMay(Model model) {
        List<Object[]> lawyerScheduleForMay = adminService.getLawyerScheduleForMay();

        String message = "Query 3 selection conditions " +
                "using the BETWEEN predicate: " +
                "lawyers' schedule for the month of May";

        model.addAttribute("data", lawyerScheduleForMay);
        model.addAttribute("type", "lawyerScheduleForMay");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    @GetMapping("/client-count")
    public String getClientCount(Model model) {
        long clientCount = adminService.getClientCount();

        String message = "Query 4 aggregate function " +
                "without grouping: number of " +
                "clients in the database: ";

        model.addAttribute("message", message + clientCount);
        model.addAttribute("type", "clientCount");

        return "admin/admin-dashboard";
    }

    @GetMapping("/consultation-count-by-lawyer")
    public String getConsultationCountByLawyer(Model model) {
        List<Object[]> countOfConsulForEachClient = adminService.getCountOfConsulForEachClient();

        String message = "Query 5 aggregate function with grouping:" +
                " number of consultations for each client " +
                "with grouping relative to the number of consultations";


        model.addAttribute("data", countOfConsulForEachClient);
        model.addAttribute("type", "consulForClient");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    // Запит 6
    @GetMapping("/lawyer-most-consultations")
    public String getLawyerWithMostConsultations(Model model) {
        List<Lawyer> lawyerWithMostConsultations = adminService.getLawyerWithMostConsultations();

        String message = "Query 6 using the ALL or ANY predicate: " +
                "find the lawyer with the most consultations";

        model.addAttribute("data", lawyerWithMostConsultations);
        model.addAttribute("type", "mostLawyer");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    // Запит 7
    @GetMapping("/consultation-count-for-each-lawyer")
    public String getConsultationCountForEachLawyer(Model model) {
        List<Object[]> consultationCountForEachLawyer = adminService.getConsultationCountForEachLawyer();

        String message = "Query 7 correlated sub-query: " +
                "number of consultations for each lawyer";
        model.addAttribute("data", consultationCountForEachLawyer);
        model.addAttribute("type", "consulForLaw");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    // Запит 8.1
    @GetMapping("/clients-without-consultations-left-join")
    public String getClientsWithoutConsultationsLeftJoin(Model model) {
        List<Client> clientsWithoutConsultationsLeftJoin = adminService.getClientsWithoutConsultationsLeftJoin();

        String message = "Query 8 for objection using LEFT JOIN: " +
                "client without consultation";

        model.addAttribute("data", clientsWithoutConsultationsLeftJoin);
        model.addAttribute("type", "leftJoin");
        model.addAttribute("message", message);


        return "admin/admin-dashboard";
    }

    // Запит 8.2
    @GetMapping("/clients-without-consultations-not-in")
    public String getClientsWithoutConsultationsNotIn(Model model) {
        List<Client> clientsWithoutConsultationsNotIn = adminService.getClientsWithoutConsultationsNotIn();

        String message = "Query 8 for objection using IN: " +
                "client without consultation";

        model.addAttribute("data", clientsWithoutConsultationsNotIn);
        model.addAttribute("type", "notIn");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }

    // Запит 8.3
    @GetMapping("/clients-without-consultations-exists")
    public String getClientsWithoutConsultationsExists(Model model) {
        List<Client> clientsWithoutConsultationsExists = adminService.getClientsWithoutConsultationsExists();

        String message = "Query 8 for objection using EXІSTS: " +
                "client without consultation";

        model.addAttribute("data", clientsWithoutConsultationsExists);
        model.addAttribute("type", "exists");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }


    // Запит 9
    @GetMapping("/clients-and-lawyers-with-role")
    public String getClientsAndLawyersWithRole(Model model) {
        List<Object[]> clientsAndLawyersWithRole = adminService.getClientsAndLawyersWithRole();

        String message = "Query 9 UNION merge operation " +
                "with inclusion of a comment in each line: " +
                "a list of all system users " +
                "with a comment regarding their role";

        model.addAttribute("data", clientsAndLawyersWithRole);
        model.addAttribute("type", "users");
        model.addAttribute("message", message);

        return "admin/admin-dashboard";
    }
}