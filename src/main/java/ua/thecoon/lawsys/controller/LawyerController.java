package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.model.entity.Schedule;
import ua.thecoon.lawsys.service.LawyerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LawyerController {
    private final LawyerService lawyerService;

    @GetMapping("/lawyers")
    public String getAllLawyers(Model model) {
        List<Lawyer> lawyers = lawyerService.getAllLawyers();
        model.addAttribute("lawyers", lawyers);
        return "lawyers/list";
    }

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

}
