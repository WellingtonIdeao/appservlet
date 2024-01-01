package br.com.ideao.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cadastroAPI")
public class CadastroAPI extends HttpServlet {
    private List<Usuario> usuarios = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        this.usuarios.add(new Usuario("User 1", "user1@mail.com"));
        this.usuarios.add(new Usuario("User 2", "user2@mail.com"));
        this.usuarios.add(new Usuario("User 3", "user3@mail.com"));
        Gson gson = new Gson();
        String usuariosConvertidos = gson.toJson(usuarios);
//        ObjectMapper mapper = new ObjectMapper();
//        String usuariosConvertidos = mapper.writeValueAsString(usuarios);
        response.getWriter().append(usuariosConvertidos);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null){
            sb.append(line);
        }
        Gson gson = new Gson();
        Usuario user = gson.fromJson(sb.toString(), Usuario.class);
//        ObjectMapper mapper = new ObjectMapper();
//        Usuario user = mapper.readValue(sb.toString(), Usuario.class);
        this.usuarios.add(user);
        System.out.println(user);
        response.getWriter().append(sb.toString());


    }

    record Usuario(String name, String email){}
}
