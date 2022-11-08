package banking2;

import java.util.Scanner;

public class Temp3 {


		   // 계좌개설을 위한 메서드
		   public void makeAccount(int choice) {
		      Scanner scan = new Scanner(System.in);
		      String iAccountNum, iName, iRating;
		      int iBalance;
		      // 계좌 비교
		      System.out.println("1.보통계좌");
		      System.out.println("2.신용신뢰계좌");
		      choice = scan.nextInt();

		      System.out.print("계좌번호:");
		      iAccountNum = scan.nextLine();
		      System.out.print("고객이름 :");
		      iName = scan.nextLine();
		      System.out.print("잔고 :");
		      iBalance = scan.nextInt();
		      System.out.print("기본이자>");
		      int inter = scan.nextInt();
		      
		      Account2 acc = null;
		      if (choice == 1) {
		         acc = new NormalAccount2(iAccountNum, iName, iBalance, inter);
		      } 
		      else if (choice == 2) {
		         System.out.print("등급>");
		         iRating = scan.nextLine();
		         acc = new HighCreditAccount2(iAccountNum, iName, iBalance, inter, iRating);
		      }
		   }
		   
	}

