package com.uniamerida.estadistica.DTO;

public class EstatisticasDTO {
    private double media;
    private double mediana;
    private double desvioPadrao;

    public EstatisticasDTO(double media, double mediana, double desvioPadrao) {
        this.media = media;
        this.mediana = mediana;
        this.desvioPadrao = desvioPadrao;
    }
    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

}

