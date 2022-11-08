package banking2;

public class Temp012 {

	public static void main(String[] args) {

		int balance = 10000;
		
		int money = 5000;
		
		int rate = 2; // 0.02
		
		
		//잔액 = 잔액 + (잔액 * 이자) + 입금액
		
		balance = balance + ( balance * rate  / 100 ) + money;
		// 잔 액 < - 10000 +  (  10000 * 2 / 100 )  + 5000
		System.out.println(balance);
		
	}

}
