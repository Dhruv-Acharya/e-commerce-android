package com.onboarding.ecomm.Model.Response;

import com.google.gson.annotations.SerializedName;

public class OrderPageResponse{

	@SerializedName("date")
	private String date;

	@SerializedName("amount")
	private int amount;

	@SerializedName("orderId")
	private String orderId;

	@SerializedName("customerId")
	private String customerId;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}

	public String getCustomerId(){
		return customerId;
	}

	@Override
 	public String toString(){
		return 
			"OrderPageResponse{" + 
			"date = '" + date + '\'' + 
			",amount = '" + amount + '\'' + 
			",orderId = '" + orderId + '\'' + 
			",customerId = '" + customerId + '\'' + 
			"}";
		}
}