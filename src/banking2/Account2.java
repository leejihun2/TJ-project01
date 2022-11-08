package banking2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

//계좌정보를 표현한 클래스로 NormalAccount, HighCreditAccount의 부모클래스가 된다.
abstract public class Account2 implements Serializable{

	private String accountNum;
	private String name;
	private int balance;

	public Account2(String accountNum, String name, int balance) {
		this.setAccountNum(accountNum);
		this.name = name;
		this.balance = balance;
	}

	public void showAccInfo() {
		System.out.println("=========================================================");
		System.out.printf("계좌번호 : %s, 이름 : %s , 잔고 : %d%n", getAccountNum(), name, balance);
		
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int jihun, int money) {
		if (jihun == ICustomDefine2.DEPOSITS) {// ㅁㄴㅇ > ㅁㄴㅇ
			this.balance += money;// balance + balance잔액 = money;
		} else if (jihun == ICustomDefine2.WITHDRAWS) {
			if (this.balance < money) {
				this.balance = 0;
			} else {
				this.balance -= money;
			}
		}
	}

	@Override
	public int hashCode() {
		int returnCode = Objects.hash(this.getAccountNum());
		return returnCode;
	}

	public boolean equals(Object obj) {// 객체의 최상위 부모클래스

		Account2 a2 = (Account2) obj;// 자식클래스에 접근하기 위한 다운캐스팅
		//    갖고있는애       비교       들어올애
		if ((this.getAccountNum()).equals(a2.getAccountNum())) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "계좌번호"+ getAccountNum() + "이름" + name + "잔고" + balance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
}
