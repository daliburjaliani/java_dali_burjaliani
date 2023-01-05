package com.example.java_dali_burjaliani;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class FlightUtilTest {
    @Test
    public void testDiscount(){
        FlightUtil flightUtil = new FlightUtil();
        double discount = flightUtil.discount(240);
        discount = Double.parseDouble(new DecimalFormat("###.#").format(discount));
        Assert.assertEquals(discount, 48.0);

    }

    @Test
    public void testInsert(){
        FlightUtil flightUtil = new FlightUtil();
        String result = flightUtil.insert(new Flight("tbilisi", "02.03.2023", 5, 150));
        Assert.assertEquals(result, "Item inserted successfully");

    }
}
