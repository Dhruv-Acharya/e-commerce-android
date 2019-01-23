package com.onboarding.ecomm.Model.Response;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class MerchantResponse{

	@SerializedName("qunatity")
	private int qunatity;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("price")
	private int price;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private int rating;

	@SerializedName("discount")
	private int discount;

	@SerializedName("emailId")
	private Object emailId;

	public void setQunatity(int qunatity){
		this.qunatity = qunatity;
	}

	public int getQunatity(){
		return qunatity;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setDiscount(int discount){
		this.discount = discount;
	}

	public int getDiscount(){
		return discount;
	}

	public void setEmailId(Object emailId){
		this.emailId = emailId;
	}

	public Object getEmailId(){
		return emailId;
	}

	@Override
 	public String toString(){
		return 
			"MerchantResponse{" + 
			"qunatity = '" + qunatity + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",rating = '" + rating + '\'' + 
			",discount = '" + discount + '\'' + 
			",emailId = '" + emailId + '\'' + 
			"}";
		}
}