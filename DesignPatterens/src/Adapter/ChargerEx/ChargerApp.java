package Adapter.ChargerEx;

public class ChargerApp {

	public static void main(String[] args) {

		AndroidCharger androidCharger = new AndroidCharger();
		Android android = new OnePlus5();
		androidCharger.charge(android);

		IPhoneCharger iPhoneCharger = new IPhoneCharger();
		AndroidAdapterForIPhoneCharger adapter = new AndroidAdapterForIPhoneCharger(android);
		iPhoneCharger.charge(adapter);

	}

}
