package com.almat.finalproject.controller.command.student_command;

import com.almat.finalproject.constants.RequestParamsConstants;
import com.almat.finalproject.controller.command.CommandStrategy;
import com.almat.finalproject.model.dao.implementation.DAOFactory;
import com.almat.finalproject.model.dao.implementation.StudentDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteStudentCommand extends CommandStrategy {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        requestParamsConstants = RequestParamsConstants.getInstance();
        dao = DAOFactory.getDao(DAOFactory.DAOTypes.STUDENT);
        //TODO: use bool
        ((StudentDAOImpl) dao).deleteStudent(request.getParameter(requestParamsConstants.getStudentIdParam()));
    }
}
