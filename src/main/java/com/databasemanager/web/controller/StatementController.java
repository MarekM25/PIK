package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.StatementDTO;
import com.databasemanager.domain.dto.StatementResultDTO;
import com.databasemanager.domain.service.ConnectionService;
import com.databasemanager.domain.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/statement")
public class StatementController {

    @Autowired
    private StatementService statementService;

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("/execute")
    public String executeStatement(Model model) {
        List<ConnectionDTO> connectionList = connectionService.findConnectionsForCurrentAccount();
        model.addAttribute("connectionList",connectionList);
        return "/statement/executeStatement";
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public @ResponseBody StatementResultDTO executeStatement(@RequestBody StatementDTO statementDTO) {
        try {
            StatementResultDTO statementResultDTO = statementService.executeStatement(statementDTO);
            statementResultDTO.setSuccessful(true);
            return statementResultDTO;
        } catch (SQLException e) {
            StatementResultDTO statementResultDTO = new StatementResultDTO();
            statementResultDTO.setSuccessful(false);
            statementResultDTO.setErrorMessage(e.getMessage());
            return statementResultDTO;
        }
    }
}
