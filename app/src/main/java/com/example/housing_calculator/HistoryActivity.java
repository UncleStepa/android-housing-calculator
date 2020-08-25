package com.example.housing_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housing_calculator.model.responses.ResponseSaveTestimony;
import com.example.housing_calculator.utils.Server;
import com.example.housing_calculator.utils.ServerHistory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity  extends AppCompatActivity {

    private EditText editDate;
    private Button b_getHistory;
    private static ResponseSaveTestimony responseSaveTestimony = new ResponseSaveTestimony();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_testimony);

        editDate = findViewById(R.id.et_dateHistory);
        b_getHistory = findViewById(R.id.b_getHistoryTestimony);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServerHistory service = retrofit.create(ServerHistory.class);
                Call<ResponseSaveTestimony> call = service.getHistoryTestimony(editDate.getText().toString());
                call.enqueue(new Callback<ResponseSaveTestimony>() {
                    @Override
                    public void onResponse(Call<ResponseSaveTestimony> call, Response<ResponseSaveTestimony> response) {

                        if (response.isSuccessful()) {
                            responseSaveTestimony = response.body();
                            generateHistoryTable(view);

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

                    public void generateHistoryTable(View view) {
                        Intent intent = new Intent(HistoryActivity.this, ResultTable.class);
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

        b_getHistory.setOnClickListener(onClickListener);
    }
    public void backMain(View view) {
        Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
