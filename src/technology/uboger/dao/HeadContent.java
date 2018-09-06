package technology.uboger.dao;

import java.io.Serializable;

public class HeadContent implements Serializable {
	private String duty;
	private String name;
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
