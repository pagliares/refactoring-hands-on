package xyz.pagliares.refactoring.entities;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3; // R$ 3,00 a diaria para lancamentos  por filme alugado
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1)? 2:1;
     }
}
