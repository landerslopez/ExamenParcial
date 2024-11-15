package lopezPezo.MsLanders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lopezPezo.MsLanders.model.AlumnoModel;

@Repository
public interface IAlumnoRepository extends CrudRepository<AlumnoModel, Integer>{
    
}
