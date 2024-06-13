package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.dto.LawyerDTO;
import ua.thecoon.lawsys.service.LawyerService;
import ua.thecoon.lawsys.service.ScheduleService;

@Controller
@RequiredArgsConstructor
public class LawyerController {
    private final LawyerService lawyerService;
    private final ScheduleService scheduleService;

    @GetMapping("lawyer/{id}")
    public String getLawyer(@PathVariable Long id, Model model) {
        LawyerDTO lawyer = lawyerService.getLawyer(id);
        model.addAttribute("lawyer", lawyer);

        return "lawyer/lawyer-profile";
    }


    @PostMapping("lawyer/{id}/update")
    public String updateLawyerProfile(@PathVariable Long id,
                                      @ModelAttribute LawyerDTO lawyer) {
        lawyerService.updateLawyer(id, lawyer);

        return "redirect:/lawyer/" + id;
    }

    @GetMapping("/lawyers/schedule/{id}")
    public String updateLawyerProfile(@PathVariable Long id, Model model) {
        model.addAttribute("lawyerId", id);
        model.addAttribute("schedule", scheduleService.getSchedule());

        return "lawyer/lawyers-schedule";
    }
}
