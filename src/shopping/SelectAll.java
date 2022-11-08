package shopping;

import java.sql.SQLException;

public class SelectAll extends IConnectImpl {

	public SelectAll() {
		super("education", "1234");
	}

	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String query = "SELECT g_idx, goods_name, " + " ltrim(to_char(goods_price, '999,999,999')), "
					+ " ltrim(to_char(regidate, 'yyyy-mm-dd hh:mi')), p_code " 
					+ " FROM sh_goods";

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
		SelectAll selctall = new SelectAll();
		selctall.execute();
	}
}
