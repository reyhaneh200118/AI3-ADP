package aufgabe2.uf;

public interface UF {
    public boolean connected(int p, int q);

    // Komponentenbezeichner für p
    public int find(int p);

    // Verbindet zwei Komponenten zu einer Komponente
    public void union(int p, int q);

    // Zaehlt die Anzahl der Komponenten
    public int count();

}
