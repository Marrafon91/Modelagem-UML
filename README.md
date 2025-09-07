# 📘 Curso de UML – Diagrama de Classes com Java + Spring Boot

Neste repositório, você encontrará materiais de suporte e projeto de estudo de caso baseados no curso **"Modelagem de Dados UML (Análise & Projeto Orientado a Objetos)"**, do professor **Nelio Alves** na Udemy.  

🔗 Link do curso: [UML - Diagrama de Classes](https://www.udemy.com/course/uml-diagrama-de-classes/?kw=uml&src=sac&couponCode=KEEPLEARNINGBR)

---

## 🎯 Sobre o Curso

- **Instrutor**: Nelio Alves  
- **Objetivo**: aprender a modelar sistemas orientados a objetos com UML, especialmente usando o **Diagrama de Classes**, e implementar o modelo em **Java + Spring Boot** seguindo boas práticas.  
- **Conteúdo-chave**:
  - Classes, atributos e associações
  - Multiplicidades, enumerações e tipos primitivos
  - Agregação, composição e herança
  - Classes-associação e modelagem de relacionamentos
  - Estudo de caso completo em **Java + Spring Boot + JPA/Hibernate**
- **Carga Horária**: ~13 horas de conteúdo prático  
- **Última atualização**: Julho de 2024  

---

## 🏗️ Ideia Geral do Projeto

Este repositório replica e adapta o estudo de caso proposto no curso:

1. **Modelagem UML** — criação de diagramas de classes em ferramentas como *draw.io* ou *StarUML*.  
2. **Implementação em Java com Spring Boot** — conversão da modelagem para código, com entidades, repositórios e controllers.  
3. **API RESTful** — exposição dos dados em formato JSON.  
4. **Boas práticas de OO** — código limpo, coeso, encapsulado e organizado em camadas.  

---

## 📂 Estrutura do Repositório

```text
├── README.md
├── diagramas/
│   ├── diagrama-classe.png
│   └── modelo-conceitual.drawio
├── src/
│   ├── main/
│   │   ├── java/com/seudominio/
│   │   │   ├── controllers/
│   │   │   ├── models/
│   │   │   ├── repositories/
│   │   │   └── Application.java
│   │   └── resources/application.properties
│   └── test/
├── pom.xml (ou build.gradle)
└── docs/
    └── glosario.md
