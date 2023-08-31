package com.uniamerida.estadistica.Service;

import com.uniamerida.estadistica.Entity.NumeroEntity;
import com.uniamerida.estadistica.Repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumeroService {

    @Autowired
    private NumeroRepository numeroRepository;

    public NumeroEntity salvarNumero(Double valor) {
        return numeroRepository.save(new NumeroEntity(null, valor));
    }

    public List<Double> obterTodosNumeros() {
        return numeroRepository.findAll().stream().map(NumeroEntity::getValor).collect(Collectors.toList());
    }

    public double calcularMedia(List<Double> Numeros) {
        return Numeros.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calcularMediana(List<Double> Numeros) {
        List<Double> sortedNumbers = Numeros.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int tamanho = sortedNumbers.size();
        if (tamanho % 2 == 0) {
            return (sortedNumbers.get(tamanho / 2 - 1) + sortedNumbers.get(tamanho / 2)) / 2.0;
        } else {
            return sortedNumbers.get(tamanho / 2);
        }
    }

    public double calcularDesvioPadrão(List<Double> Numeros) {
        double media = calcularMedia(Numeros);
        double somatório = 0;
        for (double Numero : Numeros) {
            somatório += Math.pow(Numero - media, 2);
        }
        return Math.sqrt(somatório / Numeros.size());
    }

    // Adicional: função para obter os resultados quando há 20 ou mais Numeros
    public Estatisticas calcularEstatisticas() {
        List<Double> Numeros = obterTodosNumeros();
        if (Numeros.size() < 20) {
            throw new IllegalArgumentException("Não há Numeros suficientes para calcular as estatísticas.");
        }

        double media = calcularMedia(Numeros);
        double mediana = calcularMediana(Numeros);
        double desvioPadrão = calcularDesvioPadrão(Numeros);

        return new Estatisticas(media, mediana, desvioPadrão);
    }

    // Classe interna para agrupar os resultados
    public static class Estatisticas {
        private final double media;
        private final double mediana;
        private final double desvioPadrão;

        public Estatisticas(double media, double mediana, double desvioPadrão) {
            this.media = media;
            this.mediana = mediana;
            this.desvioPadrão = desvioPadrão;
        }

        public double getMedia() {
            return media;
        }

        public double getMediana() {
            return mediana;
        }

        public double getDesvioPadrão() {
            return desvioPadrão;
        }
        // getters
    }
}
