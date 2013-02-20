package com.hunwardsen.maven.webapp;

import com.hunwardsen.maven.weather.WeatherService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WeatherServlet extends HttpServlet {
	
	/**
	 * http://localhost:8080/MavenWebApp/weather?zip=94104
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String zip = request.getParameter("zip");
		WeatherService weatherService = new WeatherService();
		PrintWriter out = response.getWriter();
		try {
			out.println(weatherService.retrieveForecast(zip));
		} catch (Exception e) {
			out.println("Error Retrieving Forecast: " + e.getMessage());
		}
		out.flush();
		out.close();
	}
}