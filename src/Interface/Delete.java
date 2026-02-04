package Interface;

import Pakage.AccountBook;

public interface Delete {

    AccountBook findById(int id);

    int deleteById(int id);
}