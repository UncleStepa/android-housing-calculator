package com.example.housing_calculator.model.responses;

import com.google.gson.annotations.SerializedName;



public class ResponsePriceChange{


	@SerializedName("resultCode")
	private String resultCode;

	@SerializedName("resultText")
	private String resultText;



	public void setResultText(String resultText){
		this.resultText = resultText;
	}

	public String getResultText(){
		return resultText;
	}

	public void setResultCode(String resultCode){
		this.resultCode = resultCode;
	}

	public String getResultCode(){
		return resultCode;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePriceChange{" +
			",resultCode = '" + resultCode + '\'' +
			"resultText = '" + resultText + '\'' +
			"}";
		}
}