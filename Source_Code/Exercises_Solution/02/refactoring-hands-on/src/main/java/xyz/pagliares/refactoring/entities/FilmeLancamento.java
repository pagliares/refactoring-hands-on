package xyz.pagliares.refactoring.entities;

public class FilmeLancamento extends Filme{
    public FilmeLancamento(String titulo, int codigoPreco) {
        super(titulo, codigoPreco);
    }

    @Override
    public double lerPreco(int diasAlugados) {
        return diasAlugados * 3;
    }

    @Override
    public int lerPontosLocadorFrequente(int numDiasAlugado) {
        if (numDiasAlugado > 1) {
            return 2;
        }
        return 1;
    }
}
