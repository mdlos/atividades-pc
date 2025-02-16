package atividades.aula7_ex1;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

/**
 * Classe Results que armazena os resultados parciais da busca.
 */
public class Results {

    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
