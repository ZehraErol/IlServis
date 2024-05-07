package tr.zehraerol.IlServis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.zehraerol.IlServis.model.Il;

import java.util.List;
import java.util.Optional;

public interface IlRepository  extends MongoRepository<Il, String> {
 List<Il> findAllByName(String name);
 Optional<Il>findByName(String name);


}
