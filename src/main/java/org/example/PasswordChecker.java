package org.example;
import java.util.Scanner;

public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина пароля не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений символа подряд должно быть больше 0");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == 0 || maxRepeats == 0) {
            throw new IllegalStateException("Не установлены минимальная длина пароля или максимальное количество повторений символа подряд");
        }
        if (password.length() < minLength) {
            return false;
        }
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                int repeats = 1;
                while (i + 1 < password.length() && password.charAt(i) == password.charAt(i + 1)) {
                    repeats++;
                    i++;
                }
                if (repeats > maxRepeats) {
                    return false;
                }
            }
        }
        return true;
    }
}

