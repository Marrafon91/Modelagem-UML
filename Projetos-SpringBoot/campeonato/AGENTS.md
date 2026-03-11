# AGENTS.md - Campeonato Spring Boot Project

## Architecture Overview

This is a **Spring Boot 4.0.3 REST API** for managing sports championships (Campeonato). The application uses **JPA/Hibernate** with **H2 in-memory database** for development/testing.

### Core Domain Model
- **Campeonato**: Championship events (year + name)
- **TimeJogadores**: Team/roster with players
- **Jogador**: Individual players with position, birth date, height, shirt number
- **Partida**: Match events linking teams, stadiums, scores
- **Estadio**: Stadium with address
- **Endereco**: Address (street, number, neighborhood, city, state)

**Key Relationships**:
- Partida → Campeonato (many-to-one)
- Jogador → TimeJogadores (many-to-one)
- Jogador ↔ Partida (many-to-many via `jogador_partida`)
- Estadio ↔ Endereco (one-to-one)

## Development Workflow

### Build & Run
```bash
mvn clean package              # Build JAR with embedded test data
java -jar target/campeonato-0.0.1-SNAPSHOT.jar  # Run with H2 console at http://localhost:8080/h2-console
```

### Test Data
- Auto-loaded from `src/main/resources/import.sql` (H2 schema created with `ddl-auto: create-drop`)
- Includes 2 stadiums, 1 championship, 4 teams, 4 players, 2 matches
- Reset on every application restart

### Key Development Endpoints
- `GET /endereco` - List all addresses
- `GET /endereco/cidade/{cidade}` - Search by city (case-insensitive, partial match)
- `GET /endereco/bairro/{bairro}` - Search by neighborhood
- `GET /endereco/logradouro/{logradouro}` - Search by street name

## Code Patterns & Conventions

### Layered Architecture (3-tier)
```
Controller (REST endpoints)
    ↓ @Autowired EnderecoService
Service (business logic, @Transactional)
    ↓ @Autowired EnderecoRepository
Repository (JpaRepository, custom @Query methods)
    ↓ JPA
Entity (JPA @Entity with @Table annotation)
```

### Entity Patterns
- **ID**: Always `@GeneratedValue(strategy = GenerationType.IDENTITY)` (auto-increment)
- **Validation**: Use Jakarta constraints (`@NotBlank`, `@Size`, `@NotNull`) on DTOs, not entities
- **Relationships**: Always use `@ManyToOne`, `@OneToMany(cascade=CascadeType.ALL)`, `@ManyToMany`
- **Table Naming**: Entities use `@Table(name = "tb_entityname")` prefix convention

### DTO Pattern
- **Record-based**: Use Java records for immutable DTOs (see `EnderecoDTO`)
- **Constructor Pattern**: Each DTO has `DTO(Entity entity)` constructor for conversion
- **Validation**: Put Jakarta validation annotations on DTO fields, not entities
- **Stream Conversion**: Services convert entities to DTOs via `.stream().map(DTO::new).toList()`

### Service Layer Conventions
- Mark all read operations with `@Transactional(readOnly = true)`
- Inject repositories via `@Autowired`
- Services never return entities directly - always convert to DTOs
- Custom query methods in repositories are preferred over Service-level filtering

### Repository Patterns
- Extend `JpaRepository<Entity, Long>`
- Custom finder methods use `@Query` with JPQL and `@Param` annotations
- Query notes: H2 doesn't support `unnacent()` function (PostgreSQL-specific) - use `LOWER(CONCAT('%', :param, '%'))` for case-insensitive partial matches

## Critical Notes for AI Agents

1. **Java Version**: Project uses Java 25 - use modern syntax (records, var, sealed classes where appropriate)
2. **Package Structure**: Strict convention: `io.github.com.campeonato.*` (entities, dtos, services, controllers, repositories)
3. **Profile-Based Config**: Only "test" profile is active - H2 in-memory database with auto-schema creation
4. **No XML/Serialization**: Uses JSON via Spring MVC (implicit HttpMessageConverter)
5. **Foreign Key Constraints**: H2 is lenient; verify referential integrity when adding new endpoints
6. **Transaction Management**: Spring manages transactions; readOnly queries are optimized by Hibernate
7. **No Exception Handling Layer**: Controllers return raw responses - consider adding global error handler if expanding

## Testing
```bash
mvn test  # Runs CampeonatoApplicationTests
```

## When Adding New Features
1. Create Entity with `@Entity @Table(name = "tb_entityname")`
2. Create Repository extending `JpaRepository`
3. Create DTO record with validation annotations
4. Create Service with `@Transactional(readOnly=true)` query methods
5. Create Controller with `@RestController @RequestMapping("/endpoint")`
6. Add test data to `import.sql` if needed
7. Update this document if adding new patterns or conventions

