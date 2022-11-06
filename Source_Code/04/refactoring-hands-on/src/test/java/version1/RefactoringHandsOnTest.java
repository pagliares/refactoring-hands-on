package version1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RefactoringHandsOnTest {

    @Test
    public void locacaoFilmes() {
        String saidaEsperadaTemp = "Registro de Locacao para Rodrigo Martins Pagliares\n"
                + "\tEncontros e Desencontros	6.5\n"
                + "\tMeia-Noite em Paris           	9.0\n"
                + "\tParis, Texas             	3.5\n"
                + "\tBravura Indômita           	3.0\n"
                + "\tShrek                         	3.0\n"
                + "Total devido, R$ 25.0\n"
                + "Pontos adquiridos na locacao : 6\n";

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
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

        rodrigo.adicionarLocacao(loc1);
        rodrigo.adicionarLocacao(loc2);
        rodrigo.adicionarLocacao(loc3);
        rodrigo.adicionarLocacao(loc4);
        rodrigo.adicionarLocacao(loc5);

        // assertEquals(saidaEsperadaTemp.trim(), rodrigo.conta().trim());
        assertTrue(rodrigo.conta().contains("Total devido, R$ 25.0"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor5DiaDeveCustar15ReaisEGerar2PontosLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme meia = new Filme("Meia-Noite em Paris           ", 1);
        Locacao loc1 = new Locacao(meia, 5);
        rodrigo.adicionarLocacao(loc1);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 15.0"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 2"));
    }

    @Test
    public void alugarUmFilmeNormalPorUmDiaDeveCustar2ReaisEGerar1PontoLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao loc1 = new Locacao(encontros, 1);
        rodrigo.adicionarLocacao(loc1);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 2.0"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPorUmDiaDeveCustar3ReaisEGerar1PontoLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao loc4 = new Locacao(indomita, 1);
        rodrigo.adicionarLocacao(loc4);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 3.0"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeInfantilPorUmDiaDeveCustar1RealE50CentavosEGerar1PontoLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 1);
        rodrigo.adicionarLocacao(loc5);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 1.5"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeNormalPor3DiasDeveCustar3ReaisE50CentavosSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme encontros = new Filme("Encontros e Desencontros", 0);
        Locacao locacao = new Locacao(encontros, 3);
        rodrigo.adicionarLocacao(locacao);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 3.5"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 1"));
    }

    @Test
    public void alugarUmFilmeLancamentoPor2DiasDeveCustar6ReaisSendo3ReaisDeMultaEGerar2PontosLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme indomita = new Filme("Bravura Indômita           ", 1);
        Locacao locacao = new Locacao(indomita, 2);
        rodrigo.adicionarLocacao(locacao);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 6.0"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 2"));
    }


    @Test
    public void alugarUmFilmeInfantilPor4DiasDeveCustar3ReaisSendo1RealE50CentavosDeMultaEGerar1PontoLocadorFrequente() {

        Cliente rodrigo = new Cliente("Rodrigo Martins Pagliares");
        Filme shrek = new Filme("Shrek                         ", 2);
        Locacao loc5 = new Locacao(shrek, 4);
        rodrigo.adicionarLocacao(loc5);

        assertTrue(rodrigo.conta().contains("Total devido, R$ 3.0"));
        assertTrue(rodrigo.conta().contains("Pontos adquiridos na locacao : 1"));
    }
}
