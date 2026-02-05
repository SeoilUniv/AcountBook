package View;

import java.util.Scanner;
import Pakage.AccountBookManager;

public class InsertView {
    private Scanner scan = new Scanner(System.in);

    public void display(AccountBookManager am) {
        System.out.println("\n----- 가계부 내역 입력 -----");
        try {
            System.out.print("구분(수입/지출): ");
            String type = scan.nextLine().trim();

            System.out.print("금액: ");
            int amount = Integer.parseInt(scan.nextLine().trim());

            System.out.print("분류(식비/교통비 등): ");
            String category = scan.nextLine().trim();

            System.out.print("날짜(YYYY-MM-DD): ");
            String date = scan.nextLine().trim();

            am.insert(type, amount, category, date);
            
        } catch (NumberFormatException e) {
            System.out.println(">>> [오류] 금액은 숫자만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println(">>> [오류] 입력 중 문제가 발생했습니다: " + e.getMessage());
        }
    }
}