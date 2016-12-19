package main;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private List<Sabor> sabores = new ArrayList<Sabor>();
    private double preco = 12;
    private String nome;

    public void addSabor(Sabor sabor){
        sabores.add(sabor);
        preco += sabor.getPreco();
    }

    public void removeSabor(Sabor sabor){
        sabores.remove(sabor);
        preco-=sabor.getPreco();
    }

    //SET & GET
    public List<Sabor> getSabores(){
        return sabores;
    }

    public void setSabores(List<Sabor> sabores){
        this.sabores = sabores;
        preco = 12;
        for(Sabor sabor:sabores){
            preco += sabor.getPreco();
        }
    }

    public double getPreco(){
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
        return String.format("%s - %.2f",nome,preco);
    }

    public void geraNome(){
        String[] nomes = new String[sabores.size()];
        int ct = 0;
        for(Sabor sabor:sabores){
            int start,end;
            start = ct%2 > 0 && sabor.getNome().length() >= 6 ? 3 : 0;
            end = ct%2 > 0 && sabor.getNome().length() >= 6 ? sabor.getNome().length() : 3;

            if(ct+1 == nomes.length) {
                nomes[ct] = sabor.getNome().substring(start, end);
            }else {
                nomes[ct] = sabor.getNome().substring(start, end);
            }
            ct++;
        }
        nome = "main.Pizza";
        for(int i = 0; i < nomes.length; i++){
            if(i%2 > 0) {
                nome += i == 0 ? nomes[i].substring(0, 1).toUpperCase() + nomes[i].substring(1).toLowerCase() : nomes[i].toLowerCase();
            }else {
                nome += " " + nomes[i].substring(0, 1).toUpperCase() + nomes[i].substring(1).toLowerCase();
            }
        }

    }

}
