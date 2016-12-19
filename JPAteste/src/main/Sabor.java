package main;

public class Sabor {

    private double preco;
    private String nome;

    public Sabor(String nome, double preco){
        this.preco = preco;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return String.format("%s - R$%.2f",nome,preco);
    }

}
