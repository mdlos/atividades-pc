package atividades.aula6_ex3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
/**
 * Classe que simula um arquivo com linhas de texto.
 */
public class FileMock {
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int) (Math.random() * 255);
                buffer.append((char) indice);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }

    /**
     * Verifica se ainda há linhas a serem lidas.
     * @return true se há mais linhas, false caso contrário.
     */
    public boolean hasMoreLines() {
        return index < content.length;
    }

    /**
     * Retorna a próxima linha do arquivo.
     * @return Próxima linha.
     */
    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }
}

