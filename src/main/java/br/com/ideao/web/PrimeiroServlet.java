package br.com.ideao.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/helloWorld")
public class PrimeiroServlet extends HttpServlet {
    protected  void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Primeiro servlet funcionando!!");
        System.out.println("Método - " + request.getMethod());
        response.getWriter().append("<html><h1>Hello World!</h1></html");
    }
}
