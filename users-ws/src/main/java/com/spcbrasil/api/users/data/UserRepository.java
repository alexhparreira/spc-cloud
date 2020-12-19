package com.spcbrasil.api.users.data;

import com.spcbrasil.api.data.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Usuario, String>, QuerydslPredicateExecutor<Usuario> {

    Usuario findByEmail(String email);
    Usuario findByUsername(String username);

    Usuario findByUsernameOrEmail(String username,String email);

    Usuario findByDocumentId(String username);

    Usuario findByEmailAndIdNot(String email,String id);
    Usuario findByUsernameAndIdNot(String username,String id);
    Usuario findByDocumentIdAndIdNot(String username,String id);


}
