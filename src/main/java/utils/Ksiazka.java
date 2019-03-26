package utils;

public class Ksiazka {
    private String tytul;
    private String autor;

    public Ksiazka(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
