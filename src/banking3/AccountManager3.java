package banking3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;

public class AccountManager3 {
	Scanner scanner = new Scanner(System.in);

	HashSet<Account3> accountHashSet;

	public AccountManager3() {
		accountHashSet = new HashSet<>();
	}

	// 계좌를 생성하는 메서드
	public void makeAccount(int choice) {
		String scanStr = scanValue("계좌번호");
		int scanInt = scanInt("계좌번호");
		String iAccNo, iName;
		int iRating;

		while (true) {

			iAccNo = scanStr = scanValue("계좌번호 :");

			iName = scanStr = scanValue("고객이름 :");

			iRating = scanInt = scanInt("잔고 :");

			//Account3 a = new Account3(iAccNo, iName, iRating);
			System.out.println("완료되었습니다.");
			break;
		}
	}

	// 입금을 담당하는 메서드
	void depositMoney() {
		
		System.out.println("입금합니다");
		String scaAccNo = scanValue("계좌번호");
		for (Account3 acc : accountHashSet) {
			if (scaAccNo.equals(acc.accountNum)) {
				
				int money = scanInt("돈");
				acc.balance += money;
				System.out.println("입금이 완료되었습니다.");
			}
		}
	}

	// 출금을 담당하는 메서드
	void withdrawMoney() {
		boolean isFind = false;
		System.out.println("출급합니다");
		String scaAccNo = scanValue("계좌번호");
		for (Account3 acc : accountHashSet) {
			if (scaAccNo.equals(acc.accountNum)) {
				int money = scanInt("돈");
				acc.balance -= money;
				System.out.println("출금이 완료되었습니다.");
			}
		}
	}

	// 정보를 출력하는 메서드
	void showAccInfo() {
		System.out.println("계좌정보를 봅니다.");
		for (Account3 ac3 : accountHashSet) {
			ac3.showAccInfo();
		}
	}

	// 파일을 불러오는 메서드
	void readFile() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("src/banking3/AccountInfo.obj"));
			while (true) {
				accountHashSet.add((Account3) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("파일 불러오기 끝 ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일을 저장하는 메서드
	void saveFile() {
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("src/banking3/AccountInfo.obj"));
			for (Account3 at : accountHashSet) {
				oos.writeObject(at);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String scanValue(String title) {
		System.out.println(title + "을/를 입력 >>");
		String str = scanner.nextLine();
		return str;
	}

	int scanInt(String title) {
		System.out.println(title + "을/를 입력>>");
		int intNum = scanner.nextInt();
		return intNum;
	}

}
