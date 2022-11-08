package banking2;

public class AutoSaver extends Thread {

	AccountManager2 am ;
	
	
	public AutoSaver(AccountManager2 mgr) {
		am = mgr;
	}

	@Override
	public void run() {
		
		while(true) {
			
			try {
				sleep(5000);
				am.saveThread();
				System.out.println("AutoSaveAccount.txt 가 생성되었습니다");
				System.out.println("5초에 한번 자동저장이 실행중입니다.");
			}
			catch (InterruptedException e) {
				System.out.println("자동저장종료");
				break;
			}
			
		}
	}

}
