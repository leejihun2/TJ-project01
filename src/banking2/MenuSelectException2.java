package banking2;
//개발자가 직접 정의한 예외처리 클래스
public class MenuSelectException2 extends Exception{
	//예외처리
	public MenuSelectException2() {
		super("1~5의숫자를 입력하세요.");
	}
	
}
