package com.homework.homework1;

import com.demo.PhoneImpl;

public class Phone implements PhoneImpl {

    @Override
    public void cell() {
        System.out.println("打电话");
    }

    @Override
    public void Internet() {
        System.out.println("上网");
    }
}
