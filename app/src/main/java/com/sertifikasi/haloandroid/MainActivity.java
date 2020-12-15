package com.sertifikasi.haloandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.sertifikasi.haloandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        displayResult();
        findViewById(R.id.btn_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String width = activityMainBinding.edtWidth.getText().toString();
                String height = activityMainBinding.edtHeight.getText().toString();
                String length = activityMainBinding.edtLength.getText().toString();
                if (length.isEmpty()) {
                    activityMainBinding.edtLength.setError("Masih kosong");
                } else if (width.isEmpty()) {
                    activityMainBinding.edtWidth.setError("Masih kosong");
                } else if (height.isEmpty()) {
                    activityMainBinding.edtHeight.setError("Masih kosong");
                } else {
                    mainViewModel.calculate(width, height, length);
                    displayResult();
                }
            }
        });
    }

    private void displayResult() {
        activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.result));
    }
}