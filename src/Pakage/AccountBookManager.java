package Pakage;
import java.util.List;

import Interface.AccountBookDAO;

public class AccountBookManager {

    AccountBookDAO dao;

    public AccountBookManager(AccountBookDAO dao) {
        this.dao = dao;
    }

    // insert
    
    
    
    // findAll
    
    
    
    // update
    
    
    
    // delete
    
    
    
    // 검색
    public List<AccountBook> searchByDate(String date) {
        return dao.findByDate(date);
    }
}
