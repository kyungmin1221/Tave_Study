package com.in28minutes.learnspringapp.aopexample.business;

import com.in28minutes.learnspringapp.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

// 비즈니스 로직을 실행하는 클래스 //

@Service
public class BusinessService1 {
    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateMax() {
        int[] data = dataService1.retrieveData();
        return Arrays.stream(data).max().orElse(0);
    }
}
