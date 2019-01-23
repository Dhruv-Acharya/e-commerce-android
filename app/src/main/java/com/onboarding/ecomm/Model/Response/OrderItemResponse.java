package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;

public class OrderItemResponse{

	@SerializedName("productImageUrl")
	private String productImageUrl;

	@SerializedName("productQuantity")
	private int productQuantity;

	@SerializedName("productId")
	private String productId;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("productDescription")
	private String productDescription;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productPrice")
	private int productPrice;

	@SerializedName("merchantName")
	private String merchantName;

	public void setProductImageUrl(String productImageUrl){
		this.productImageUrl = productImageUrl;
	}

	public String getProductImageUrl(){
		return productImageUrl;
	}

	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}

	public int getProductQuantity(){
		return productQuantity;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}

	public int getProductPrice(){
		return productPrice;
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
			"OrderItemResponse{" + 
			"productImageUrl = '" + productImageUrl + '\'' + 
			",productQuantity = '" + productQuantity + '\'' + 
			",productId = '" + productId + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productName = '" + productName + '\'' + 
			",productPrice = '" + productPrice + '\'' + 
			",merchantName = '" + merchantName + '\'' + 
			"}";
		}
}