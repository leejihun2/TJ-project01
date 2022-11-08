package banking3;

import java.util.Scanner;

public class BankingSystemMain3 {

	void showMenu() {
		System.out.println("1. 계좌생성");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 정보보기");
		System.out.println("5. 종료");
		System.out.println("메뉴선택하세요 >>");
	}
	
	/*
	 * 1. Account 클래스를 이용해서 계좌생성
	 * 2. 입금 . 출금 
	 * 3. Nomal 클래스 상속해서 계좌생성 
	 * 4. 입금출금 확인
	 * 5. High 클래스 상속해서 계좌생성
	 * 6. 입금출금 확인
	 * 
	 */
	
	
	public static void main(String[] args) {

		BankingSystemMain3 bsm3 = new BankingSystemMain3();
		AccountManager3 am3 = new AccountManager3();
		
		Scanner scanner = new Scanner(System.in);
		
		am3.readFile();
		
		while(true) {
			bsm3.showMenu();//메뉴 출력
			
			int choice = scanner.nextInt();
			switch(choice) {
			case ICustomDefine3.MAKE://1
				am3.makeAccount(choice);//계좌생성
				break;
			case ICustomDefine3.DEPOSIT://2
				am3.depositMoney();//입금
				break;
			case ICustomDefine3.WITHDRAW://3
				am3.withdrawMoney();//출금
				break;
			case ICustomDefine3.INQUIRE://4
				am3.showAccInfo();//계좌정보
				break;
			case ICustomDefine3.EXIT://5
				System.out.println("종료합니다");
				am3.saveFile();
				System.exit(0);
			}
		
		}
		
		
//		am3.saveFile();
		
//		am3.readFile();
		
		
		
		
		
	}

}
