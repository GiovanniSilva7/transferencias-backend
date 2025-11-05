 Sistema de Agendamento de Transferências Financeiras - Backend

Decisões Arquiteturais

Arquitetura Hexagonal (Ports & Adapters)

O projeto foi estruturado seguindo a arquitetura hexagonal para garantir:
- **Desacoplamento**: Lógica de negócio independente de frameworks e tecnologias externas
- **Testabilidade**: Core da aplicação pode ser testado sem dependências externas
- **Manutenibilidade**: Facilita mudanças de tecnologia sem impactar o domínio

 Estrutura de Camadas:

```
src/main/java/com/transferencias/
├── domain/                          # Camada de Domínio (Core)
│   ├── model/                       # Entidades e Value Objects
│   ├── port/                        # Interfaces (Portas)
│   │   ├── in/                      # Casos de uso (entrada)
│   │   └── out/                     # Repositórios e serviços (saída)
│   └── service/                     # Lógica de negócio
├── application/                     # Camada de Aplicação
│   ├── usecase/                     # Implementação dos casos de uso
│   └── dto/                         # DTOs de transferência
├── adapter/                         # Adaptadores (Infrastructure)
│   ├── in/
│   │   └── web/                     # Controllers REST
│   └── out/
│       └── persistence/             # Implementação JPA
└── config/                          # Configurações Spring
```

### Princípios SOLID Aplicados

1. **Single Responsibility Principle (SRP)**
   - Cada classe tem uma única responsabilidade
   - `TaxaCalculatorService`: apenas calcula taxas
   - `TransferenciaService`: apenas gerencia transferências

2. **Open/Closed Principle (OCP)**
   - Sistema aberto para extensão (novas regras de taxa)
   - Fechado para modificação (core não muda)

3. **Liskov Substitution Principle (LSP)**
   - Interfaces podem ser substituídas por implementações

4. **Interface Segregation Principle (ISP)**
   - Interfaces específicas por responsabilidade

5. **Dependency Inversion Principle (DIP)**
   - Dependências apontam para abstrações (ports)
   - Framework depende do domínio, não o contrário

Clean Code

- Nomes descritivos e significativos
- Métodos pequenos e focados
- Comentários apenas quando necessário
- Tratamento de exceções customizadas
- Validações no domínio
- Testes unitários e de integração

Tecnologias Utilizadas

- **Java**: 11
- **Spring Boot**: 2.7.18 (última versão compatível com Java 11)
- **Spring Data JPA**: Persistência
- **H2 Database**: Banco em memória
- **Lombok**: Redução de boilerplate
- **MapStruct**: Mapeamento de objetos
- **JUnit 5 + Mockito**: Testes
- **Maven**: Gerenciamento de dependências
- **Swagger/OpenAPI**: Documentação da API

Pré-requisitos

- Java 11
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse ou VS Code)

 Como Executar

 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/transferencias-backend.git
cd transferencias-backend
```

 2. Compilar o projeto

```bash
mvn clean install
```

 3. Executar a aplicação

```bash
mvn spring-boot:run
```

ou

```bash
java -jar target/transferencias-api-1.0.0.jar
```

 4. Acessar a aplicação

- **API**: http://localhost:8080/api
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:transferenciasdb`
  - Username: `sa`
  - Password: *(vazio)*

- Endpoints da API

- Agendar Transferência
```http
POST /api/transferencias
Content-Type: application/json

{
  "contaOrigem": "1234567890",
  "contaDestino": "0987654321",
  "valorTransferencia": 1000.00,
  "dataTransferencia": "2025-11-10"
}
```

Listar Todas as Transferências
```http
GET /api/transferencias
```

Buscar Transferência por ID
```http
GET /api/transferencias/{id}
```

## Regras de Negócio - Cálculo de Taxa

| Dias de Antecedência | Taxa Fixa (R$) | Taxa Percentual |
|---------------------|----------------|-----------------|
| 0 (mesmo dia)       | 3,00           | 2,5%            |
| 1 a 10             | 12,00          | 0%              |
| 11 a 20            | 0,00           | 8,2%            |
| 21 a 30            | 0,00           | 6,9%            |
| 31 a 40            | 0,00           | 4,7%            |
| 41 a 50            | 0,00           | 1,7%            |
| Acima de 50        | **Não permitido** | -           |

**Taxa Total = Taxa Fixa + (Valor × Taxa Percentual)**

Testes

```bash
# Todos os testes
mvn test

# Com cobertura
mvn test jacoco:report
```
