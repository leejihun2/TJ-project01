package shopping;

import java.util.Scanner;

import banking2.ICustomDefine2;

public class ShapMain {

	public static void shapMenu() {
		System.out.println("-----JDBC프로그램-----");
		System.out.println("1.조회하기 ");
		System.out.println("2.생성하기 ");
		System.out.println("3.수정하기");
		System.out.println("4.삭제하기");
		System.out.println("5.전체정보");
		System.out.println("6.종료");
		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		while (true) {
			
	
			shapMenu();
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					SelectShop selctSQL = new SelectShop();
					System.out.println("조회합니다");
					selctSQL.execute();
					break;
				case 2:
					new InsertShop().execute();
					System.out.println("생성합니다");
					break;
				case 3:
					new UpdateShop().execute();
					System.out.println("수정합니다");
					break;
				case 4:
					new DeleteShop().execute();
					System.out.println("삭제합니다");
					break;
				case 5:
					SelectAll selctall = new SelectAll();
					selctall.execute();
					System.out.println("전체정보를 출력합니다");
					break;
				case 6:
					System.out.println("프로그램종료");
					System.exit(0);
					break;
				}
				
		}	

	}

}
