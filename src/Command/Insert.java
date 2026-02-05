package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Pakage.AccountBook;

public class Insert {
    public int execute(Connection conn, AccountBook ab) {
        String sql = "INSERT INTO accountbook VALUES(id_seq.nextval, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ab.getType());
            ps.setInt(2, ab.getAmount());
            ps.setString(3, ab.getCategory());
            ps.setString(4, ab.getDate());
            
            return ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}