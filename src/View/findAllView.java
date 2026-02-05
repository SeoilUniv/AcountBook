package View;

import java.util.List;
import Pakage.AccountBook;
import Pakage.AccountBookManager;

public class findAllView {

    public void display(AccountBookManager am) {
        List<AccountBook> list = am.findAll();

        System.out.println("\n==================== 전체 가계부 내역 ====================");
        System.out.println("번호\t구분\t금액\t\t분류\t날짜");
        System.out.println("-------------------------------------------------------");
        if (list == null || list.isEmpty()) {
            System.out.println("저장된 내역이 없습니다.");
        } else {
            for (AccountBook ab : list) {
                System.out.printf("%d\t%s\t%,d원\t%s\t%s\n",
                    ab.getId(),
                    ab.getType(),
                    ab.getAmount(),
                    ab.getCategory(),
                    ab.getDate()
                );
            }
        }
        System.out.println("=======================================================\n");
    }
}