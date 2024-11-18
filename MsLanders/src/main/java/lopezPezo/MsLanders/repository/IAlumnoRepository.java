package lopezPezo.MsLanders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lopezPezo.MsLanders.model.AlumnoModel;

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoModel, Integer>{
    
}
