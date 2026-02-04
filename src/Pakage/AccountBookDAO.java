package Pakage;
import java.util.List;

public interface AccountBookDAO extends Update, Search{
	// 각자 구현한거 합치기
	
	int insert(AccountBook ab);
    List<AccountBook> findAll();
    int delete(int id);
	List<AccountBook> findByDate(String date);
}
