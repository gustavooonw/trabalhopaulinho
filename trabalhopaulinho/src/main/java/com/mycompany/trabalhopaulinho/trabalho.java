package com.mycompany.trabalhopaulinho;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class trabalho {
    public static void main(String[] args) {

        String escolhaMetodo = JOptionPane.showInputDialog("Escolha um método de ordenação:\n" +
                                                      "\n1 → Ordenação por Inserção" +
                                                      "\n2 → Ordenação por Seleção" +
                                                      "\n3 → Ordenação Bolha\n\n");
        int escolha = Integer.parseInt(escolhaMetodo);

        if(escolha <= 0 || escolha >= 4){
            JOptionPane.showMessageDialog(null, "Número inválido, escolha corretamente!!");
            System.exit(0);
     }
        String tamanhoV = JOptionPane.showInputDialog("→ Informe o tamanho do vetor:");
        int tamanhoVetor = Integer.parseInt(tamanhoV);

        int[] vetorNumeros = new int[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            String numeroStr = JOptionPane.showInputDialog("→ Informe numero " + (i+1));
            vetorNumeros[i] = Integer.parseInt(numeroStr);
    }

      
        int[] vetorOriginal = Arrays.copyOf(vetorNumeros, vetorNumeros.length);
        long tempoInicio = System.nanoTime();
        switch (escolha) {
            case 1:
                ordenacaoPorInsercao(vetorNumeros);
                break;
            case 2:
                ordenacaoPorSelecao(vetorNumeros);
                break;
            case 3:
                ordenacaoBolha(vetorNumeros);
                break;
     }
        long tempoFim = System.nanoTime();

        StringBuilder vetorOriginalStr = new StringBuilder();
        for (int numero : vetorOriginal) {
            vetorOriginalStr.append(numero).append(" ");
     }

        StringBuilder vetorOrdenadoStr = new StringBuilder();
        for (int numero : vetorNumeros) {
            vetorOrdenadoStr.append(numero).append(" ");
      }
        JOptionPane.showMessageDialog(null,"Vetor original:\n" + vetorOriginalStr.toString() +
                                            "\n\nVetor ordenado:\n" + vetorOrdenadoStr.toString() +
                                            "\n\nTempo de execução: " + (tempoFim - tempoInicio) + " nano segundos"); //Tinha colocado em MS, mas sempre ficava 0
                                                                                                                      //Para aparecer coloquei em NS
 }
    public static void ordenacaoPorInsercao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
         }
            vetor[j + 1] = chave;
       }
 }
    public static void ordenacaoPorSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
             }
      }
            int aux = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = aux;
      }
  }
    public static void ordenacaoBolha(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
}
   }
      }
         }
}
