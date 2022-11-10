package xyz.pagliares.refactoring.entities;

public class Movie {

    private MovieType movieType;

   private String title;

    private Price priceCode;

   public Movie(String title, MovieType movieType) {
       this.title = title;
       setPriceCode(movieType);
   }

   public MovieType getMovieType() {
       return priceCode.getMovieType();
   }

   public void setPriceCode(MovieType movieType) {
       switch (movieType) { // priceCode associado ao tipo do filme
           case REGULAR:
               this.priceCode = new RegularPrice();
               break;
           case NEW_RELEASE:
               this.priceCode = new NewReleasePrice();
               break;
           case CHILDREN:
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

