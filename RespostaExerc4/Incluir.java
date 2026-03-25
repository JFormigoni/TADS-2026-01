package RespostaExerc4;

import java.util.List;
import java.util.Random;

public class Incluir implements Runnable{
    private List<Integer> lista;

    public Incluir(List<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lista) {
                lista.add(random.nextInt(1000));
            }
        }
    }
}
