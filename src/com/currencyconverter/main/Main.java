package com.currencyconverter.main;

import com.currencyconverter.service.CurrencyConverterService;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterService service = new CurrencyConverterService();
        service.run();
    }
}
