package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Pakage.AccountBook;

public class findAll {

    public List<AccountBook> execute(Connection conn) {
        List<AccountBook> list = new ArrayList<>();
        String sql = "SELECT * FROM accountBook ORDER BY id ASC";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new AccountBook(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getInt("amount"),
                    rs.getString("category"),
                    rs.getString("date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}