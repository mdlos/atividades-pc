package atividades.aula7_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Classe FileSearch que implementa Runnable para buscar arquivos com uma extensão específica.
 */
public class FileSearch implements Runnable {

    private String initPath; // Caminho inicial para a busca
    private String end;      // Extensão do arquivo a ser buscado
    private List<String> results; // Lista de resultados
    private Phaser phaser;   // Phaser para sincronização das fases

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        this.results = new ArrayList<>();
    }

    @Override
    public void run() {
        // Fase 1: Aguarda todas as threads começarem
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
        File file = new File(initPath);
        if (file.isDirectory()) {
            directoryProcess(file); // Processa o diretório
        }

        // Fase 2: Verifica se há resultados
        if (!checkResults()) {
            return; // Se não houver resultados, a thread é desregistrada
        }

        // Fase 3: Filtra os resultados (arquivos modificados nas últimas 24 horas)
        filterResults();

        // Fase 4: Verifica novamente se há resultados após o filtro
        if (!checkResults()) {
            return; // Se não houver resultados, a thread é desregistrada
        }

        // Fase 5: Exibe os resultados
        showInfo();

        // Fase 6: Finaliza a execução da thread
        phaser.arriveAndDeregister();
        System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
    }

    /**
     * Processa um diretório e seus subdiretórios.
     */
    private void directoryProcess(File file) {
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isDirectory()) {
                    directoryProcess(f); // Recursão para subdiretórios
                } else {
                    fileProcess(f); // Processa arquivos
                }
            }
        }
    }

    /**
     * Processa um arquivo e verifica se ele tem a extensão desejada.
     */
    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath()); // Adiciona o caminho do arquivo à lista de resultados
        }
    }

    /**
     * Filtra os resultados para incluir apenas arquivos modificados nas últimas 24 horas.
     */
    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (String result : results) {
            File file = new File(result);
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(result); // Adiciona à nova lista se o arquivo foi modificado nas últimas 24 horas
            }
        }
        results = newResults;
    }

    /**
     * Exibe os resultados encontrados.
     */
    private void showInfo() {
        for (String result : results) {
            File file = new File(result);
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance(); // Aguarda todas as threads terminarem de exibir os resultados
    }

    /**
     * Verifica se há resultados. Se não houver, a thread é desregistrada.
     */
    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
            System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
            phaser.arriveAndDeregister(); // Desregistra a thread
            return false;
        } else {
            System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),
                    results.size());
            phaser.arriveAndAwaitAdvance(); // Aguarda outras threads
            return true;
        }
    }
}
