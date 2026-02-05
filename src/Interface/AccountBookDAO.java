package Interface;
import java.util.List;

import Pakage.AccountBook;

public interface AccountBookDAO extends Update, Search, findAll, Delete{
	// 각자 구현한거 합치기
	
	int insert(AccountBook ab);
	List<AccountBook> findByDate(String date);
}
