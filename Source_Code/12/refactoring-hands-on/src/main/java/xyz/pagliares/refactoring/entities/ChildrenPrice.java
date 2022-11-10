package xyz.pagliares.refactoring.entities;

public class ChildrenPrice extends Price {
    @Override
    public MovieType getMovieType() {
        return MovieType.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5; // R$ 1,50 por 3 dias por filme infantil alugado
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5; // Multa de 1,50 por dia de atraso caso s
        return result;
    }
}
