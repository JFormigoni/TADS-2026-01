package Exercicio4;

import java.util.List;
import java.util.Random;

public class Adicionador implements Runnable {
    private List<Integer> lista;
    private String nome;

    public Adicionador(List<Integer> lista, String nome) {
        this.lista = lista;
        this.nome = nome;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int valor = random.nextInt(100);
            lista.add(valor);
            System.out.println(nome + " adicionou: " + valor);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
