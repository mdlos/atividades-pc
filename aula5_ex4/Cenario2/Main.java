package atividades.aula5_ex4.Cenario2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
public class Main {

    public static void main(String[] args) {
        // Criação da instância do cinema
        Cinema cinema = new Cinema();

        // Criação da bilheteira 1 e da thread associada
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");

        // Criação da bilheteira 2 e da thread associada
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

        // Início das threads (início das operações de venda e devolução de ingressos)
        thread1.start();
        thread2.start();

        try {
            // Aguarda as threads terminarem antes de continuar
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o número de vagas restantes nas duas salas
        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }
    
    /**
      Room 1 Vacancies: 5
      Room 2 Vacancies: 6
    */
}
