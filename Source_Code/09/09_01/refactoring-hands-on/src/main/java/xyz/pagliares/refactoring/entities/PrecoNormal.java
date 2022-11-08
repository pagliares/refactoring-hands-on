package xyz.pagliares.refactoring.entities;

public class PrecoNormal extends Preco{

    @Override
    public int lerCodigoPreco() {
        return Filme.NORMAL;
    }
}
