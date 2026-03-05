//Faça um programa concorrente que crie 10 threads que exibam o nome da thread e a hora atual.

import java.util.Date;

public class Exercicio1 extends Thread{

    @Override
    public void run(){
        System.out.printf("%s: %tT\n", getName(), new Date());
    }

    public static void main(String[] args) {
        Exercicio1[] exercs = new Exercicio1[10];
        for (int i = 0; i <= 10; i++){
            exercs[i] = new Exercicio1();
        }
        for (int i = 0; i <= 10; i++){
            exercs[i].start();
        }
    }
}