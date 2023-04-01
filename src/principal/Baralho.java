package principal;

import java.security.SecureRandom;
import java.util.Random;

public class Baralho {
    private Carta[] cartas;
    private static String[] naipes = {"Paus", "Ouros", "Copas", "Espadas"};
    private static Random gerador = new Random();
    private static SecureRandom embaralha = new SecureRandom();


    public Baralho() {
        int posicao = 0;
        this.cartas = new Carta[52];

        for (int i = 0; i < naipes.length; i++) {
            for (int valor = 1; valor < 14; valor++) {
                cartas[posicao] = new Carta(valor, naipes[i]);
                posicao++;
            }
        }
    }

    /*MÉTODOS*/

    public void Embaralhar() {

        for (int i = 0; i < (cartas.length - 1); i++) {
            //Sorteia uma posição do baralho
            int posicao = embaralha.nextInt(cartas.length);

            //Troca o conteúdo da posição atual pelo conteúdo da posição sorteada
            Carta aux = cartas[i];
            cartas[i] = cartas[posicao];
            cartas[posicao] = aux;
        }
    }

    public Carta retirarUmaCarta() {
        Carta carta;
        int posicao = gerador.nextInt(51);

        //Randomiza a posição enquanto o valor do objeto nela contido seja nulo
        while (cartas[posicao] == null)
            posicao = gerador.nextInt(51);

        carta = cartas[posicao];
        cartas[posicao] = null;

        return carta;
    }

    public Carta[] retirarCartas(int quantidade) {
        Carta[] cartasRemovidas = new Carta[quantidade];
        int posicao = gerador.nextInt((cartas.length - 1));

        //Limita a quantidade de cartas a serem removidas
        if (quantidade > cartas.length)
            quantidade = (cartas.length)/2;

        for (int i = 0; i < quantidade; i++) {
            cartasRemovidas[i] = this.retirarUmaCarta();
        }

        return cartasRemovidas;
    }

    /*GETTERS E SETTERS*/
    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }
}