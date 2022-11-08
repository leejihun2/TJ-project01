package banking2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
1.스캐너 바꾸기 
2. 중복되는 코드 없애기
3. 중복검사하는  코드 변경
 */
//컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
public class AccountManager2 {
	HashSet<Account2> accountHashSet;

	public AccountManager2() {
		accountHashSet = new HashSet<>();
	}

	// 계좌개설을 위한 메서드
	public void makeAccount(int choice) {
		String iAccountNum, iName, iRating;

		int iBalance;
		// 계좌 비교
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		choice = scanInt("계좌종류");

		iAccountNum = scanValue("계좌번호");
		iName = scanValue("고객이름");
		iBalance = scanInt("잔고");
		int inter = scanInt("기본이자");

		// 등급
		Account2 acc = null;
		if (choice == 1) {
			acc = new NormalAccount2(iAccountNum, iName, iBalance, inter);

		} else if (choice == 2) {
			iRating = scanValue("등급");
			acc = new HighCreditAccount2(iAccountNum, iName, iBalance, inter, iRating);
		}
		boolean isDup = accountHashSet.add(acc);
		if (isDup == false) {
			System.out.println("중복된 계좌가 발생하였습니다");
			String overlap = scanValue("덮어쓸려면 Y 취소할려면 N");
			if (overlap.equalsIgnoreCase("Y")) {
				accountHashSet.remove(acc);// 기존에 있는 계좌번호를 지움.
				accountHashSet.add(acc); // 다시 추가.
			} else if (overlap.equalsIgnoreCase("N")) {
				System.out.println("취소합니다");
				return;
			}
			System.out.println(" 완료되었습니다.");
		}
	}

	// 정보를 출력하는 메서드
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for (Account2 acc2 : accountHashSet) {
			acc2.showAccInfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}

	// 입금하는 메서드
	public void depositMoney() {
		boolean isFind = false;
		String searchaccountnum = scanValue("계좌번호와 입금할 금액");
		System.out.println("계좌번호:");

		for (Account2 acc2 : accountHashSet) {
			if (searchaccountnum.equals(acc2.getAccountNum())) {
				try {
					int addnum = scanInt(" 입금액");
					if (addnum <= 0) {
						System.out.println("마이너스 금액은 입급할 수 없습니다.");
						return;
					} else if (addnum % 500 != 0) {
						System.out.println("500원 단위로 입금하세요.");
						return;
					} else {
						acc2.setBalance(ICustomDefine2.DEPOSITS, addnum);
						System.out.println(" 입금이 완료되었습니다.");
						isFind = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("문자를 입력할 수 없습니다.");
				}
			}
		}
		if (isFind == false)
			System.out.println("***계좌번호가 틀렸습니다.***");
	}

	// 출금하는 메서드
	public void withdrawMoney() {
		boolean isFind = false;
		String searchaccountnum = scanValue("계좌번호");
		for (Account2 acc2 : accountHashSet) {
			if (searchaccountnum.equals(acc2.getAccountNum())) {
				int addnum = scanInt(" 출금할 금액");
				if (addnum <= 0) {
					System.out.println("마이너스 금액은 출금할 수 없습니다.");
					return;
				}else if (addnum % 1000 != 0) {
						System.out.println("1000원 단위로 출금하세요.");
						return;
				} else if (addnum > acc2.getBalance()) {
					System.out.println("잔고가 부족합니다 전체잔고를 출력할까요?");
					String addnym = scanValue("Y: 전체처리, N출금요청");
					if ("Y".equalsIgnoreCase(addnym)) {
						System.out.println("전체처리 완료");
						isFind = true;
					} else if ("N".equalsIgnoreCase(addnym)) {
						System.out.println("출금요청 취소");
						return;
					}
				} else {
					System.out.println(" 출금이 완료되었습니다.");
					isFind = true;
				}
				acc2.setBalance(ICustomDefine2.WITHDRAWS, addnum);
			}
		}
		if (isFind == false)
			System.out.println("***계좌번호가 틀렸습니다.***");
	}

	public void saveAccountInfo() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("src/banking2/AccountInfo.obj"));
			for (Account2 ac2 : accountHashSet) {
				oos.writeObject(ac2);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readAccountInfo() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("src/banking2/AccountInfo.obj"));
			while (true) {
				accountHashSet.add((Account2) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("파일불러오기 끝");
		} catch (FileNotFoundException e) {
			System.out.println("불러오기 실패");
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
			
		}
	}
	//오토서버 객체를 받아서 사용한 메서드
	public void AutoSaver(AutoSaver mgr) {

		int choice = scanInt("1.자동저장On, 2.자동저장Off");
		if (choice == 1) {
			System.out.println("자동저장on");
			if (mgr.isAlive()) {
				System.out.println("이미 실행 중 입니다");
			} else {
				mgr.start();
			}

		} else if (choice == 2) {
			System.out.println("자동저장 off");
			mgr.interrupt();
		}
	}

	public void saveThread() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/banking2/AutoSaveAccount.txt"));
			for (Account2 ac2 : accountHashSet) {
				out.print(ac2.toString());
			}
			out.close();
		} catch (Exception e) {
		}
	}

	String scanValue(String title) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(title + "을/를 입력하세요 >>");
		String str = scanner.nextLine();
		return str;
	}

	int scanInt(String title) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(title + "을/를 입력하세요 >>");
		int intNum = scanner.nextInt();
		return intNum;
	}
}