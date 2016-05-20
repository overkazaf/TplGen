class Cat {
	private String name;
	private String color;

	public Cat(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String toString() {
		return this.name + "::" + this.color;
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.toString() + " is disposed");
	}
};

public class FinalizeDemo {

	public static void main(String[] args) {
		Cat c1 = new Cat("Dudu", "White");
		Cat c2 = new Cat("Dudu1", "Blue");
		Cat c3 = new Cat("Dudu2", "Golden");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		c2 = c3 = null;
		System.gc();
	}
	
}
