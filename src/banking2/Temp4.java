package banking2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import shopping.IConnect;
import shopping.IConnectImpl;

public class Temp4 implements IConnect{
	
	public Connection con;
	public PreparedStatement msmt;
	public Statement stmt;
	public CallableStatement csmt;
	public ResultSet rs;
	
	public Temp4() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}

	@Override
	public void connect(String user, String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String scanValue(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
