package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.service.ClientService;

import java.util.List;


@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());

        return "view-clients";
    }

    @GetMapping("/{id}")
    public String getClient(@PathVariable int id, Model model) {
        Client client = clientService.getClient((long) id);
        List<Consultation> consultations = client.getConsultations();

        model.addAttribute("client", client);
        model.addAttribute("consultations", consultations);

        return "client-profile";
    }
}
