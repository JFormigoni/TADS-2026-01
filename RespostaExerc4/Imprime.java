package RespostaExerc4;

import java.util.List;

public class Imprime implements Runnable {
    private List<Integer> lista;

    public Imprime(List<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lista) {
                System.out.println(lista);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}