public class App {
    public static void main(String[] args){
        int[] vetor = {5, 2, 9, 1, 5, 6};
        crescenteVetor(vetor);
    }

    public static void crescenteVetor(int[] vetor){
        int n = vetor.length;
        for (int i = 0; i < n; i++) {
            int menorValor = vetor[0];
            int indexMenor = 0;
            
            for (int j = 0; j < n; j++) {
                if (vetor[j] != Integer.MAX_VALUE && vetor[j] < menorValor) {
                    menorValor = vetor[j];
                    indexMenor = j;
                }
            }

            System.out.print(menorValor + " ");

            vetor[indexMenor] = Integer.MAX_VALUE; 
        }
    }
}
