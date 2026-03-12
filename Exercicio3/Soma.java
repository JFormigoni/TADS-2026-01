package Exercicio3;

class Soma implements Runnable {
    private int[] numeros;
    private int inicio;
    private int fim;
    private long soma;
    
    public Soma(int[] numeros, int inicio, int fim) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    public void run() {
        soma = 0;
        for (int i = inicio; i < fim; i++) {
            soma += numeros[i];
        }
    }
    
    public long getSoma() {
        return soma;
    }
}
