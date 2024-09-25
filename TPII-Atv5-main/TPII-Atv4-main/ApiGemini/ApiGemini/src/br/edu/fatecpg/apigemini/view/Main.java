package br.edu.fatecpg.apigemini.view;

import br.edu.fatecpg.apigemini.service.ConsomeApi;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("1- Fazer uma pergunta \n 2- Sair");
            int mudar = scan.nextInt();
            scan.nextLine(); 
            
            if (mudar == 1) {
                    System.out.println("Digite sua primeira pergunta: ");
                    String question1 = scan.nextLine();
                    System.out.println("Digite sua segunda pergunta: ");
                    String question2 = scan.nextLine();
                    System.out.println("Digite sua terceira pergunta: ");
                    String question3 = scan.nextLine();
                    String resposta = ConsomeApi.fazerPergunta("Faça um resumo sobre: " + question1 + question2 + question3);
                    System.out.println("Sua resposta é: " + resposta);
                        try {
                            FileWriter writer = new FileWriter("api.txt");
                            writer.write(resposta);
                            writer.close();
                            System.out.println("Gravado com sucesso");
                        } catch (IOException e) {
                            System.out.println("Ocorreu um erro.");
                        }
            } else {
                return;
            }
        }
    }
}
