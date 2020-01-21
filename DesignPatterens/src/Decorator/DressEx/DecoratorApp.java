package Decorator.DressEx;

public class DecoratorApp {

	public static void main(String[] args) {

		Dress dress = new CasualDress(new FancyDress(new BasicDress()));
		dress.manufacture();
	}

}

interface Dress {
	void manufacture();
}

class BasicDress implements Dress {

	@Override
	public void manufacture() {
		System.out.println("Basic Dress Features");
	}

}

class DressDecorator implements Dress {

	private Dress dress;

	DressDecorator(Dress dress) {
		this.dress = dress;
	}

	@Override
	public void manufacture() {
		dress.manufacture();
	}

}

class CasualDress extends DressDecorator {

	CasualDress(Dress dress) {
		super(dress);
	}

	@Override
	public void manufacture() {
		super.manufacture();
		System.out.println("Casual Dress Features");
	}

}

class FancyDress extends DressDecorator {

	FancyDress(Dress dress) {
		super(dress);
	}

	@Override
	public void manufacture() {
		super.manufacture();
		System.out.println("Fancy Dress Features");
	}

}
