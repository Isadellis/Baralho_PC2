package principal;

import java.util.Scanner;

public class Mesa {
    public static void main(String[] args) {
        boolean fimDeJogo = false; //O jogo acaba quando a variável tiver valor "true"

        while (!fimDeJogo) {
            Scanner scanner = new Scanner(System.in);
            Baralho baralho = new Baralho();

            int quantidadeDeCartas;

            /* Inicia-se o jogo */
            System.out.println("Mesa embaralhando........");
            baralho.Embaralhar();

            System.out.println("Informe o número de cartas a distribuir para os jogadores:");
            quantidadeDeCartas =  scanner.nextInt();

            System.out.println("Mesa distribui as " + quantidadeDeCartas + " cartas para o jogador A e para o jogador B");
            Jogador jogadorA = new Jogador(baralho.retirarCartas(quantidadeDeCartas));
            Jogador jogadorB = new Jogador(baralho.retirarCartas(quantidadeDeCartas));

            //Joga a maior carta de cada jogador
            Carta maiorCartaJogadorA = jogadorA.jogarMaiorCarta();
            Carta maiorCartaJogadorB = jogadorB.jogarMaiorCarta();

            System.out.println("\nO jogador A joga a carta de naipe " + maiorCartaJogadorA.getNaipe() + " e de valor " + maiorCartaJogadorA.getValor());
            System.out.println("O jogador B joga a carta de naipe " + maiorCartaJogadorB.getNaipe() + " e de valor " + maiorCartaJogadorB.getValor());

            //Comparação das cartas jogadas
            if (maiorCartaJogadorA.getValor() > maiorCartaJogadorB.getValor()) { //Caso o jogador A tenha a carta de maior valor
                System.out.println("O jogador A venceu o jogo.");
                fimDeJogo = true;

            } else if (maiorCartaJogadorB.getValor() > maiorCartaJogadorA.getValor()) { //Caso o jogador B tenha a carta de maior valor
                System.out.println("O jogador B venceu o jogo.");
                fimDeJogo = true;

            } else { //Caso de empate verifica qual deles tem o naipe "Ouros", se forem os dois o jogo é tido como empatado
                if (maiorCartaJogadorA.getNaipe().equals("Ouros") && !maiorCartaJogadorB.getNaipe().equals("Ouros")) {
                    System.out.println("O jogador A venceu o jogo.");
                    fimDeJogo = true;

                } else if (maiorCartaJogadorB.getNaipe().equals("Ouros") && !maiorCartaJogadorA.getNaipe().equals("Ouros")) {
                    System.out.println("O jogador B venceu o jogo.");
                    fimDeJogo = true;

                } else {
                    System.out.println("O jogo ficou empatado!\n\nJogando novamente...\n\n");
                    fimDeJogo = false;
                }

            }
        } // fim while (fimDeJogo = false)
    }
}
