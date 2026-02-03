package sangyoon;
import java.util.List;

public interface AccountBookDAO {
	// 각자 구현한거 합치기
	
	
    List<AccountBook> findByDate(String date);
}
