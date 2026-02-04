package Pakage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Command.Search;
import Interface.AccountBookDAO;
import View.SearchView;
import View.findAllView;

public class AccountBookProgram {

	private AccountBookManager am;
	private Scanner scan = new Scanner(System.in);

	private int id;
	private String type;
	private int amount;
	private String category;
	private String date;

	public AccountBookProgram(AccountBookDAO dao) throws IOException {
		am = new AccountBookManager(dao);

		while (true) {
			switch (menu()) {
			case 1:
				insert();
				break;
			case 2:
				views();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				searchByDate();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.!");
				System.exit(0);
				break;
			default:
				System.out.println("없는 메뉴입니다.");
			}
		}
	}


	private int menu() {
		System.out.println("+=====================+");
		System.out.println("|      가계부 관리       |");
		System.out.println("+=====================+");
		System.out.println("| 1. 입력              |");
		System.out.println("| 2. 전체 출력          |");
		System.out.println("| 3. 수정              |");
		System.out.println("| 4. 삭제              |");
		System.out.println("| 5. 검색              |");
		System.out.println("| 0. 프로그램 종료       |");
		System.out.println("+=====================+");
		System.out.print("> ");
		return Integer.parseInt(scan.nextLine().trim());
	}

	private void insert() {
//        System.out.print("구분(수입/지출): ");
//        type = scan.nextLine();
//
//        System.out.print("금액: ");
//        amount = Integer.parseInt(scan.nextLine());
//
//        System.out.print("분류(식비/교통비/...): ");
//        category = scan.nextLine();
//
//        System.out.print("날짜(YYYY-MM-DD): ");
//        date = scan.nextLine();
//
//        am.insert(type, amount, category, date);
//        System.out.println("입력 완료");
	}

	private findAllView findAllView = new findAllView();

	private void views() {
		findAllView.display(am);
	}

	private void update() {

	}
	
	private void delete() {
	    System.out.print("삭제할 목록의 ID를 입력해주세요 : ");
	    id = Integer.parseInt(scan.nextLine().trim());

	    if (!am.isExist(id)) {
	        System.out.println("해당 번호의 내역이 존재하지 않습니다.");
	        return;
	    }

	    System.out.println("정말 삭제하시겠습니까? (Y/N) : ");
	    if (!scan.nextLine().equalsIgnoreCase("Y")) {
	        System.out.println("삭제가 취소되었습니다.");
	        return;
	    }

	    int result = am.delete(id);

	    if (result > 0) {
	        System.out.println("삭제 완료");
	    } else {
	        System.out.println("삭제 실패");
	    }
	}


	// 검색
	private void searchByDate() throws IOException {
		SearchView sv = new SearchView();
		sv.searchByDate();
	}
}
