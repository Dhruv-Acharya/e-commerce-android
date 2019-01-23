package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;


public class ProductResponse{

	@SerializedName("highestPrice")
	private int highestPrice;

	@SerializedName("lowestPrice")
	private int lowestPrice;

	@SerializedName("usp")
	private String usp;

	@SerializedName("productId")
	private String productId;

	@SerializedName("ratingCounter")
	private int ratingCounter;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private float rating;

	@SerializedName("description")
	private String description;

	@SerializedName("category")
	private Category category;

	public void setHighestPrice(int highestPrice){
		this.highestPrice = highestPrice;
	}

	public int getHighestPrice(){
		return highestPrice;
	}

	public void setLowestPrice(int lowestPrice){
		this.lowestPrice = lowestPrice;
	}

	public int getLowestPrice(){
		return lowestPrice;
	}

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

	public void setRatingCounter(int ratingCounter){
		this.ratingCounter = ratingCounter;
	}

	public int getRatingCounter(){
		return ratingCounter;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(float rating){
		this.rating = rating;
	}

	public float getRating(){
		return rating;
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

	@Override
 	public String toString(){
		return 
			"ProductResponse{" + 
			"highestPrice = '" + highestPrice + '\'' + 
			",lowestPrice = '" + lowestPrice + '\'' + 
			",usp = '" + usp + '\'' + 
			",productId = '" + productId + '\'' + 
			",ratingCounter = '" + ratingCounter + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",rating = '" + rating + '\'' + 
			",description = '" + description + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}