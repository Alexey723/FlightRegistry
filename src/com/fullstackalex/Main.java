package com.fullstackalex;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        program();
    }

    public static void program() {

        Scanner in = new Scanner(System.in);
        ArrayList<Flight> flight = new ArrayList<>();
        System.out.println("Добро пожаловать в программу для формирования авиарейсов ");
        while (true) {
            System.out.print("*****************************\n" +
                            "* 1)Добавление нового рейса *\n" +
                            "* 2)Вывод всех рейсов       *\n" +
                            "* 3)Выход                   *\n" +
                            "*****************************\n" +
                            "Пожалуйста, выберите необходимый пункт меню: ");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Добавление нового рейса");
                    String flightNumber;
                    boolean repeat;
                    do {
                        repeat = false;
                        System.out.print("Введите номер рейса(в формате ХХ1234):  ");
                        flightNumber = in.nextLine();
                        if (findFlightNumber(flightNumber, flight)){
                            repeat = true;
                        }
                        if (!flightNumber.matches("([A-ZА-Я]{2})+(\\d{4})")) {
                            System.out.println("Введите корректные данные");
                            repeat = true;
                        }
                    }while (repeat);

                    System.out.print("Введите название аэропорта отправления:  ");
                    String airportName = in.nextLine();

                    System.out.print("Введите название компании авиаперевозчика:  ");
                    String airCompanyName = in.nextLine();

                    System.out.print("Введите название аэропорта назначения:  ");
                    String destination = in.nextLine();
                    String timeOfFlightOut;
                    do {
                        repeat = false;
                        System.out.print("Введите время вылета(в формате \"12:00\"):  ");
                        timeOfFlightOut = in.nextLine();
                        if (!timeOfFlightOut.matches("([012]{1})+([0-9]{1})+(:)+([0-5]{1})+([0-9]{1})")) {
                            System.out.println("Введите корректные данные");
                            repeat = true;
                        }
                    }while (repeat);

                    System.out.print("Введите стоимость билета:  ");
                    double price = in.nextDouble();
                    System.out.println("******************************************");
                    System.out.print(
                            "* 1) Подтвердить добавление нового рейса *\n" +
                            "* 2) Отменить добавление нового рейса    *\n" +
                            "******************************************\n" +
                            " Выберите что делаем дальше: ");
                    int whatNext = in.nextInt();
                    in.nextLine();

                    switch (whatNext){
                        case 1:
                            System.out.println("");
                            flight.add(new Flight(flightNumber, airportName, airCompanyName, destination, timeOfFlightOut, price));
                            System.out.println("");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Вы ввели неверное значение.");
                    }
break;
                case 2:
                    System.out.println("");
                    for (Flight flights : flight) {
                        System.out.println(flights.toString());
                    }
                    System.out.println("");
                    break;

                case 3:
                    return;
                default:
                    System.out.println("Вы ввели неверное значение. ");
            }
        }
    }

    static boolean findFlightNumber(String flightNumber, ArrayList<Flight> flight) {

        for (Flight flights : flight) {
            if (flights.getFlightNumber().equals(flightNumber)) {
                System.out.println("Данный рейс уже добавлен в базу");
                return true;
            }
        }
        return false;
    }

}