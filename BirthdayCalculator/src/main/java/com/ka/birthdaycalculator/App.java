/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ka.birthdaycalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author kennethan
 */
public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator!\n");
        System.out.println("What's your birthday? (MM-dd-yyyy)");
        String stringBirthday = scanner.next();

        LocalDate birthday = LocalDate.parse(stringBirthday, DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        LocalDate birthdayThisYear = birthday.withYear(LocalDate.now().getYear());
        DayOfWeek day = birthday.getDayOfWeek();
        DayOfWeek dayOfYear = birthdayThisYear.getDayOfWeek();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        LocalDate nextBirthday = birthdayThisYear;
        if (birthdayThisYear.isBefore(LocalDate.now())) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long numOfDaysLeft = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday);
        long age = ChronoUnit.YEARS.between(birthday, nextBirthday);

        System.out.println("That means you were born on a " + day + "!");
        System.out.println("This year it falls on a " + dayOfYear + "...");
        System.out.println("And since today is " + today + ",");
        System.out.println("there's only " + numOfDaysLeft + " more days until the next one when you turn " + age + "!");

    }

}
