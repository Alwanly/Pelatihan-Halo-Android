package com.sertifikasi.haloandroid;

public class MainViewModel extends androidx.lifecycle.ViewModel {

    int result =0;

    void calculate(String width, String height, String length){
        result = Integer.parseInt(width)*Integer.parseInt(height)*Integer.parseInt(length);
    }
}
