package xyz.pagliares.refactoring.entities;

public class PrecoInfantil extends Preco{
    @Override
    public int lerCodigoPreco() {
        return Filme.INFANTIL;
    }

    @Override
    public double lerPreco(int diasAlugados) {
        double resultado = 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
        if (diasAlugados > 3)
            resultado += (diasAlugados - 3) * 1.5; // Multa de 1,50 por dia de atraso caso s
        return resultado;
    }
}
