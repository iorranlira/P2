import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe utilizada para a testes do sistema.
 *
 * @author Iorran Santos de Lira
 */
public class MrBetSistemaTest {
    MrBetSistema sistema = new MrBetSistema();

    @Test
    public void Test01() {
        String saida = "tem que dar CAMPEONATO ADICIONADO!";
        assertEquals(saida, sistema.adicionaCampeonato("Brasileirão série A 2023",20), "CAMPEONATO ADICIONADO!");
    }

    @Test
    public void Test02() {
        sistema.adicionaCampeonato("Brasileirão série A 2023",20);
        String saida = "tem que dar CAMPEONATO JÁ EXISTE!";
        assertEquals(saida, sistema.adicionaCampeonato("Brasileirão série A 2023",20), "CAMPEONATO JÁ EXISTE!");
    }

    @Test
    public void Test03() {
        String saida = "tem que dar TIME INCLUÍDO NO CAMPEONATO!";
        sistema.adicionaCampeonato("Brasileirão série A 2023",20);
        sistema.adicionaTimes("250_PB", "Nacional de Patos", "Canário");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("250_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("252_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
    }

    @Test
    public void Test04() {
        String saida = "tem que dar TIME INCLUÍDO NO CAMPEONATO!";
        sistema.adicionaCampeonato("Brasileirão série A 2023",20);
        sistema.adicionaTimes("250_PB", "Nacional de Patos", "Canário");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("250_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("252_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("252_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
    }

    @Test
    public void Test05() {
        String saida = "tem que dar O TIME NÃO EXISTE!";
        sistema.adicionaCampeonato("Brasileirão série A 2023",20);
        assertEquals(saida, sistema.incluirTimeEmCampeonato("005_PB","Brasileirão série A 2023"), "TIME NÃO EXISTE!");
    }

    @Test
    public void Test06() {
        String saida = "tem que dar CAMPEONATO NÃO EXISTE!";
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("252_PB","Brasileirão série A 2023"), "CAMPEONATO NÃO EXISTE!");
    }

    @Test
    public void Test07() {
        String saida = "tem que dar TIME INCLUÍDO NO CAMPEONATO! eTODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
        sistema.adicionaCampeonato("Brasileirão série A 2023",1);
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("252_PB","Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
        sistema.adicionaTimes("250_PB", "Nacional de Patos", "Canário");
        assertEquals(saida, sistema.incluirTimeEmCampeonato("250_PB","Brasileirão série A 2023"), "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
    }

    @Test
    public void Test08() {
        String saida = "tem que dar O TIME ESTÁ NO CAMPEONATO! e O TIME NÃO ESTÁ NO CAMPEONATO!";
        sistema.adicionaCampeonato("Copa do Nordeste 2023",20);
        sistema.adicionaTimes("250_PB", "Nacional de Patos", "Canário");
        sistema.incluirTimeEmCampeonato("250_PB","Copa do Nordeste 2023");
        assertEquals(saida, sistema.verificarTimeEmCampeonato("250_PB","Copa do Nordeste 2023"),"O TIME ESTÁ NO CAMPEONATO!");
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.verificarTimeEmCampeonato("252_PB","Copa do Nordeste 2023"),"O TIME NÃO ESTÁ NO CAMPEONATO!");
    }

    @Test
    public void Test09() {
        String saida = "tem que dar CAMPEONATO NÃO EXISTE";
        sistema.adicionaTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        assertEquals(saida, sistema.verificarTimeEmCampeonato("252_PB","Copa do Nordeste 2023"),"CAMPEONATO NÃO EXISTE!");
    }
    @Test
    public void Test10() {
    String saida = "tem que dar O TIME NÃO EXISTE!";
    sistema.adicionaCampeonato("Copa do Nordeste 2023",20);
    assertEquals(saida, sistema.verificarTimeEmCampeonato("005_PB","Copa do Nordeste 2023"),"TIME NÃO EXISTE!");
    }
}