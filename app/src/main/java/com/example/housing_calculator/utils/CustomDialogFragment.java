package com.example.housing_calculator.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Информация")
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Тарифы успешно изменены")
                .setPositiveButton("OK", null)
                .create();
    }
}

