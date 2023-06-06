package br.com.plantanalytics.view;

import br.com.plantanalytics.bo.AnaliseBO;
import br.com.plantanalytics.models.Analise;

import java.util.List;

public class AnaliseView {
    private AnaliseBO analiseBO = new AnaliseBO();

    public List<Analise> getAllAnalises() {
        return analiseBO.getAllAnalises();
    }

    public Analise getAnaliseById(int id) {
        return analiseBO.getAnaliseById(id);
    }

    public Analise createAnalise(Analise analise) {
        return analiseBO.createAnalise(analise);
    }

    public Analise updateAnalise(int id, Analise analise) {
        analise.setId(id);
        return analiseBO.updateAnalise(analise);
    }

    public boolean deleteAnalise(int id) {
        return analiseBO.deleteAnalise(id);
    }
}
