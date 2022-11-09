package xyz.pagliares.refactoring.entities;

public class PrecoLancamento extends Preco{

    @Override
    public int lerCodigoPreco() {
        return Filme.LANCAMENTO_NOVO;
    }

    @Override
    public double lerPreco(int diasAlugados) {
        return diasAlugados * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado
    }

    public int lerPontosLocadorFrequente(int numDiasAlugado) {
        return (numDiasAlugado > 1)? 2:1;
     }
}
