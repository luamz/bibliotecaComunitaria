/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.biblioteca;

/**
 *
 * @author victoria
 */
public abstract class Endereco {
    
    protected String rua;
    protected String bairro;
    protected String cep;
    protected String cidade;
    protected String estado;
    
    public void Endereco(String rua, String bairro, String cep, String cidade, String estado){
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}