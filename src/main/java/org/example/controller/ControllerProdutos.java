package org.example.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.example.models.Produtos;
import org.hibernate.mapping.List;
import org.hibernate.sql.Select;

public class ControllerProdutos {

    private boolean init = false;
    private static Scanner input = new Scanner(System.in);
    EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("exercícios-jpa");
    EntityManager gerenciador_mestre = gerenciador.createEntityManager();
 
    private String br = "\n";
    public ControllerProdutos(String _init){
        if(_init.equals("/init")){
            this.init = true; 

            System.out.printf("1-/create:criar produto %s2-/delete:deletar produto  %s3-/alter:alterar produto %s4-/select selecionar produto %s%s",br,br,br,br,br);
            
            System.out.println("Digite algum comando");
            String option = input.nextLine();

            switch(option){
                case "/create":
                adicionarProduto();
                break;
                case "/delete":
                filter();
                break;
                case "/alter":
                break;
                case "/select":
                selecionarProduto();
                break;
                case "/select*":
                selecionarTodosProdutos();
                break;
                default:
                System.out.println("nenhum comando foi reconhecido");
            }

        
                
        }
        else{
            System.out.println("sistema não foi inicializado. Se você queres é inicializar aplicação digite /init");
        }
    }
    private void adicionarProduto(){
        String nome = JOptionPane.showInputDialog("qual nome do produto a ser inserido");
        Double preco = Double.parseDouble(JOptionPane.showInputDialog("qual o preço do produto"));


        boolean valor_negativo = preco > 0;
        boolean valor_vazio = nome.isBlank();
        boolean valor_nulo = nome == null;
        if(valor_negativo){
            if(!valor_vazio){
                if(!valor_nulo){
                    Produtos p = new Produtos(nome,preco);

                    gerenciador_mestre.persist(p);
                    
                    gerenciador_mestre.getTransaction().begin();
                    gerenciador_mestre.getTransaction().commit();
                    gerenciador.close();
                    gerenciador_mestre.close();
                    JOptionPane.showMessageDialog(null,"Produto inserido","inserção",JOptionPane.PLAIN_MESSAGE);    
                }else{ 
                    System.out.println("Este produto não possui nome");
                }
            }else{
                System.out.println("o produto possui o nome vazio");
            }
        }else{
            System.out.println("valor do preço é menor que zero");
        }
    
    }
    private void removerProduto(){
       
    }
    private void alterarproduto(){}
    private void selecionarProduto(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"digite o id do produto"));
        Produtos produtos_R = gerenciador_mestre.find(Produtos.class, id);
        JOptionPane.showMessageDialog(null," id => " + produtos_R.getId() + "\n" + "Produto => " +produtos_R.getNome() + "\n" + "preço =>" + produtos_R.getPreco()+"R$");}
    private void selecionarTodosProdutos(){
        String Jpql = "select u from Produtos u";
        TypedQuery<Produtos> query = gerenciador_mestre.createQuery(Jpql, Produtos.class);
        query.setMaxResults(4);
        java.util.List<Produtos> prodList = query.getResultList();

        prodList.forEach(p -> {
            System.out.println("id => " + p.getId() + "\n" + "Produto => " + p.getNome() + "\n" + "preço =>" + p.getPreco()+"R$"+"\n");});
        
    }

    private void filter(){
        String caracter = JOptionPane.showInputDialog(null,"Qual a inicial para filtro irá utilizar ?");
        String Jpql = "select u from Produtos u"+ 
        "where u == " + caracter;
        TypedQuery<Produtos> query = gerenciador_mestre.createQuery(Jpql, Produtos.class);
        query.setMaxResults(4);
        java.util.List<Produtos> prodList = query.getResultList();
         prodList.forEach(p -> {
            System.out.println("id => " + p.getId() + "\n" + "Produto => " + p.getNome() + "\n" + "preço =>" + p.getPreco()+"R$"+"\n");});
      
        


    }



    private void subFilterPreco(){}
    private void subFilterId(){}


}
