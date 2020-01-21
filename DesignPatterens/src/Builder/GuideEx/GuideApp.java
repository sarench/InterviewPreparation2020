package Builder.GuideEx;

import java.math.BigDecimal;

public class GuideApp {

	public static void main(String[] args) {
		Guide guide = new Guide.GuideBuilder(1, 20, "sara").setSalary(new BigDecimal(1000)).build();
		System.out.println(guide);
	}

}
