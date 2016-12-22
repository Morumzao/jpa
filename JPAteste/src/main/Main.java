package main;

import main.Compra;

import java.util.Scanner;

public class Main {


    static String logo =
            "=============================================\n" +
            "|  ______   _   _______   ______   ______   |\n" +
            "|  |  _  | | |  |___   |  |___   | |  _  |  |\n" +
            "|  | |_| | | |      / /       / /  | |_| |  |\n" +
            "|  |  __/  | |    / /       / /    |  _  |  |\n" +
            "|  | |     | |  / /____   / /____  | | | |  |\n" +
            "|  |_|     |_| |_______| |_______| |_| |_|  |\n" +
            "=============================================";

    static String[] main_menu = {
            "Montar uma pizza",
            "Remover uma pizza do carrinho",
            "Ver pedidos anteriores",
            "Sair"
    };

    static String[] menu_pedido = {
            "Adiciona um sabor",
            "Remover um sabor",
            "Adicionar ao carrinho",
            "Cancelar pedido"
    };

    static Sabor[] sabores = {
            new Sabor("Muzzarela",1.75),new Sabor("Calabresa",2.25),
            new Sabor("Peperonni",3.25),new Sabor("Cebola",2),
            new Sabor("Ovo",2),new Sabor("Piment�o",2),
            new Sabor("Tomate",2),new Sabor("Presunto",2),
            new Sabor("R�cula",1.75),new Sabor("Mangeric�o",1.5),
            new Sabor("Picanha",2),new Sabor("Azeitona",1)};

    static Compra compra = new Compra();

    public static void main(String args[]){

        int opt;

        boolean fim = false;

        do {

            clearConsole();
            System.out.println(logo);
            System.out.println("Seja bem-vindo � melhor pizzaria da cidade!\nComo podemos Ajuda-lo?");
            mostraCarrinho(compra);
            System.out.print(compra.getPizzas().size() > 0 ? "0 - Enviar Pedido\n" : "");
            mostraArray(main_menu);
            System.out.print("\nDigite a op��o desejada: ");

            opt = validaOpcao(compra.getPizzas().size() > 0 ? 0 : 1, main_menu.length);

            switch (opt) {
                case 0:
                    clearConsole();
                    GravaCompra.gravarCompra(compra);
                    System.out.println("Compra finalizada com sucesso!");
                    break;
                case 1:
                    clearConsole();
                    fim = novoPedido();
                    break;
                case 2:
                    clearConsole();
                    fim = verPedidos();
                    break;
                case 3:
                    clearConsole();
                    System.out.println("Compras anteriores: ");
                    Object[] compras = GravaCompra.getCompras().toArray();
                    for(int i = 0; i < compras.length; i++){
                        mostraArray(((Compra) compras[i]).getPizzas().toArray());
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
                    }
                    break;
                default:
                    System.out.println("Volte sempre! A melhor pizzaria da cidade agradece!");
                    fim = true;
            }

        } while(!fim);

    }

    public static <T> void mostraArray(T[] array){
        int ct = 1;
        for(T element:array){
            System.out.println(ct+" - "+element);
            ct++;
        }
    }

    public static boolean novoPedido(){

        boolean fim = false;

        Pizza pizza = new Pizza();

        int opt;

        do {

            clearConsole();
            System.out.println(logo);
            mostraPizza(pizza);
            System.out.println("Seja bem vindo ao nosso sistema de pedidos personalizados!\n" +
                    "Utilize o menu abaixo para montar sua pizza!");

            mostraArray(menu_pedido);

            opt = validaOpcao(1, menu_pedido.length);

            switch(opt){

                case 1:

                    clearConsole();
                    System.out.println(logo);
                    mostraPizza(pizza);
                    System.out.println("Sabores dispon�veis: ");
                    System.out.println("0 - Cancelar");
                    mostraArray(sabores);
                    System.out.print("Digite um sabor para ser adicionado na pizza: ");

                    opt = validaOpcao(0, sabores.length);

                    if(opt > 0)
                        pizza.addSabor(sabores[opt-1]);

                    break;

                case 2:

                    Object[] sabores = pizza.getSabores().toArray();

                    clearConsole();
                    System.out.println(logo);
                    mostraPizza(pizza);
                    System.out.println("Sabores escolhidos: ");
                    System.out.println("0 - Cancelar");
                    mostraArray(sabores);
                    System.out.print("Digite um sabor para ser removido da pizza: ");

                    opt = validaOpcao(0, sabores.length);

                    if(opt > 0)
                        pizza.removeSabor((Sabor) sabores[opt-1]);

                    break;

                case 3:
                    pizza.geraNome();
                    compra.addPizza(pizza);

                default:
                    fim = true;

            }

        }while(!fim);



        return false;

    }

    public static boolean verPedidos(){

        boolean fim = false;

        return fim;

    }

    public static void mostraPizza(Pizza pizza){

        if(pizza.getSabores().size() > 0) {

            System.out.println("=============================================");
            System.out.println("main.Pizza - R$12");
            mostraArray(pizza.getSabores().toArray());
            System.out.println("Total: R$" + pizza.getPreco());
            System.out.println("=============================================");

        }

    }

    public static void mostraCarrinho(Compra compra){

        if(compra.getPizzas().size() > 0) {

            System.out.println("=============================================");
            System.out.println("Carrinho de compras:");
            mostraArray(compra.getPizzas().toArray());
            System.out.println("Total: R$" + compra.getPreco());
            System.out.println("=============================================");

        }

    }

    public static int validaOpcao(int min, int max){

        Scanner scanner;
        int opt;

        do {

            scanner = new Scanner(System.in);

            opt = scanner.nextInt();

            if (opt < min || opt > max) {
                System.out.println("Op��o inv�lida, tente novamente.");
                System.out.print("\nDigite a op��o desejada: ");
            }

        } while (opt < min || opt > max);

        return opt;

    }

    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

}