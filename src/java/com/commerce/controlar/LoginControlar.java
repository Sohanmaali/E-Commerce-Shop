package com.commerce.controlar;

import com.commerce.model.EmployeeDao;
import com.commerce.model.EmployeeDto;
import com.commerce.model.UserDao;
import com.commerce.model.UserDto;
import com.commerce.other.*;
//import com.mysql.cj.protocol.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
//import java.io.PrintWriter;

public class LoginControlar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        if (login.trim().equals("user")) {
            try {
                UserDao userDao = new UserDao();
                UserDto userDto = new UserDto();
                String userEmail = request.getParameter("user_email");
                String userPassword = request.getParameter("user_password");
                userDao.setUserEmail(userEmail);
                userDao.setUserPassword(userPassword);
                // getting user through entered email and passsword
//                User user = userDao.getUserByEmailPassword(userEmail, userPassword);
                // storing current user in session
                HttpSession session = request.getSession();
                boolean b = userDto.userLogin(userDao);

                if (b) {
                    session.setAttribute("activeUser", userDao);
                    response.sendRedirect("UserDashBoard.jsp");
                } else {
                    Message message = new Message("Invalid details! Try again!!", "error", "alert-danger");
                    session.setAttribute("message", message);
                    response.sendRedirect("UserLogin.jsp");

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        } else if (login.trim().equals("admin")) {
            try {
                EmployeeDao employeeDao = new EmployeeDao();
                EmployeeDto employeeDto = new EmployeeDto();
                String userName = request.getParameter("email");
                String password = request.getParameter("password");
                employeeDao.setEmail(userName);
                employeeDao.setPassword(password);
               
//				Admin admin = adminDao.getAdminByEmailPassword(userName, password);
                HttpSession session = request.getSession();
                if (employeeDto.adminLogin(employeeDao)) {
                    session.setAttribute("activeEmployee", employeeDao);
                    response.sendRedirect("EmployeeDashboard.jsp");
                } else {
                    Message message = new Message("Invalid details! Try again!!", "error", "alert-danger");
                    session.setAttribute("message", message);
                    response.sendRedirect("EmployeeLogin.jsp");

                }
            } catch (IOException e) {
                System.out.println(e);
            }
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
