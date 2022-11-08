package banking2;

import java.util.Scanner;

/*
Account의 자식클래스로 신용도가 높은 고객에게 개설이 허용되며 높은 이율의 계좌이다.
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.
 */
/*
HighCreditAccount
신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
Ex) 5000 + (5000 * 0.02) + (5000 * 0.04) + 2000 = 7,300원
balance + (balance * 기본이자) + (balance * 추가이자) + 입금액
 */
public class HighCreditAccount2 extends Account2 {
	int inter;
	String rating;

	public HighCreditAccount2(String accountNum, String name, int balance, int inter, String rating) {
		super(accountNum, name, balance);
		this.inter = inter;
		this.rating = rating;
	}

	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("이자:" + inter + "%");
		System.out.println("신용등급(A,B,C등급):" + rating + "등급");
		System.out.println("=========================================================");
	}
	@Override
	public void setBalance(int jihun, int money) {
		if (jihun == ICustomDefine2.DEPOSITS) {
			if ("A".equalsIgnoreCase(rating)) {
				super.setBalance(ICustomDefine2.DEPOSITS, (this.getBalance() * inter / 100) 
						+ (this.getBalance() * ICustomDefine2.A / 100) + money);
				
			} else if ("B".equalsIgnoreCase(rating)) {
				super.setBalance(ICustomDefine2.DEPOSITS, (this.getBalance() * inter / 100) 
						+ (this.getBalance() * ICustomDefine2.B / 100) + money);
				
			} else if ("C".equalsIgnoreCase(rating)) {
				super.setBalance(ICustomDefine2.DEPOSITS, (this.getBalance() * inter / 100) 
						+ (this.getBalance() * ICustomDefine2.C / 100) + money);
				
			} else {
				super.setBalance(ICustomDefine2.DEPOSITS, this.getBalance() * inter / 100 + money);
			}
		} else if (jihun == ICustomDefine2.WITHDRAWS) {
			
			super.setBalance(ICustomDefine2.WITHDRAWS, money);
			
		}
	}

}
