package com.ui.pojo;

import java.util.Map;

import com.constants.EnvironmentConstants;

public class Config {
	Map<String, Environment> environments;

	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}
}
