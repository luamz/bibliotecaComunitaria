package biblioteca.livros;

import biblioteca.arquivo.Editor;
import biblioteca.biblioteca.Unidade;
import java.util.ArrayList;
import biblioteca.pessoas.*;

/* @author Luam */

public class Acervo {
    public int idsLivros= 1;
    public int idsEstantes = 1;
    protected ArrayList<Estante> estantes = new ArrayList<>();
    protected ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    protected ArrayList<Autor> autores = new ArrayList<>();

    public void emprestarLivro(Unidade unidade, Cliente cliente, String titulo) {
        
        if (cliente.getLivrosPegos()<3){ // Checa se o cliente pode pegar um livro
            Livro aux  = this.buscarLivroTitulo(titulo);
            Emprestimo novo = new Emprestimo(aux, "15/10/20", "30/12/20" );
            aux.emprestar();
            //Editor.modificarEmprestimo(this, aux, unidade.getPath(), "true");

            this.emprestimos.add(novo);
            // Adicionar no arquivo de emprestimos
            cliente.addLivrosPegos();
            // Atualizar arquivo de clientes
        }
        
        else {
            System.out.println("O cliente já pegou o máximo de livros emprestado.");
        }   
    }
    
   
    public void devolverLivro(Unidade unidade, Cliente cliente, String titulo) {
        Emprestimo devolucao = buscarEmprestimo(cliente,titulo);
        emprestimos.remove(devolucao);
        
        Livro aux  = this.buscarLivroTitulo(titulo);
        aux.devolver();
        
        Editor.modificarEmprestimo(this, aux, unidade.getPath(), "false");
        
        // Tirar doo arquivo de emprestimos
        cliente.decrementLivrosPegos();
        // Atualizar arquivo de clientes
    }
    
    public Emprestimo buscarEmprestimo(Cliente cliente, String titulo){
        for (Emprestimo e: emprestimos){
            if ((e.getCliente().equals(cliente)) && (e.getLivro().getTitulo().equals(titulo))){
                return e;
            }
        }
        return null;
    }
    
    public boolean buscarAutor(String nome){
        for (Autor autor : autores){
            if (autor.getNome().equals(nome))
                return true;
        }
        return false;
    }
    
  
    public void addEstante(Estante nova) {
        estantes.add(nova);
        idsEstantes++;
    }
    
    public void addLivro(Livro novo){
        if (autores.contains(novo.getAutor())){
            for (Autor autor : autores){
                autor.addLivro(novo);
            }
        }
        
        else{
            Autor autor = new Autor(novo.getAutor().getNome());
            autor.addLivro(novo);
            this.autores.add(autor);
        }
        
        for (Estante e : estantes){
            if (e.getGenero().equals(novo.genero)){
                e.addLivroNaEstante(novo);
            }
        }
        
    }
    
    public Livro buscarLivroTitulo (String titulo){
        for (Estante e : estantes){
            for (Livro l : e.livros){
                if (l.titulo.equals(titulo)){
                    return l;
                }
            }
        }
        return null;
    }
    
    public void imprimirAcervo(String nomeUnidade){
        System.out.println("Acervo da Unidade - " + nomeUnidade);
        for (Estante e : estantes){
            e.imprimirEstante();
        }
    }
  
    public void setEstantes(ArrayList<Estante> estantes) {
        this.estantes = estantes;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
}
