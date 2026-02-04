package sangyoon;
import java.util.List;

import d260202_03.AccountBook;
import d260202_03.UpdateDAO;

public class AccountBookManager {

    AccountBookDAO dao;

    public AccountBookManager(AccountBookDAO dao) {
        this.dao = dao;
    }

    // insert
    
    
    
    // findAll
    
    
    
    // update
	UpdateDAO udao;
	
	public void update(String category, String indate, AccountBook p) {
		if(p.getAmount().equals("")) {p.setAmount(null);}
		if(p.getCategory().equals("")) {p.setCategory(null);}
		if(p.getIndate().equals("")) {p.setIndate(null);}
		p.setId(0);
		
		udao.SelectUpdate2(p);
	}

    
    
    // delete
    
    
    
    // 검색
    public List<AccountBook> searchByDate(String date) {
        return dao.findByDate(date);
    }
}
