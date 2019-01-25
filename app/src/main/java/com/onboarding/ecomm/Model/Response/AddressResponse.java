package com.onboarding.ecomm.Model.Response;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class AddressResponse{

	@SerializedName("address")
	private String address;

	@SerializedName("addressId")
	private String addressId;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setAddressId(String addressId){
		this.addressId = addressId;
	}

	public String getAddressId(){
		return addressId;
	}

	@Override
 	public String toString(){
		return 
			"AddressResponse{" + 
			"address = '" + address + '\'' + 
			",addressId = '" + addressId + '\'' + 
			"}";
		}
}