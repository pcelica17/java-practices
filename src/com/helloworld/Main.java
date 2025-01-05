package com.helloworld;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Konstante za broj meseci u godini i pretvaranje procenata
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Kreiranje skenera za unos podataka sa tastature
        Scanner scanner = new Scanner(System.in);

        // Unos glavnice (Principal)
        System.out.print("Principal: ");// Glavnica kredita
        int principal = scanner.nextInt();// Čita unetu vrednost

        // Unos godišnje kamate
        System.out.print("Annual Interest Rate: ");// Godišnja kamata
        float annualInterest = scanner.nextFloat();// Uzimanje vrednosti
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;// Računanje ukupnog broja uplata

        // Unos trajanja kredita u godinama
        System.out.print("Period (Years): ");// Trajanje kredita
        byte years = scanner.nextByte();// Unos broja godina
        int numberOfPayments = years * MONTHS_IN_YEAR;// Računanje ukupnog broja uplata

        // Računanje mesečne rate koristeći formulu za hipoteku (Amortizacija kredita)
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // Formatiranje rezultata u novčanu vrednost (valutu)
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}