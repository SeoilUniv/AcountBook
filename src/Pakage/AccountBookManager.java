package Pakage;
import java.util.List;

import Command.Search;
import Interface.AccountBookDAO;

public class AccountBookManager {

    AccountBookDAO dao;

    public AccountBookManager(AccountBookDAO dao) {
        this.dao = dao;
    }

    // insert
    public void insert(String type, int amount, String category, String date) {
        // 1. 받은 데이터를 객체로 포장
        AccountBook ab = new AccountBook(0, type, amount, category, date);
        // 2. DAO에게 전달
        dao.insert(ab);
        System.out.println("입력 완료!");
    }
    
    // findAll
    
    public List<AccountBook> findAll() {
        return dao.findAll();
    }
    
    // update
    
    public int update(int amount, String category, String date) {
        AccountBook ab = new AccountBook(0, null, amount, category, date);
        
        return dao.SelectUpdate2(ab);
    }
    
    // Delete
    // 존재 여부 확인
    public boolean isExist(int id) {
        return dao.findById(id) != null;
    }
    // 삭제
    public int delete(int id) {
        return dao.deleteById(id);
    }    
    
    // 검색
    public List<AccountBook> searchByDate(String date) {
        return dao.findByDate(date);
    }

	

}