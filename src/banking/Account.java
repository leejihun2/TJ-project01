package banking;
//계좌정보를 표현한 클래스로 NormalAccount, HighCreditAccount의 부모클래스가 된다.
public class Account {
		
		//맴버변수
		String accountnum;
		String name;
		int balance;

		//생성자
		public Account(String accountnum, String name, int balance) {
			this.accountnum = accountnum;
			this.name = name;
			this.balance = balance;
		}

		public void showAccInfo() {
			System.out.println("계좌번호:" + accountnum);
			System.out.println("이름:" + name);
			System.out.println("잔고:" + balance);
		}
	}

//static String scanStr(String title) {
//Scanner scan = new Scanner(System.in);
//System.out.print(title + "을(를) 입력 : ");
//String inputStr = "";
//try {
//	inputStr = scan.nextLine();
//} catch (InputMismatchException e) {
//	System.out.println("문자를 입력하세요.");
//	inputStr = scan.nextLine();
//}
//return inputStr;
//}
//
//
//static int scanInt(String title) {
//Scanner scan = new Scanner(System.in);
//System.out.print(title + "을(를) 입력 : ");
//int inputInt = 0;
//try {
//	inputInt = scan.nextInt();
//} catch (InputMismatchException e) {
//	System.out.println("숫자를 입력하세요.");
//	inputInt = scan.nextInt();
//}
//return inputInt;
//}
