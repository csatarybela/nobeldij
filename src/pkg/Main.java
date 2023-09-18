package pkg;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Feladatok.f2();
            Feladatok.f3();
            Feladatok.f4();
            Feladatok.f5();
            Feladatok.f6();
            Feladatok.f7();
        } catch (IOException e) {
            System.err.println("Nincs meg az input fájl!");
            throw new RuntimeException(e);
        }

    }
}
