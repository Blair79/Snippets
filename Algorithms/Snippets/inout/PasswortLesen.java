package inout;

import java.io.Console;

public class PasswortLesen {

    static final int MIN_PASSWORD_LENGTH = 8;

    public static void main(String[] args) {
        char[] password;
        Console c = System.console();
        if (c != null) {
            do {
                password = c.readPassword(
                        "Passwort eingeben (Minimum %d Zeichen) und\nanschliessend <return> druecken: ",
                        MIN_PASSWORD_LENGTH);
                if(password.length < MIN_PASSWORD_LENGTH)
                    System.out.println("Passwort  zu kurz, bitte wiederholen!");
            } while (password.length < MIN_PASSWORD_LENGTH);
            System.out.println(new String(password));
            password = null;
        }
    }
} 