import java.net.InetAddress;

public class GetAddr {
	public static void main(String[] args) {
		InetAddress address = null;
		try {
			String host = "www.baidu.com";
			address = InetAddress.getByName(host);
			
			System.out.println(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
