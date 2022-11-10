package xyz.pagliares.refactoring.entities;

import java.util.Enumeration;
import java.util.Vector;
public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        Enumeration rentals = this.rentals.elements();
        String result = "Registro de Locacao para " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //armazena o valor do filme para each filme locado
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getPrice()) + "\n";
         }

        //adiciona o rodape
        result += "Total devido, R$ " + String.valueOf(getTotalCharge()) + "\n";
        result += "Pontos adquiridos na locacao : " + String.valueOf(getTotalFrequentRenterPoints());
        return result;

    }

    public String HTMLStatement() {

        Enumeration rentals = this.rentals.elements();
        String result = "<h1>Registro de Locacao para <em>" + getName() + "</em></h1>\n"
                + "<ul>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //armazena o valor do filme para each filme locado
            result += "\t" + "<li>" +each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getPrice()) + "</li>\n";
        }

        result+="</ul>\n";

        //adiciona o rodape
        result += "<p>Total devido, <em>R$ " + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>Pontos adquiridos na locação: <em>" + String.valueOf(getTotalFrequentRenterPoints()+ "</em></p>");

        return result;

    }

    public double getTotalCharge() {

        double result = 0.0;
        Enumeration l = rentals.elements();

        while (l.hasMoreElements()) {
            Rental each = (Rental) l.nextElement();
            result+= each.getPrice();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {

        int result = 0;
        Enumeration l = rentals.elements();

        while (l.hasMoreElements()) {
            Rental each = (Rental) l.nextElement();
            result+= each.getFrequentRenterPoints();
        }

        return result;
    }
}

