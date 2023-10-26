package org.example.controller;

import java.util.Scanner;

public class ControllerProdutos {

    private boolean init = false;
    private static Scanner input = new Scanner(System.in);
 
    private String br = "\n";
    public ControllerProdutos(String _init){
        if(_init.equals("/init")){
            this.init = true; 

            System.out.printf("1-/create:criar produto %s2-/delete:deletar produto  %s3-/alter:alterar produto %s4-/select selecionar produto %s%s",br,br,br,br,br);
            
            System.out.println("Digite algum comando");
            String option = input.nextLine();

            switch(option){
                case "/create":
                break;
                case "/delete":
                break;
                case "/alter":
                break;
                case "select":
                break;
                default:
                System.out.println("nenhum comando foi reconhecido");
            }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
        else{
            System.out.println("sistema não foi inicializado. Se você queres é inicializar aplicação digite /init");
        }
    }
    private void adicionarProduto(){}
    private void removerProduto(){}
    private void alterarproduto(){}
    private void selecionarProduto(){}


}
