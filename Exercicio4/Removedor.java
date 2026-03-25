package Exercicio4;

import java.util.List;

public class Removedor implements Runnable {
    private List<Integer> lista;

    public Removedor(List<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while (true) {
            if (!lista.isEmpty()) {
                int removido = lista.remove(0);
                System.out.println("Removeu: " + removido);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
