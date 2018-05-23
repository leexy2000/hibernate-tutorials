package org.tutorialspoint.domain;

import java.io.Serializable;
public class Tuser1 implements Serializable {

	private static final long serialVersionUID = 339292953621055195L;
	private Integer id;
	private String name;

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

}
