package com.henry.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edWeight;
    private EditText edHeigh;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        findViews();
        String hello=getString(R.string.hello);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeigh = findViewById(R.id.ed_height);
        result = findViewById(R.id.result_bmi);
        Button help = findViewById(R.id.help);
        help.setOnClickListener(view -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.help)
                    .setMessage(R.string.bmi_info)
                    .setPositiveButton(R.string.ok,null)
                    .show();

        });
    }

    public void bmi(View view){
        String w=edWeight.getText().toString();
        String h=edHeigh.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("MainActivity", "BMI : "+bmi);
        Toast.makeText(this,getString(R.string.your_bmi_is)+bmi,Toast.LENGTH_LONG).show();
        result.setText(getString(R.string.your_bmi_is)+bmi);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("BMI",bmi);
        startActivity(intent);

       /* new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(getString(R.string.your_bmi_is)+bmi)
                .setPositiveButton(getString(R.string.ok), (dialogInterface,i) ->{
                    edWeight.setText("");
                    edHeigh.setText("");
                })
                .show();*/


    }

}