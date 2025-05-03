package ru.netology;


import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(
                "Пермь",
                "Москва",
                6500,
                18,
                22
        );

        Ticket ticket2 = new Ticket(
                "Москва",
                "Санкт-Петербург",
                4500,
                9,
                12
        );
        Ticket ticket3 = new Ticket(
                "Пермь",
                "Сочи",
                6000,
                15,
                16
        );
        Ticket ticket4 = new Ticket(
                "Пермь",
                "Москва",
                3500,
                11,
                13
        );
        Ticket ticket5 = new Ticket(
                "Пермь",
                "Казань",
                5900,
                10,
                11
        );
    }
}

