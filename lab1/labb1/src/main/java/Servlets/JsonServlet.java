package Servlets;

import Entity.MyEntity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MyEntity entity = new MyEntity("wbl", "4", "15$");
        ArrayList<MyEntity> data = new ArrayList<MyEntity>();
        data.add(entity);

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(mydata);
        out.flush();
    }
}
