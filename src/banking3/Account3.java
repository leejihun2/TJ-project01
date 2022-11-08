package banking3;

import java.io.Serializable;

abstract public class Account3 implements Serializable {

	String accountNum;
	String name;
	int balance;

	public Account3(String accNo, String name, int balance) {
		this.accountNum = accNo;
		this.name = name;
		this.balance = balance;
	}

	public void showAccInfo() {
		System.out.println("=========================================================");
		System.out.printf("계좌번호 : %s, 이름 : %s , 잔고 : %d%n", accountNum, name, balance);
		System.out.println("=========================================================");
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
