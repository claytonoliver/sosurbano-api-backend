# 🚨 SOS Urbano - API Backend

Repositório oficial da API backend do projeto **SOS Urbano**, desenvolvido como **MVP** no contexto do **Desafio FIAP - Cidade Inteligente**, com foco em **Segurança Pública**.

---

## 📌 Sobre o Projeto

O **SOS Urbano** é uma solução voltada para o engajamento da população e órgãos públicos no tratamento de ocorrências urbanas relacionadas à segurança. A proposta é disponibilizar uma plataforma **web/mobile** onde os cidadãos possam **registrar chamados** (como furtos, problemas de iluminação, vandalismo etc.) e **acompanhar o andamento** diretamente com as autoridades competentes.

### ✅ Este repositório representa a **Versão 2 com Inteligência Artificial (IA)** entregue no desafio FIAP

Além das funcionalidades principais de registro e acompanhamento de ocorrências, esta versão MVP incorpora um **módulo de IA** que:

- Gera relatórios automáticos com base em dados dos chamados
- Detecta **áreas de maior risco**
- Sugere **realocação de agentes públicos** (policiais, trânsito etc.) com base em zonas críticas identificadas

> ⚠️ Este projeto é um **MVP** e não representa a versão final do sistema.

---

## 🧪 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JPA (Hibernate)**
- **Oracle Database**
- **JWT (JSON Web Token)**
- **Docker / Docker Compose**
- **IA com modelo estatístico (versão 2)**

---

## ⚙️ Como Executar

### 🔧 Opção 1: Executando Localmente

#### Pré-requisitos:
- Java 17+
- Maven
- Oracle Database (instância local ou em nuvem)
- IDE como IntelliJ ou VS Code
---a

#### Passos:

```bash
# Clone o projeto
git clone https://github.com/claytonoliver/sosurbano-api-backend.git

cd sosurbano-api-backend

# Compile o projeto
mvn clean install

# Rode o projeto
mvn spring-boot:run

```

