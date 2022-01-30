package com.almat.finalproject.controller.command.user_command;

import com.almat.finalproject.constants.MappingConstants;
import com.almat.finalproject.constants.RequestParamsConstants;
import com.almat.finalproject.controller.command.CommandStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignOutUserCommand extends CommandStrategy {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ServletException {
        requestParamsConstants = RequestParamsConstants.getInstance();
        mappingConstants = MappingConstants.getInstance();
        HttpSession session = request.getSession();
        session.removeAttribute(requestParamsConstants.getUserNameParam());
        session.invalidate();
        response.sendRedirect(request.getContextPath() + mappingConstants.getPathToSignInPage());
    }

}
