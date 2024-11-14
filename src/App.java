public class App {
    public static void main(String[] args) {

        int[] vetor = new int[10];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() *10);
            System.out.print(vetor[i] + " ");
        }

        System.out.println();

        int indiceImpar = 0;
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                if (i != indiceImpar) {
                    int temp = vetor[i];
                    vetor[i] = vetor[indiceImpar];
                    vetor[indiceImpar] = temp;
                }
                indiceImpar++;
            }
        }
        for (int num : vetor) {
            if (num % 2 == 0) {
                break;
            }
            System.out.print(num + " ");
        }
    }
}
