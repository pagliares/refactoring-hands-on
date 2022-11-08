package xyz.pagliares.refactoring.entities;

public class PrecoInfantil extends Preco{
    @Override
    public int lerCodigoPreco() {
        return Filme.INFANTIL;
    }
}
