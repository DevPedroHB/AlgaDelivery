# AlgaDelivery

## 📋 Índice

- [AlgaDelivery](#algadelivery)
  - [📋 Índice](#-índice)
  - [📖 Sobre o Projeto](#-sobre-o-projeto)
  - [✨ Funcionalidades](#-funcionalidades)
  - [🚀 Tecnologias Utilizadas](#-tecnologias-utilizadas)
  - [🏗️ Arquitetura do Projeto](#️-arquitetura-do-projeto)
  - [🏁 Como Executar](#-como-executar)
  - [📝 Licença](#-licença)

---

## 📖 Sobre o Projeto

O AlgaDelivery é um sistema de entregas que visa conectar clientes, restaurantes e entregadores de forma eficiente e segura. A plataforma foi desenvolvida utilizando uma arquitetura de microsserviços, garantindo escalabilidade, resiliência e manutenibilidade.

## ✨ Funcionalidades

- **Gestão de Pedidos:** Clientes podem realizar pedidos, acompanhar o status e avaliar o serviço.
- **Gestão de Entregadores:** Entregadores podem aceitar entregas, visualizar rotas e receber pagamentos.
- **Comunicação em Tempo Real:** A plataforma oferece comunicação em tempo real entre as partes envolvidas no processo de entrega.

## 🚀 Tecnologias Utilizadas

- **Java 21:** Linguagem de programação principal.
- **Spring Boot:** Framework para criação de microsserviços.
- **Spring Cloud:** Ferramentas para desenvolvimento de aplicações em nuvem.
- **Docker:** Conteinerização dos microsserviços.
- **Kafka:** Plataforma de streaming para comunicação assíncrona.
- **PostgreSQL:** Banco de dados relacional.

## 🏗️ Arquitetura do Projeto

O projeto foi desenvolvido utilizando uma arquitetura de microsserviços, onde cada serviço é responsável por uma parte específica do negócio. A comunicação entre os serviços é feita de forma assíncrona utilizando o Kafka, garantindo desacoplamento e resiliência.

- **Gateway:** Ponto de entrada para todas as requisições externas.
- **Service Registry:** Registro e descoberta de serviços.
- **Courier Management:** Gerenciamento de entregadores.
- **Delivery Tracking:** Rastreamento de entregas.

## 🏁 Como Executar

Para executar o projeto, é necessário ter o Docker e o Docker Compose instalados.

1. Clone o repositório: `git clone https://github.com/DevPedroHB/algadelivery.git`
2. Navegue até a pasta do projeto: `cd algadelivery`
3. Execute o comando: `docker-compose up -d`

Após a execução, os serviços estarão disponíveis nos seguintes endereços:

- **Gateway:** <http://localhost:8080>
- **Service Registry:** <http://localhost:8761>

## 📝 Licença

Este projeto está licenciado sob a licença do [MIT](https://choosealicense.com/licenses/mit).

---

Feito com ❤️ por Pedro Henrique Bérgamo 🚀 [Never stop learning!](https://github.com/DevPedroHB)
