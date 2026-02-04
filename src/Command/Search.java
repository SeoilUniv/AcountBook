package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Pakage.AccountBook;

public class Search {

    public List<AccountBook> searchByDate(Connection conn, String date) {
        try {
            String sql = "select * from accountbook where date = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();

            List<AccountBook> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                int amount = rs.getInt("amount");
                String category = rs.getString("category");
                String d = rs.getString("date");

                list.add(new AccountBook(id, type, amount, category, d));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}