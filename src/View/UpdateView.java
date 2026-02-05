package View;

import java.io.IOException;
import java.util.Scanner;

import Pakage.AccountBookManager;

public class UpdateView {
	AccountBookManager am;
	private Scanner scan = new Scanner(System.in);

	public void update() throws IOException {
		System.out.println("수정할 물품을 입력하세요");
		String category = scan.nextLine().trim();
		System.out.println("수정할 날짜를 입력하세요");
		String indate = scan.nextLine().trim();

		int update = am.update(category, indate);

//		}
	}
}
