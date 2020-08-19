package com.example.housing_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.housing_calculator.model.requests.CurrentTestimony;
import com.example.housing_calculator.model.requests.RequestSaveTestimony;
import com.example.housing_calculator.model.responses.ResponseSaveTestimony;
import com.example.housing_calculator.utils.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SaveTestimony extends Activity {

    public RequestSaveTestimony requestSaveTestimony = new RequestSaveTestimony();
    private CurrentTestimony currentTestimony = new CurrentTestimony();
    private EditText editDate;
    private EditText editColdWater;
    private EditText editHotWater;
    private EditText editGas;
    private EditText editElectricity;
    private TextView testimonyTittle;
    private TextView mandatoryField;
    private Button sentTestimony;
    private TextView result;
    private String saveUrl = "http://localhost:8080/services/testimony/save";
    private String coldString;
    private String hotString;
    private String gasString;
    private String elecString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_testimony);

        testimonyTittle = findViewById(R.id.tx_currentTestimony);
        editDate = findViewById(R.id.et_date);
        editColdWater = findViewById((R.id.et_coldWater));
        editHotWater = findViewById((R.id.et_hotWater));
        editGas = findViewById(R.id.et_gas);
        editElectricity = findViewById(R.id.et_electricity);
        mandatoryField = findViewById(R.id.tx_textView7);
        sentTestimony = findViewById((R.id.b_sentTestimony));
        result = findViewById((R.id.tv_result));


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coldString = editColdWater.getText().toString();
                hotString = editHotWater.getText().toString();
                gasString = editGas.getText().toString();
                elecString = editElectricity.getText().toString();
                requestSaveTestimony.setDate(editDate.getText().toString());
                currentTestimony.setColdWater(Integer.parseInt(coldString));
                currentTestimony.setHotWater(Integer.parseInt(hotString));
                currentTestimony.setGas(Integer.parseInt(gasString));
                currentTestimony.setElectricity(Integer.parseInt(elecString));
                requestSaveTestimony.setCurrentTestimony(currentTestimony);
                List<RequestSaveTestimony> listRequest = new ArrayList<>();
                listRequest.add(requestSaveTestimony);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8080/services/testimony/") // Адрес сервера
                        .addConverterFactory(GsonConverterFactory.create()) // говорим ретрофиту что для сериализации необходимо использовать GSON
                        .build();

                Server service = retrofit.create(Server.class);
                Call<ResponseSaveTestimony> call = service.saveTestimony(requestSaveTestimony);
                System.out.println(call.toString());
                System.out.println(requestSaveTestimony.toString());
                call.enqueue(new Callback<ResponseSaveTestimony>() {
                    @Override
                    public void onResponse(Call<ResponseSaveTestimony> call, Response<ResponseSaveTestimony> response) {

                        if (response.isSuccessful()) {
                            // код для успешного случая
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

                    @Override
                    public void onFailure(Call<ResponseSaveTestimony> call, Throwable t) {
                        System.out.println("222222222222222222222222");
                    }
                });

            }
        };
        sentTestimony.setOnClickListener(onClickListener);
    }

}
