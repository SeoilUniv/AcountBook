package Pakage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Command.Search;
import Interface.AccountBookDAO;
import View.DeleteView;
import View.InsertView;
import View.SearchView;
import View.UpdateView;
import View.findAllView;

public class AccountBookProgram {

	private AccountBookManager am;
	private Scanner scan = new Scanner(System.in);
	private InsertView insertView = new InsertView();
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

	// 삭제
	private void delete() {
		DeleteView deleteView = new DeleteView(am);
		try {
			deleteView.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	// AccountBookProgram 클래스의 insert() 메서드 내용 교체
	private void insert() {
		// 복잡한 입력 로직은 InsertView 담당자에게 맡김
		insertView.display(am);
	}

	private findAllView findAllView = new findAllView();

	private void views() {
		findAllView.display(am);
	}
	
    private void update() throws IOException {
    	UpdateView update = new UpdateView();
    	update.update();
    }

	// 검색
	private void searchByDate() throws IOException {
		SearchView sv = new SearchView();
		sv.searchByDate();
	}
}
