//Faça um programa concorrente que crie 10 threads que exibam o nome da thread e um contador que varia de 1 a 10.
//Execute várias vezes e observe as variações na saída. 
//Os valores são sempre impressos na mesma ordem?

public class Exercicio2 extends Thread{

    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Exercicio2 e1 = new Exercicio2();
            e1.start();
        }
    }
}

class InnerExercicio2 implements Runnable {
    public void run(){
        for (int i = 1; i <= 10; i++){
            System.out.println(Thread.currentThread().threadId() + " " + i);
        }
    }
    
    public static void main(String[] args) {
        Thread[] ts = new Thread[10];
        InnerExercicio2 e1 = new InnerExercicio2();
        for (int i = 0; i < 10; i++){
            ts[i] = Thread.ofVirtual().name("T" + 1).start(e1);
        }
        for (int i = 0; i < 10; i++){
            try{
                ts[i].join();
            } catch (InterruptedException ie) {
            }
        }
    }
}