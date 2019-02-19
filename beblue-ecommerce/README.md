Para rodar a aplicação, basta, baixar, abrir em sua IDE de preferência e dar um play, cargas e configurações não precisam ser feitas.
Outra opção é baixar, executar o mvn clean package e rodar o jar gerado com o comando java -jar normalmente.

Assim que baixarem a aplicação e subirem, podem acessar os endPoints a partir da pagina abaixo, para tal documentação utilizei a api do swagger.
http://localhost:8080/swagger-ui.html

Caso, queiram acessar o banco de dados para ver os resultados, eu utilizei o squirrel, mas fica a preferência de cada um,
só vale ressaltar que õ banco está em memory.
O link abaixo para fazer download da IDE squirrel (caso queiram):
https://sourceforge.net/projects/squirrel-sql/

As cargas de teste estão automaticas, e são executados assim que a aplicação termina de subir, caso queiram conferir estão na classe:
br.com.beblue.ecommerce.config.ApplicationStartUp

Sobre a integração com spotfy, criei uma aplicação la na API do spotify, conforme pedem na documentação,
pelo meu login com o nome da beblue com os client_id e secret_id que estão configuraveis no arquivo srs/main/resources/credenciais.properties.
Se quiserem alterar, é só alterar esse arquivo que tem que continuar funcionando.

Abaixo um modelo json já pronto que utilizei para realizar meus testes.
{
  "cliente": {
    "cpf": "12345678910",
    "nome": "Raphael Vidal Bernoldi"
  },
  "discos": [
    {
    "idDisco": 151,
    "nomeArtista": "Jay Rock",
    "nomeAlbum": "Redemption",
    "genero": "ROCK",
    "totalMusicas": 14,
    "valorDisco": 19
  },
  {
    "idDisco": 152,
    "nomeArtista": "PnB Rock",
    "nomeAlbum": "Catch These Vibes",
    "genero": "ROCK",
    "totalMusicas": 18,
    "valorDisco": 19
  }
  ]
}



