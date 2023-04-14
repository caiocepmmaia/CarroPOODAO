/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 181810115
 */
public class CPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

    public int geraID() {
        return this.idPessoa++;
    }// fim auto increment

    /**
     * Método addPessoa adiciona Pessoa no ArrayList pessoas
     *
     * @param p
     */
    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);
    }// fim arraylist

    /**
     * Método removePessoa remover Pessoas do ArrayList pessoas
     *
     * @param p
     */
    public void removePessoa(Pessoa p) {
        this.pessoas.remove(p);
    }// fim do removePessoa

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }// fim get pessoas

    /**
     * Método getPessoaCPF retona uma pessoa caso encontre correspondencia no
     * CPF do ArrayList pessoas, caso contrário retorna null.
     *
     * @param CPF
     * @return
     */
    public Pessoa getPessoaCPF(String CPF) {
        Pessoa p = null;
        for (Pessoa pes : pessoas) {
            if (pes.getCpf().equals(CPF)) {
                p = pes;
                break;
            }
        }// fim for
        return p;
    }//fim getpessoacpf

    public void mockPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("18585960094");
        p1.setNome("Rafael Sóbis");
        p1.setTelefone("51940028922");
        p1.setEndereco("Rua Venancio Aires");
        addPessoa(p1);
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("89177634055");
        p2.setNome("Fernando Lucio da Costa");
        p2.setTelefone("51917122006");
        p2.setEndereco("Avenida Padre Cacique");
        addPessoa(p2);

    }

}//fim da classe
