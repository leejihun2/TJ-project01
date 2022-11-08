package shopping;

public interface IConnect {

	String ORACLE_DRIVER= "oracle.jdbc.OracleDriver";
	String ORACLE_URE = "jdbc:oracle:thin:@localhost:1521:xe";
	
	void connect(String user, String pass);
	void execute();
	void close();
	String scanValue(String title);
}
