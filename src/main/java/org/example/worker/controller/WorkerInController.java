package org.example.worker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.worker.dao.ScheduleDAO;

import java.io.IOException;

@Log4j2
@WebServlet(value = "/login/worker/in")
public class WorkerInController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer wid = Integer.parseInt(req.getParameter("wid"));

        log.info("in - " + wid);


        try {
            ScheduleDAO.INSTANCE.otime(wid);
            resp.sendRedirect("/main");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
