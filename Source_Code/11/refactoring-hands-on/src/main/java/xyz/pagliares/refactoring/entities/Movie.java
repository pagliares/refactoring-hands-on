package xyz.pagliares.refactoring.entities;

public class Movie {
    
   public static final int REGULAR = 0;  // R$ 2,00
   public static final int NEW_RELEASE = 1; // R$ 3,00
    public static final int CHILDREN = 2; // R$ 1,50

   private String title;

    private Price priceCode;

   public Movie(String title, int priceCode) {
       this.title = title;
       setPriceCode(priceCode);
   }

   public int getPriceCode() {
       return priceCode.getPriceCode();
   }

   public void setPriceCode(int priceCode) {
       switch (priceCode) { // priceCode associado ao tipo do filme
           case Movie.REGULAR:
               this.priceCode = new RegularPrice();
               break;
           case Movie.NEW_RELEASE:
               this.priceCode = new NewReleasePrice();
               break;
           case Movie.CHILDREN:
               this.priceCode = new ChildrenPrice();
               break;
           default:
               throw new IllegalArgumentException("Código de preço incorreto");
       }
    }

   public String getTitle(){
       return title;
   }

    public double getCharge(int daysRented) {
       return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
       return priceCode.getFrequentRenterPoints(daysRented);
    }
 }

