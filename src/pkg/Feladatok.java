package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Feladatok {
    private static List<NobelDijas> nobelDijasok = new ArrayList<>();

    public static void f2() throws IOException {
        String line;
        FileReader fr = new FileReader("orvosi_nobeldijak.txt");
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(";");
            NobelDijas id = new NobelDijas(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]);
            nobelDijasok.add(id);
        }
        br.close();
        fr.close();
    }

    public static void f3() {
        System.out.println("3. feladat: Díjazottak száma: " + nobelDijasok.size());
    }

    public static void f4() {
        OptionalLong maxEv = nobelDijasok.stream().mapToLong(NobelDijas::getEv).max();
        System.out.println("4. feladat: Utolsó év: " + maxEv.getAsLong());
    }

    public static void f5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("5. feladat: Kérem adja meg egy ország kódját: ");
        String kod = sc.nextLine();
        long darab = nobelDijasok.stream().filter(n -> n.getOrszagKod().equals(kod)).count();
        if (darab == 0) {
            System.out.println("\tA megadott országból nem volt díjazott!");
        } else if (darab == 1) {
            System.out.println("\tA megadott ország díjazottja:");
            NobelDijas nobelDijas = nobelDijasok.stream()
                    .filter(n -> n.getOrszagKod().equals(kod)).findFirst().get();
            System.out.println(nobelDijas);
        } else {
            System.out.printf("\tA megadott országból %d fő díjazott volt!\n", darab);
        }
        sc.close();
    }

    public static void f6() {
        Map<String, Integer> stat = new HashMap<>();
        for (NobelDijas n : nobelDijasok) {
            stat.putIfAbsent(n.getOrszagKod(), 0);
            stat.put(n.getOrszagKod(), stat.get(n.getOrszagKod()) + 1);
        }
        System.out.println("6. feladat: Statisztika");
        for (Map.Entry<String, Integer> e : stat.entrySet()) {
            if (e.getValue() > 5) {
                System.out.println("\t" + e.getKey() + " - " + e.getValue() + " fő");
            }
        }
    }

    public static void f7() {
        int osszeg = 0;
        int darab = 0;
        for (NobelDijas n:nobelDijasok) {
            Elethossz elethossz = new Elethossz(n.getSzuletesHalalpzas());
            if (elethossz.ismertElethossz()){
                osszeg += elethossz.elethosszEvekben();
                darab++;
            }
        }
        double atlag = (double)osszeg / darab;
        System.out.printf("7. feladat: A keresett átlag: %.1f év", atlag);
    }
}
