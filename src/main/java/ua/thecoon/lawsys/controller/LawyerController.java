package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.model.entity.Schedule;
import ua.thecoon.lawsys.service.LawyerService;
import ua.thecoon.lawsys.service.ScheduleService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LawyerController {
    private final LawyerService lawyerService;
    private final ScheduleService scheduleService;

    @GetMapping("lawyer/{id}")
    public String getLawyer(@PathVariable Long id, Model model) {
        Lawyer lawyer = lawyerService.getLawyer(id);
        model.addAttribute("lawyer", lawyer);

        return "lawyer/lawyer-profile";
    }


    @PostMapping("lawyer/{id}/update")
    public String updateLawyerProfile(@PathVariable Long id,
                                      @ModelAttribute Lawyer lawyer) {
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
