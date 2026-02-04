package Interface;

import java.util.List;

import Pakage.AccountBook;

public interface Search {
	

	List<AccountBook> findByDate(String date);
}
