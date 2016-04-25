package com.databasemanager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public abstract class ControllerBase {
    @Autowired
    protected HttpServletRequest context;
}
