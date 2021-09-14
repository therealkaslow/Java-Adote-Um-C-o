public class Usuario{
	
 /*
 ao iniciar o main criar um novo objeto usuario para 
 armazenar informacoes
 */
	String nome = "";
	int idade = 0;
	String cidade = "";

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getCidade(){
		return cidade;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public int getIdade(){
		return idade;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public void MostraInfo(){
		System.out.println("|Nome: " + nome);
		System.out.println("|Idade: " + idade);
		System.out.println("|Cidade: " + cidade);
	}

}