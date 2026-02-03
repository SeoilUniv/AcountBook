package sangyoon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleAccountBookDAO implements AccountBookDAO {

    Connection conn;

    public OracleAccountBookDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.97:1521:xe", "system", "1234");
            System.out.println("DB연결 성공!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert
    
    
    
    // findAll
    
    
    
    // update
    
    
    
    // delete
    
    
    

    // 검색
    @Override
    public List<AccountBook> findByDate(String date) {
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
