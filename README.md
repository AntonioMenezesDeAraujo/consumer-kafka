# consumer-kafka

Pelo terminal entrar na pasta docker e executar o seguinte comando:

sudo docker-compose -f kafka-docker-compose.yml up -d

após executar esse comando, verifique se os containers estão up:

sudo docker container list -a
 
Se estiverem UP, acesse o seguinte endereço para visualizar o dashboard do kafka --Kafdrop
localhost:19000

Agora, só você fazer requisições no post e verificar se as mensagens chegam no tópico atráves do kafdrop
