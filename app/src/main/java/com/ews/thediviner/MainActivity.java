package com.ews.thediviner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    private EditText etNumber;
    private TextView tvResult;

    private int numberUser;
    private int nextRandom;

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etNumber = (EditText) findViewById(R.id.etNumber);
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.nextRandom = new Random().nextInt(10);

        //Alert Dialog
        this.dialog = new AlertDialog.Builder(this)
            .setTitle("Correct")
            .setMessage("The number " + this.numberUser)
            .setIcon(R.drawable.ic_warning_black_18dp)
            .setNegativeButton(R.string.bt_disagree, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Sorry about that!", Toast.LENGTH_SHORT).show();
                }
            })
            .setPositiveButton(R.string.bt_agree, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Thanks for agree!", Toast.LENGTH_SHORT).show();
                }
            }).create();
    }


    public void send(View view) {
        this.numberUser = TextUtils.isEmpty(this.etNumber.getText().toString())
                ? 0 : Integer.valueOf(this.etNumber.getText().toString());
        Log.d(TAG, "MainActivity.send");
        Log.i(TAG, "NumerUser: " + this.numberUser);
        Log.i(TAG, "Random: " + this.nextRandom);

        if (this.numberUser < this.nextRandom) {
            this.tvResult.setText("Numero Menor");
        } else if (this.numberUser > this.nextRandom) {
            this.tvResult.setText("Numero Maior");
        } else {
            this.dialog.show();
        }

    }

}
