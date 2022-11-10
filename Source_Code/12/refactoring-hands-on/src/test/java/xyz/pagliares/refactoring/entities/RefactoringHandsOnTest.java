package xyz.pagliares.refactoring.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefactoringHandsOnTest {
    private Customer customer;

    @BeforeEach
    public void setup(){
        customer = new Customer("Rodrigo Martins Pagliares");
    }

    @Test
    public void locarVariosFilmesComoNesteExemploDeveGerarUmaSaidaEmHTMLComNomeClienteFilmesLocadosTotalDevidoEPontosAdquiridos() {
        String saidaEsperadaHTML = "<h1>Registro de Locacao para <em>Rodrigo Martins Pagliares</em></h1>\n"
                + "<ul>\n"
                + "\t<li>Encontros e Desencontros	6.5 </li>\n"
                + "\t<li>Meia-Noite em Paris         9.0 </li>\n"
                + "\t<li>Paris, Texas             	3.5 </li>\n"
                + "\t<li>Bravura Indômita           	3.0 </li>\n"
                + "\t<li>Shrek                       3.0 </li>\n"
                + "</ul>\n"
                + "<p>Total devido, <em>R$ 25.0</em></p>\n"
                + "<p>Pontos adquiridos na locação: <em>6</em></p>\n";

        String saidaEsperadaHTMLSemEspacos = saidaEsperadaHTML.replaceAll("\\s", ""); //  \\s is a single space in unicode

        // Primeiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 4,50 de multa - Total parcial = R$ 6,50)
        Movie encontros = new Movie("Encontros e Desencontros", MovieType.REGULAR);
        Rental loc1 = new Rental(encontros, 5);
        // Segundo filme sendo locado(Lancamento) (Resultado = R$ 3,0 locacao + R$ 6,00 de multa - Total parcial = R$ 9,00)
        Movie meia = new Movie("Meia-Noite em Paris           ", MovieType.NEW_RELEASE);
        Rental loc2 = new Rental(meia, 3);

        // Terceiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 1,50 de multa - Total parcial = R$ 3,50)
        Movie parisTexas = new Movie("Paris, Texas             ", MovieType.REGULAR);
        Rental loc3 = new Rental(parisTexas, 3);

        // Quarto filme sendo locado(lancamento) (Resultado = R$ 3,0 locacao , sem multa - Total parcial = R$ 3,00)
        Movie indomita = new Movie("Bravura Indômita           ", MovieType.NEW_RELEASE);
        Rental loc4 = new Rental(indomita, 1);

        // Quinto filme sendo locado(infantil) (Resultado = R$ 1,50 locacao + R$ 1,50 de multa - Total parcial = R$ 3,00)
        Movie shrek = new Movie("Shrek                         ", MovieType.CHILDREN);
        Rental loc5 = new Rental(shrek, 4);

        customer.addRental(loc1);
        customer.addRental(loc2);
        customer.addRental(loc3);
        customer.addRental(loc4);
        customer.addRental(loc5);

        assertEquals(saidaEsperadaHTMLSemEspacos, customer.HTMLStatement().replaceAll("\\s", ""));
    }

    @Test
    public void locarVariosFilmesComoNesteExemploDeveGerarUmaSaidaNoConsoleComNomeClienteFilmesLocadosTotalDevidoEPontosAdquiridos() {
        String saidaEsperadaTemp = "Registro de Locacao para Rodrigo Martins Pagliares\n"
                + "\tEncontros e Desencontros	6.5\n"
                + "\tMeia-Noite em Paris           	9.0\n"
                + "\tParis, Texas             	3.5\n"
                + "\tBravura Indômita           	3.0\n"
                + "\tShrek                         	3.0\n"
                + "Total devido, R$ 25.0\n"
                + "Pontos adquiridos na locacao : 6\n";

        String saidaEsperadaSemEspacos = saidaEsperadaTemp.replaceAll("\\s", ""); //  \\s is a single space in unicode

        // Primeiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 4,50 de multa - Total parcial = R$ 6,50)
        Movie encontros = new Movie("Encontros e Desencontros", MovieType.REGULAR);
        Rental loc1 = new Rental(encontros, 5);
        // Segundo filme sendo locado(Lancamento) (Resultado = R$ 3,0 locacao + R$ 6,00 de multa - Total parcial = R$ 9,00)
        Movie meia = new Movie("Meia-Noite em Paris           ", MovieType.NEW_RELEASE);
        Rental loc2 = new Rental(meia, 3);

        // Terceiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 1,50 de multa - Total parcial = R$ 3,50)
        Movie parisTexas = new Movie("Paris, Texas             ", MovieType.REGULAR);
        Rental loc3 = new Rental(parisTexas, 3);

        // Quarto filme sendo locado(lancamento) (Resultado = R$ 3,0 locacao , sem multa - Total parcial = R$ 3,00)
        Movie indomita = new Movie("Bravura Indômita           ", MovieType.NEW_RELEASE);
        Rental loc4 = new Rental(indomita, 1);

        // Quinto filme sendo locado(infantil) (Resultado = R$ 1,50 locacao + R$ 1,50 de multa - Total parcial = R$ 3,00)
        Movie shrek = new Movie("Shrek                         ", MovieType.CHILDREN);
        Rental loc5 = new Rental(shrek, 4);

        customer.addRental(loc1);
        customer.addRental(loc2);
        customer.addRental(loc3);
        customer.addRental(loc4);
        customer.addRental(loc5);

        assertEquals(saidaEsperadaSemEspacos, customer.statement().replaceAll("\\s", ""));
     }

    /* Testando alugueis de todos os tipos de filmes por um dia */
    @Test
    public void alugarUmFilmeNormalPor1DiaDeveCustar2ReaisEGerar1PontoLocadorFrequente() {

        Movie encontros = new Movie("Encontros e Desencontros", MovieType.REGULAR);
        Rental loc1 = new Rental(encontros, 1);
        customer.addRental(loc1);

        assertTrue(customer.statement().contains("Total devido, R$ 2.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor1DiaDeveCustar3ReaisEGerar1PontoLocadorFrequente() {

        Movie indomita = new Movie("Bravura Indômita           ", MovieType.NEW_RELEASE);
        Rental loc4 = new Rental(indomita, 1);
        customer.addRental(loc4);

        assertTrue(customer.statement().contains("Total devido, R$ 3.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeInfantilPor1DiaDeveCustar1RealE50CentavosEGerar1PontoLocadorFrequente() {

        Movie shrek = new Movie("Shrek                         ", MovieType.CHILDREN);
        Rental loc5 = new Rental(shrek, 1);
        customer.addRental(loc5);

        assertTrue(customer.statement().contains("Total devido, R$ 1.5"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    /* Testando alugueis de todos os tipos de filme por mais de um dia, dentro do limite para cada tipo, mas sem multa */
    @Test
    public void alugarUmFilmeNormalPor2DiasDeveCustar2ReaisEGerar1PontoLocadorFrequente() {

        Movie encontros = new Movie("Encontros e Desencontros", MovieType.REGULAR);
        Rental loc1 = new Rental(encontros, 1);
        customer.addRental(loc1);

        assertTrue(customer.statement().contains("Total devido, R$ 2.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeInfantilPor3DiasDeveCustar1RealE50CentavosEGerar1PontoLocadorFrequente() {

        Movie shrek = new Movie("Shrek                         ", MovieType.CHILDREN);
        Rental rental = new Rental(shrek, 3);
        customer.addRental(rental);

        assertTrue(customer.statement().contains("Total devido, R$ 1.5"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    /* Testando alugueis de todos os tipos de filme por mais de um dia, com multa */
    @Test
    public void alugarUmFilmeNormalPor3DiasDeveCustar3ReaisE50CentavosSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Movie encontros = new Movie("Encontros e Desencontros", MovieType.REGULAR);
        Rental rental = new Rental(encontros, 3);
        customer.addRental(rental);

        assertTrue(customer.statement().contains("Total devido, R$ 3.5"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor2DiasDeveCustar6ReaisSendo3ReaisDeMultaEGerar2PontosLocadorFrequente() {

        Movie indomita = new Movie("Bravura Indômita           ", MovieType.NEW_RELEASE);
        Rental rental = new Rental(indomita, 2);
        customer.addRental(rental);

        assertTrue(customer.statement().contains("Total devido, R$ 6.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 2"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor5DiaDeveCustar15ReaisSendo12ReaisDeMultaEGerar2PontosLocadorFrequente() {

        Movie meia = new Movie("Meia-Noite em Paris           ", MovieType.NEW_RELEASE);
        Rental loc1 = new Rental(meia, 5);
        customer.addRental(loc1);

        assertTrue(customer.statement().contains("Total devido, R$ 15.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 2"));
    }

    @Test
    public void alugarUmFilmeInfantilPor4DiasDeveCustar3ReaisSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Movie shrek = new Movie("Shrek                         ", MovieType.CHILDREN);
        Rental loc5 = new Rental(shrek, 4);
        customer.addRental(loc5);

        assertTrue(customer.statement().contains("Total devido, R$ 3.0"));
        assertTrue(customer.statement().contains("Pontos adquiridos na locacao : 1"));
    }
}
