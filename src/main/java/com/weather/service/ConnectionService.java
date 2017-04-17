package com.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.entity.CityWeather;
import com.weather.enums.Cities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ConnectionService {

    private final static String MY_CODE = "appid=45979b2b52c31f24d370da827122737f";
    private final static String DEMO_CODE = "appid=b1b15e88fa797225412429c1c50c122a1";
    private final static String CITY = "q=London";
    private final static String BASE_URL_DEMO = "http:/samples.openweathermap.org/data/2.5/find";
    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public CityWeather getWeater(Cities c) {
        CityWeather weather = null;
        try {
            String FULL_URL
                    = String.format("%s?q=%s&units=metric&%s", BASE_URL, c.getName(), MY_CODE);
            System.out.println(FULL_URL);
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(FULL_URL);

            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.readEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);
            ObjectMapper mapper = new ObjectMapper();
            weather = mapper.readValue(output, CityWeather.class);
            weather.setName(c.getName());
            System.out.println("\n" + weather);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather;

    }
}
