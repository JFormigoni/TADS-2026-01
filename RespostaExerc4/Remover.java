package RespostaExerc4;

import java.util.List;

public class Remover implements Runnable {
    private List<Integer> lista;

    public Remover(List<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lista) {
            if (!lista.isEmpty()) {
                lista.removeFirst();
                }
            }
        }
    }
}
