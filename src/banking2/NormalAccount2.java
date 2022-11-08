package banking2;

import java.util.Scanner;

/*
Account의 자식클래스로 보통예금계좌를 의미한다.
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.
 */
/*
1계좌를 나눠서
2NormalAccount만들고
일반계좌 : 잔고 + (잔고 * 기본이자) + 입금액 
Ex) 5000 + (5000 * 0.02) + 2000 = 7,100원
balance + (balance * 기본이자) + 입금액
 */
public class NormalAccount2 extends Account2 {
	int inter;
	
	public NormalAccount2(String accountNum, String name, int balance, int inter) {
		super(accountNum, name, balance);
		this.inter = inter;
	}

	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("이자"+inter+"%");
		System.out.println("=========================================================");
		
		
	}

	@Override
	public void setBalance(int temp, int money) {
		if(temp == ICustomDefine2.DEPOSITS ) {
			super.setBalance(ICustomDefine2.DEPOSITS, this.getBalance() * inter/100 + money);
		}
		else if (temp == ICustomDefine2.WITHDRAWS) {
			super.setBalance(ICustomDefine2.WITHDRAWS, money);
		}
	}
	
	
}
