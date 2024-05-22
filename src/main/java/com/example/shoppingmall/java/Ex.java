package com.example.shoppingmall.java;

import com.example.shoppingmall.utils.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("score:");
                String score = scanner.next();

                if (score.equals("q")){
                    System.out.println("exit");
                    break;
                }


                int scoreInt = Integer.parseInt(score);

                if (scoreInt <= 100 && scoreInt >= 60) {
                    System.out.println("fail");
                } else if (scoreInt < 60 && scoreInt >= 0) {
                    System.out.println("pass");
                }

            } catch (Exception e) {
                System.out.println("error - " + e);
            }
        }

    }
}
