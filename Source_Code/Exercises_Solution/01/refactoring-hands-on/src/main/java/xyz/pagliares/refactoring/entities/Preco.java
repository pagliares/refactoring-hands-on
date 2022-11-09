package xyz.pagliares.refactoring.entities;

public abstract class Preco {
    public abstract int lerCodigoPreco();

    public abstract double lerPreco(int diasAlugados);

    public int lerPontosLocadorFrequente(int numDiasAlugado) {
        return 1;
    }
}
