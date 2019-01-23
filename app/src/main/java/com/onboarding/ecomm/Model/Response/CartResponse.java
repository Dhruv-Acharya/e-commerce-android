package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;

public class CartResponse{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("price")
	private int price;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("product_id")
	private String productId;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("merchant_id")
	private String merchantId;

	@SerializedName("merchantName")
	private String merchantName;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}

	public String getMerchantName(){
		return merchantName;
	}

	@Override
 	public String toString(){
		return 
			"CartResponse{" + 
			"quantity = '" + quantity + '\'' + 
			",price = '" + price + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",product_id = '" + productId + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",merchant_id = '" + merchantId + '\'' + 
			",merchantName = '" + merchantName + '\'' + 
			"}";
		}
}