package sangyoon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import d260202_03.AccountBook;

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

    // insert
    
    
    
    // findAll
    
    
    
    // update
	@Override
	public int SelectUpdate2(AccountBook ab) {
		try {
		AccountBook new_ab = findById(ab.getCategory());

		String sql = "update accountbook set amount=? where category=? and indate=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ?가 있으므로 set 함수가 존재한다
		
		ps.setInt(1, new_ab.getAmount());
		ps.setString(2, new_ab.getCategory());
		ps.setString(3, new_ab.getIndate());

		int rs = ps.executeUpdate();
		ps.close();
		return rs;
		
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}


    
    
    // delete

    
    
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
}
