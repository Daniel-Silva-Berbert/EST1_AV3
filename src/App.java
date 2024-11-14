public class App {
    public static void main(String[] args){
        int[] vetor1 = {1, 3, 5, 7, 10};
        int[] vetor2 = {2, 4, 5, 8, 10};

        int[] resultado = gerarVetor(vetor1, vetor2);

        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }

    public static int[] gerarVetor(int[] vetor1, int[] vetor2) {
        int n = vetor1.length;
        int p1 = 0;
        int p2 = 0;
        int[] resultado = new int[n];
        for (int i = 0; i < n; i++) {
            int sorteio = (int)(Math.random() * 10);

            if (sorteio % 2 == 0) {
                resultado[i] = vetor1[p1++];
            } else {
                resultado[i] = vetor2[p2++];
            }
        }

        return resultado;
    }
}
