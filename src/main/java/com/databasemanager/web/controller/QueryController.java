package com.databasemanager.web.controller;

import com.databasemanager.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/select")
    public List<String[]> executeQuery() {
        try {
            List<String[]> results = queryService.executeSelectQuery("select * from account");
            for (String[] row : results) {
                for (String tuple : row) {
                    System.out.print(tuple + " | ");
                }
                System.out.println();
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
