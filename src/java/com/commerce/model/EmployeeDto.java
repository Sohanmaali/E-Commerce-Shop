package com.commerce.model;

/**
 *
 * @author Sohan_Maali
 */
import com.commerce.services.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import com.eazydeals.entities.Admin;

public class EmployeeDto {

    public EmployeeDto() {

    }

    public boolean saveEmployee(EmployeeDao empDao) {
        boolean flag = false;
        Connection con = GetConnection.getConnectin();
        if (con != null) {
            try {
                String query = "insert into admin(name, email, password, phone) values(?, ?, ?, ?)";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, empDao.getName());
                psmt.setString(2, empDao.getEmail());
                psmt.setString(3, empDao.getPassword());
                psmt.setString(4, empDao.getPhone());

                psmt.executeUpdate();
                flag = true;

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return flag;
    }

    public boolean adminLogin(EmployeeDao empDao) {
        boolean flag = false;
        Connection con = GetConnection.getConnectin();
        if (con != null) {
            try {
                String email = empDao.getEmail();
                String password = empDao.getPassword();
                System.out.println("--------------" + email + "-------------");
                System.out.println("--------------" + password + "-------------");
                String query = "select * from admin where email = ? and password = ?";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, email);
                psmt.setString(2, password);

                ResultSet set = psmt.executeQuery();
                while (set.next()) {

                    empDao.setId(set.getInt("id"));
                    empDao.setName(set.getString("name"));
                    empDao.setEmail(set.getString("email"));
                    empDao.setPassword(set.getString("password"));
                    empDao.setPhone(set.getString("phone"));
                    flag = true;
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return flag;
    }

//    public List<EmployeeDao> getAllEmployee() {
//        List<EmployeeDao> list = new ArrayList<EmployeeDao>();
//        try {
//
//            String query = "select * from admin";
//            Statement statement = this.con.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                Admin admin = new Admin();
//                admin.setId(rs.getInt("id"));
//                admin.setName(rs.getString("name"));
//                admin.setEmail(rs.getString("email"));
//                admin.setPhone(rs.getString("phone"));
//                admin.setPassword(rs.getString("password"));
//
//                list.add(admin);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    public boolean deleteAdmin(int id) {
        boolean flag = false;
        Connection con = GetConnection.getConnectin();
        if (con != null) {
            try {
                String query = "delete from admin where id = ?";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, id);
                psmt.executeUpdate();
                flag = true;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return flag;
    }
}
