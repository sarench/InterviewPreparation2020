package FactoryMethod.LogisticsEx;

public class Truck implements Transport {

	@Override
	public void deliver() {
		System.out.println("Delivered By Truck");

	}

}
