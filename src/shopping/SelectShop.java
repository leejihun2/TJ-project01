package shopping;

import java.sql.SQLException;

public class SelectShop extends IConnectImpl {

	public SelectShop() {
		super("education", "1234");
	}

	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String item = scanValue("상품명");
			String query = "SELECT g_idx, goods_name, " + " to_char(goods_price, '999,999,999'), "
					+ " to_char(regidate, 'yyyy-mm-dd hh:mi'), p_code " 
					+ " FROM sh_goods WHERE goods_name "
					+ " LIKE '%" + item + "%'";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String idx = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String date = rs.getString(4);
				String code = rs.getString(5);

				System.out.printf("%s %s %s %s %s\n", idx, name, price, date, code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public static void main(String[] args) {
		SelectShop selctSQL = new SelectShop();
		selctSQL.execute();
	}

}
