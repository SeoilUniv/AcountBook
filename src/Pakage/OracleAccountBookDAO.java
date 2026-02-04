package Pakage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Command.Search;
import Pakage.AccountBook;

public class OracleAccountBookDAO implements AccountBookDAO {
	private Search searchLogic = new Search();
    Connection conn;
    public OracleAccountBookDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.95:1521:xe", "system", "1234");
            System.out.println("DB연결 성공!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    //Search
    @Override
    public List<AccountBook> findByDate(String date) {
        return searchLogic.searchByDate(conn, date);
    }
    
    // insert
	@Override
	public int insert(AccountBook ab) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    
    // findAll
	@Override
	public List<AccountBook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
//     update
//	@Override
//	public int SelectUpdate2(AccountBook ab) {
//		try {
//		AccountBook new_ab = findById(ab.getCategory());
//
//		String sql = "update accountbook set amount=? where category=? and indate=?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		// ?가 있으므로 set 함수가 존재한다
//		
//		ps.setInt(1, new_ab.getAmount());
//		ps.setString(2, new_ab.getCategory());
//		ps.setString(3, new_ab.getIndate());
//
//		int rs = ps.executeUpdate();
//		ps.close();
//		return rs;
//		
//		}catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//
//	}

    
    
    // delete
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
    
   
}
