package repository;

import DbUtil.DBUtil;
import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void saveUsersToDb(List<User> users) {
        String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertQuery)){
            for (User user : users) {
                pstmt.setString(1, user.name());
                pstmt.setString(2, user.email());
                pstmt.addBatch(); // Add to batch
            }
            int[] result = pstmt.executeBatch(); // Execute all inserts
            System.out.println(result.length + " users inserted into DB.");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsersFromDb(){
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM users";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement psmt = conn.prepareStatement(selectQuery);
            ResultSet rs =  psmt.executeQuery()){
            while(rs.next()){
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                users.add(user);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return users;
    }

}