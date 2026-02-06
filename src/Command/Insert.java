package Command;

import Pakage.AccountBookManager;

public class Insert {

    AccountBookManager manager;

    public Insert(AccountBookManager manager) {
        this.manager = manager;
    }

    public void execute() {
        manager.insert();
    }
    
}
