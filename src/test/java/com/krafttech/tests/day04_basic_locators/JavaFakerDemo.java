package com.krafttech.tests.day04_basic_locators;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class JavaFakerDemo {
    public static void main(String[] args) {
        Faker faker=new Faker();

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

        System.out.println("faker.finance().creditCard(CreditCardType.MASTERCARD) = " + faker.finance().creditCard(CreditCardType.MASTERCARD));

        System.out.println("faker.internet().password() = " + faker.internet().password());

        System.out.println("faker.internet().password(8,16,true,true,false) = " + faker.internet().password(8, 16,
                true, true, true));

        //AB*12a ile başlayan şifre

        System.out.println("\"AB*12a\"+faker.internet().password() = " + "AB*12a" + faker.internet().password());
    }
}
