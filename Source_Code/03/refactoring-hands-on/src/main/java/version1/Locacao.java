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

    public double quantiaDe() {
        double resultado = 0.0;
        // Valor da locacao para cada filme dentro do Vector
        switch (lerFilme().lerCodigoPreco()) { // codigoPreco associado ao tipo do filme
            case Filme.NORMAL:
                resultado += 2;  // R$ 2,00 por filme normal alugado
                if (lerDiasAlugados() > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
                    resultado += (lerDiasAlugados() - 2) * 1.5;
                }
                break;
            case Filme.LANCAMENTO_NOVO:
                resultado += lerDiasAlugados() * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado
                break;
            case Filme.INFANTIL:
                resultado += 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
                if (lerDiasAlugados() > 3) {
                    resultado += (lerDiasAlugados() - 3) * 1.5; // Multa de 1,50 por dia de atraso caso seja entregue apos 3 dias.
                }
                break;
        }
        return resultado;
    }
}
