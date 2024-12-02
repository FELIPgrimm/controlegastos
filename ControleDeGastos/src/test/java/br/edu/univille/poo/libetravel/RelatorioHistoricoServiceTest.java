package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioHistoricoServiceTest {

    @Test
    void deveGerarRelatoriosHistoricosCorretamente() {
        RelatorioHistoricoService service = new RelatorioHistoricoService();
        Calendar cal = Calendar.getInstance();

        // Adicionar despesas
        cal.set(2024, Calendar.NOVEMBER, 10); // Novembro
        service.adicionarDespesa("Alimentação", 100.0, cal.getTime());
        cal.set(2024, Calendar.DECEMBER, 5); // Dezembro
        service.adicionarDespesa("Transporte", 200.0, cal.getTime());

        Map<String, Map<String, Double>> historico = service.gerarRelatoriosHistoricos();

        // Verificar histórico
        assertEquals(2, historico.size());
        assertTrue(historico.containsKey("11-2024"));
        assertTrue(historico.containsKey("12-2024"));

        Map<String, Double> novembro = historico.get("11-2024");
        assertEquals(1, novembro.size());
        assertEquals(100.0, novembro.get("Alimentação"));

        Map<String, Double> dezembro = historico.get("12-2024");
        assertEquals(1, dezembro.size());
        assertEquals(200.0, dezembro.get("Transporte"));
    }

    @Test
    void deveGerarHistoricoVazioQuandoNaoHouverDespesas() {
        RelatorioHistoricoService service = new RelatorioHistoricoService();

        Map<String, Map<String, Double>> historico = service.gerarRelatoriosHistoricos();

        assertTrue(historico.isEmpty());
    }
}
