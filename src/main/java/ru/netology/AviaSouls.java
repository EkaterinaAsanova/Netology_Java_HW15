package ru.netology;

import java.util.Arrays;
import java.util.Comparator;


public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current Массив, в который мы хотим добавить элемент
     * @param ticket  Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    /**
     * Метод добавления билета в менеджер
     *
     * @param ticket Добавляемый билет
     */
    public void add(Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        for (int i = 0; i < tickets.length; i++) {
            System.out.println(tickets[i].getFrom() + '-' + tickets[i].getTo() +
                    ' ' + tickets[i].getPrice());
        }
        return tickets;
    }

    /**
     * Метод поиска билетов по маршруту
     *
     * @param from Откуда вылетаем
     * @param to   Куда прилетаем
     * @return Массив из подходящих билетов
     */
    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result, Ticket::compareTo);

        return result;
    }

    public void searchAndSortBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = search(from, to);

        Arrays.sort(result, comparator);
        this.tickets = result;
    }
}