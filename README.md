Backend

Decisões Arquiteturais

Arquitetura MVC

Controller: recebe as requisições HTTP.

Service: centraliza as regras de negócio (ex: cálculo de taxa).

Repository: faz a persistência via JPA.

Model/Entity: representam as tabelas.

Mapper: converte entre entidades e DTOs.

SOLID / Clean Code

Cada classe tem uma única responsabilidade.

Baixo acoplamento entre camadas.

DTOs protegem a API de exposição direta do modelo de domínio.

Banco em memória (H2)
Simplifica testes e permite reiniciar o estado a cada execução.

Java 11

Spring Boot 2.7.18

Spring Web / JPA / Validation

Lombok

Banco H2 (em memória)

Arquitetura MVC e princípios SOLID

CORS configurado para acesso pelo frontend

Backend

Cadastro de transferências com:

Conta de origem e destino (10 dígitos)

Valor

Data da transferência

Data de agendamento (automática)

Cálculo automático de taxas conforme tabela:

Dias até a transferência	Taxa Fixa	Percentual (%)
0	R$ 3,00	2,5%
1 a 10	R$ 12,00	0%
11 a 20	R$ 0,00	8,2%
21 a 30	R$ 0,00	6,9%
31 a 40	R$ 0,00	4,7%
41 a 50	R$ 0,00	1,7%

Caso não haja taxa aplicável, o sistema retorna um erro.

Consulta paginada de agendamentos realizados

Backend (Spring Boot)

Pré-requisitos:

Java 11 instalado

Maven configurado (mvn -v)