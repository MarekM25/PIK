package com.databasemanager.web.controller;

import com.databasemanager.domain.dto.QueryDTO;
import com.databasemanager.domain.dto.QueryResultDTO;
import com.databasemanager.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public QueryResultDTO executeQuery(@RequestBody QueryDTO queryDTO) {
        try {
            QueryResultDTO queryResultDTO = queryService.executeQuery(queryDTO.getQueryText());
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
