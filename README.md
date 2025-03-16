# PoGpt - Sistema de Gestão de Clientes, Vendedores e Faturas

## 📌 Descrição

PoGpt é um sistema desenvolvido em **Spring Boot** para gerenciar clientes, vendedores e faturas. Ele permite operações como cadastro, atualização, listagem e exclusão de registros, garantindo eficiência e organização na gestão de dados.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

## 🏗 Estrutura do Projeto

```
PoGpt/
│── src/main/java/PoGpt/Gpt/
│   ├── controller/    # Controllers da aplicação
│   ├── model/         # Modelos de dados (Entidades JPA)
│   ├── repository/    # Interfaces de acesso ao banco de dados
│   ├── service/       # Lógica de negócios
│── src/main/resources/
│   ├── application.properties  # Configurações do banco de dados
│── pom.xml           # Dependências do projeto
│── README.md         # Documentação
```

## 📌 Endpoints da API

### Clientes
- `POST /clientes` → Criar cliente
- `GET /clientes` → Listar todos os clientes
- `GET /clientes/{id}` → Buscar cliente por ID
- `PUT /clientes/{id}` → Atualizar cliente
- `DELETE /clientes/{id}` → Deletar cliente

### Vendedores
- `POST /vendedores` → Criar vendedor
- `GET /vendedores` → Listar todos os vendedores
- `GET /vendedores/{id}` → Buscar vendedor por ID
- `PUT /vendedores/{id}` → Atualizar vendedor
- `DELETE /vendedores/{id}` → Deletar vendedor

### Faturas
- `POST /faturas` → Criar fatura
- `GET /faturas` → Listar todas as faturas
- `GET /faturas/{id}` → Buscar fatura por ID
- `DELETE /faturas/{id}` → Deletar fatura

---
> Projeto desenvolvido para aprimoramento de habilidades em **Spring Boot** e **PostgreSQL**.

UML do Projeto 
![Captura de tela de 2025-03-15 17-24-38](https://github.com/user-attachments/assets/8293a81f-5bf0-4c35-b105-6bd94df20644)
