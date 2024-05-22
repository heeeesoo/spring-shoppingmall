package exercise.exception;

import java.util.Scanner;

public class AgesCheckerEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {

                int age = scanner.nextInt();

                System.out.println("당신의 나이는 " + age + "살입니다.");

                if (age == -1)
                    break;
                if (age < 0 || age > 100) {
                    System.out.println("0~100 사이");
                    throw new Exception("0 ~ 100 사이 입력");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
