package atividades.aula5_ex4.Cenario1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
public class TicketOffice2 implements Runnable {
    // Atributo que representa a referência para o cinema
    private Cinema cinema;

    // Construtor que inicializa a referência para o cinema
    public TicketOffice2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        // Simula a venda e devolução de ingressos para o Cinema 1 e Cinema 2

        // Vende 2 ingressos para o Cinema 2
        cinema.sellTickets2(2);
        // Vende 4 ingressos para o Cinema 2
        cinema.sellTickets2(4);
        // Vende 2 ingressos para o Cinema 1
        cinema.sellTickets1(2);
        // Vende 1 ingresso para o Cinema 1
        cinema.sellTickets1(1);
        // Devolve 2 ingressos para o Cinema 2
        cinema.returnTickets2(2);
        // Vende 3 ingressos para o Cinema 1
        cinema.sellTickets1(3);
        // Vende 2 ingressos para o Cinema 2
        cinema.sellTickets2(2);
        // Vende 2 ingressos para o Cinema 1
        cinema.sellTickets1(2);
    }
}
