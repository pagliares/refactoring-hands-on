package xyz.pagliares.refactoring.entities;

public class PrecoNormal extends Preco{

    @Override
    public int lerCodigoPreco() {
        return Filme.NORMAL;
    }

    @Override
    public double lerPreco(int diasAlugados) {
        double resultado = 2;  // R$ 2,00 por filme normal alugado
        if (diasAlugados > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
            resultado += (diasAlugados - 2) * 1.5;
        }
        return  resultado;
    }
}
