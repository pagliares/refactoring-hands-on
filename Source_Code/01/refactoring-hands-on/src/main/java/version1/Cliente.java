package version1;

import java.util.Enumeration;
import java.util.Vector;
public class Cliente {

    private String _nome;
    private Vector _locacoes = new Vector();  

    public Cliente(String nome) {
        this._nome = nome;
    }

    public void adicionarLocacao(Locacao locacao) {
        _locacoes.addElement(locacao);
    }

    public String lerNome() {
        return _nome;
    }

    public String conta() {
        double quantiaTotal = 0;
        int pontosLocadorFrequente = 0;
        Enumeration locacoes = _locacoes.elements();
        String resultado = "Registro de Locacao para " + lerNome() + "\n";
        while (locacoes.hasMoreElements()) {
            double estaQuantia = 0;
            Locacao cada = (Locacao) locacoes.nextElement();

            // Valor da locacao para cada filme dentro do Vector
            switch (cada.lerFilme().lerCodigoPreco()) { // codigoPreco associado ao tipo do filme
                case Filme.NORMAL:
                    estaQuantia += 2;  // R$ 2,00 por filme normal alugado
                    if (cada.lerDiasAlugados() > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
                        estaQuantia += (cada.lerDiasAlugados() - 2) * 1.5;
                    }
                    break;
                case Filme.LANCAMENTO_NOVO:
                    estaQuantia += cada.lerDiasAlugados() * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado

                    break;
                case Filme.INFANTIL:
                    estaQuantia += 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
                    if (cada.lerDiasAlugados() > 3) {
                        estaQuantia += (cada.lerDiasAlugados() - 3) * 1.5; // Multa de 1,50 por dia de atraso caso seja entregue apos 3 dias.
                    }
                    break;
            }             
            pontosLocadorFrequente++;
            // Ponto adicional para o locatario para cada filme lancamento
            if ((cada.lerFilme().lerCodigoPreco() == Filme.LANCAMENTO_NOVO)
                    && cada.lerDiasAlugados() > 1) {
                pontosLocadorFrequente++;
            }

            //armazena o valor do filme para cada filme locado
            resultado += "\t" + cada.lerFilme().lerTitulo() + "\t"
                    + String.valueOf(estaQuantia) + "\n";
            quantiaTotal += estaQuantia;  // total da locacao

         }
        //adiciona o rodape
        resultado += "Total devido, R$ " + String.valueOf(quantiaTotal) + "\n";
        resultado += "Pontos adquiridos na locacao : " + String.valueOf(pontosLocadorFrequente);
        return resultado;

    }
}

