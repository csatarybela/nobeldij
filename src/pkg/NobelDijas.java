package pkg;

public class NobelDijas {
    private int ev;
    private String nev;
    private String szuletesHalalpzas;
    private String orszagKod;

    public NobelDijas(int ev, String nev, String szuletesHalalpzas, String orszagKod) {
        this.ev = ev;
        this.nev = nev;
        this.szuletesHalalpzas = szuletesHalalpzas;
        this.orszagKod = orszagKod;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzuletesHalalpzas() {
        return szuletesHalalpzas;
    }

    public void setSzuletesHalalpzas(String szuletesHalalpzas) {
        this.szuletesHalalpzas = szuletesHalalpzas;
    }

    public String getOrszagKod() {
        return orszagKod;
    }

    public void setOrszagKod(String orszagKod) {
        this.orszagKod = orszagKod;
    }

    @Override
    public String toString() {
        return  "\tNév: " + nev +
                "\n\tÉv: " + ev +
                "\n\tSz/H: " + szuletesHalalpzas;
    }
}
