package com.example.housing_calculator.model.responses;

import com.google.gson.annotations.SerializedName;

import java.math.RoundingMode;

public class ResponseSaveTestimony{

	@SerializedName("date")
	private String date;

	@SerializedName("previousDate")
	private String previousDate;

	@SerializedName("consumed")
	private Consumed consumed;

	@SerializedName("cost")
	private Cost cost;

	@SerializedName("totalCost")
	private double totalCost;

	@SerializedName("faultcode")
	private Faultcode faultcode;


	public ResponseSaveTestimony() {
	}

	public ResponseSaveTestimony(String date, String previousDate, Consumed consumed, Cost cost, double totalCost) {
		this.date = date;
		this.previousDate = previousDate;
		this.consumed = consumed;
		this.cost = cost;
		this.totalCost = totalCost;
	}

	public ResponseSaveTestimony(Faultcode faultcode) {
		this.faultcode = faultcode;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setConsumed(Consumed consumed){
		this.consumed = consumed;
	}

	public Consumed getConsumed(){
		return consumed;
	}

	public void setCost(Cost cost){
		this.cost = cost;
	}

	public Cost getCost(){
		return cost;
	}

	public void setFaultcode(Faultcode faultcode){
		this.faultcode = faultcode;
	}

	public Faultcode getFaultcode(){
		return faultcode;
	}

	public void setPreviousDate(String previousDate){
		this.previousDate = previousDate;
	}

	public String getPreviousDate(){
		return previousDate;
	}

	public void setTotalCost(double totalCost){
		this.totalCost = totalCost;
	}

	public double getTotalCost(){
		return totalCost;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSaveTestimony{" + 
			"date = '" + date + '\'' + 
			",consumed = '" + consumed + '\'' + 
			",cost = '" + cost + '\'' +
			",previousDate = '" + previousDate + '\'' + 
			",totalCost = '" + totalCost + '\'' +
			",faultcode = '" + faultcode + '\'' +
				"}";
		}
}