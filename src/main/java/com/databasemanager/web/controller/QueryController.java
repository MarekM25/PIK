package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.ConnectionDTO;
import com.databasemanager.domain.dto.QueryDTO;
import com.databasemanager.domain.dto.QueryResultDTO;
import com.databasemanager.domain.service.ConnectionService;
import com.databasemanager.domain.service.QueryService;
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
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("/execute")
    public String executeQuery(Model model) {
        List<ConnectionDTO> connectionList = connectionService.findConnectionsForCurrentAccount();
        model.addAttribute("connectionList",connectionList);
        return "/account/executeQuery";
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public @ResponseBody QueryResultDTO executeQuery(@RequestBody QueryDTO queryDTO) {
        try {
            QueryResultDTO queryResultDTO = queryService.executeQuery(queryDTO);
            queryResultDTO.setSuccessful(true);
            return queryResultDTO;
        } catch (SQLException e) {
            QueryResultDTO queryResultDTO = new QueryResultDTO();
            queryResultDTO.setSuccessful(false);
            queryResultDTO.setErrorMessage(e.getMessage());
            return queryResultDTO;
        }
    }
}
