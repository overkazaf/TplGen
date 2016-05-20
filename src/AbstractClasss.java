
public abstract class AbstractClasss {
	private String name;
	private String address;
	private int number;

	public AbstractClasss (String name, String address, int number) {
		this.name = name;
		this.address = address;
		this.number = number;
	}
	public abstract void print();

	public abstract void read();

	public abstract void write();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
