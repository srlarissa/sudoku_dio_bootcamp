package br.com.srlarissa;

import br.com.srlarissa.model.Board;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));

        var option = -1;
        while(true){
            System.out.println("Selecione uma das opções a seguir:");
            System.out.println("1 - Iniciar um novo jogo");
            System.out.println("2 - Adicionar um número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar o tabuleiro");
            System.out.println("5 - Verificar o status do jogo");
            System.out.println("6 - Limpar tabuleiro");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch(option){
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentBoard();
                case 5 -> showGameStatus();
                case 6 -> clearBoard();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida! Selecione uma das opções do menu.");
            }

        }
    }

    private static void finishGame() {
    }

    private static void clearBoard() {
    }

    private static void showGameStatus() {
    }

    private static void showCurrentBoard() {
    }

    private static void removeNumber() {
    }

    private static void inputNumber() {
    }

    private static void startGame(final Map<String, String> positions) {
    }
}