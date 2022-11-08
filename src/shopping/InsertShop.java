package shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertShop extends IConnectImpl {

	public InsertShop() {
		super(ORACLE_DRIVER, "education", "1234");
	}

	@Override
	public void execute() {
		
		String quety = "INSERT INTO sh_goods VALUES (seq_total_idx.nextval, ?, ?, sysdate, ?)";
		
		try {
			psmt = con.prepareStatement(quety);
			
			psmt.setString(1, scanValue("상품명"));
			psmt.setString(2, scanValue("상품가격"));
			psmt.setString(3, scanValue("상품코드"));
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertShop().execute();
	}
}
