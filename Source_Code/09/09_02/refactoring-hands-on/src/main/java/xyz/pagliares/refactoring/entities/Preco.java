package xyz.pagliares.refactoring.entities;

public abstract class Preco {
    public abstract int lerCodigoPreco();

    public double lerPreco(int diasAlugados) {
        double resultado = 0.0;
        // Valor da locacao para cada filme dentro do Vector
        switch (lerCodigoPreco()) { // codigoPreco associado ao tipo do filme
            case Filme.NORMAL:
                resultado += 2;  // R$ 2,00 por filme normal alugado
                if (diasAlugados > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
                    resultado += (diasAlugados - 2) * 1.5;
                }
                break;
            case Filme.LANCAMENTO_NOVO:
                resultado += diasAlugados * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado
                break;
            case Filme.INFANTIL:
                resultado += 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
                if (diasAlugados > 3) {
                    resultado += (diasAlugados - 3) * 1.5; // Multa de 1,50 por dia de atraso caso seja entregue apos 3 dias.
                }
                break;
        }
        return resultado;
    }
}
