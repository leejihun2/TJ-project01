package banking;

public class Temp01 {

	public static void main(String[] args) {

		int balance = 10000;
		int money = 5000;
		int rate = 2; // 0.02
		
		int A = 7, B =4 , C= 2;
		
		
		//잔액 = 잔액 + (잔액 * 이자) + 입금액
		
		balance = balance + ( balance * rate  / 100 ) + money;
		// 잔 액 < - 10000 +  (  10000 * 2 / 100 )  + 5000
		System.out.println(balance);
		
		//신용계좌
		//잔액 = 잔액 + (잔액 * 이자) + (잔액 * 추가이자)입금액		A,B,C
		balance = balance + ( balance * rate  / 100 ) + (balance * A / 100) + money;
		// 잔 액 < - 10000 +  (  10000 * 2 / 100 )  + 5000
		System.out.println(balance);
	}

}
