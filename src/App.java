public class App {
    public static void main(String[] args) {
        int[] vetor = new int[100];
        int ultimaPosicao = 0;
        int tamanho = 0;

        for (int i = 0; i < vetor.length; i++) {
            int opcao = (int)(Math.random() * 3) + 1;
            int numero = (int)(Math.random() * 100) + 1;

            switch (opcao) {
                case 1:
                    if (tamanho == 0 ) {
                        vetor[0] = numero;
                    } else {
                        for (int j = tamanho; j > 0; j--) {
                            vetor[j] = vetor[j - 1];
                        }
                        vetor[0] = numero;
                        
                    }
                    tamanho++;
                    ultimaPosicao = 0;
                    break;
                case 2:
                        vetor[tamanho] = numero;
                        ultimaPosicao = tamanho;
                        tamanho++;
                        break;
                case 3:
                    if (ultimaPosicao > 0 && ultimaPosicao < tamanho) {
                        vetor[ultimaPosicao + 1] =  vetor[ultimaPosicao];
                        vetor[ultimaPosicao] = vetor[ultimaPosicao - 1];
                        vetor[ultimaPosicao - 1] = numero;
                        ultimaPosicao = ultimaPosicao - 1;
                    } else if (ultimaPosicao == 0) {
                        for (int j = tamanho; j > 0; j--) {
                            vetor[j] = vetor[j - 1];
                        }
                        vetor[0] = numero;
                        ultimaPosicao = 0;
                    }
                    tamanho++;
                    break;
            }
        }
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
}
