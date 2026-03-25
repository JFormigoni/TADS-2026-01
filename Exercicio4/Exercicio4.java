package Exercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {
        List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
        
        Adicionador ad1 = new Adicionador(lista, "Thread 1");
        Adicionador ad2 = new Adicionador(lista, "Thread 2");
        Removedor rem = new Removedor(lista);
        Impressora imp = new Impressora(lista);
        
        Thread t1 = new Thread(ad1);
        Thread t2 = new Thread(ad2);
        Thread t3 = new Thread(rem);
        Thread t4 = new Thread(imp);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
