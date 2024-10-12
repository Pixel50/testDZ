package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите мин. длину пароля: ");
        int minLength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите макс. допустимое количество повторений символа подряд: ");
        int maxRepeats = scanner.nextInt();
        scanner.nextLine();


        PasswordChecker checker = new PasswordChecker();
        try {
            checker.setMinLength(minLength);
            checker.setMaxRepeats(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при установке настроек: " + e.getMessage());
            System.exit(1);
        }

        while (true) {
            System.out.println("Введите пароль или end: ");
            String password = scanner.nextLine();
            if (password.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }
            try {
                if (checker.verify(password)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } catch (IllegalStateException e) {
                System.out.println("Ошибка при проверке пароля: " + e.getMessage());
                break;
            }
        }

    }
}