package br.com.plantanalytics.bo;

import br.com.plantanalytics.dao.AnaliseDAO;
import br.com.plantanalytics.models.Analise;

import java.util.Date;
import java.util.List;

public class AnaliseBO {
    private AnaliseDAO analiseDAO = new AnaliseDAO();

    public List<Analise> getAllAnalises() {
        return analiseDAO.getAllAnalises();
    }

    public Analise getAnaliseById(int id) {
        return analiseDAO.getAnaliseById(id);
    }

    public Analise createAnalise(Analise analise) {
        analise.setDataEnvio(new Date());
        return analiseDAO.createAnalise(analise);
    }

    public Analise updateAnalise(Analise analise) {
        return analiseDAO.updateAnalise(analise);
    }

    public boolean deleteAnalise(int id) {
        return analiseDAO.deleteAnalise(id);
    }
}
