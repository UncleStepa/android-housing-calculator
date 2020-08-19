package com.example.housing_calculator.model.requests;

import com.google.gson.annotations.SerializedName;




public class Price{



	@SerializedName("priceHotWater")
	private double priceHotWater;

	@SerializedName("priceGas")
	private double priceGas;

	@SerializedName("priceColdWater")
	private double priceColdWater;

	@SerializedName("priceElectricity")
	private double priceElectricity;


	public void setPriceHotWater(double priceHotWater){
		this.priceHotWater = priceHotWater;
	}

	public double getPriceHotWater(){
		return priceHotWater;
	}

	public void setPriceGas(double priceGas){
		this.priceGas = priceGas;
	}

	public double getPriceGas(){
		return priceGas;
	}

	public void setPriceColdWater(double priceColdWater){
		this.priceColdWater = priceColdWater;
	}

	public double getPriceColdWater(){
		return priceColdWater;
	}

	public void setPriceElectricity(double priceElectricity){
		this.priceElectricity = priceElectricity;
	}

	public double getPriceElectricity(){
		return priceElectricity;
	}

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"priceHotWater = '" + priceHotWater + '\'' + 
			",priceGas = '" + priceGas + '\'' + 
			",priceColdWater = '" + priceColdWater + '\'' + 
			",priceElectricity = '" + priceElectricity + '\'' + 
			"}";
		}
}