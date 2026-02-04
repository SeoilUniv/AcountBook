package View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Pakage.AccountBook;
import Pakage.AccountBookManager;

public class SearchView {
	AccountBookManager am;
	private Scanner scan = new Scanner(System.in);

	public void searchByDate() throws IOException {
		System.out.print("검색할 날짜(YYYY-MM-DD): ");
		String date = scan.nextLine().trim();

		List<AccountBook> list = am.searchByDate(date);

		System.out.println("번호\t날짜\t\t카테고리\t금액");
		for (AccountBook ab : list) {
			System.out.println(ab.toString());
		}
	}
}
