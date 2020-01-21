package FactoryMethod.LogisticsEx;

public class LogisticsApp {

	public static void main(String[] args) {

		String transportMode = "Road";

		if ("Road".equals(transportMode)) {
			new RoadLogistics().doDelivery();
		} else if ("Sea".equals(transportMode)) {
			new SeaLogistics().doDelivery();
		}

	}

}
