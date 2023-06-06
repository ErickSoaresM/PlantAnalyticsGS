package br.com.plantanalytics.dao;

import br.com.plantanalytics.models.Analise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnaliseDAO {
    private List<Analise> analises = new ArrayList<>();
    private int nextId = 1;

    public List<Analise> getAllAnalises() {
        return analises;
    }

    public Analise getAnaliseById(int id) {
        for (Analise analise : analises) {
            if (analise.getId() == id) {
                return analise;
            }
        }
        return null;
    }

    public Analise createAnalise(Analise analise) {
        analise.setId(nextId++);
        analise.setDataEnvio(new Date());
        analises.add(analise);
        return analise;
    }

    public Analise updateAnalise(Analise analise) {
        for (int i = 0; i < analises.size(); i++) {
            if (analises.get(i).getId() == analise.getId()) {
                analises.set(i, analise);
                return analise;
            }
        }
        return null;
    }

    public boolean deleteAnalise(int id) {
        for (Analise analise : analises) {
            if (analise.getId() == id) {
                analises.remove(analise);
                return true;
            }
        }
        return false;
    }
}
