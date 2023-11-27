package com.commerce.controlar;

import com.commerce.model.UserDao;
import com.commerce.model.UserDto;
import com.commerce.other.Message;
//import com.mysql.cj.protocol.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
//import java.io.PrintWriter;

public class RegistrationControlar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String userName = request.getParameter("user_name");
            String userEmail = request.getParameter("user_email");
            String userPassword = request.getParameter("user_password");
            String userPhone = request.getParameter("user_mobile_no");
            String userGender = request.getParameter("gender");
            String userAddress = request.getParameter("user_address");
            String userCity = request.getParameter("city");
            String userPincode = request.getParameter("pincode");
            String userState = request.getParameter("state");

            UserDao userDao = new UserDao(userName, userEmail, userPassword, userPhone, userGender, userAddress, userCity, userPincode, userState);
            UserDto userDto = new UserDto();
            boolean flag = userDto.saveUser(userDao);

            HttpSession session = request.getSession();
            Message message = null;
            if (flag) {
                response.sendRedirect("UserLogin.jsp");
                message = new Message("Registration Successful !!", "success", "alert-success");
//                MailMessenger.successfullyRegister(userName, userEmail);
            } else {
                message = new Message("Something went wrong! Try again!!", "error", "alert-danger");
                response.sendRedirect("UserRegistration.jsp");
            }
            session.setAttribute("message", message);

        } catch (IOException | SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
