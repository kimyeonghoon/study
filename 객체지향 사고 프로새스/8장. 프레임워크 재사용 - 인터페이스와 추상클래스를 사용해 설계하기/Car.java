
public class Car implements Nameable{

	String carName;
	
	@Override
	public String getName() {
		return carName;
	}

	@Override
	public void setName(String myName) {
		carName = myName;
	}
	
}
