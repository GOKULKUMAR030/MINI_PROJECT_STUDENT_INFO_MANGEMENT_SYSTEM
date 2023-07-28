package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AdminModel;
import utility.ConnectionManager;

public class AdminDao {

    // Get admin by username
    public AdminModel getAdminByUsername(String username) throws ClassNotFoundException {
        Connection dbConn = null;
        AdminModel admin = null;
        try {
            dbConn = ConnectionManager.getConnection();
            String SELECT = "SELECT * FROM admin WHERE admin_username=?";
            PreparedStatement ps = dbConn.prepareStatement(SELECT);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int adminId = rs.getInt("admin_id");
                String adminName = rs.getString("admin_name");
                String adminUsername = rs.getString("admin_username");
                String adminPassword = rs.getString("admin_password");
                admin = new AdminModel(adminId, adminName, adminUsername, adminPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dbConn != null) {
                    dbConn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }
}
