package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MbtiThrowsEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== MBTI 검사를 시작합니다 ===");

            checkEorI(scanner);
            System.out.println("=== MBTI 검사가 종료되었습니다 ===");
        } catch (InputMismatchException e) {
            System.out.println("키보드 입력이 잘못 되었습니다. - " + e);
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public static void checkEorI(Scanner scanner) {
        System.out.println("1. 나는 밖에서 에너지를 얻는다. 2. 나는 안에서 에너지를 얻는다.");
        System.out.println("당신의 선택은?");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("E형 인간입니다.");
        } else if (choice == 2) {
            System.out.println("I형 인간입니다.");
        } else {
            System.out.println("1 또는 2 중 선택하셔야 합니다.");
            throw new InputMismatchException("잘못된 입력입니다.");
        }
    }
}
