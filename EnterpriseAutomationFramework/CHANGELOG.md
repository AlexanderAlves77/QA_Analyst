# Changelog

Todas as mudanças importantes do Enterprise Automation Framework serão documentadas neste arquivo.

Este projeto segue os princípios do **Keep a Changelog** e do **Semantic Versioning**.

---

## [0.1.0] - Em desenvolvimento

### Added

- Estrutura inicial da Solution
- Organização da arquitetura em camadas
- Projeto Core
- Primeiras abstrações
- FrameworkException
- Result Pattern
- README inicial

- Configuration Engine inicial
- FrameworkSettings
- IConfigurationProvider
- JsonConfigurationProvider
- validação de configurações
- testes unitários do mecanismo de configuração

- Structured Logging infrastructure
- ILoggingService
- LogLevel
- LoggingSettings
- Serilog integration
- Console logging
- JSON file logging
- Logging settings validation
- Logging unit tests

- Dependency Injection infrastructure
- IServiceCollection-based service registration
- Configuration service registration
- Logging service registration
- Infrastructure composition extensions
- Dependency resolution tests
- Singleton lifetime validation

- Multi-environment configuration support
- Development environment settings
- QA environment settings
- Homolog environment settings
- Production environment settings
- EAF_ENVIRONMENT selection
- Environment-aware Configuration Builder
- Environment Variable overrides
- Configuration precedence tests
- Local configuration protection

- Framework Bootstrap
- EAF Bootstrap Context
- Centralized infrastructure initialization
- Service Provider validation
- Shared Configuration instance
- Bootstrap integration tests
- Startup validation foundation
- Fail Fast initialization strategy

- Browser core abstractions
- Browser factory abstraction
- Browser provider abstraction
- Navigation abstraction
- Element finder abstraction
- Web element wrapper abstraction
- Browser type definitions
- Locator type definitions
- Browser information model
- Element locator model
- Browser core tests

- Browser Settings
- Browser Settings validation
- Environment-specific Browser configuration
- Selenium WebDriver infrastructure
- Selenium WebDriver Factory
- Browser Options Factory
- Chrome browser options
- Edge browser options
- Firefox browser options
- Dependency Injection registration for Web infrastructure
- Browser configuration tests

- Selenium Browser implementation
- Selenium Browser Factory
- Browser Provider implementation
- Selenium navigation adapter
- Selenium element finder
- Selenium web element wrapper
- Selenium locator mapper
- Scoped browser lifecycle
- Selenium browser DI registrations
- Selenium infrastructure tests


### Changed

- Organização dos projetos utilizando CLI do .NET
- Padronização da estrutura do repositório

### Documentation

- Início da série QA Engineering na Prática

