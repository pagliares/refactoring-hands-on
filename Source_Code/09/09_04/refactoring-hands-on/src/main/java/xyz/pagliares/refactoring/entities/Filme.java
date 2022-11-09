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

   public int lerCodigoPreco() {
       return _codigoPreco.lerCodigoPreco();
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
       return _codigoPreco.lerPreco(diasAlugados);
    }

    public int lerPontosLocadorFrequente(int numDiasAlugado) {
       return _codigoPreco.lerPontosLocadorFrequente(numDiasAlugado);
    }
 }

