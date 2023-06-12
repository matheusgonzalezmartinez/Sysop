/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sysop.dao;

import com.sysop.objects.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * @author CAA201
 */
public class DAO {

    public boolean existe(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha= ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public String retornaUsuario(Usuario usuario) throws Exception {
        String sql = "SELECT Funcao FROM usuario WHERE nome = ? AND senha= ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Funcao");
                }
                return null;

            }
        }
    }
    
    public int retornaId(Usuario usuario) throws Exception {
        String sql = "SELECT ID_usuario FROM usuario WHERE nome = ? AND senha= ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_usuario");
                }
                return 0;
            }
        }
    }
    public boolean existeCpf(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE CPF = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getCpf());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    public Usuario buscaCpf(String cpf) throws Exception {
        String sql = "SELECT * FROM usuario WHERE CPF = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setCpf(rs.getString("CPF"));
                    usuario.setId (rs.getInt("ID_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSenha(rs.getString("Senha"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setFuncao(rs.getString("Funcao"));  
                    return usuario;
                }
                                           
                    return null;
                
            }
        }
    }
    
    public boolean atualizaUsuario(Usuario u) throws Exception {
        String sql = "UPDATE usuario SET CPF = ?, nome = ?, senha = ?, email = ?, Funcao = ?  WHERE ID_usuario = ?" ;
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getCpf());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getFuncao());
            ps.setInt(6, u.getId());
            
             int k = ps.executeUpdate();

            if (k == 1) {
                return true;
            
            }
                return false;
        }
    }
}
