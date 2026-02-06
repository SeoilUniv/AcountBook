package Pakage;

import java.util.List;
import java.util.Scanner;

import Interface.AccountBookDAO;

public class AccountBookManager {

    AccountBookDAO dao;

    public AccountBookManager(AccountBookDAO dao) {
        this.dao = dao;
    }

    // insert
    public void insert() {
        Scanner sc = new Scanner(System.in);

        String type = inputType(sc);

        System.out.print("날짜(YYYY-MM-DD): ");
        String date = sc.nextLine().trim();

        System.out.print("카테고리: ");
        String category = sc.nextLine().trim();

        int amount = inputAmount(sc);

        // 지출이면 음수 처리
        if ("지출".equals(type)) amount = -amount;

        AccountBook ab = new AccountBook(0, type, amount, category, date);

        int result = dao.insert(ab);

        if (result == 1) {
            System.out.println("저장 완료!");
        } else {
            System.out.println("저장 실패!");
        }

    }

    private String inputType(Scanner sc) {
        while (true) {
            System.out.print("구분(1.수입 / 2.지출): ");
            String sel = sc.nextLine().trim();
            if ("1".equals(sel)) return "수입";
            if ("2".equals(sel)) return "지출";
            System.out.println("다시 입력해주세요.");
        }
    }

    private int inputAmount(Scanner sc) {
        while (true) {
            System.out.print("금액(숫자만): ");
            String s = sc.nextLine().trim().replace(",", "");
            try {
                int v = Integer.parseInt(s);
                if (v <= 0) {
                    System.out.println("금액은 0보다 커야 합니다.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // findAll
    public List<AccountBook> findAll() {
        return dao.findAll();
    }

    // update

    // delete

    // 검색
    public List<AccountBook> searchByDate(String date) {
        return dao.findByDate(date);
    }
}