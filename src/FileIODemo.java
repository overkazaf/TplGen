import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileIODemo {
	public static void main(String[] args) throws IOException {
		
		//listDir(dirname);
		
		String tempDir = "e:/temp";
		String tempFileName = "test.txt";
		
		File file = new File(tempDir+"/"+tempFileName);
		
		
		OutputStream os = new FileOutputStream(file);
		byte[] b = {11,21,3,40,5};
		
		for (byte t : b) {
			os.write(t);
		}
		
		os.close();
		System.out.println("File has been successfully written...");
		
		InputStream is = new FileInputStream(file);
		
		int size = is.available();
		
		for (int i = 0; i < size; i++) {
			System.out.print((byte)is.read());
		}
		
		
		fixCaoticCodes();
		
	}
	
	public static void fixCaoticCodes () throws IOException {
		String filename = "e:/temp/test2.txt";
		File file = new File(filename);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
		
		String[] words = {
				"asdf",
				"sdf",
				"dsfsadf",
				"Good!"
		};
		
		for (String word : words) {
			writer.append(word);
			writer.append("\n");
		}
		
		writer.close();
		
		fos.close();
		
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
		
		StringBuilder sb = new StringBuilder();
		while (reader.ready()) {
			sb.append((char)reader.read());
		}
		System.out.println(sb.toString());
		reader.close();
		fis.close();
		
		System.out.println("Done");
		
	}
	
	public static void listDir(String dirname) {
		File f = new File(dirname);
		String[] files = f.list();
		System.out.println(dirname + " has " + files.length + " files");
		for (String file : files) {
			File tmp = new File(dirname + "/" + file);
			if (tmp.isDirectory()) {
				System.err.println(file + " is a directory");
			} else {
				System.out.println(file + " is a file");
			}
		}
	}
}
