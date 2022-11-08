package xyz.pagliares.refactoring.entities;

public class Filme {
    
   public static final int  NORMAL = 0;  // R$ 2,00
   public static final int  LANCAMENTO_NOVO = 1; // R$ 3,00
    public static final int  INFANTIL = 2; // R$ 1,50

   private String _titulo;

    private Preco _codigoPreco;

   public Filme(String titulo, int codigoPreco) {
       this._titulo = titulo;
       gravarCodigoPreco(codigoPreco);
   }

   public Preco lerCodigoPreco() {
       return _codigoPreco;
   }

   public void gravarCodigoPreco(int codigoPreco) {
       switch (codigoPreco) { // codigoPreco associado ao tipo do filme
           case Filme.NORMAL:
               _codigoPreco = new PrecoNormal();
               break;
           case Filme.LANCAMENTO_NOVO:
               _codigoPreco = new PrecoLancamento();
               break;
           case Filme.INFANTIL:
               _codigoPreco = new PrecoInfantil();
               break;
           default:
               throw new IllegalArgumentException("Código de preço incorreto");
       }
    }

   public String lerTitulo (){
       return _titulo;
   }

    public double lerPreco(int diasAlugados) {
        double resultado = 0.0;
        // Valor da locacao para cada filme dentro do Vector
        switch (_codigoPreco.lerCodigoPreco()) { // codigoPreco associado ao tipo do filme
            case Filme.NORMAL:
                resultado += 2;  // R$ 2,00 por filme normal alugado
                if (diasAlugados > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
                    resultado += (diasAlugados - 2) * 1.5;
                }
                break;
            case Filme.LANCAMENTO_NOVO:
                resultado += diasAlugados * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado
                break;
            case Filme.INFANTIL:
                resultado += 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
                if (diasAlugados > 3) {
                    resultado += (diasAlugados - 3) * 1.5; // Multa de 1,50 por dia de atraso caso seja entregue apos 3 dias.
                }
                break;
        }
        return resultado;
    }

    public int lerPontosLocadorFrequente(int numDiasAlugado) {
        if (_codigoPreco.lerCodigoPreco() == Filme.LANCAMENTO_NOVO && numDiasAlugado > 1) {
            return 2;
        }
        return 1;
    }
 }

