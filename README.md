# Desafio Dio Rest 2023 Java API

RESTful API construída em Java 17 com Spring Boot 3.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 - **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## [Link do Figma](https://www.figma.com/community/file/1100826294536456295/weather-app-ui-design)

O Figma foi utilizado para a abstração do domínio desta API, sendo útil na análise e projeto da solução.

Creditos do Figma - [aksonvady](https://www.figma.com/@aksonvady) 

## Diagrama de Classes (Domínio da API)

```mermaid

classDiagram
    class City {
        - String cityName
        - String coutry
        - int temperature
        - String status
        - int high
        - int low
        - List<HourlyForecast> hourlyForecast
    }

    class HourlyForecast {
        - int hour
        - String status
        - int temperature
    }

    City "1" -- "0..*" HourlyForecast : has

```

## Documentação da API (Swagger)

### [Teste a API](https://desafio-dio-rest-production.up.railway.app/swagger-ui/index.html#/)

A API estará disponível por tempo limitado pelo Railway. 


## Autor

- [@kayandesouza](https://github.com/KayandeSouzaPereira) Desenvolvedor da API