# Sistema de Gerenciamento de Biblioteca (Trabalho Lab. BD)

Este projeto é uma aplicação completa (CRUD) para gerenciamento de uma biblioteca.

## 📁 Estrutura do Projeto
- `db/`: Contém o script `schema.sql` para criação do banco de dados MySQL.
- `src/`: Código-fonte Java (Model, DAO, View, Util).
- `docs/`: Documentação técnica (DER, Diagrama de Classes).
- `lib/`: (Adicionar manualmente) Driver JDBC do MySQL (`mysql-connector-j-x.x.x.jar`).

## 🚀 Como Executar
1. **Banco de Dados**:
   - Execute o script em `db/schema.sql` no seu MySQL (ex: via MySQL Workbench ou XAMPP).
2. **Configuração Java**:
   - Abra o projeto na sua IDE favorita (Eclipse, IntelliJ ou VS Code).
   - Adicione o Driver JDBC do MySQL ao Classpath do projeto.
   - Verifique as credenciais (usuário e senha) no arquivo `src/util/ConnectionFactory.java`.
3. **Execução**:
   - Execute a classe `view.MainView` para iniciar a interface gráfica.

## 🛠️ Tecnologias Utilizadas
- **Banco de Dados**: MySQL
- **Linguagem**: Java
- **Persistência**: JDBC
- **Interface**: Java Swing
- **Diagramas**: Mermaid / D2
