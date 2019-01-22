package com.onboarding.ecomm.Model.Request;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class SignUpRequest {

	@SerializedName("password")
	private String password;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"SignUpRequest{" +
			"password = '" + password + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}