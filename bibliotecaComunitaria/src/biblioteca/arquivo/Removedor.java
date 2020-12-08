package biblioteca.arquivo;

import biblioteca.livros.*;
import biblioteca.pessoas.*;
import java.io.*;

/* @author Luam */

public class Removedor {
    
     public static void removerLivro(Livro livroDevolucao, String path) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File antigo = new File(path+"livros.csv");
        File novo = new File (path+"temp.csv");
        
        try {
            br = new BufferedReader(new FileReader(antigo));
            bw = new BufferedWriter(new FileWriter(novo, true));
            PrintWriter pw= new PrintWriter(bw);
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
    
                String[] livro = linha.split(",");
                if (!livro[1].equals(livroDevolucao.getTitulo())){
                    pw.println(linha);
                }
            }
            pw.flush();  
            pw.close();
            br.close();
            antigo.delete();
            
            File aux = new File (path+"livros.csv");
            novo.renameTo(aux);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }   
        }
    }
     
     
     public static void removerCliente(Cliente clienteDeletado, String path) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File antigo = new File(path+"clientes.csv");
        File novo = new File (path+"temp.csv");
        
        try {
            br = new BufferedReader(new FileReader(antigo));
            bw = new BufferedWriter(new FileWriter(novo, true));
            PrintWriter pw= new PrintWriter(bw);
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
    
                String[] cliente = linha.split(",");
                if (!cliente[0].equals(clienteDeletado.getNome())){
                    pw.println(linha);
                }
            }
            pw.flush();  
            pw.close();
            br.close();
            antigo.delete();
            
            File aux = new File (path+"clientes.csv");
            novo.renameTo(aux);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }   
        }
    }
     
     
     public static void removerFuncionario(Funcionario funcionarioDeletado, String path) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File antigo = new File(path+"funcionarios.csv");
        File novo = new File (path+"temp.csv");
        
        try {
            br = new BufferedReader(new FileReader(antigo));
            bw = new BufferedWriter(new FileWriter(novo, true));
            PrintWriter pw= new PrintWriter(bw);
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
    
                String[] funcionario = linha.split(",");
                if (!funcionario[0].equals(funcionarioDeletado.getNome())){
                    pw.println(linha);
                }
            }
            pw.flush();  
            pw.close();
            br.close();
            antigo.delete();
            
            File aux = new File (path+"funcionarios.csv");
            novo.renameTo(aux);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }   
        }
    }
}