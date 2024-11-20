import java.util.ArrayList;

public class Disco {
    private String titulo;
    private int anoLancamento;
    private ArrayList<String> faixas;
    private Artista artista;

    public Disco(String titulo, int anoLancamento, Artista artista) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = new ArrayList<>(); // Faixa é incrementada
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public ArrayList<String> getFaixas() {
        return faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void addFaixa(String faixa) {
        this.faixas.add(faixa);
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Título🎼: " + titulo + " | Ano📅: " + anoLancamento + "\n" +
                "Artista👩🏻‍🎤: " + artista.getNome() + " | Gênero🎵: " + artista.getGenero() + "\n" +
                "Faixas💿: " + faixas;
    }
}
