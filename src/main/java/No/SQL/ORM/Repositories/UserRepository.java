package No.SQL.ORM.Repositories;

import No.SQL.ORM.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {


}
