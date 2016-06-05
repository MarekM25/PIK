package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.QueryResultDTO;
import com.databasemanager.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/select")
    public QueryResultDTO executeQuery() {
        try {
            QueryResultDTO queryResultDTO = queryService.executeQuery("INSERT INTO employee VALUES (7,'dupa')");
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
