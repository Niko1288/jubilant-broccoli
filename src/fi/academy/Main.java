package fi.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Mitä haluat tehdä? \n");
        System.out.println("Vaihtoehdot: ");
        System.out.println("\t" + "1 - Käännä merkkijono.");
        System.out.println("\t" + "2 - Tarkista onko sanat anagrammeja.");
        System.out.println("\t" + "3 - Käännä värikoodi.");
        System.out.println("\t" + "4 - Listaa numeron alkutekijät.");
        System.out.println("\t" + "5 - Numerotaidetta.");

        String komento = lukija.nextLine();

        switch (komento) {
            case "1":
                System.out.println("Anna merkkijono: ");
                String sana = lukija.nextLine();
                System.out.println(kaanna(sana));
                break;

            case "2":
                System.out.println("Anna ensimmäinen merkkijono: ");
                String eka = lukija.nextLine();
                System.out.println("Anna toinen merkkijono: ");
                String toka = lukija.nextLine();

                if (anagrammi(eka, toka)) {
                    System.out.println("Sanat ovat anagrammeja.");
                } else {
                    System.out.println("Sanat eivät ole anagrammeja.");
                }
                break;

            case "3":
                System.out.println("Syötä koodi: ");
                String koodi = lukija.nextLine();
                varimaaritys(koodi);
                break;

            case "4":
                System.out.println("Anna luku: ");
                int num = lukija.nextInt();
                System.out.println(tekijat(num));
                break;

            case "5":
                break;

            default:
                System.out.println("Virheellinen komento.");
                break;
        }
    }

    public static StringBuilder kaanna(String merkkijono) {
        StringBuilder sana = new StringBuilder(merkkijono);
        return sana.reverse();
    }

    public static boolean anagrammi(String ekaSana, String tokaSana) {
        char[] sana = ekaSana.replaceAll("[\\s+]", "").toCharArray();
        char[] vertailu = tokaSana.replaceAll("[\\s+]", "").toCharArray();
        Arrays.sort(sana);
        Arrays.sort(vertailu);
        return Arrays.equals(sana, vertailu);
    }

    public static void varimaaritys(String koodi) {
        int r = Integer.valueOf(koodi.substring(1, 3), 16);
        int g = Integer.valueOf(koodi.substring(3, 5), 16);
        int b = Integer.valueOf(koodi.substring(5, 7), 16);
        System.out.println("rgb(" + r + ", " + g + ", " + b + ")");
    }



    public static List<Integer> tekijat(int luku) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 2; i <= luku; i++) {
            while (luku % i == 0) {
                lista.add(i);
                luku = luku / i;
            }
        }
        return lista;
    }
}
