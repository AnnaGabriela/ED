package OrderedList;

public class OrderedList {

    private int[] dados;
    private int qtd;

    public OrderedList() {
        dados = new int[10];
        qtd = 0;
    }

    public void add(int n) {
        int i = 0;
        cheia();
        while (n < qtd) {
            if (n < dados[i]) {
                i++;
                break;
            }
        }
        if (dados[i] != n) {
            for (int j = qtd; j > i; j--) {
                dados[j] = dados[j - 1];
            }
            dados[i] = n;
            qtd++;
        }
    }

    public void remover(int n) {
        int i = 0;
        cheia();
        if (dados.length != 0) {
            while (i < qtd) {
                if (n <= dados[i]) {
                    break;
                }
                i++;
            }

            if (dados[i] == n) {
                for (int j = i + 1; j < qtd; j++) {
                    dados[j - 1] = dados[j];
                }
            }
            qtd--;
            dados[qtd] = 0;
        }
    }

    public void cheia() {
        if (qtd == dados.length) {
            int[] novosDados = new int[dados.length * 2];
            for (int i = 0; i < dados.length; i++) {
                novosDados[i] = dados[i];
            }
            dados = novosDados;
        }
    }

    private int indexOf(int x) {
        int esq = 0, dir = qtd - 1;
        int index = -1;
        while (esq <= dir) {
            int meio = (esq + dir) / 2;
            if (x == dados[meio]) {
                index = meio;
                break;
            } else if (x < dados[meio]) {
                dir = meio - 1;
            } else {
                esq = meio + 1;
            }
        }
        return index;
    }
}