//Faça um programa concorrente que crie 10 threads que exibam o nome da thread e a hora atual.

import java.util.Date;

public class Exercicio1 extends Thread{

    public void run(){
        System.out.println(getName() + " " + new Date());
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Exercicio1 e1 = new Exercicio1();
            e1.start();
        }
    }
}

//Feito com Runnable
class InnerExercicio1 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        InnerExercicio1 e1 = new InnerExercicio1();
        for (int i = 0; i < 10; i++){
            Thread.ofPlatform().start(e1);
        }
    }
}
//Feito com Thread Virtual
class Exerc1 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName() + " " + new Date());       
    }

    public static void main(String[] args) {
        Exerc1 e1 = new Exerc1();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = Thread.ofVirtual().start(e1);
        }
        for (int i = 0; i < 10; i++){
            try{
                threads[i].join();
            } catch (InterruptedException ie) {
            }
        }
    }
}