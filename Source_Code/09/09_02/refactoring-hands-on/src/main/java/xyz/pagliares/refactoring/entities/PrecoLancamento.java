package xyz.pagliares.refactoring.entities;

public class PrecoLancamento extends Preco{

    @Override
    public int lerCodigoPreco() {
        return Filme.LANCAMENTO_NOVO;
    }
}
