package com.almat.finalproject.controller;

import com.almat.finalproject.constants.DBConstants;
import com.almat.finalproject.controller.command.CommandExecutor;
import com.almat.finalproject.model.jdbc.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    public final static Logger LOG = LogManager.getLogger("ControllerServletLogger");
    private CommandExecutor commandExecutor = null;

    @Override
    public void init() throws ServletException {
        commandExecutor = new CommandExecutor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        LOG.info("Processing request...");
        try {
            commandExecutor.executeCommand(req, resp);
        } catch (ClassNotFoundException e) {
            LOG.error(e);
        } catch (SQLException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error("Failed to read config file: " + e);
        }
    }

    @Override
    public void destroy() {
        try {
            DBConstants dbConstants = DBConstants.getInstance();
            DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance(
                    dbConstants.getDriver(), dbConstants.getUrl(), dbConstants.getUser(),
                    dbConstants.getPassword(), dbConstants.getPoolSize());
            dbConnectionPool.destroyPool();
        } catch (IOException e) {
            LOG.error(e);
        } catch (SQLException e) {
            LOG.error(e);
        } catch (ClassNotFoundException e) {
            LOG.error(e);
        }
    }
}
