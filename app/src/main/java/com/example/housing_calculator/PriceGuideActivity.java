package com.example.housing_calculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.housing_calculator.model.requests.Price;
import com.example.housing_calculator.model.requests.PriceChange;
import com.example.housing_calculator.model.responses.ResponsePriceChange;
import com.example.housing_calculator.utils.dialogpages.CustomDialogFragmentChangePrice;
import com.example.housing_calculator.utils.ServerPriceChange;
import com.example.housing_calculator.utils.dialogpages.DialogEmptyFields;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PriceGuideActivity extends AppCompatActivity {

    private PriceChange priceChange = new PriceChange();
    private Price price = new Price();
    private EditText editPriceCold;
    private EditText editPriceHot;
    private EditText editPriceElec;
    private EditText editPriceGas;
    private Button butChangePrice;
    private String coldString;
    private String hotString;
    private String gasString;
    private String elecString;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_guide);

        editPriceCold = findViewById(R.id.et_coldPrice);
        editPriceHot = findViewById(R.id.et_hotPrice);
        editPriceGas = findViewById(R.id.et_gasPrice);
        editPriceElec = findViewById(R.id.et_electricityPrice);
        butChangePrice = findViewById(R.id.b_updatePriceGuide);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                coldString = editPriceCold.getText().toString();
                hotString = editPriceHot.getText().toString();
                gasString = editPriceGas.getText().toString();
                elecString = editPriceElec.getText().toString();

                if (coldString.equals("") || hotString.equals("") || elecString.equals("")) {
                    showDialogEmpty(view);
                }
                else {
                    price.setPriceColdWater(Integer.parseInt(coldString));
                    price.setPriceHotWater(Integer.parseInt(hotString));
                    price.setPriceElectricity(Integer.parseInt(elecString));
                    priceChange.setPrice(price);
                }
                if (gasString.equals("")) {
                    price.setPriceGas(0);
                } else {
                    price.setPriceGas(Integer.parseInt(gasString));
                }
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/services/testimony/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServerPriceChange serverPriceChange = retrofit.create(ServerPriceChange.class);
                Call<ResponsePriceChange> call = serverPriceChange.changePriceGuide(priceChange);
                call.enqueue(new Callback<ResponsePriceChange>() {
                    @Override
                    public void onResponse(Call<ResponsePriceChange> call, Response<ResponsePriceChange> response) {

                        if (response.isSuccessful()) {
//                            responsePriceChange = response.body();
                            showDialog(view);
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

                    public void showDialog(View v) {
                        CustomDialogFragmentChangePrice dialog = new CustomDialogFragmentChangePrice();
                        dialog.show(getSupportFragmentManager(), "custom");
                    }


                    @Override
                    public void onFailure(Call<ResponsePriceChange> call, Throwable t) {
                    }
                });

            }

        };

        butChangePrice.setOnClickListener(onClickListener);
    }

    public void backMain(View view) {
        Intent intent = new Intent(PriceGuideActivity.this, MainActivity.class);
        startActivity(intent);
    }
        public void showDialogEmpty(View v) {
            DialogEmptyFields dialog = new DialogEmptyFields();
            dialog.show(getSupportFragmentManager(), "custom");
        }
}
