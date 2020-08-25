package com.example.housing_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housing_calculator.model.requests.CurrentTestimony;
import com.example.housing_calculator.model.requests.RequestSaveTestimony;
import com.example.housing_calculator.model.responses.ResponseSaveTestimony;
import com.example.housing_calculator.utils.Server;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SaveTestimony extends AppCompatActivity {

    public RequestSaveTestimony requestSaveTestimony = new RequestSaveTestimony();
    private CurrentTestimony currentTestimony = new CurrentTestimony();
    private EditText editDate;
    private EditText editColdWater;
    private EditText editHotWater;
    private EditText editGas;
    private EditText editElectricity;
    private Button sentTestimony;
    private String coldString;
    private String hotString;
    private String gasString;
    private String elecString;
    private static ResponseSaveTestimony responseSaveTestimony = new ResponseSaveTestimony();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_testimony);
        editDate = findViewById(R.id.et_date);
        editColdWater = findViewById((R.id.et_coldWater));
        editHotWater = findViewById((R.id.et_hotWater));
        editGas = findViewById(R.id.et_gas);
        editElectricity = findViewById(R.id.et_electricity);
        sentTestimony = findViewById(R.id.b_sentTestimony);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                coldString = editColdWater.getText().toString();
                hotString = editHotWater.getText().toString();
                gasString = editGas.getText().toString();
                elecString = editElectricity.getText().toString();
                requestSaveTestimony.setDate(editDate.getText().toString());
                currentTestimony.setColdWater(Integer.parseInt(coldString));
                currentTestimony.setHotWater(Integer.parseInt(hotString));

                if (gasString.equals("")) {
                    currentTestimony.setGas(0);
                } else {
                    currentTestimony.setGas(Integer.parseInt(gasString));
                }
                currentTestimony.setElectricity(Integer.parseInt(elecString));
                requestSaveTestimony.setCurrentTestimony(currentTestimony);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/services/testimony/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Server service = retrofit.create(Server.class);
                Call<ResponseSaveTestimony> call = service.saveTestimony(requestSaveTestimony);
                call.enqueue(new Callback<ResponseSaveTestimony>() {
                    @Override
                    public void onResponse(Call<ResponseSaveTestimony> call, Response<ResponseSaveTestimony> response) {

                        if (response.isSuccessful()) {
                            responseSaveTestimony = response.body();
                            generateTable(view);

                        } else {

                            switch (response.code()) {
                                case 404:
                                    System.out.println(404);
                                    break;
                                case 500:
                                    System.out.println(500);
                                    break;
                            }
                        }
                    }

                    public void generateTable(View view) {
                        Intent intent = new Intent(SaveTestimony.this, ResultTable.class);
                        intent.putExtra("currentDate", responseSaveTestimony.getDate());
                        intent.putExtra("previousDate", responseSaveTestimony.getPreviousDate());
                        intent.putExtra("consumedСoldWater", responseSaveTestimony.getConsumed().getColdWater());
                        intent.putExtra("consumedHotWater", responseSaveTestimony.getConsumed().getHotWater());
                        intent.putExtra("consumedGas", responseSaveTestimony.getConsumed().getGas());
                        intent.putExtra("consumedElectricity", responseSaveTestimony.getConsumed().getElectricity());
                        intent.putExtra("costСoldWater", responseSaveTestimony.getCost().getColdWater());
                        intent.putExtra("costHotWater", responseSaveTestimony.getCost().getHotWater());
                        intent.putExtra("costGas", responseSaveTestimony.getCost().getGas());
                        intent.putExtra("costElectricity", responseSaveTestimony.getCost().getElectricity());
                        intent.putExtra("totalCost", responseSaveTestimony.getTotalCost());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ResponseSaveTestimony> call, Throwable t) {
                    }
                });

            }

        };

        sentTestimony.setOnClickListener(onClickListener);
    }
    public void backMain(View view) {
        Intent intent = new Intent(SaveTestimony.this, MainActivity.class);
        startActivity(intent);
    }


}
