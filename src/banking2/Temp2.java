package banking2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Temp2 {
	
public static void main(String[] args) {
		
	ObjectInputStream in = null;
	ObjectOutputStream out = null;
		int copyByte = 0;
		
		try {
			in = new ObjectInputStream(new FileInputStream("src/banking2/AccountInfo.obj"));
			
			out = new ObjectOutputStream(new FileOutputStream("src/banking2/AccountInfo.obj"));
			
			int bData;
			while (true) {
				
				bData = in.read();
				
				if (bData == -1) {
					break;
				}
				
				out.write(bData);
				
				copyByte++;
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지않습니다");
		} 
		catch (IOException e) {
			System.out.println("파일스트림 생성시 오류발생됨");
		} 
		finally {
			/*
			try문으로 진입하여 스트림을 생성했다면 finally구문에서는
			스트림을 닫아준다. try구문으로 진입했을때 무조건 실행되는
			구문이 finally절이다.
			 */
			try {
				in.close();
				out.close();

				System.out.println("복사된 KByte 크기:" +
						(copyByte / 1024));
			}
			catch (IOException e) {
				System.out.println("파일스트림닫기오류");
			}
		}
	}
}
