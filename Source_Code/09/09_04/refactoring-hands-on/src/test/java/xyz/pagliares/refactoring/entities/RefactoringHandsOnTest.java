package xyz.pagliares.refactoring.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.pagliares.refactoring.entities.Cliente;
import xyz.pagliares.refactoring.entities.Filme;
import xyz.pagliares.refactoring.entities.Locacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefactoringHandsOnTest {
    private Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente = new Cliente("Rodrigo Martins Pagliares");
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
        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao loc1 = new Locacao(encontros, 5);
        // Segundo filme sendo locado(Lancamento) (Resultado = R$ 3,0 locacao + R$ 6,00 de multa - Total parcial = R$ 9,00)
        Filme meia = new Filme("Meia-Noite em Paris           ", 1);
        Locacao loc2 = new Locacao(meia, 3);

        // Terceiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 1,50 de multa - Total parcial = R$ 3,50)
        Filme parisTexas = new Filme("Paris, Texas             ", 0);
        Locacao loc3 = new Locacao(parisTexas, 3);

        // Quarto filme sendo locado(lancamento) (Resultado = R$ 3,0 locacao , sem multa - Total parcial = R$ 3,00)
        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao loc4 = new Locacao(indomita, 1);

        // Quinto filme sendo locado(infantil) (Resultado = R$ 1,50 locacao + R$ 1,50 de multa - Total parcial = R$ 3,00)
        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 4);

        cliente.adicionarLocacao(loc1);
        cliente.adicionarLocacao(loc2);
        cliente.adicionarLocacao(loc3);
        cliente.adicionarLocacao(loc4);
        cliente.adicionarLocacao(loc5);

        assertEquals(saidaEsperadaHTMLSemEspacos, cliente.contaHTML().replaceAll("\\s", ""));
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
        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao loc1 = new Locacao(encontros, 5);
        // Segundo filme sendo locado(Lancamento) (Resultado = R$ 3,0 locacao + R$ 6,00 de multa - Total parcial = R$ 9,00)
        Filme meia = new Filme("Meia-Noite em Paris           ", 1);
        Locacao loc2 = new Locacao(meia, 3);

        // Terceiro filme sendo locado(normal) (Resultado = R$ 2,0 locacao + R$ 1,50 de multa - Total parcial = R$ 3,50)
        Filme parisTexas = new Filme("Paris, Texas             ", 0);
        Locacao loc3 = new Locacao(parisTexas, 3);

        // Quarto filme sendo locado(lancamento) (Resultado = R$ 3,0 locacao , sem multa - Total parcial = R$ 3,00)
        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao loc4 = new Locacao(indomita, 1);

        // Quinto filme sendo locado(infantil) (Resultado = R$ 1,50 locacao + R$ 1,50 de multa - Total parcial = R$ 3,00)
        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 4);

        cliente.adicionarLocacao(loc1);
        cliente.adicionarLocacao(loc2);
        cliente.adicionarLocacao(loc3);
        cliente.adicionarLocacao(loc4);
        cliente.adicionarLocacao(loc5);

        assertEquals(saidaEsperadaSemEspacos, cliente.conta().replaceAll("\\s", ""));
     }

    /* Testando alugueis de todos os tipos de filmes por um dia */
    @Test
    public void alugarUmFilmeNormalPor1DiaDeveCustar2ReaisEGerar1PontoLocadorFrequente() {

        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao loc1 = new Locacao(encontros, 1);
        cliente.adicionarLocacao(loc1);

        assertTrue(cliente.conta().contains("Total devido, R$ 2.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor1DiaDeveCustar3ReaisEGerar1PontoLocadorFrequente() {

        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao loc4 = new Locacao(indomita, 1);
        cliente.adicionarLocacao(loc4);

        assertTrue(cliente.conta().contains("Total devido, R$ 3.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeInfantilPor1DiaDeveCustar1RealE50CentavosEGerar1PontoLocadorFrequente() {

        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 1);
        cliente.adicionarLocacao(loc5);

        assertTrue(cliente.conta().contains("Total devido, R$ 1.5"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    /* Testando alugueis de todos os tipos de filme por mais de um dia, dentro do limite para cada tipo, mas sem multa */
    @Test
    public void alugarUmFilmeNormalPor2DiasDeveCustar2ReaisEGerar1PontoLocadorFrequente() {

        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao loc1 = new Locacao(encontros, 1);
        cliente.adicionarLocacao(loc1);

        assertTrue(cliente.conta().contains("Total devido, R$ 2.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeInfantilPor3DiasDeveCustar1RealE50CentavosEGerar1PontoLocadorFrequente() {

        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao locacao = new Locacao(shrek, 3);
        cliente.adicionarLocacao(locacao);

        assertTrue(cliente.conta().contains("Total devido, R$ 1.5"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    /* Testando alugueis de todos os tipos de filme por mais de um dia, com multa */
    @Test
    public void alugarUmFilmeNormalPor3DiasDeveCustar3ReaisE50CentavosSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao locacao = new Locacao(encontros, 3);
        cliente.adicionarLocacao(locacao);

        assertTrue(cliente.conta().contains("Total devido, R$ 3.5"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor2DiasDeveCustar6ReaisSendo3ReaisDeMultaEGerar2PontosLocadorFrequente() {

        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao locacao = new Locacao(indomita, 2);
        cliente.adicionarLocacao(locacao);

        assertTrue(cliente.conta().contains("Total devido, R$ 6.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 2"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor5DiaDeveCustar15ReaisSendo12ReaisDeMultaEGerar2PontosLocadorFrequente() {

        Filme meia = new Filme("Meia-Noite em Paris           ", 1);
        Locacao loc1 = new Locacao(meia, 5);
        cliente.adicionarLocacao(loc1);

        assertTrue(cliente.conta().contains("Total devido, R$ 15.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 2"));
    }

    @Test
    public void alugarUmFilmeInfantilPor4DiasDeveCustar3ReaisSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 4);
        cliente.adicionarLocacao(loc5);

        assertTrue(cliente.conta().contains("Total devido, R$ 3.0"));
        assertTrue(cliente.conta().contains("Pontos adquiridos na locacao : 1"));
    }
}
