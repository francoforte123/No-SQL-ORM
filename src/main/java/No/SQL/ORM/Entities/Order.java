package No.SQL.ORM.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {

    @Id
    @Field
    private String id;
    private String name;
    private int amount;
}
