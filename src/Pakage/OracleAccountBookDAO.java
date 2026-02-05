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

	private findAll fa = new findAll();
//	Connection conn;
//
//	public OracleAccountBookDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.95:1521:xe", "system", "1234");
//			System.out.println("DB연결 성공!!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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

    
    
//     update



	@Override
	public String update(String category, String indate) {
		return updateLogic.SelectUpdate2(category, indate);
	}
	
	@Override
	public int SelectUpdate2(String category, String indate) {
		return updateLogic.SelectUpdate2(category, indate);
	}


    
    // delete

	// delete

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int update(String category, String indate, AccountBook p) {
		// TODO Auto-generated method stub
		return 0;
	}






    

}
