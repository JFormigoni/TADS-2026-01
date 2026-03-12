package Exercicio3;

import java.util.Random;

public class Exercicio3 {
    public static void main(String[] args) throws InterruptedException {
        // Criando 1 bilhão de números aleatórios
        int[] numeros = new int[1_000_000_000];
        Random random = new Random();
        
        System.out.println("Gerando números aleatórios...");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println("Números gerados!\n");
        
        // 1. Soma sequencial (jeito tradicional, sem threads)
        System.out.println("=== SOMA SEQUENCIAL ===");
        long inicio = System.currentTimeMillis();
        long soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Resultado: " + soma);
        System.out.println("Tempo: " + tempo + " ms\n");

        // 2. Soma com 10 threads normais
        System.out.println("=== 10 THREADS NORMAIS ===");
        somarComThreads(numeros, 10, false);
        
        // 3. Soma com 100 threads normais
        System.out.println("=== 100 THREADS NORMAIS ===");
        somarComThreads(numeros, 100, false);
        
        // 4. Soma com 10 threads virtuais
        System.out.println("=== 10 THREADS VIRTUAIS ===");
        somarComThreads(numeros, 10, true);
        
        // 5. Soma com 100 threads virtuais
        System.out.println("=== 100 THREADS VIRTUAIS ===");
        somarComThreads(numeros, 100, true);
    }
    
    // Método auxiliar para somar usando threads
    static void somarComThreads(int[] numeros, int numeroDeThreads, boolean virtual) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        
        // Cada thread vai processar uma parte do array
        int tamanhoDaParte = numeros.length / numeroDeThreads;
        
        // Arrays para guardar as threads e os objetos que fazem a soma
        Soma[] somas = new Soma[numeroDeThreads];
        Thread[] threads = new Thread[numeroDeThreads];
        
        // Criando e iniciando cada thread
        for (int i = 0; i < numeroDeThreads; i++) {
            int comeco = i * tamanhoDaParte;
            int fim = (i == numeroDeThreads - 1) ? numeros.length : (i + 1) * tamanhoDaParte;
            
            somas[i] = new Soma(numeros, comeco, fim);
            
            if (virtual) {
                threads[i] = Thread.ofVirtual().start(somas[i]);
            } else {
                threads[i] = new Thread(somas[i]);
                threads[i].start();
            }
        }
        
        // Esperando todas as threads terminarem e somando os resultados
        long somaTotal = 0;
        for (int i = 0; i < numeroDeThreads; i++) {
            threads[i].join(); // Espera a thread terminar
            somaTotal += somas[i].getSoma(); // Pega o resultado dela
        }
        
        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Resultado: " + somaTotal);
        System.out.println("Tempo: " + tempo + " ms\n");
    }
}
