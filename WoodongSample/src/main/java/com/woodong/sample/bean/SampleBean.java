package com.woodong.sample.bean;

public class SampleBean {
	private String key;
	private String value;

	public SampleBean (String key, String value) {
		this.key = key;
		this.value = value;
	}

	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}
}
