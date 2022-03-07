package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] cinema = cinemaBuilder();
        menuSelect(cinema);
    }

    public static void menuSelect(char[][] cinema) {
        int selection;
        do {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            selection = Integer.parseInt(SCANNER.nextLine());

            if (selection == 0) {
                return;
            }
            if (selection == 1) {
                cinemaPrinter(cinema);
            }
            if (selection == 2) {
                ticketSelector(cinema);
            }
            if (selection == 3) {
                incomeCalculator(cinema);
            }
        } while (true);
    }

    public static char[][] cinemaBuilder() {
        int numberOfRows = rowCounter();
        int numberOfSeats = seatCounter();
        char[][] cinema = new char[numberOfRows][numberOfSeats];

        //fill out cinema
        char emptySeat = 'S';
        for (int i = 0; i < numberOfRows; i++) {
            Arrays.fill(cinema[i], emptySeat);
        }
        return cinema;
    }

    public static void cinemaPrinter(char[][] cinema) {
        int numberOfRows = cinema.length;
        int numberOfSeats = cinema[0].length;

        //top
        System.out.println("Cinema:");
        for (int i = 0; i < numberOfSeats + 1; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(i);
            }
            if (i != numberOfSeats) {
                System.out.print(" ");
            }
        }
        System.out.println();

        //cinema
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < numberOfSeats; j++) {
                System.out.print(cinema[i][j]);
                if (j != numberOfSeats - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static void ticketSelector(char[][] cinema) {
        final char selectedSeat = 'B';
        final String INVALID_INPUT = "Wrong input!";
        boolean occupiedSeatLoop = true;
        do {
            int rowNumber = rowSelect();
            int seatNumber = seatSelect();
            if (rowNumber >= cinema.length || rowNumber < 0 ||
                    seatNumber >= cinema[rowNumber].length || seatNumber < 0) {
                System.out.println(INVALID_INPUT);
                System.out.println();
                continue;
            }
            if (cinema[rowNumber][seatNumber] == selectedSeat) {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                cinema[rowNumber][seatNumber] = selectedSeat;
                System.out.println();
                System.out.println("Ticket price: $" + seatPriceCalculator(cinema, rowNumber));

                occupiedSeatLoop = false;
            }
        } while (occupiedSeatLoop);
    }

    private static int rowSelect() {
        System.out.println("Enter a row number:");
        return Integer.parseInt(SCANNER.nextLine()) - 1;
    }

    private static int seatSelect() {
        System.out.println("Enter a seat number in that row:");
        return Integer.parseInt(SCANNER.nextLine()) - 1;
    }

    private static int rowCounter() {
        System.out.println("Enter the number of rows:");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static int seatCounter() {
        System.out.println("Enter the number of seats in each row:");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static int seatPriceCalculator(char[][] cinema, int rowSelected) {
        final int BACK_ROW_SEAT_PRICE = 8;
        final int FRONT_ROW_SEAT_PRICE = 10;
        int numberOfRows = cinema.length;
        int numberOfSeats = cinema[0].length;
        int totalSeats = (numberOfRows * numberOfSeats);
        if (totalSeats < 60) {
            return FRONT_ROW_SEAT_PRICE;
        } else {
            if (rowSelected + 1 > numberOfRows / 2) {
                return BACK_ROW_SEAT_PRICE;
            } else {
                return FRONT_ROW_SEAT_PRICE;
            }
        }
    }

    public static void incomeCalculator(char[][] cinema) {
        final char OCCUPIED_SEAT = 'B';

        int purchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == OCCUPIED_SEAT) {
                    purchasedTickets++;
                    currentIncome += seatPriceCalculator(cinema, i);
                }
                totalIncome += seatPriceCalculator(cinema, i);
            }
        }

        double percentageSold = (double) purchasedTickets / (cinema.length * cinema[0].length) * 100;
        System.out.printf("Number of purchased tickets: %d%n", purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percentageSold);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }
}