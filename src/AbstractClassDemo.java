
public class AbstractClassDemo extends AbstractClasss{

	public AbstractClassDemo (String name, String address, int number) {
		super(name, address, number);
	}
	
	public String toString(){
		return this.getName() + "::" + this.getAddress() + "::" + this.getNumber();
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("print() in subclass");
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("read() in subclass");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("write() in subclass");
	}
	
	public static void main(String[] args) {
		AbstractClassDemo demo = new AbstractClassDemo("JohnDoe", "WallStreet", 12323);
		
		demo.print();
		demo.read();
		demo.write();
		
		System.out.println(demo);
	}

}
