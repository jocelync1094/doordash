package com.laioffer.introductiontointellij;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.introductiontointellij.entity.Customer;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Jocelyn!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // Hello
        JSONObject customer = new JSONObject();
        customer.put("email", "jocelync1094@gmail.com");
        customer.put("name", "Jocelyn Chang");
        response.getWriter().println(customer);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(IOUtils.toString(request.getReader()), Customer.class);

        System.out.println(customer.getEmail());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);

    }
    public void destroy() {
    }
}