package Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Pakage.AccountBook;

public class Update extends Search{
	Connection conn;
	
	public int SelectUpdate2(AccountBook ab) {
		try {
		List<AccountBook> new_ab = searchByDate(conn, ab.getDate());

		String sql = "update accountbook set amount=? where category=? and indate=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ?가 있으므로 set 함수가 존재한다
		
		
		ps.setInt(1, ((AccountBook) new_ab).getAmount());
		ps.setString(2, ((AccountBook) new_ab).getCategory());
		ps.setString(3, ((AccountBook) new_ab).getDate());

		int rs = ps.executeUpdate();
		
		ps.close();
		return rs;
		
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public String SelectUpdate2(String category, String indate) {
		// TODO Auto-generated method stub
		return null;
	}
}
