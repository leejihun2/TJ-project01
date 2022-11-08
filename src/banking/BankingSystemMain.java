package banking;

import java.util.Scanner;

public class BankingSystemMain {

	public static void showMenu() { // 메뉴출력
		System.out.println("-----Menu------");
		System.out.println("1.계좌계설 ");
		System.out.println("2.입금 ");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	static void makeAccount(int choice) { // 계좌개설을 위한 함수
		System.out.println("1번");
	}    
	
	static void depositMoney() {  // 입    금
		System.out.println("2번");
	}  
	
	static void withdrawMoney() { // 출    금
		System.out.println("3번");
	} 
	
	static void showAccInfo() { // 전체계좌정보출력
		System.out.println("4번");
	}  


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//AccountManager hunarr = new AccountManager(49);

		while (true) {

			showMenu();

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				makeAccount(choice);
				break;
			case 2:
				depositMoney();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				showAccInfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
