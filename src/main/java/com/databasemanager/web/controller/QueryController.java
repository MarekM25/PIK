package com.databasemanager.web.controller;

import com.databasemanager.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/select")
    public String executeQuery() {
        try{
            List<String[]> results=queryService.executeSelectQuery("select * from account");
            for(String[] row:results){
                for(String tuple :row){
                    System.out.print(tuple +" | ");
                }
                System.out.println();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return "account/welcome";
    }
}
