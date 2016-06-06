package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.exception.ConnectionDoesNotExistException;
import com.databasemanager.domain.exception.MustBeOwnerException;
import com.databasemanager.domain.model.DatabaseType;
import com.databasemanager.domain.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller()
@RequestMapping("/connection")
public class ConnectionController extends ControllerBase {

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping(value = "/", method = RequestMethod.GET, name = "connections")
    public String index(Model model) {
        model.addAttribute("connectionsList", connectionService.findConnectionsForCurrentAccount());
        model.addAttribute("databaseTypes", DatabaseType.values());
        if (!model.containsAttribute("connectionDTO")) {
            model.addAttribute("connectionDTO", new ConnectionDTO());
        }

        return "connection/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, name = "addConnection")
    public String add(@ModelAttribute @Valid ConnectionDTO connectionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.connectionDTO", bindingResult);
            redirectAttributes.addFlashAttribute("connectionDTO", connectionDTO);
            return "redirect:/connection/";
        }

        connectionService.createConnection(connectionDTO);
        return "redirect:/connection/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, name = "deleteConnection")
    public String delete(@RequestParam long connectionId, RedirectAttributes redirectAttributes) {
        try {
            this.connectionService.deleteConnection(connectionId);
        }
        catch (MustBeOwnerException ex) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", ex.getMessage());
        }
        catch (ConnectionDoesNotExistException ex) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", ex.getMessage());
        }

        return "redirect:/connection/";
    }
}
