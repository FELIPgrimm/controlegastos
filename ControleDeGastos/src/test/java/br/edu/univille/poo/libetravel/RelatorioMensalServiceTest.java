package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioMensalServiceTest {

    @Test
    void deveGerarRelatorioMensalCorretamente() {
        RelatorioMensalService service = new RelatorioMensalService();
        Calendar cal = Calendar.getInstance();

        // Adicionar despesas
        cal.set(2024, Calendar.NOVEMBER, 10); // Mês 11
        service.adicionarDespesa("Alimentação", 100.0, cal.getTime());
        cal.set(2024, Calendar.NOVEMBER, 15);
        service.adicionarDespesa("Transporte", 50.0, cal.getTime());
        cal.set(2024, Calendar.DECEMBER, 5); // Mês 12
        service.adicionarDespesa("Alimentação", 200.0, cal.getTime());

        // Gerar relatório para Novembro (11)
        Map<String, Double> relatorioNovembro = service.gerarRelatorioMensal(11, 2024);

        assertEquals(2, relatorioNovembro.size());
        assertEquals(100.0, relatorioNovembro.get("Alimentação"));
        assertEquals(50.0, relatorioNovembro.get("Transporte"));
    }

    @Test
    void deveGerarRelatorioVazioSeNaoHouverDespesasNoMes() {
        RelatorioMensalService service = new RelatorioMensalService();

        Map<String, Double> relatorio = service.gerarRelatorioMensal(10, 2024);

        assertTrue(relatorio.isEmpty());
    }
}
