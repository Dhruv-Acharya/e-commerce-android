package com.onboarding.ecomm.Model.Response;

import com.google.gson.annotations.SerializedName;


public class ProductByCategoryResponce{

	@SerializedName("usp")
	private String usp;

	@SerializedName("productId")
	private String productId;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("category")
	private Category category;

	@SerializedName("priceRange")
	private String priceRange;

	@SerializedName("productName")
	private String productName;

	public void setUsp(String usp){
		this.usp = usp;
	}

	public String getUsp(){
		return usp;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setPriceRange(String priceRange){
		this.priceRange = priceRange;
	}

	public String getPriceRange(){
		return priceRange;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	@Override
 	public String toString(){
		return 
			"ProductByCategoryResponce{" + 
			"usp = '" + usp + '\'' + 
			",productId = '" + productId + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",description = '" + description + '\'' + 
			",category = '" + category + '\'' + 
			",priceRange = '" + priceRange + '\'' + 
			",productName = '" + productName + '\'' + 
			"}";
		}
}