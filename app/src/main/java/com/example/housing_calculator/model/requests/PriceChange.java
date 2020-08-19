package com.example.housing_calculator.model.requests;

import com.google.gson.annotations.SerializedName;




public class PriceChange{



	@SerializedName("price")
	private Price price;



	public void setPrice(Price price){
		this.price = price;
	}

	public Price getPrice(){
		return price;
	}

	@Override
 	public String toString(){
		return 
			"PriceChange{" + 
			"price = '" + price + '\'' + 
			"}";
		}
}