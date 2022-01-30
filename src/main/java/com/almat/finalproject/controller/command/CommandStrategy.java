package com.almat.finalproject.controller.command;

import com.almat.finalproject.constants.MappingConstants;
import com.almat.finalproject.constants.RequestParamsConstants;
import com.almat.finalproject.model.dao.implementation.AbstractDAO;
import com.almat.finalproject.util.InputUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class CommandStrategy {
    protected InputUtil inputUtil;
    protected AbstractDAO dao;
    protected MappingConstants mappingConstants;
    protected RequestParamsConstants requestParamsConstants;

    protected abstract void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ServletException;
}
