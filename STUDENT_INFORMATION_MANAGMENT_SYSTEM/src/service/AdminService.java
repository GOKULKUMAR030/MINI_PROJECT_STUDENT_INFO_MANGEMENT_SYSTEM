package service;

import dao.AdminDao;
import model.AdminModel;

public class AdminService {
    private AdminDao adminDao = new AdminDao();

    // Authenticate admin based on username and password
    public boolean authenticateAdmin(String username, String password) throws ClassNotFoundException {
        AdminModel admin = adminDao.getAdminByUsername(username);
        if (admin != null && admin.getAdminPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
}
