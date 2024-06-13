package ua.thecoon.lawsys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.lawsys.model.dto.ClientDTO;
import ua.thecoon.lawsys.service.ClientService;



@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("client/{id}")
    public String getClient(@PathVariable int id,
                            Model model) {
        ClientDTO client = clientService.getClient((long) id);

        model.addAttribute("client", client);
        model.addAttribute("clientId", client.getId());
        return "client/client-profile";
    }

    @PostMapping("client/{id}/update")
    public String updateClientProfile(@PathVariable Long id,
                                      @ModelAttribute ClientDTO updatedClient) {

        clientService.updateClient(id, updatedClient);

        return "redirect:/client/" + id;
    }

    @DeleteMapping("/client/{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        boolean b = clientService.deleteClient(id);
        
        return "index";
    }

    @PostMapping("/client/consultation/delete/{clientId}/{consultationId}")
    public String deleteClientConsultation(@PathVariable Long clientId,
                                           @PathVariable Long consultationId) {
        clientService.deleteClientConsultation(consultationId);

        return "redirect:/client/" + clientId;
    }
}
