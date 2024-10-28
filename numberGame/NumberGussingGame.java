package com.numberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGussingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random  random = new Random();
        System.out.println("number of rounds:");
        int rounds = sc.nextInt();
        System.out.println("number of attempts:");
        int maxAttempts=sc.nextInt();
        int totalScore = 0;
//        ArrayList<Integer> targetNumber = new ArrayList<>();
        System.out.println("welcome to number gussing game");
        System.out.println("guss the number between 1 to 100");
        System.out.println("you have"+rounds+"rounds to play");
        for(int round =1;round<=rounds;round++){
            int target = random.nextInt(100)+1;
//            targetNumber.add(target);
            int attempts=0;
            boolean guss = false;
            System.out.println("\nround" +round+ "begin!");
            System.out.println("guss the number between 1 to 100");

            while(attempts<maxAttempts && !guss){
                attempts++;
                System.out.println("attempts"+attempts+":");
                int gussnum = sc.nextInt();
                if(gussnum< 1||gussnum>100){
                    System.out.println("enter a number between 1 to 100");
                    continue;
                }
                if (gussnum<target){
                    System.out.println("number is too low");
                } else if (gussnum>target) {
                    System.out.println("number is too high");

                }
                else {
                    System.out.println("congratulations"+target);
                    guss=true;
                    int points =(maxAttempts-attempts+1)*10;
                    System.out.println("points earned"+points);
                    totalScore+=points;
                }
            }
            if(!guss){
                System.out.println("sorry,all attempts are used");
                System.out.println("correct number is:"+target);
            }
        }
        System.out.println("\ngame over! your total score "+totalScore);
        System.out.println("thanks for playing");

        sc.close();
    }
}

