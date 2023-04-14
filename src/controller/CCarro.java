/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static inf3n212.carro.INF3N212Carro.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 181810115
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList();

    public void addCarro(Carro c) {
        this.carros.add(c);
    }//fim addCarro

    public void removeCarro(Carro c) {
        this.carros.remove(c);
    }//fim remove

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }//fim arraylist

    public Carro getCarroPlaca(String placa) {
        Carro c = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                c = carro;
                break;

            }//fim for
        }
        return c;
    }//fim getcarroplaca
    public void mockCarros(){
        Carro c1 = new Carro();
        c1.setPlaca("IYX4E12");
        c1.setMarca("Chevrolet");
        c1.setModelo("Onix");
        c1.setAnoFab(2018);
        c1.setAnoMod(2019);
        c1.setCor("Branco");
        c1.setTpCambio("Manual");
        c1.setCombustivel("Flex");
        c1.setProprietario(cadPessoa.getPessoaCPF("18585960094"));
        addCarro(c1);
        Carro c2 = new Carro();
        c2.setPlaca("MSX9900");
        c2.setMarca("Ford");
        c2.setModelo("Focus");
        c2.setAnoFab(2017);
        c2.setAnoMod(2017);
        c2.setCor("Preto");
        c2.setTpCambio("Automático");
        c2.setCombustivel("Flex");
        c2.setProprietario(cadPessoa.getPessoaCPF("89177634055"));
        addCarro (c2);
    
    }// fim mock
}//fim da classe
