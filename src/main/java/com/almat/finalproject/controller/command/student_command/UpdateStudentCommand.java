package com.almat.finalproject.controller.command.student_command;

import com.almat.finalproject.constants.RequestParamsConstants;
import com.almat.finalproject.controller.command.CommandStrategy;
import com.almat.finalproject.model.dao.implementation.DAOFactory;
import com.almat.finalproject.model.dao.implementation.StudentDAOImpl;
import com.almat.finalproject.model.entity.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStudentCommand extends CommandStrategy {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        dao = DAOFactory.getDao(DAOFactory.DAOTypes.STUDENT);
        requestParamsConstants = RequestParamsConstants.getInstance();
        String firstName = request.getParameter(requestParamsConstants.getFirstNameParam());
        String lastName = request.getParameter(requestParamsConstants.getLastNameParam());
        String email = request.getParameter(requestParamsConstants.getEmailParam());
        int id = Integer.parseInt(request.getParameter(requestParamsConstants.getStudentIdParam()));
        //TODO: USE BOOLEAN RETURN VALUE OF THE METHOD
        ((StudentDAOImpl) dao).updateStudent(new Student
                .Builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build());
    }
}
