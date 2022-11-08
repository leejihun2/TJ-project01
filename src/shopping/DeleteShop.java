package shopping;

public class DeleteShop extends IConnectImpl{

	public DeleteShop() {
		super("education","1234");
	}
	@Override
	public void execute() {
		try {
			String query = "DELETE FROM sh_goods WHERE g_idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, scanValue("삭제할상품의일련번호"));
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	
	public static void main(String[] args) {
		new DeleteShop().execute();
		
	}

}
