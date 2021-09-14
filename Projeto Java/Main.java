import java.util.Scanner;

class Main {	

  static Scanner entrada = new Scanner(System.in);

  public static void main(String[] args) throws NumberFormatException{    

		//###INFO PESSOA###
  	String nome = "";
		String cidade = "";
    int idade = 0;

		boolean resposta = false; 
    
		//### INFO SOBRE CONDICAO ###
		boolean espacoSuficiente = false; //condicionais para o final
		boolean condicaoFinanceira = false; //condicionais para o final
		boolean tempoDisponivel = false; //condicionais para o final

		//### INFO SOBRE ANIMAL ###
		boolean ehGato = false; 
		boolean ehFemea = false; 
		boolean petResgatado = false;
    
		///### INICIANDO ###

		Usuario usuario = new Usuario();
    System.out.println("==========================================================");
    System.out.println("================ {}Java Adote Um Pet{} ===================");    
    System.out.println("################  {!}Seja bem vinde{!} ###################");
    System.out.println("==========================================================");
    
    /////////////Info e verificação de Nome/////////
    do {
			resposta = false;
    	System.out.println("\n{*}Digite o seu nome{*} ");
   		nome = entrada.nextLine();			

      if(!nome.matches("^[A-zÀ-ú '´]+$")){ //.matches() verifica se o nome passado é compatível com os caracteres de A a Z e com acentuação, caso contrário, retorna que o nome não é válido
        System.out.println("Você precisa digitar um nome válido!");
      } else if (nome.length() < 5){
        System.out.println("O nome precisa ter pelo menos 5 letras");
        } else {
        resposta = true;
        String[] partes = nome.split(" "); //trecho para forçar letras minúsculas para maiúsculas, criação do array partes para separar as palavras passadas com espaço, todas as palavras são verificadas por um loop for, depois juntamos as palavras com o append.
        StringBuilder sb = new StringBuilder(); //stringBuilder serve para manipular as palavras, já que String normal não te permite fazer isso

        for (int i = 0; i < partes.length; i++) {
            String word = partes[i];
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            sb.append(" ").append(word);
            nome = sb.toString().replaceFirst(" ", ""); //replaceFirst é um método pra substituir a primeira letra depois de passado um espaço
        }
        usuario.setNome(nome);//w/faz o objeto usuario receber o nome
      }
    } while(resposta == false);

		System.out.println("\n==========================================================");

	 /////////////Info e verificação de Idade/////////
    do{
			resposta = false;
    	System.out.println("\nOlá " + nome + ", digite a sua idade: ");
      try { //testa as condicionais, casso ocorra a entrada de uma exceção, ie: passar número onde é esperado string, ao invés do programa encerra, ele trata a exceção no catch.
          idade = Integer.parseInt(entrada.nextLine());					
          if (idade == (int)idade && idade < 1 || idade > 120) {
              System.out.println("Digite uma idade válida!");
          } else if (idade <= 17) {
              System.out.println("|{Converse Com Seus Pais ou Responsaveis e Tente Novamente!!!}|");
          } else {
              resposta = true;
              usuario.setIdade(idade);//w/faz o objeto usuario receber a idade
          }
      } catch (NumberFormatException e){
          System.out.println("Digite uma idade válida!");
      }

    } while (resposta == false);

		System.out.println("\n==========================================================");

  	/////////////Info de Localização da Cidade/////////

		do{
			resposta = false;
			System.out.println("\nEm que cidade você está localizade?");
			cidade = entrada.nextLine();					
      
			if(!cidade.matches("^[A-zÀ-ú '´]+$")){
				System.out.println("Nome de cidade inválido!");
			} else if (cidade.length() < 5){
        System.out.println("O nome precisa ter pelo menos 5 letras");
      } else {
				resposta = true;      
        String[] partes = cidade.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < partes.length; i++) {
            String word = partes[i];
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            sb.append(" ").append(word);
            cidade = sb.toString().replaceFirst(" ", "");
        }
        usuario.setCidade(cidade);//w/faz o objeto usuario receber a cidade	
			}

		} while (resposta == false);        

    System.out.println("\n|Recapitulando... Seu nome é: " + usuario.getNome() + ", você tem " + usuario.getIdade() + " anos e sua cidade é " + usuario.getCidade() + "."); //usando get para receber variaveis do usuario

		usuario.MostraInfo();

		System.out.println("\n==========================================================");
    
		///////////ESPACO EM RESIDENCIA /////////////
		do{
      resposta = false;
      System.out.println("\nVocê Possui Espaço em Sua Residencia Para a Adoção/Criação de um Pet?");
      System.out.println("\n[1] - ()Sim()\n[0] - ()Não()");
      try {
          int opcao; //= -1;//variavel para armazenar resposta
          opcao = Integer.parseInt(entrada.nextLine());

          if (opcao == 1) {
              espacoSuficiente = true;
              resposta = true;
          } else if (opcao == 0) {
              espacoSuficiente = false;
              resposta = true;
          } else {
            System.out.println("Opção inválida, por favor, digite novamente!");
          }
      } catch (NumberFormatException e){
          //resposta = false;
          System.out.println("Opção inválida, por favor, digite novamente!");
        } 

    }while(resposta == false);  

		System.out.println("\n==========================================================");

		 /////////////CONDICAO FINANCEIRA/////////////
		do{
        resposta = false;
        System.out.println("\nVocê possui condição financeira para cuidar do pet?");
        System.out.println("\n[1] - ()Sim()\n[0] - ()Não()");
        try {
            int opcao = -1;//variavel para armazenar resposta
            opcao = Integer.parseInt(entrada.nextLine());

            if (opcao == 1) {
                condicaoFinanceira = true;
                resposta = true;
            } else if (opcao == 0) {
                condicaoFinanceira = false;
                resposta = true;
            } else {
                resposta = false;
                System.out.println("Opção inválida, por favor, digite novamente!");
            }
        } catch (NumberFormatException e){
            resposta = false;
            System.out.println("Opção inválida, por favor, digite novamente!");
        }

    } while(resposta == false);

		System.out.println("\n==========================================================");
		
		/////////////TEMPO DISPONIVEL/////////////
		
		do{
      resposta = false;
      System.out.println("\nVocê Possui Tempo disponivel para cuidar de um pet?");
      System.out.println("\n[1] - ()Sim()\n[0] - ()Não()");
      try {

          int opcao = -1;//variavel para armazenar resposta
          opcao = Integer.parseInt(entrada.nextLine());

          if (opcao == 1) {
              tempoDisponivel = true;
              resposta = true;
          } else if (opcao == 0) {
              tempoDisponivel = false;
              resposta = true;
          } else {
              resposta = false;
              System.out.println("Opção inválida, por favor, digite novamente!");
          }
      } catch (NumberFormatException e){
          resposta = false;
          System.out.println("Opção inválida, por favor, digite novamente!");
      }

    }while(resposta == false);

		System.out.println("\n==========================================================");

		/////////////TIPO DE ANIMAL /////////////

		do{			
			resposta = false;
			System.out.println("\nEm Qual Tipo de Pet Você Se Interessa ?");
			System.out.println("\n[1] - Gato\n[2] - Cachorro");
      try {
			int opcao = Integer.parseInt(entrada.nextLine());			
			
			if(opcao == 1){
				ehGato = true;
				resposta = true;
			}
			else if(opcao == 2){
				ehGato = false;
				resposta = true;
			}else{
				resposta = false;
        System.out.println("Opção inválida, por favor, digite novamente!");
			}		
      } catch (NumberFormatException e){
          resposta = false;
          System.out.println("Opção inválida, por favor, digite novamente!");
      }

		}while(resposta == false);

		System.out.println("\n==========================================================");


		///###GENERO DO ANIMAL###
		do{
      resposta = false;
      System.out.println("\nQual o gênero do pet?");
      System.out.println("\n[1] - Femea\n[2] - Macho");
      try {
          //int opcao = -1;//variavel para armazenar resposta
          int opcao = Integer.parseInt(entrada.nextLine());

          if (opcao == 1) {
              ehFemea = true;
              resposta = true;
          } else if (opcao == 2) {
              ehFemea = false;
              resposta = true;
          } else {
              resposta = false;
              System.out.println("Opção inválida, por favor, digite novamente!");
          }
      } catch (NumberFormatException e){
          resposta = false;
          System.out.println("Opção inválida, por favor, digite novamente!");
      }

    } while(resposta == false);

		System.out.println("\n==========================================================");
			
    /////////////FINALIZAÇÃO DO PROGRAMA/////////////   
        
      if (espacoSuficiente == false && condicaoFinanceira == false && tempoDisponivel == false){
        System.out.println("\n|{Poxa que pena, Para o Conforto do Pet, é Essencial Possuir Espaço suficiente}|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Nós Vimos Aqui no Programa Que Você Não Tem Condições Financeiras o Suficiente e Sentimos Muito, mas para Cuidar Bem de Um Pet e Preciso Ter as Contas Equilibradas|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Ter um Tempinho é Muito Importante para Dar Uma Atenção para Pet e Por Isso Não vai Ser Possivel Adotar um Pet Agora..}|");
        System.out.println
        ("\n==========================================================");
         
      } else if (condicaoFinanceira == false && espacoSuficiente == false){
      	System.out.println("\n|{Nós Vimos Aqui no Programa Que Você Não Tem Condições Financeiras o Suficiente e Sentimos Muito, mas para Cuidar Bem de Um Pet e Preciso Ter as Contas Equilibradas|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Poxa que pena, Para o Conforto do Pet, é Essencial Possuir Espaço suficiente}|");
        System.out.println
        ("\n==========================================================");

       /////////////POSSIBILIDADES DE FINALIZAÇÃO DO PROGRAMA/////////////
      } else if (tempoDisponivel == false && condicaoFinanceira == false){
        System.out.println("\n|{Ter um Tempinho é Muito Importante para Dar Uma Atenção para Pet e Por Isso Não vai Ser Possivel Adotar um Pet Agora..}|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Nós Vimos Aqui no Programa Que Você Não Tem Condições Financeiras o Suficiente e Sentimos Muito, mas para Cuidar Bem de Um Pet e Preciso Ter as Contas Equilibradas|");
        System.out.println("\n==========================================================");
        }else if (tempoDisponivel == false && espacoSuficiente == false){
        System.out.println("\n|{Ter um Tempinho é Muito Importante para Dar Uma Atenção para Pet e Por Isso Não vai Ser Possivel Adotar um Pet Agora..}|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Poxa que pena, Para o Conforto do Pet, é Essencial Possuir Espaço suficiente}|");
        System.out.println
        ("\n==========================================================");

        }else if (tempoDisponivel == false){
        System.out.println("\n|{Ter um Tempinho é Muito Importante para Dar Uma Atenção para Pet e Por Isso Não vai Ser Possivel Adotar um Pet Agora..}|");
        System.out.println
        ("\n==========================================================");

        }else if (condicaoFinanceira == false){
      	System.out.println("\n|{Nós Vimos Aqui no Programa Que Você Não Tem Condições Financeiras o Suficiente e Sentimos Muito, mas para Cuidar Bem de Um Pet e Preciso Ter as Contas Equilibradas|");
        System.out.println
        ("\n==========================================================");

        }else if (espacoSuficiente == false){
        System.out.println("\n|{Poxa que pena, Para o Conforto do Pet, é Essencial Possuir Espaço suficiente}|");
        System.out.println
        ("\n==========================================================");
        
        } else {
           
        if(ehGato && ehFemea){
          System.out.println("\nRecapitulando... Você selecionou uma gatinha!");
        }
        if(ehGato && !ehFemea){
          System.out.println("\nRecapitulando... Você selecionou um gatinho!");
        }
        if(!ehGato && ehFemea){
          System.out.println("\nRecapitulando... Você selecionou uma cachorrinha!");
        }
        if(!ehGato && !ehFemea){
          System.out.println("\nRecapitulando... Você selecionou um cachorrinho!");
        }

        System.out.println("\n==========================================================");

        System.out.println("\n|{Sucesso! Deu Tudo Certo!}|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n{|Estamos Muito Felizes Por Sua Escolha e Sua Linda Atitude}|");
        System.out.println
        ("\n==========================================================");
        System.out.println("\n|{Criamos Esse Programa para Servir de Ponte Justamente\n pra Conseguir Te Direcionar a ONG's que Conseguem Ajudar\n                     |{na Causa}|");
        System.out.println
        ("\n==========================================================");
      }
        

		entrada.close();
	}//end static void main

}//end Main


    
     

  





