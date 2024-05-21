package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.service.ClientService;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());

        return "view-clients";
    }

    @GetMapping("client/{id}")
    public String getClient(@PathVariable int id, Model model) {
        Client client = clientService.getClient((long) id);

        model.addAttribute("client", client);
        model.addAttribute("clientId", client.getId());
        return "client/client-profile";
    }

    @PostMapping("client/{id}/update")
    public String updateClientProfile(@PathVariable Long id,
                                      @ModelAttribute Client updatedClient) {
        clientService.updateClient(id, updatedClient);

        return "redirect:/client/" + id;
    }

    @DeleteMapping("/client/{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        boolean b = clientService.deleteClient(id);
        
        return "index";
    }
}
