package banking2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain2 {
	
	
	public static void showMenu() {
		System.out.println("-----Menu------");
		System.out.println("1.계좌계설 ");
		System.out.println("2.입금 ");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.저장옵션");
		System.out.println("6.프로그램종료");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("1차프로젝트(학원)");
		System.out.println("pull없이 작업진행함");

		Scanner scan = new Scanner(System.in);
		
		MenuSelectException2 ex = new MenuSelectException2();
		AccountManager2 hunarr = new AccountManager2();
		AutoSaver sa = new AutoSaver(hunarr);
		sa.setDaemon(true);
		
		hunarr.readAccountInfo();
		while (true) {
			showMenu();
			try {
				int choice = scan.nextInt();
				switch (choice) {
				case ICustomDefine2.MAKE:
					hunarr.makeAccount(choice);
					break;
				case ICustomDefine2.DEPOSIT:
					hunarr.depositMoney();
					break;
				case ICustomDefine2.WITHDRAW:
					hunarr.withdrawMoney();
					break;
				case ICustomDefine2.INQUIRE:
					hunarr.showAccInfo();
					break;
				case ICustomDefine2.AUTO_SAVE:
					hunarr.AutoSaver(sa);
					break;
				case ICustomDefine2.EXIT:
					System.out.println("프로그램종료");
					hunarr.saveAccountInfo();
					System.exit(0);
				default:
					throw ex;
				}
			} catch (MenuSelectException2 e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다");
				scan.nextLine();
			}
		}
	}
}
