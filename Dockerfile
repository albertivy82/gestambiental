# Usa a imagem do OpenJDK 17 como base
FROM openjdk:17

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos binários/compilados do seu projeto para o diretório de trabalho
COPY ./target/*.jar /app/api.jar

# Expõe a porta em que sua aplicação irá rodar (ajuste conforme necessário)
EXPOSE 8080

# Define o comando para iniciar sua aplicação
CMD ["java", "-jar", "api.jar"]
