package RespostaExerc4;

import java.util.ArrayList;
import java.util.List;

public class RespostaExerc4 {
    public static void main(String[] args) {
        List<Integer> lista = (new ArrayList<>());
        Thread.ofPlatform().start(new Incluir(lista));
        Thread.ofPlatform().start(new Incluir(lista));
        Thread.ofPlatform().start(new Remover(lista));
        Thread.ofPlatform().start(new Imprime(lista));
    }
}