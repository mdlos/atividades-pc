package atividades.aula4_ex3;

import java.util.Date;

/**
 * Classe que representa um evento com uma data e uma descrição.
  * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class Event {
    private Date date; // Data em que o evento foi criado
    private String event; // Descrição do evento

    /**
     * Retorna a data do evento.
     * @return Um objeto {@link Date} representando a data do evento.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Define a data do evento.
     * @param date Objeto {@link Date} representando a nova data do evento.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retorna a descrição do evento.
     * @return Uma string contendo a descrição do evento.
     */
    public String getEvent() {
        return event;
    }

    /**
     * Define a descrição do evento.
     * @param event Uma string contendo a nova descrição do evento.
     */
    public void setEvent(String event) {
        this.event = event;
    }
}

