package com.jsfcdijpa;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/olaMundo")
public class OlaMundo extends HttpServlet {

    @Inject
    Calculadora calculadora;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.getOutputStream().print("OLá Mundo! SOMA: " + calculadora.soma(2, 2));
    }
}
