package controller;

import java.util.Scanner;

public class MenuController {
    static Scanner sc = new Scanner(System.in);

    public static int lerIndiceValido(int tamanhoLista, Scanner sc) {
    while (true) {
        try {
            String entrada = sc.nextLine();
            int idx = Integer.parseInt(entrada) - 1; 

            if (idx >= 0 && idx < tamanhoLista) {
                return idx;
            } else {
                System.out.println("Escolha um índice válido (entre 1 e " + tamanhoLista + ")!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números para o índice!");
        }
    }
}

    
}
