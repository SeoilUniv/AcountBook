package Pakage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Interface.AccountBookDAO;
import Pakage.AccountBook;

public class H2AccountBookDAO implements AccountBookDAO {

    Connection conn;

    public H2AccountBookDAO() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            System.out.println("DB연결 성공!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(AccountBook ab) {
        String sql = "INSERT INTO AccountBook (type, amount, category, date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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

    @Override
    public List<AccountBook> findAll() {
        String sql = "SELECT * FROM AccountBook ORDER BY id";
        List<AccountBook> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountBook(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getInt("amount"),
                    rs.getString("category"),
                    rs.getString("date")
                ));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public AccountBook findById(int id) {
        String sql = "SELECT * FROM AccountBook WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new AccountBook(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getInt("amount"),
                    rs.getString("category"),
                    rs.getString("date")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM AccountBook WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    
    // 검색
    @Override
    public List<AccountBook> findByDate(String date) {
        try {
            String sql = "select * from AccountBook where date = ?";
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

	@Override
	public int SelectUpdate2(AccountBook ab) {
		// TODO Auto-generated method stub
		return 0;
	}
}
