package Servlets;

import Crud.CrudInterface;
import Entity.MyEntity;
import Data.Data;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    private List<MyEntity> li = new Data().getData();

    ServletConfigInterface servletConfig;
    CrudInterface crud;
    public Servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ArrayList<MyEntity> data = new ArrayList<MyEntity>();
        //data.add(crud.readEntity());

        String someJson = new Gson().toJson(li);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        //resp.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();



    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int id = Integer.parseInt(request.getParameter("id"));
        //String name = req.getParameter("name");
        //String places = req.getParameter("places");
        //String price = req.getParameter("price");

        //crud.updateEntity(new MyEntity(id, name, places, price));

        MyEntity watch = crud.watchParse(req);
        int id = Integer.parseInt((req.getPathInfo().substring(1)));
        resp.setContentType("application/json");
        int index = crud.getIndexByWatchId(id, li);
        li.set(index, watch);
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyEntity watch = crud.watchParse(req);
        watch.setId(crud.getNextId(li));
        li.add(watch);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        resp.setContentType("application/json");
        int index = crud.getIndexByWatchId(id, li);
        li.remove(index);
        doGet(req, resp);
    }
}
