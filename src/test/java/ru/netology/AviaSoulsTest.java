package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
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
            6500,
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
    Ticket ticket6 = new Ticket(
            "Пермь",
            "Москва",
            1500,
            10,
            11
    );

    @Test
    public void compareToPriceFirstMore() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        System.out.println(ticket1.getFrom() + "-" + ticket1.getTo() + " " + ticket1.getPrice());
        System.out.println(ticket2.getFrom() + "-" + ticket2.getTo() + " " + ticket2.getPrice());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToPriceFirstless() {
        int expected = -1;
        int actual = ticket2.compareTo(ticket3);

        System.out.println(ticket2.getFrom() + "-" + ticket2.getTo() + " " + ticket2.getPrice());
        System.out.println(ticket3.getFrom() + "-" + ticket3.getTo() + " " + ticket3.getPrice());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToPriceSame() {
        int expected = 0;
        int actual = ticket1.compareTo(ticket4);

        System.out.println(ticket1.getFrom() + "-" + ticket1.getTo() + " " + ticket1.getPrice());
        System.out.println(ticket4.getFrom() + "-" + ticket4.getTo() + " " + ticket4.getPrice());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchWithOrderedInAscendingOrderPrice() {
        AviaSouls fly = new AviaSouls();
        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        Ticket[] expected = {ticket6, ticket1, ticket4};
        Ticket[] actual = fly.search("Пермь", "Москва");

        fly.setTickets(actual);
        fly.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void orderingWithTicketTimeComparator() {
        AviaSouls fly = new AviaSouls();
        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);

        TicketTimeComparator TimeComparator = new TicketTimeComparator();

        Arrays.sort(fly.findAll(), TimeComparator);
        System.out.println();

        Ticket[] expected = {ticket3, ticket5, ticket6, ticket4, ticket2, ticket1};
        Ticket[] actual = fly.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void orderingWithSearchAndSortByPrice() {
        AviaSouls fly = new AviaSouls();
        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);

        fly.searchAndSortBy("Пермь", "Москва", Comparator.comparing(Ticket::getPrice));

        Ticket[] expected = {ticket6, ticket1, ticket4};
        Ticket[] actual = fly.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
