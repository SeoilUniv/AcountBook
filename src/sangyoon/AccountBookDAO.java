package sangyoon;
import java.util.List;

public interface AccountBookDAO {
	
	
	
    List<AccountBook> findByDate(String date);
}
