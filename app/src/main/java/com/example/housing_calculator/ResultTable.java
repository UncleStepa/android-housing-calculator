package com.example.housing_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResultTable extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_result_table);
        fillingTable();
    }



    public void fillingTable() {
        Bundle arguments = getIntent().getExtras();
        String currentDate = arguments.get("currentDate").toString();
        String previousDate = arguments.get("previousDate").toString();
        String consumedСoldWater = arguments.get("consumedСoldWater").toString();
        String costСoldWater = arguments.get("costСoldWater").toString();
        String consumedHotWater = arguments.get("consumedHotWater").toString();
        String costHotWater = arguments.get("costHotWater").toString();
        String consumedGas = arguments.get("consumedGas").toString();
        String costGas = arguments.get("costGas").toString();
        String consumedElectricity = arguments.get("consumedElectricity").toString();
        String costElectricity = arguments.get("costElectricity").toString();
        String totalCost = arguments.get("totalCost").toString();



        TableLayout tableLayout = (TableLayout) findViewById(R.id.result);
        LayoutInflater inflater = LayoutInflater.from(this);
        TableRow tr1 = (TableRow) inflater.inflate(R.layout.result_table, null);
        TextView tv1 = (TextView) tr1.findViewById(R.id.period);
        tv1.setText(currentDate + " / " + previousDate);
        tableLayout.addView(tr1);


        TableRow tr2 = (TableRow) inflater.inflate(R.layout.result_table_row2, null);
        tableLayout.addView(tr2);


        TableRow tr3 = (TableRow) inflater.inflate(R.layout.result_table_row3, null);
        TextView tv3_1 = (TextView) tr3.findViewById(R.id.consumedCold);
        tv3_1.setText(consumedСoldWater);
        TextView tv3_2 = (TextView) tr3.findViewById(R.id.costCold);
        tv3_2.setText(costСoldWater);
        tableLayout.addView(tr3);

        TableRow tr4 = (TableRow) inflater.inflate(R.layout.result_table_row4, null);
        TextView tv4_1 = (TextView) tr4.findViewById(R.id.consumedHot);
        tv4_1.setText(consumedHotWater);
        TextView tv4_2 = (TextView) tr4.findViewById(R.id.costHot);
        tv4_2.setText(costHotWater);
        tableLayout.addView(tr4);


        TableRow tr6 = (TableRow) inflater.inflate(R.layout.result_table_row_5, null);
        TextView tv6_1 = (TextView) tr6.findViewById(R.id.consumedGas);
        tv6_1.setText(consumedGas);
        TextView tv6_2 = (TextView) tr6.findViewById(R.id.costGas);
        tv6_2.setText(costGas);
        tableLayout.addView(tr6);

        TableRow tr7 = (TableRow) inflater.inflate(R.layout.result_table_row_6, null);
        TextView tv7_1 = (TextView) tr7.findViewById(R.id.consumedElec);
        tv7_1.setText(consumedElectricity);
        TextView tv7_2 = (TextView) tr7.findViewById(R.id.costElec);
        tv7_2.setText(costElectricity);
        tableLayout.addView(tr7);

        TableRow tr8 = (TableRow) inflater.inflate(R.layout.result_table_row_7, null);
        TextView tv8_1 = (TextView) tr8.findViewById(R.id.sumTotal);
        tv8_1.setText(totalCost);
        tableLayout.addView(tr8);
    }
    public void backMain(View view) {
        Intent intent = new Intent(ResultTable.this, MainActivity.class);
        startActivity(intent);
    }
}