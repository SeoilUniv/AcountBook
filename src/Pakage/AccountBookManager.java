package Pakage;
import java.util.List;

import Interface.AccountBookDAO;


public class AccountBookManager {

    AccountBookDAO dao;
    AccountBook p;
    public AccountBookManager(AccountBookDAO dao) {
        this.dao = dao;
    }

    // insert
    
    
    
    // findAll
    
    
    
    // update
    public int update(String category, String indate) {
    	return dao.SelectUpdate2(category,indate);
    }
    
    
    // delete
    
    
    
    // 검색
    public List<AccountBook> searchByDate(String date) {
        return dao.findByDate(date);
    }
}
