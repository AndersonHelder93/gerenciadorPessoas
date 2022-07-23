# People Management

- API de Gerenciamento de Cadastro de Pessoas e Endereços 

<img src="https://images.genial.ly/genially/layouts/f898cb55-5ea4-4bd6-a966-cae379c2b895.gif?5eb353286780410d5780fc6d&1637712000063" alt="loading" width="250px"/>

- Ferramentas utilizadas:

      Java 11;
      Springboot 2.7.1;
         
         
- Instruções de Instalação e uso:
      Baixe o código do repositório;
      
      Importe o código na IDE que você preferir , de preferência o eclipse;
      
      Execute a API a partir do arquivo (GerenciarPessoasApplication.java), clicando com o botão direito
      e selecionando a opção run application, ou da forma que você se adequar na sua IDE;
      
      A API pode ser testada de 2 formas:  
      pelo navegador com o endpoint: http://localhost:8080/swagger-ui/index.html;
    
  pelo programa postman: https://www.postman.com/downloads/
          
 - Testando pelo postman:
      
        O fluxo de teste da aplicação será da seguinte forma respectivamente:
          cadastrar a pessoa;
          cadastrar o endereço;
	      cadastrar o endereço principal em uma pessoa previamente cadastrada;   
	      listar pessoas, endereços, pessoas com seus endereços cadastrados e com o endereço principal;
       OBS: Cada etapa do fluxo terá um endpoint especifico para executar de forma isolada em cada processo de execução.
       
       Abra o programa, crie uma nova guia e insira o seguinte endpoint para cadastrar uma pessoa:
          localhost:8080/api/pessoa
	      selecione os campos body -> raw -> tipo: JSON
	      insira a seguinte collection: 
		      {
   			    "nome":"Estudante" ,
   			    "dataNascimento":"20/07/2022"
		      }
          selecione o verbo http POST e por último clique em send, o resultado do status será 200 OK e o body 
	       retornará os dados cadastrados, o campo id com o valor preenchido e enderecoPrincipal null, pois 
	       será inserido nos passos posteriores.
       OBS: pode inserir o nome e a data de sua preferência, desde que seja do mesmo tipo.
       
       Crie uma nova guia e insira o seguinte endpoint para cadastrar um endereço:
	        localhost:8080/api/endereco
	        selecione os campos body -> raw -> tipo: JSON;
	        insira as seguinte collection:
		      {
    			  "logradouro":"rua do teste",
    			  "cep":"58888888",
    		  	  "numero":"10",
    			  "cidade":"Cidateste",
    			  "pessoa_id":1  
		      };
	        selecione o verbo http POST e por último clique em send, o resultado do status será 200 OK e o body 
	          retornará os dados cadastrados com o campo id com o valor preenchido, observe que o campo "pessoa_id"
	          está com o mesmo valor do id do array anterior, fazendo assim a associação do endereço com a pessoa
	          anteriormente cadastrada, caso esse valor não seja preenchido, o endereço não será associado a pessoa.
        OBS: Pode inserir o logradouro, cep, número e os demais campos de sua preferencia, desde que seja do mesmo tipo;
           Pode inserir quantos endereços você preferir.

        Crie uma nova guia e insira o seguinte endpoint para listar um endereço associado a pessoa cadastrada:
	        localhost:8080/api/pessoaenderecos/1 => esse valor "1" no final do endpoint é o id da pessoa cadastrada
	          podendo ser mudado para outros valores de outras pessoas cadastradas.
	        selecione o verbo http GET e por último clique em send, o resultado do status será 200 OK e o body 
	          retornará os endereços cadastrados da pessoa.
	
        Crie uma nova guia e insira o seguinte endpoint para inserir um endereço principal para a pessoa cadastrada:
	        localhost:8080/api/enderecoprincipal;
	        insira as seguinte collection: 
		      {
   			    "endereco_id": 3,
  			    "pessoa_id": 2
		      };
	        selecione o verbo http PUT e por último clique em send, o resultado do status será 200 OK e o body 
	          retornará o endereço principal associado a pessoa cadastrada.

       Crie uma nova guia e insira o seguinte endpoint para editar uma pessoa cadastrada:
	      localhost:8080/api/pessoa/1
	      insira as seguinte collection:
		      {
    			  "nome":"Aluno10"
		      }
	      selecione o verbo http PUT e por último clique em send, o resultado do status será 200 OK e o body 
	        retornará o array da pessoa com o nome atualizado.

- Testando pelo swagger:

	  É um método mais simples e intuitivo, basta apenas:
      
            selecionar os campos de inserir, editar e buscar;
          
            seguindo o mesmo fluxo de teste no postmam, clicando no verbo http;
         
            preencher os dados seguindo o modelo do array que ele irá sugerir;
          
            clicar tryout e depois alterando os campos e por último clicando em
            execute, e o resultado será exibido abaixo com seus respectivos status.
       
       
        
      
     
      
        
    



