package com.commerce.model;

import com.commerce.services.GetConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDto {

    public UserDto() {
    }

    public boolean saveUser(UserDao user) throws java.sql.SQLException {
        boolean flag = false;
        Connection con = GetConnection.getConnectin();
        if (con != null) {
            try {
                String query = "insert into user(name, email, password, phone, gender, address, city, pincode, state) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, user.getUserName());
                psmt.setString(2, user.getUserEmail());
                psmt.setString(3, user.getUserPassword());
                psmt.setString(4, user.getUserPhone());
                psmt.setString(5, user.getUserGender());
                psmt.setString(6, user.getUserAddress());
                psmt.setString(7, user.getUserCity());
                psmt.setString(8, user.getUserPincode());
                psmt.setString(9, user.getUserState());

                psmt.executeUpdate();
                flag = true;

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return flag;
    }

    public boolean userLogin(UserDao user) {
        Connection con = GetConnection.getConnectin();
        boolean flag = false;
        ResultSet rs = null;
        if (con != null) {
            try {
                String query = "select * from user where email = ? and password = ?";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, user.getUserEmail());
                psmt.setString(2, user.getUserPassword());
                System.out.println(user.getUserEmail()+"+++++++5555555555");
                System.out.println(user.getUserPassword()+"888888888");

                ResultSet set = psmt.executeQuery();
                while (set.next()) {

                    user.setUserId(set.getInt("userid"));
                    user.setUserName(set.getString("name"));
                    System.out.println("----------------------"); 
                   System.out.println(set.getString("name"));
                    System.out.println("----------------------"); 
                    user.setUserEmail(set.getString("email"));
                    user.setUserPassword(set.getString("password"));
                    user.setUserPhone(set.getString("phone"));
                    user.setUserGender(set.getString("gender"));
//				user.setDateTime(set.getTimestamp("registerdate"));
                    user.setUserAddress(set.getString("address"));
                    user.setUserCity(set.getString("city"));
                    user.setUserPincode(set.getString("pincode"));
                    user.setUserState(set.getString("state"));
                    flag = true;
                }

            } catch (SQLException e) {
                System.out.println(e+"-------------");
            }
        }
        return flag;
    }

}
