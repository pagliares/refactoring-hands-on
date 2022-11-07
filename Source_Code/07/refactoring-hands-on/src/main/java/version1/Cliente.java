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

        Enumeration locacoes = _locacoes.elements();
        String resultado = "Registro de Locacao para " + lerNome() + "\n";

        while (locacoes.hasMoreElements()) {
            Locacao cada = (Locacao) locacoes.nextElement();

            //armazena o valor do filme para cada filme locado
            resultado += "\t" + cada.lerFilme().lerTitulo() + "\t"
                    + String.valueOf(cada.lerPreco()) + "\n";
         }

        //adiciona o rodape
        resultado += "Total devido, R$ " + String.valueOf(lerPrecoTotal()) + "\n";
        resultado += "Pontos adquiridos na locacao : " + String.valueOf(lerTotalPontosLocadorFrequente());
        return resultado;

    }

    public double lerPrecoTotal() {

        double resultado = 0.0;
        Enumeration l = _locacoes.elements();

        while (l.hasMoreElements()) {
            Locacao cada = (Locacao) l.nextElement();
            resultado+= cada.lerPreco();
        }
        return resultado;
    }

    public int lerTotalPontosLocadorFrequente() {

        int resultado = 0;
        Enumeration l = _locacoes.elements();

        while (l.hasMoreElements()) {
            Locacao cada = (Locacao) l.nextElement();
            resultado+= cada.lerPontosLocadorFrequente();
        }

        return resultado;
    }
}

