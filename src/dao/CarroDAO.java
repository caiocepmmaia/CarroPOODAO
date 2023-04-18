/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Carro;
import serviços.PessoaServicos;
import serviços.ServicosFactory;

/**
 *
 * @author 181810115
 */
public class CarroDAO {

    public void cadastrarCarroDao(Carro cVO) {
        try {

            Connection con = Conexao.getConexao();
            String sql = "insert into carros values (null,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getPlaca());
            pst.setString(2, cVO.getMarca());
            pst.setString(3, cVO.getModelo());
            pst.setInt(4, cVO.getAnoFab());
            pst.setInt(5, cVO.getAnoMod());
            pst.setString(6, cVO.getCor());
            pst.setString(7, cVO.getTpCambio());
            pst.setString(8, cVO.getCombustivel());
            pst.setInt(9, cVO.getProprietario().getIdPessoa());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veículo.\n"
                    + e.getMessage());
        }
    }// fim do carro dao

    public ArrayList<Carro> getCarros() {
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        ArrayList<Carro> carros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select c.*, p.cpf as cpf from carros c "
                    + "join pessoas p on c.proprietario = p.idPessoa";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Carro c = new Carro();
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setAnoMod(rs.getInt("anoMod"));
                c.setCor(rs.getString("cor"));
                c.setTpCambio(rs.getString("tpCambio"));
                c.setCombustivel(rs.getString("combustivel"));
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
                carros.add(c);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao lista veículo.\n"
                    + e.getMessage());
        }
        return carros;
    }

    public Carro getCarroByDoc(String placa) {
        Carro c = new Carro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select c.*, p.cpf as cpf from carros c "
                    + "join pessoas p on c.proprietario = p.idPessoa"
                    + "where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setAnoMod(rs.getInt("anoMod"));
                c.setCor(rs.getString("cor"));
                c.setTpCambio(rs.getString("tpcambio"));
                c.setCombustivel(rs.getString("combustivel"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar placa.\n"
                    + e.getMessage());
        }
        return c;
    }
    
    public void atualizarCarroDao(Carro cVO){
        try{
            Connection con = Conexao.getConexao();
            String sql = "update carros set cor = ?, tpcambio = ?, combustivel = ?, proprietario = ?"
                    + " where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getCor());
            pst.setString(2, cVO.getTpCambio());
            pst.setString(3, cVO.getCombustivel());
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            pst.setInt(4, pessoaS.getPessoaByDoc(cVO.getProprietario().getCpf()).getIdPessoa());
            pst.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar veículo.\n"
                    + e.getMessage());
        }
    }
    
    public void deletarCarroDAO(String placa){
        try{
            Connection con = Conexao.getConexao();
            String sql = "delete from carros where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            pst.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao deletar veículo.\n"
                    + e.getMessage());
        }
    }

}
