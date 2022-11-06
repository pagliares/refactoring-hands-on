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

            pontosLocadorFrequente++;
            // Ponto adicional para o locatario para cada filme lancamento
            if ((cada.lerFilme().lerCodigoPreco() == Filme.LANCAMENTO_NOVO)
                    && cada.lerDiasAlugados() > 1) {
                pontosLocadorFrequente++;
            }

            //armazena o valor do filme para cada filme locado
            resultado += "\t" + cada.lerFilme().lerTitulo() + "\t"
                    + String.valueOf(cada.lerPreco()) + "\n";
            quantiaTotal += cada.lerPreco();  // total da locacao

         }
        //adiciona o rodape
        resultado += "Total devido, R$ " + String.valueOf(quantiaTotal) + "\n";
        resultado += "Pontos adquiridos na locacao : " + String.valueOf(pontosLocadorFrequente);
        return resultado;

    }

}

