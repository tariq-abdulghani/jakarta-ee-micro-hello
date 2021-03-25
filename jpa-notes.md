
#JPA 
 
## Entity
>mapped to a data base table.

```java
@Entity
@Table(name = "TODO") // table name
public class Todo {

    @Id // we must provide an Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
}
```
#### GenerationType:
Enum Constant and Description

**AUTO** : Indicates that the persistence provider should pick an appropriate strategy for the particular database.

**IDENTITY**: Indicates that the persistence provider must assign primary keys for the entity using a database identity column.

**SEQUENCE** : Indicates that the persistence provider must assign primary keys for the entity using a database sequence.

**TABLE** : Indicates that the persistence provider must assign primary keys for the entity using an underlying database table to ensure uniqueness.

