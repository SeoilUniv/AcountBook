package Pakage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Command.Update;
import Interface.AccountBookDAO;
import Pakage.AccountBook;

public class H2AccountBookDAO implements AccountBookDAO {

    Connection conn;
    private Update updateLogic = new Update();

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
	public String update(String category, String indate) {
		return updateLogic.SelectUpdate2(category, indate);
	}
    
	@Override
	public int SelectUpdate2(String category, String indate) {
		return updateLogic.SelectUpdate2(category, indate);
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



	@Override
	public int insert(AccountBook ab) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccountBook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SelectUpdate2(AccountBook p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String category, String indate, AccountBook p) {
		// TODO Auto-generated method stub
		return 0;
	}


}
