package xyz.pagliares.refactoring.entities;

public class FilmeInfantil extends Filme{
    public FilmeInfantil(String titulo, int codigoPreco) {
        super(titulo, codigoPreco);
    }

    @Override
    public double lerPreco(int diasAlugados) {
        double resultado = 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
        if (diasAlugados > 3) {
            resultado += (diasAlugados - 3) * 1.5; // Multa de 1,50 por dia de atraso caso seja entregue apos 3 dias.
        }
        return resultado;
    }
}
