package xyz.pagliares.refactoring.entities;

public class FilmeNormal extends Filme {

    public FilmeNormal(String titulo, int codigoPreco) {
        super(titulo, codigoPreco);
    }

    public double lerPreco(int diasAlugados) {
        double resultado = 0.0;

        resultado = 2;  // R$ 2,00 por filme normal alugado
        if (diasAlugados > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
            resultado += (diasAlugados - 2) * 1.5;
        }

        return resultado;
    }
}
