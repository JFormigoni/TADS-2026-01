package Exercicio4;

import java.util.List;

public class Impressora implements Runnable {
    private List<Integer> lista;

    public Impressora(List<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lista) {
                System.out.println("Lista: " + lista);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
