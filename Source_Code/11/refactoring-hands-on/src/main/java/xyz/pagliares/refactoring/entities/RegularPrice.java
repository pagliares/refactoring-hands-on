package xyz.pagliares.refactoring.entities;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;  // R$ 2,00 por filme normal alugado
        if (daysRented > 2) { // Multa de 1.50 por dia de atraso caso seja entregue apos 2 dias
            result += (daysRented - 2) * 1.5;
        }
        return  result;
    }
}
