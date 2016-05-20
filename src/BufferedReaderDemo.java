import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char c;
//		
//		System.out.println("Enter character and press q to exit");
//		do {
//			c = (char) br.read();
//			System.out.println(c);
//		} while (c != 'q');
		String line;
		
		do {
			line = (String) br.readLine();
			System.out.println(line);
		} while (!line.equals("end"));
	}
}
