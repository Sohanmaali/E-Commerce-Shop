package com.commerce.controlar;

import com.commerce.model.UserDao;
import com.commerce.model.UserDto;
import com.mysql.cj.protocol.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
//import java ;

//import com.eazydeals.dao.AdminDao;
//import com.eazydeals.dao.UserDao;
//import com.eazydeals.entities.Admin;
//import com.eazydeals.entities.Message;
//import com.eazydeals.entities.User;
//import com.eazydeals.helper.ConnectionProvider;
public class UserLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        if (login.trim().equals("user")) {
            try {
//                UserDao userDao = new UserDao(userName, userEmail, userPassword, userPhone, userGender, userAddress, userCity, userPincode, userState);
                UserDao userDao = new UserDao();
                UserDto userDto = new UserDto();
                userDao.setUserEmail(request.getParameter("user_email"));
                userDao.setUserPassword(request.getParameter("user_password"));
                boolean b = userDto.userLogin(userDao);
                System.out.println(b + "-----111111----------");
                if (b) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", userDao.getUserId());
                    session.setAttribute("name", userDao.getUserName());
//                    session.setAttribute("father", userDao.getFather());
                    session.setAttribute("email", userDao.getUserEmail());
                    session.setAttribute("password", userDao.getUserPassword());
                    session.setAttribute("mobile", userDao.getUserPhone());
                    session.setAttribute("gender", userDao.getUserGender());
//                    session.setAttribute("RegistrationDate", userDao.getUser());
                    session.setAttribute("address", userDao.getUserAddress());
                    session.setAttribute("city", userDao.getUserCity());
                    session.setAttribute("pincode", userDao.getUserPincode());
                    session.setAttribute("state", userDao.getUserState());
//                    System.out.println(regidao.getName() + "----------------");
                    response.sendRedirect("UserDashBoard.jsp");
                } else {
                    HttpSession session = request.getSession();
//                     Message message = new Message("Invalid details! Try again!!", "error", "alert-danger");
                    String message = "Invalid details! Try again!!";
                    session.setAttribute("message", message);
                    response.sendRedirect("login.jsp");
                }
//                User user = userDao.getUserByEmailPassword(userEmail, userPassword);
                // storing current user in session
//                HttpSession session = request.getSession();
//                if (user != null) {
//                    session.setAttribute("activeUser", user);
//                    response.sendRedirect("index.jsp");
//                } else {
//                    Message message = new Message("Invalid details! Try again!!", "error", "alert-danger");
//                    session.setAttribute("message", message);
//                    response.sendRedirect("login.jsp");
//                    return;
//                }

            } catch (IOException e) {
            }
        } else if (login.trim().equals("admin")) {
//            try {
//                String userName = request.getParameter("email");
//                String password = request.getParameter("password");
//
////                AdminDao adminDao = new AdminDao(ConnectionProvider.getConnection());
////                Admin admin = adminDao.getAdminByEmailPassword(userName, password);
//                HttpSession session = request.getSession();
//                if (admin != null) {
//                    session.setAttribute("activeAdmin", admin);
//                    response.sendRedirect("admin.jsp");
//                } else {
////                    Message message = new Message("Invalid details! Try again!!", "error", "alert-danger");
////                    session.setAttribute("message", message);
//                    response.sendRedirect("adminlogin.jsp");
//                }
//            } catch (IOException e) {
//            }
        }
    }
}
