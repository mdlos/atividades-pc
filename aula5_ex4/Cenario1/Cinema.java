package atividades.aula5_ex4.Cenario1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    public Cinema() {
        vacanciesCinema1 = 20;  // Cinema 1 começa com 20 vagas
        vacanciesCinema2 = 20;  // Cinema 2 também começa com 20 vagas
    }

    // Método sincronizado para vender ingressos para o Cinema 1
    public synchronized boolean sellTickets1(int number) {
        if (number <= vacanciesCinema1) {
            vacanciesCinema1 -= number;  // Reduz o número de vagas disponíveis
            return true;  // Venda de ingressos bem-sucedida
        }
        return false;  // Não há ingressos suficientes
    }

    // Método sincronizado para vender ingressos para o Cinema 2
    public synchronized boolean sellTickets2(int number) {
        if (number <= vacanciesCinema2) {
            vacanciesCinema2 -= number;  // Reduz o número de vagas disponíveis
            return true;  // Venda de ingressos bem-sucedida
        }
        return false;  // Não há ingressos suficientes
    }

    // Método sincronizado para devolver ingressos para o Cinema 1
    public synchronized boolean returnTickets1(int number) {
        vacanciesCinema1 += number;  // Aumenta o número de vagas disponíveis
        return true;  // Devolução de ingressos bem-sucedida
    }

    // Método sincronizado para devolver ingressos para o Cinema 2
    public synchronized boolean returnTickets2(int number) {
        vacanciesCinema2 += number;  // Aumenta o número de vagas disponíveis
        return true;  // Devolução de ingressos bem-sucedida
    }

    // Métodos para obter o número de vagas restantes em cada cinema
    public synchronized long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public synchronized long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
