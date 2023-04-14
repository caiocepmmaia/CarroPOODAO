/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviços;

import dao.DAOFactory;
import dao.PessoaDAO;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 181810115
 */
public class PessoaServicos {
    public void cadastroPessoa(Pessoa pVO){
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.cadastrarPessoaDao(pVO);
        
    }
    
    public ArrayList<Pessoa> getPessoas(){
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getPessoas();
    }
    public Pessoa getPessoaByPessoa(String cpf){
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getPessoaByDoc(cpf);
    }
    public void atualizarPessoa(Pessoa pVO){
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.atualizarPessoaDAO(pVO);
    }
    public void deletarPessoa(String cpf){
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.detelatPessoaDAO(cpf);
    }
}
