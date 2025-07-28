# Usa a imagem do OpenJDK 17 como base
FROM openjdk:26-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos binários/compilados do seu projeto para o diretório de trabalho
COPY ./target/*.jar /app/api.jar

# Expõe a porta em que sua aplicação irá rodar (ajuste conforme necessário)
EXPOSE 8080

# Aguarda 40 segundos e inicia a aplicação
CMD ["sh", "-c", "sleep 40 && java -jar api.jar"]
