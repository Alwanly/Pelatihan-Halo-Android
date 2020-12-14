package com.sertifikasi.haloandroid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainViewModelTest {

    private MainViewModel mainViewModel;

    @Before
    public void init(){
        mainViewModel= new MainViewModel();
    }

    @Test
    public void calculate() {
        String width="1";
        String length = "2";
        String height = "3";
        mainViewModel.calculate(width,length,height);
        assertEquals(6,mainViewModel.result);
    }
}