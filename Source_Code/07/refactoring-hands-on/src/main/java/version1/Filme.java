package version1;

public class Filme {
    
   public static final int  NORMAL = 0;  // R$ 2,00
   public static final int  LANCAMENTO_NOVO = 1; // R$ 3,00
    public static final int  INFANTIL = 2; // R$ 1,50

   private String _titulo;
   private int _codigoPreco; // codigoPreco contem uma das constantes acima

   public Filme(String titulo, int codigoPreco) {
       this._titulo = titulo;
       this._codigoPreco = codigoPreco;
   }

   public int lerCodigoPreco() {
       return _codigoPreco;
   }

   public void gravarCodigoPreco(int codigoPreco) {
     this._codigoPreco = codigoPreco;
   }

   public String lerTitulo (){
       return _titulo;
   }
 }

