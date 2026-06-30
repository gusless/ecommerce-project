# E-commerce Project

Sistema de e-commerce desenvolvido em **Java** como projeto acadêmico, utilizando os conceitos de **Programação Orientada a Objetos (POO)** e organizado em módulos para representar os principais componentes de uma loja virtual.

## Funcionalidades

- Cadastro e gerenciamento de usuários;
- Cadastro de endereços de entrega;
- Gerenciamento de categorias e produtos;
- Carrinho de compras;
- Realização de pedidos;
- Processamento de pagamentos;
- Avaliações de produtos;
- Cálculo de frete.

## Estrutura do Projeto

```
src/
└── main/
    └── java/
        └── com/lp1/project/
            ├── app/
            ├── config/
            ├── domain/
            │   ├── address/
            │   ├── cart/
            │   ├── category/
            │   ├── order/
            │   ├── payment/
            │   ├── product/
            │   ├── repository/
            │   ├── review/
            │   ├── shipping/
            │   └── user/
            └── Main.java
```

## Tecnologias Utilizadas

- Java 21
- Maven
- Gson

## Objetivo

O projeto simula o funcionamento básico de um sistema de e-commerce, permitindo que usuários realizem compras, gerenciem seus endereços, adicionem produtos ao carrinho e finalizem pedidos.

## Como Executar

### Pré-requisitos

- Java JDK 21 ou superior
- Apache Maven 3.9+ (ou compatível)

### Passos

1. Clone este repositório:

```bash
git clone https://github.com/gusless/ecommerce-project
```

2. Entre na pasta do projeto:

```bash
cd ecommerce-project
```

3. Compile o projeto:

```bash
mvn clean compile
```

4. Execute a aplicação:

```bash
mvn exec:java
```

Caso sua IDE esteja configurada com o Maven (IntelliJ IDEA, Eclipse ou VS Code), basta abrir o projeto e executar a classe:

```
com.lp1.project.Main
```
