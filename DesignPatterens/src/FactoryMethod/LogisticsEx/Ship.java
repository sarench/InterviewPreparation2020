package FactoryMethod.LogisticsEx;

public class Ship implements Transport {
	
	@Override
	public void deliver() {
		System.out.println("Delivered By Ship");

	}
}
