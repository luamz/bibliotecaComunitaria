package biblioteca.biblioteca;

import biblioteca.arquivo.*;
import biblioteca.livros.*;
import biblioteca.pessoas.*;
import java.util.ArrayList;

/* @author Luam */

public class Main {
    public static void main(String[] args){
        Sistema sistema = new Sistema();
        sistema.setUnidades(Leitor.leitorUnidades());
        
    }
    
    // Tenho que ler numero, nome e endereço de cada unidade e depois gerar a unidade
    
    public static void lerUnidade(String num){
         //Cria unidade
        Unidade un = new Unidade("src\\unidades\\un"+ num+"\\","Niteroi", "Rua Marechal Floriano 43", "Inga", "23441-001", "Niteroi", "Rio de Janeiro");
        
        //Lê o acervo
        Acervo acervoUn = Leitor.leitorEstantes(un.getPath());
        ArrayList<Autor> autores = Leitor.leitorAutores(un.getPath());
        acervoUn.setAutores(autores);
        Leitor.leitorLivros(acervoUn,un.getPath());
        un.setAcervo(acervoUn);
        //unNiteroi.getAcervo().imprimirAcervo(un.getNome());
       
        //Lê os clientes
        ArrayList<Cliente> clientesNiteroi = Leitor.leitorClientes(un.getPath());
        un.setClientes(clientesNiteroi);
        //imprimir(un.getClientes());
        
        //Lê os funcionarios
        ArrayList<Funcionario> funcionariosNiteroi = Leitor.leitorFuncionarios(un.getPath());
        un.setFuncionarios(funcionariosNiteroi);
        //imprimir(un.getFuncionarios());
    
    }
    
    public static void imprimir(ArrayList a){
        for (Object i: a){
           System.out.println(i);
        }
    }
}
