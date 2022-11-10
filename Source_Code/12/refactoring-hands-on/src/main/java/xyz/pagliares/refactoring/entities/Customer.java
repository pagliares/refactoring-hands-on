package xyz.pagliares.refactoring.entities;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Registro de Locacao para " + getName() + "\n";

        for (Rental rental: rentals) {
            //armazena o valor do filme para each filme locado
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getPrice()) + "\n";
         }

        //adiciona o rodape
        result += "Total devido, R$ " + String.valueOf(getTotalCharge()) + "\n";
        result += "Pontos adquiridos na locacao : " + String.valueOf(getTotalFrequentRenterPoints());
        return result;

    }

    public String HTMLStatement() {

        String result = "<h1>Registro de Locacao para <em>" + getName() + "</em></h1>\n"
                + "<ul>\n";

        for (Rental rental: rentals) {
            //armazena o valor do filme para each filme locado
            result += "\t" + "<li>" +rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getPrice()) + "</li>\n";
        }

        result+="</ul>\n";

        //adiciona o rodape
        result += "<p>Total devido, <em>R$ " + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>Pontos adquiridos na locação: <em>" + String.valueOf(getTotalFrequentRenterPoints()+ "</em></p>");

        return result;
    }

    public double getTotalCharge() {

        double result = 0.0;
        for (Rental rental: rentals) {
            result+= rental.getPrice();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {

        int result = 0;
        for (Rental rental: rentals) {
            result+= rental.getFrequentRenterPoints();
        }

        return result;
    }
}

