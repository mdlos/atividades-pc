package atividades.aula5_ex4.Cenario2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    // Locks para controlar o acesso aos atributos
    private final Lock lockCinema1 = new ReentrantLock();
    private final Lock lockCinema2 = new ReentrantLock();

    public Cinema() {
        vacanciesCinema1 = 20;  // Cinema 1 começa com 20 vagas
        vacanciesCinema2 = 20;  // Cinema 2 também começa com 20 vagas
    }

    // Método para vender ingressos para o Cinema 1
    public boolean sellTickets1(int number) {
        lockCinema1.lock();  // Bloqueia o acesso ao Cinema 1
        try {
            if (number <= vacanciesCinema1) {
                vacanciesCinema1 -= number;  // Reduz o número de vagas disponíveis
                return true;  // Venda de ingressos bem-sucedida
            }
            return false;  // Não há ingressos suficientes
        } finally {
            lockCinema1.unlock();  // Libera o acesso ao Cinema 1
        }
    }

    // Método para vender ingressos para o Cinema 2
    public boolean sellTickets2(int number) {
        lockCinema2.lock();  // Bloqueia o acesso ao Cinema 2
        try {
            if (number <= vacanciesCinema2) {
                vacanciesCinema2 -= number;  // Reduz o número de vagas disponíveis
                return true;  // Venda de ingressos bem-sucedida
            }
            return false;  // Não há ingressos suficientes
        } finally {
            lockCinema2.unlock();  // Libera o acesso ao Cinema 2
        }
    }

    // Método para devolver ingressos para o Cinema 1
    public boolean returnTickets1(int number) {
        lockCinema1.lock();  // Bloqueia o acesso ao Cinema 1
        try {
            vacanciesCinema1 += number;  // Aumenta o número de vagas disponíveis
            return true;  // Devolução de ingressos bem-sucedida
        } finally {
            lockCinema1.unlock();  // Libera o acesso ao Cinema 1
        }
    }

    // Método para devolver ingressos para o Cinema 2
    public boolean returnTickets2(int number) {
        lockCinema2.lock();  // Bloqueia o acesso ao Cinema 2
        try {
            vacanciesCinema2 += number;  // Aumenta o número de vagas disponíveis
            return true;  // Devolução de ingressos bem-sucedida
        } finally {
            lockCinema2.unlock();  // Libera o acesso ao Cinema 2
        }
    }

    // Métodos para obter o número de vagas restantes em cada cinema
    public long getVacanciesCinema1() {
        lockCinema1.lock();  // Bloqueia o acesso ao Cinema 1
        try {
            return vacanciesCinema1;
        } finally {
            lockCinema1.unlock();  // Libera o acesso ao Cinema 1
        }
    }

    public long getVacanciesCinema2() {
        lockCinema2.lock();  // Bloqueia o acesso ao Cinema 2
        try {
            return vacanciesCinema2;
        } finally {
            lockCinema2.unlock();  // Libera o acesso ao Cinema 2
        }
    }
}
