package services;

import manager.UserManager;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by franciscoraya on 9/2/17.
 */
public class KataService
{
    public String getName(String username) throws SQLException {
        HashMap result = UserManager.getUserByUsername(username);
        return (String) result.get("name");
    }
    public String getPassword(String username) throws SQLException {
        HashMap result = UserManager.getUserByUsername(username);
        return (String) result.get("password");
    }
}
