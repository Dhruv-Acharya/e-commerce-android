package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;


public class LoginResponse{

	@SerializedName("customerId")
	private String customerId;

	@SerializedName("name")
	private String name;

	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}

	public String getCustomerId(){
		return customerId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"customerId = '" + customerId + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}