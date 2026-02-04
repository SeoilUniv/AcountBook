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
    
    
    
    // findAll
    
    public List<AccountBook> findAll() {
        return dao.findAll();
    }
    
    // update
    
    
    
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
