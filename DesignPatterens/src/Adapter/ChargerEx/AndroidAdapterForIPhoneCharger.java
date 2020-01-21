package Adapter.ChargerEx;

public class AndroidAdapterForIPhoneCharger implements IPhone {

	private Android android;

	AndroidAdapterForIPhoneCharger(Android android) {
		this.android = android;
	}

	@Override
	public void charge() {
		android.charge();
	}

}
