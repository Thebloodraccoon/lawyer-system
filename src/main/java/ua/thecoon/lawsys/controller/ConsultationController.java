package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.*;
import ua.thecoon.lawsys.service.ClientService;
import ua.thecoon.lawsys.service.ConsultationService;
import ua.thecoon.lawsys.service.LawyerService;
import ua.thecoon.lawsys.service.ScheduleService;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ConsultationController {
    private final ClientService clientService;
    private final LawyerService lawyerService;
    private final ConsultationService consultationService;
    private final ScheduleService scheduleService;

    @GetMapping("/consultation/create/step1/{id}")
    public String createConsultationStep1(@PathVariable Long id,
                                          Model model) {
        model.addAttribute("clientId", id);

        return "consultation/create-consultation-step1";
    }

    @PostMapping("/consultation/create/step2/{id}")
    public String createConsultationStepTwo(@PathVariable Long id,
                                            @RequestParam("name") String name,
                                            @RequestParam("type") String type,
                                            Model model) {
        ConsultationType consultationType = ConsultationType.valueOf(type);
        List<Lawyer> lawyers = lawyerService.getLawyerByType(consultationType);
        double consultationCost = consultationService.getConsultationCost(consultationType);

        model.addAttribute("clientId", id);
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        model.addAttribute("cost", consultationCost);
        model.addAttribute("lawyers", lawyers);

        return "consultation/create-consultation-step2";
    }

    @PostMapping("/consultation/create/step3/{id}")
    public String createConsultationStepThree(@PathVariable Long id,
                                              @RequestParam("name") String name,
                                              @RequestParam("type") String type,
                                              @RequestParam("cost") double cost,
                                              @RequestParam("lawyer") Long lawyerId,
                                              Model model) {
        Lawyer lawyer = lawyerService.getLawyer(lawyerId);

        model.addAttribute("clientId", id);
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        model.addAttribute("cost", cost);
        model.addAttribute("lawyer", lawyer);

        return "consultation/create-consultation-step3";
    }

    @PostMapping("/consultation/create/save/{id}")
    public String createConsultationStepFour(@PathVariable Long id,
                                             @RequestParam("name") String name,
                                             @RequestParam("type") String type,
                                             @RequestParam("cost") double cost,
                                             @RequestParam("lawyer") Long lawyerId,
                                             @RequestParam("date") String date) {
        Lawyer lawyer = lawyerService.getLawyer(lawyerId);

        Consultation consultation = new Consultation();
        consultation.setName(name);
        consultation.setConsulType(ConsultationType.valueOf(type));
        consultation.setCost(cost);
        consultation.setLawyer(lawyer);
        consultation.setClient(clientService.getClient(id));
        consultation.setConsultationStatus(ConsultationStatus.Planned);
        consultation.setDate(LocalDateTime.parse(date));
        consultation.setPayments(null);


        consultationService.createConsultation(consultation);

        Schedule schedule = new Schedule();
        schedule.setDate(LocalDateTime.parse(date));
        schedule.setLawyer(lawyer);
        schedule.setConsultation(consultation);

        scheduleService.createSchedule(schedule);

        return "redirect:/client/" + id;
    }

}
