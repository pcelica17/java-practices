package com.helloworld;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Konstante za broj meseci u godini i pretvaranje procenata
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;


        // Kreiranje skenera za unos podataka sa tastature
        Scanner scanner = new Scanner(System.in);

        // Unos glavnice (Principal)
        while (true){
            System.out.print("Principal ($1K - $1M): ");// Glavnica kredita
            principal = scanner.nextInt();// Čita unetu vrednost
            if (principal > 1000 && principal < 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        // Unos godišnje kamate
        while (true){
            System.out.print("Annual Interest Rate: ");// Godišnja kamata
            float annualInterest = scanner.nextFloat();// Uzimanje vrednosti
            if (annualInterest >= 1 && annualInterest <=30){
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;// Računanje ukupnog broja uplata
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        // Unos trajanja kredita u godinama
        while(true){
            System.out.print("Period (Years): ");// Trajanje kredita
            byte years = scanner.nextByte();// Unos broja godina
            if (years >= 1 && years <=30){
                numberOfPayments = years * MONTHS_IN_YEAR;// Računanje ukupnog broja uplata
                break;
            }
            System.out.println("Enter a number between 1 and 30");
        }

        // Računanje mesečne rate koristeći formulu za hipoteku (Amortizacija kredita)
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // Formatiranje rezultata u novčanu vrednost (valutu)
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}