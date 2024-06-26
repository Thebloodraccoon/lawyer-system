package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.thecoon.lawsys.model.dto.ClientDTO;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.service.ClientService;
import ua.thecoon.lawsys.service.LawyerService;


@Controller
@RequiredArgsConstructor
public class LoginController {
    private final ClientService clientService;
    private final LawyerService lawyerService;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @PostMapping("/client/login")
    public String getClientLogin(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Model model) {
        Client existingClient = clientService.findClientByEmail(email);

        if (existingClient == null) {
            model.addAttribute("error", "Invalid email");
            return "index";
        }


        if (existingClient.getPassword().equals(password)) {
            return "redirect:/client/" + existingClient.getId();
        }

        model.addAttribute("error", "Invalid password");
        return "index";
    }

    @PostMapping("/employee/login")
    public String getEmployeeLogin(@RequestParam("employeeEmail") String email,
                                   @RequestParam("employeePassword") String password,
                                   Model model) {
        if (email.equals("admin") && password.equals("admin")) {
            return "redirect:/admin";
        }

        Lawyer lawyerByEmail = lawyerService.findLawyerByEmail(email);

        if (lawyerByEmail == null) {
            model.addAttribute("error", "Invalid email");
            return "index";
        }



        if (lawyerByEmail.getPassword().equals(password)) {
            return "redirect:/lawyer/" + lawyerByEmail.getId();
        }

        model.addAttribute("error", "Invalid password");
        return "index";
    }


    @PostMapping("/register")
    public String registerClient(@RequestParam("client-name") String name,
                                 @RequestParam("client-email") String email,
                                 @RequestParam("client-phone") String phone,
                                 @RequestParam("client-password") String password,
                                 Model model) {


        Client existingClient = clientService.findClientByEmail(email);

        if (existingClient != null) {
            model.addAttribute("error", "A client with this email already exists.");
            return "index";
        }


        Client newClient = new Client();
        newClient.setName(name);
        newClient.setEmail(email);
        newClient.setPhoneNum(phone);
        newClient.setPassword(password);

        ClientDTO savedClient = clientService.createClient(newClient);


        return "redirect:/client/" + savedClient.getId();
    }
}
