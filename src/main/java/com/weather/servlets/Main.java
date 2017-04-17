package com.weather.servlets;

import com.weather.entity.CityWeather;
import com.weather.enums.Cities;
import com.weather.service.ConnectionService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/app")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String city = request.getParameter("selectedCity");
        if (city == null) {
            response.sendRedirect("/");
            return;
        }
        Cities c = Cities.valueOf(city);

        ConnectionService service = new ConnectionService();
        CityWeather weather = service.getWeater(c);

        HttpSession session = request.getSession();
        session.setAttribute("cityWeather", weather);

        response.sendRedirect("/");
    }

}
