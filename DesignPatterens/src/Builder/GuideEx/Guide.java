package Builder.GuideEx;

import java.math.BigDecimal;

public class Guide {

	private Integer id;

	private String name;
	private BigDecimal salary;

	private Integer staffId;

	Guide() {
	}

	private Guide(GuideBuilder guideBuilder) {
		this.id = guideBuilder.id;
		this.staffId = guideBuilder.staffId;
		this.name = guideBuilder.name;
		this.salary = guideBuilder.salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public static class GuideBuilder {
		private Integer id;
		private String name;
		private BigDecimal salary;
		private Integer staffId;

		public GuideBuilder(Integer id, Integer staffId, String name) {
			this.id = id;
			this.staffId = staffId;
			this.name = name;
		}

		public GuideBuilder setSalary(BigDecimal salary) {
			this.salary = salary;
			return this;
		}

		public Guide build() {
			return new Guide(this);

		}

	}

	@Override
	public String toString() {
		return "Guide [id=" + id + ", name=" + name + ", salary=" + salary + ", staffId=" + staffId + "]";
	}

}
