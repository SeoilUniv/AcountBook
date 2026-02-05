package Pakage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Command.Search;
import Command.Update;
import Command.findAll;
import Interface.AccountBookDAO;
import Pakage.AccountBook;

public class OracleAccountBookDAO implements AccountBookDAO {
	private Search searchLogic = new Search();
	private Update updateLogic = new Update();
	private findAll fa = new findAll();
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

	// Search

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
	private findAll findAllLogic = new findAll();

	@Override
	public List<AccountBook> findAll() {
		return findAllLogic.execute(conn);
	}


	// OracleAccountBookDAO.java 내부

	@Override
	public int SelectUpdate2(AccountBook ab) {
		// conn과 함께 'ab 객체'를 그대로 전달
		return updateLogic.SelectUpdate2(conn, ab);
	}
	// delete

	@Override
	public AccountBook findById(int id) {
		// 1. ID로 딱 하나만 찾아오는 SQL
		String sql = "SELECT * FROM accountbook WHERE id = ?";
		AccountBook ab = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 2. 찾은 데이터를 객체로 포장
				ab = new AccountBook(rs.getInt("id"), rs.getString("type"), rs.getInt("amount"),
						rs.getString("category"), rs.getString("date") // 또는 rs.getString("DATE")
				);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. 찾았으면 객체를, 없으면 null을 반환
		return ab;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}