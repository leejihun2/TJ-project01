//package banking;
//
//
//	public class AccountManager {
//
//		private Account2[] accountList;
//
//		private int accountArr;
//
//		public AccountManager(int num) {
//			accountList = new Account2[num];
//			accountArr = 0;
//		}
//
//		public void makeAccount(int choice) {
//
//			Scanner scan = new Scanner(System.in);
//			String iAccountNum, iName, iRating;
//			
//			int iBalance;
//			
//			System.out.println("1.보통계좌");
//			System.out.println("2.신용신뢰계좌");
//			choice = scan.nextInt();
//			if (choice == 1) {
//				System.out.println("보통계좌");
//				System.out.println("");
//				scan.nextLine();
//				iAccountNum = scanStr("계좌번호>");
//				
//				iName = scanStr("고객이름>");
//				
//				iBalance = scanInt("잔고>");
//				
//				int inter = scanInt("기본이자>");
//				scan.nextLine();
//				Account2 normal = new NormalAccount2(iAccountNum, iName, iBalance, inter);
//				accountList[accountArr++] = normal;
//
//			} else if (choice == 2) {
//				System.out.println("신용신뢰계좌");
//				System.out.println("");
//				scan.nextLine();
//				iAccountNum = scanStr("계좌번호>");
//				
//				iName = scanStr("고객이름>");
//				
//				iBalance = scanInt("잔고>");
//				
//				int inter = scanInt("기본이자>");
//				scan.nextLine();
//				System.out.print("등급>");
//				iRating = scan.nextLine();
//				Account2 high = new HighCreditAccount2(iAccountNum, iName, iBalance, inter, iRating);
//				accountList[accountArr++] = high;
//			}
//
//			System.out.println(" 완료되었습니다.");
//
//		}
//
//		public void showAccInfo() {
//			System.out.println("***계좌정보출력***");
//
//			for (int i = 0; i < accountArr; i++) {
//				System.out.println("-------------");
//				accountList[i].showAccInfo();
//				System.out.println("-------------");
//			}
//
//			System.out.println("전체계좌정보 출력이 완료되었습니다.");
//		}
//
//		public void depositMoney() {
//			boolean isFind = false;
//			Scanner scan = new Scanner(System.in);
//			System.out.println("계좌번호와 입금할 금액을 입력하세요");
//			System.out.println("계좌번호:");
//			String searchaccountnum = scan.nextLine();
//			
//			for (int i = 0; i < accountArr; i++) {
//				
//				
//				if (searchaccountnum.equals(accountList[i].accountnum)) {
//					
//					System.out.println(" 입금액:");
//					int addnum = scan.nextInt();
//					accountList[i].setBalance(1, addnum);
//
//					System.out.println(" 입금이 완료되었습니다.");
//					isFind = true;
//				}
//			}
//			if (isFind == false)
//				System.out.println("***계좌번호가 틀렸습니다.***");
//		}
//
//		public void withdrawMoney() {
//			boolean isFind = false;
//			Scanner scan = new Scanner(System.in);
//			System.out.println("계좌번호 입력하세요");
//			String searchaccountnum = scan.nextLine();
//
//			for (int i = 0; i < accountArr; i++) {
//
//				if (searchaccountnum.equals(accountList[i].accountnum)) {
//
//					System.out.println(" 출금할 금액을 입력하세요.");
//					int addnum = scan.nextInt();
//
//					accountList[i].setBalance(2, addnum);
//					System.out.println(" 출금이 완료되었습니다.");
//					isFind = true;
//				}
//			}
//			if (isFind == false)
//				System.out.println("***계좌번호가 틀렸습니다.***");
//		}
//		
//		
//		
//		static String scanStr(String title) {
//			Scanner scan = new Scanner(System.in);
//			System.out.print(title + "을(를) 입력 : ");
//			String inputStr = "";
//			try {
//				inputStr = scan.nextLine();
//			} catch (InputMismatchException e) {
//				System.out.println("문자를 입력하세요.");
//				inputStr = scan.nextLine();
//			}
//			return inputStr;
//		}
//		
//		
//		static int scanInt(String title) {
//			Scanner scan = new Scanner(System.in);
//			System.out.print(title + "을(를) 입력 : ");
//			int inputInt = 0;
//			try {
//				inputInt = scan.nextInt();
//			} catch (InputMismatchException e) {
//				System.out.println("숫자를 입력하세요.");
//				inputInt = scan.nextInt();
//			}
//			return inputInt;
//		}
//	}
