package banking3;

import java.util.Scanner;

public class NormalAccount3 extends Account3{
	Scanner scan = new Scanner(System.in);
	int inter;

	public NormalAccount3(String accNo, String name, int balance) {
		super(accNo, name, balance);
		this.inter = inter;
	}

	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("이자"+inter+"%");
	}
	
	
	
}
