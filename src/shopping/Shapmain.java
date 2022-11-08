package shopping;

import java.util.Scanner;

import banking2.ICustomDefine2;

public class Shapmain {

	public static void shapMenu() {
		System.out.println("-----JDBC프로그램-----");
		System.out.println("1.조회하기 ");
		System.out.println("2.생성하기 ");
		System.out.println("3.수정하기");
		System.out.println("4.삭제하기");
		System.out.println("5.종료");
		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		while (true) {
			
	
			shapMenu();
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					break;
				}
		}	
		//1조회하기
		
		//2생성하기
		
		//3수정하기
		
		//4삭제하기
	}

}
