package com.ngekoding.userinterface;

import android.app.Dialog;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ComponentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToast, btnDialog, btnSnackbar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        btnToast = (Button) findViewById(R.id.btn_toast);
        btnSnackbar = (Button) findViewById(R.id.btn_snackbar);
        btnDialog = (Button) findViewById(R.id.btn_dialog);

        btnToast.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog:
                showDialog();
                break;
            case R.id.btn_snackbar:
                showSnackbar();
                break;
            case R.id.btn_toast:
                showToast();
                break;
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog")
                .setMessage("Hello, welcome to my home");

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showSnackbar() {
        snackbar = Snackbar.make(btnSnackbar, "Hello", BaseTransientBottomBar.LENGTH_LONG);
        snackbar.show();
    }

    private void showToast() {
        Toast.makeText(this, "Hi, how are you?", Toast.LENGTH_SHORT).show();
    }
}
