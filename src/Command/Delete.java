package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Pakage.AccountBook;

public class Delete {

    public AccountBook findById(Connection conn, int id) {
        String sql = "SELECT id, indate, category, amount FROM AccountBook WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new AccountBook(
                        rs.getInt("id"),
                        null,
                        rs.getInt("amount"),
                        rs.getString("category"),
                        rs.getString("indate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteById(Connection conn, int id) {
        String sql = "DELETE FROM AccountBook WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}