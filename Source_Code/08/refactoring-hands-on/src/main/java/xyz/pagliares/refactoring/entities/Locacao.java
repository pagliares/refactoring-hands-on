package xyz.pagliares.refactoring.entities;

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

    public double lerPreco() {
        return _filme.lerPreco(_diasAlugados);
       
    }

    public int lerPontosLocadorFrequente() {
        if ((lerFilme().lerCodigoPreco() == Filme.LANCAMENTO_NOVO)
                && lerDiasAlugados() > 1) {
            return 2;
        }
        return 1;
    }
}
