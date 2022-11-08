package shopping;

import java.sql.SQLException;

public class UpdateShop extends IConnectImpl {

	public UpdateShop() {
		super("education", "1234");
	}

	@Override
	public void execute() {
		String sql = "UPDATE sh_goods " 
	+ " SET goods_name=?, goods_price=?, p_code=? " 
	+ " WHERE g_idx=?";

		try {
			psmt = con.prepareStatement(sql);
			while (true) {
				psmt.setString(1, scanValue("수정할 상품명"));
				psmt.setString(2, scanValue("상품가격"));
				psmt.setString(3, scanValue("상품코드"));
				psmt.setString(4, scanValue("상품일련번호"));
				int affected = psmt.executeUpdate();
				System.out.println(affected + "행이 업데이트되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new UpdateShop().execute();
	}

}
