package com.example.housing_calculator.utils.dialogpages;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogDateNotFaund extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Информация")
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Не найдены показания предыдущего периода")
                .setPositiveButton("OK", null)
                .create();
    }
}

