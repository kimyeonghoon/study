
public class Dog implements Nameable {

	String dogName;

	@Override
	public String getName() {
		return dogName;
	}

	@Override
	public void setName(String myName) {
		dogName = myName;
	}
	
}
