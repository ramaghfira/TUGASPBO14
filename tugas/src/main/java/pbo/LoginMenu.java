package tugas.src.main.java.pbo;

import java.util.Scanner;

public class LoginMenu {
    private static final String USERNAME = "haiyah";
    private static final String PASSWORD = "boomsyakalakabum";
    private static final String CAPTCHA = "F2TI3"; // Ganti dengan logika captcha yang sesuai

    public boolean login(Scanner scanner) {
        System.out.println("SELAMAT DATANG DI NIMINOT MARKET");
        System.out.println("==============================");

        // Login
        System.out.println("Log in");
        System.out.print("Username    : ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Password     : ");
        String enteredPassword = scanner.nextLine();

        if (isValidLogin(enteredUsername, enteredPassword)) {
            // Captcha
            System.out.println("Kode Captcha : " + CAPTCHA);
            System.out.print("Entry Captcha : ");
            String enteredCaptcha = scanner.nextLine();

            if (isValidCaptcha(enteredCaptcha)) {
                System.out.println("Login berhasil!");
                return true;
            } else {
                System.out.println("Captcha salah.");
            }
        } else {
            System.out.println("Login gagal.");
        }
        return false;
    }

    private boolean isValidLogin(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private boolean isValidCaptcha(String enteredCaptcha) {
        return CAPTCHA.equals(enteredCaptcha);
    }
}