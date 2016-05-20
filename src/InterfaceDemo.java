
public class InterfaceDemo implements CombondInterface, YieldInterface{

	
	public static void main(String[] args) {
		InterfaceDemo demo = new InterfaceDemo();
		
		demo.bark();
		demo.combond();
		int res = demo.yield();
		System.out.println(res);
	}

	@Override
	public int yield() {
		// TODO Auto-generated method stub
		return Math.random() > 0.5 ? 1 : 0;
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("HHH");
	}

	@Override
	public void combond() {
		// TODO Auto-generated method stub
		System.out.println("66666666666");
	}
}
