package com.ngekoding.userinterface;

import android.app.Dialog;
import android.content.DialogInterface;
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

        // View binding
        btnToast = (Button) findViewById(R.id.btn_toast);
        btnSnackbar = (Button) findViewById(R.id.btn_snackbar);
        btnDialog = (Button) findViewById(R.id.btn_dialog);

        btnToast.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:
                // Tampilkan toast
                Toast.makeText(this, "Hi, welcome friend...", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_dialog:
                // Tampilkan dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("Delete Confirmation")
                        .setMessage("Are you sure to delete this file?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Proses delete
                                Toast.makeText(ComponentActivity.this, "File deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.btn_snackbar:
                // Tampilkan snackbar
                snackbar = Snackbar.make(btnSnackbar, "No internet connection", Snackbar.LENGTH_LONG);
                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ComponentActivity.this, "Reconnecting...", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
                break;
        }
    }
}
