# Enterprise Automation Framework (EAF)

> Framework Open Source para Automação de Testes desenvolvido em **C#** e **.NET 8**, construído passo a passo utilizando princípios de Engenharia de Software, Clean Architecture, SOLID e Design Patterns.

## 🎯 Objetivo

O Enterprise Automation Framework nasceu para demonstrar, de forma prática, como construir um Framework corporativo de automação de testes desde sua concepção.

Mais do que apresentar código, este projeto documenta cada decisão arquitetural, cada Sprint e cada evolução realizada durante o desenvolvimento.

Todo o processo é acompanhado pela série:

📚 **QA Engineering na Prática**

Cada Sprint possui um artigo correspondente.

Cada decisão arquitetural é registrada.

Cada evolução é versionada utilizando Conventional Commits.

---

## 🏗 Filosofia do Projeto

Acreditamos que qualidade não começa quando escrevemos o primeiro teste automatizado.

Ela começa quando tomamos boas decisões de arquitetura.

Por isso, cada funcionalidade implementada neste Framework possui um propósito claramente definido e uma documentação correspondente.

---

## ⚙️ Configuration Engine

O Enterprise Automation Framework possui uma infraestrutura centralizada de configuração.

O objetivo é permitir que configurações operacionais sejam alteradas sem modificar ou recompilar o código do Framework.

A arquitetura inicial utiliza:

- configuração fortemente tipada;
- `appsettings.json`;
- abstração através de `IConfigurationProvider`;
- implementação desacoplada na camada Infrastructure;
- validação de configurações;
- preparação para múltiplos ambientes.

O suporte completo a Environment Variables, Secrets e configurações específicas por ambiente será implementado progressivamente.

---

## 📝 Structured Logging

O Enterprise Automation Framework possui uma infraestrutura centralizada de Logging.
O objetivo é permitir que eventos da execução sejam registrados de forma padronizada, estruturada e preparada para análise.

A arquitetura inicial utiliza:

- abstração através de `ILoggingService`;
- implementação utilizando Serilog;
- configuração através de `LoggingSettings`;
- saída para Console;
- saída para arquivo;
- logs estruturados em JSON;
- rotação diária de arquivos;
- validação das configurações de Logging;
- preparação para Correlation ID e observabilidade.

O Core permanece desacoplado da implementação concreta do Serilog.

---

## 💉 Dependency Injection

O Enterprise Automation Framework utiliza Dependency Injection para centralizar a criação e composição de seus serviços.
A infraestrutura inicial utiliza o container nativo do ecossistema .NET através de `IServiceCollection` e `IServiceProvider`.

A arquitetura atual inclui:

- registro centralizado de serviços;
- métodos de extensão para organização da composição;
- integração do Configuration Engine;
- integração do Logging Engine;
- resolução através de abstrações;
- controle explícito dos ciclos de vida;
- preparação para serviços de Browser, API, Database e Reporting.

Os componentes do Framework devem depender preferencialmente de abstrações em vez de criar diretamente implementações concretas.

---

## 🚀 Framework Bootstrap

O Enterprise Automation Framework possui um processo centralizado de inicialização responsável por preparar sua infraestrutura antes da execução dos testes.

O Bootstrap coordena:

1. identificação do ambiente;
2. carregamento das configurações;
3. validação das configurações críticas;
4. inicialização do Structured Logging;
5. registro das dependências;
6. construção e validação do Service Provider;
7. disponibilização da infraestrutura do Framework.

Exemplo conceitual:

`using var framework = EafBootstrapper.Initialize();`

O Bootstrap atua como ponto central de composição da infraestrutura e evita que projetos consumidores precisem conhecer os detalhes internos de inicialização.

### Fail Fast

Configurações e dependências críticas devem ser validadas durante o Startup.

O objetivo é impedir que uma execução de testes seja iniciada com o Framework em um estado inválido.

### Current Infrastructure

- Configuration Engine
- Structured Logging
- Dependency Injection
- Environment Management
- Framework Bootstrap

Essa fundação será utilizada pelas próximas infraestruturas do EAF, incluindo Browser/Selenium, APIs e Database.

---

## 🛠 Tecnologias

- .NET 8 LTS
- C#
- NUnit
- Selenium
- RestSharp
- SQL Server
- GitHub Actions (em construção)

---

## 🌎 Environment Configuration

O Enterprise Automation Framework suporta configurações específicas por ambiente sem exigir alterações no código.

Ambientes inicialmente suportados:

- Development
- QA
- Homolog
- Production

A seleção do ambiente é realizada através da variável:

`EAF_ENVIRONMENT`

Exemplo no Windows CMD:

`set EAF_ENVIRONMENT=QA`

A configuração utiliza uma estratégia de composição baseada em:

1. `appsettings.json`
2. `appsettings.{Environment}.json`
3. Environment Variables

Arquivos locais e informações sensíveis não devem ser versionados.

Secrets deverão ser fornecidos através de mecanismos seguros como Environment Variables, User Secrets ou Secret Managers utilizados pela infraestrutura de CI/CD.

---

## 📂 Estrutura da Solution

*(Será detalhada conforme novas camadas forem implementadas.)*

---

## 📈 Status

🚧 Projeto em desenvolvimento.

Construído incrementalmente através da série **QA Engineering na Prática**.


## Author

Alexander Alves

QA Automation Engineer | Quality Engineer | Java Developer
