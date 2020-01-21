package FactoryMethod.LogisticsEx;


public abstract class Logistics {

	abstract Transport createTransport();

	void doDelivery() {
		Transport transport = createTransport();
		transport.deliver();
	}
}
