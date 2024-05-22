package com.example.shoppingmall.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] answers = {5,2,7};
        int chance = 10;

        while (true) {
            try {
                System.out.println("--------------------------------");
                System.out.println("세자리 숫자 입력해주세요: (예시: 563)");
                String numbers = scanner.next();
                int[] parsedNumbers = new int[numbers.length()];
                int[] values = {0, 0, 0}; // S, B, O

                if (chance == 0) {
                    System.out.println("10회 입력 끝 실패입니다.");
                    return;
                }

                if (numbers.length() != 3) {
                    System.out.println("error - 세 자리만 입력해주세요.");
                    continue;
                }

                for (int i = 0; i < numbers.length(); i++) {
                    parsedNumbers[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                }

                chance--;
                System.out.println("남은 chance: " + chance);

                if (checkDuplicates(numbers)) {
                    System.out.println("error - 중복된 숫자가 있습니다.");
                    continue;
                }


                for (int i = 0; i < parsedNumbers.length; i++) {
                    if (parsedNumbers[i] == answers[i]) {
                        values[0] += 1;
                    } else {
                        int value = parsedNumbers[i];
                        boolean flag = false;
                        for (int j = 0; j < answers.length; j++) {
                            if (value == answers[j]) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            values[1] += 1;
                        } else {
                            values[2] += 1;
                        }

                    }
                }

                System.out.println("[결과] Strike 수: " + values[0] + ",Ball 수: " + values[1] + ",Out 수: " + values[2]);

                if (values[0] == 3) {
                    System.out.println("성공");
                    return;
                }
                if (values[2] == 3) {
                    System.out.println("[OUT]");
                }
            } catch (Exception e) {
                System.out.println("error - 숫자만 입력해주세요.");
                System.out.println(e);
                scanner.nextLine();
            }


        }
    }

    private static boolean checkDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }



}
