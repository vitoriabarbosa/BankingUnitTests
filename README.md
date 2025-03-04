# 🏦 BankingUnitTests - Cobertura de Testes de um Sistema Bancário Simplificado  🚀

## 📌 Sobre o Projeto
Este projeto tem como objetivo avaliar e melhorar a cobertura de testes de um sistema bancário simplificado, utilizando a ferramenta JaCoCo para análise de cobertura de código. O trabalho foi desenvolvido no contexto da disciplina **Engenharia de Qualidade de Software 1** do curso de **Engenharia de Software Comercial**.

---
## 💻 Tecnologias Utilizadas
- **☕ Linguagem:** Java (versão >= 1.8)
- **⚙️ Gerenciador de Dependências:** Maven
- **🧪 Ferramenta de Cobertura de Testes:** JaCoCo

## 🔗 Repositório Utilizado
Para a atividade, foi utilizado o repositório [BankingUnitTests](https://github.com/vasouv/BankingUnitTests/tree/master), que implementa operações bancárias básicas:

- **💰 Classes principais:**
  - `Account`: Conta bancária comum.
  - `LimitedAccount`: Conta bancária com limite.
  - `ATM`: Controlador de transações (depósitos, saques e transferências).
  - `InsufficientFundsException`: Exceção para saldo insuficiente.

- **🧪 Testes unitários:**
  - `ATMTest.java`: Cobre cenários de depósito e saque.

---
## 🔎 Análise Inicial do Código
Antes da aplicação da ferramenta JaCoCo, foram identificadas as seguintes questões:

### ✅ Cobertura de Testes Existente
- Testes para depósitos e saques estão presentes no `ATMTest`.
- Algumas transferências entre contas estão parcialmente cobertas.

### ⚠️ Lacunas Identificadas
- Transferências com `LimitedAccount` como fonte ou destino não foram completamente testadas.
- Testes para valores negativos em depósitos e saques estão ausentes.
- O arquivo `Main.java` não possui cobertura de teste.


### 💡 Identificação de Vulnerabilidades
Para garantir maior segurança, seguimos as boas práticas:
- Revisão manual do código para tratamento correto de exceções.
- Uso de mensagens de erro diferenciadas para facilitar depuração.
- Verificação de dependências utilizando bases públicas de vulnerabilidades.

---
## 🤔 Escolha da Ferramenta de Cobertura

### ✨ Por que o JaCoCo?
- **Ampla adoção:** Ferramenta popular na comunidade Java.
- **Integração facilitada:** Plugin nativo para Maven.
- **Custo zero:** Open-source.
- **Relatórios detalhados:** Disponíveis em HTML e XML.

### ⚡ Comparando com Outras Ferramentas
- **Cobertura:** Menos eficaz para testes baseados em branches.
- **PIT Mutation Testing:** Excelente para testes de mutação, mas com tempo de execução maior.
- **Emma:** Ferramenta desatualizada, sem suporte ativo.<br><br>

## ⚙️ Instalação e Configuração do JaCoCo
Para configurar o JaCoCo, adicione o seguinte trecho ao `pom.xml`:

```xml
  <build>
    <plugins>
      <!-- Plugin JaCoCo para geração de relatórios de cobertura de código -->
      <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
        <executions>
          <execution>
            <id>prepare-agent</id>
            <goals>
              <goal>prepare-agent</goal>
            </goals>
          </execution>
          <execution>
            <id>report</id>
            <phase>verify</phase>
            <goals>
              <goal>report</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```

## 🚀 Executando os Testes com JaCoCo
1. Compile o projeto:
   ```sh
   mvn clean install
   ```
2. Execute os testes:
   ```sh
   mvn test
   ```
3. Gere o relatório de cobertura:
   ```sh
   mvn jacoco:report
   ```
4. O relatório estará disponível em:
   ```sh
   target/site/jacoco/index.html
   ```
---
## 🛠 Melhoria da Cobertura de Testes
[a implementar]

---
## 📊 Resultados Obtidos
- **Cobertura inicial:** ~60%
- **Cobertura após melhorias:** [a fazer]
- **Impacto:** [a fazer]

## 🎯 Conclusão
[a implementar]

---
## 👨‍💻 Equipe
- André Hugo
- Breno Carvalho
- Fabiola Santos
- João de Sousa
- Vitória Barbosa