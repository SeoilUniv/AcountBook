package Pakage;

import java.io.IOException;

//PhonebookMain->PhonebookProgram->PhonebookManager->OraclePhonebookDAO
//dao의 findAll()함수까지 추적 
public class AccountBookMain {

	public static void main(String[] args) throws IOException {
		//프로그램을 처음 시작할 때 어떤 db를 사용할 것인지 값을 입력하여 처리
		//다른 말로 필요하는 도구를 생성자에 입력하여 처리한다.
		new AccountBookProgram(new OracleAccountBookDAO());
	}

}