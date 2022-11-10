package xyz.pagliares.refactoring.entities;

public abstract class Price {
    public abstract MovieType getMovieType();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
