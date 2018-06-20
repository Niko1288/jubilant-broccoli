package fi.academy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numerotaide {

    public Numerotaide() {

        List<String> numerot = new ArrayList<>();
        try (Scanner lukija = new Scanner(new File("numerot.txt"))) {
            while (lukija.hasNextLine()) {

                String reseptinNimi = lukija.nextLine();
                numerot.add(reseptinNimi);
                while (lukija.hasNextLine()) {
                    String rivit = lukija.nextLine();
                    if (rivit.isEmpty()) {
                        break;
                    }
                    numerot.add(rivit);
                }
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
}
