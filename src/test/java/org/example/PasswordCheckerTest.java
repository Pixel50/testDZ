package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    private PasswordChecker checker;

    @BeforeEach
    public void setUp() {
        checker = new PasswordChecker();
    }


    // Тест на проверку корректного пароля
    @Test
    public void testVerifyValidPassword() {
        checker.setMinLength(6);
        checker.setMaxRepeats(2);
        assertTrue(checker.verify("abc123"), "Пароль должен быть валидным.");
    }

    // Тест на проверку пароля с недостаточной длиной
    @Test
    public void testVerifyInvalidShortPassword() {
        checker.setMinLength(6);
        checker.setMaxRepeats(2);
        assertFalse(checker.verify("abc"), "Пароль слишком короткий.");
    }

    // Тест на проверку пароля с превышением допустимых повторений символов
    @Test
    public void testVerifyInvalidRepeatPassword() {
        checker.setMinLength(6);
        checker.setMaxRepeats(2);
        assertFalse(checker.verify("aabbbcc"), "Пароль не должен содержать более 2 подряд идущих одинаковых символов.");
    }

}