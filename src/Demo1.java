public class Demo1 {
	public static void main(String[] args) {
		String greeting = "Hello Kitty";
		String[] array = new String[]{
				"a", "b", "c", "d", "e"
		};
		System.out.println(greeting);
		
		for (String tmp : array) {
			System.out.println("current -> " + tmp);
		}
	}
}
