package version1;

public class Locacao {
    private Filme _filme;
    private int _diasAlugados;

    public Locacao(Filme filme, int diasAlugados) {
        this._filme = filme;
        this._diasAlugados = diasAlugados;
    }

    public int lerDiasAlugados() {
        return _diasAlugados;
    }

    public Filme lerFilme() {
        return _filme;
    }
}
