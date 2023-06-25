package Servlets;

import Crud.CrudInterface;
import Entity.MyEntity;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    ServletConfigInterface servletConfig;
    CrudInterface crud;
    public Servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<MyEntity> data = new ArrayList<MyEntity>();
        data.add(crud.readEntity());

        String someJson = new Gson().toJson(data);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();



    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String places = req.getParameter("places");
        String price = req.getParameter("price");

        crud.updateEntity(new MyEntity(name, places, price));
    }
}
