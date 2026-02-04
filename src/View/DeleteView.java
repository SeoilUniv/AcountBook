package View;

import java.io.IOException;
import java.util.Scanner;

import Pakage.AccountBook;
import Pakage.AccountBookManager;

public class DeleteView {

    private AccountBookManager am;
    private Scanner scan = new Scanner(System.in);

    public DeleteView(AccountBookManager am) {
        this.am = am;
    }

    public void delete() throws IOException {
        System.out.print("삭제할 번호 입력: ");
        int id = Integer.parseInt(scan.nextLine());

        if (!am.isExist(id)) {
            System.out.println("해당 번호의 내역이 없습니다.");
            return;
        }

        System.out.print("정말 삭제하시겠습니까? (Y/N): ");
        if (!scan.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("삭제 취소");
            return;
        }

        int result = am.delete(id);

        if (result > 0) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }
}