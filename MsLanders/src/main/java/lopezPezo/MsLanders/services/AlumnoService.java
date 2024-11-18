package lopezPezo.MsLanders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.repository.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService {
    @Autowired
    IAlumnoRepository repository;

    @Override
    public List<AlumnoModel> findAllStudent() {
        return (List<AlumnoModel>)repository.findAll();
    }

    @Override
    public AlumnoModel findByIdStudent(Integer id) {
        return (AlumnoModel)repository.findById(id).get();
    }

    @Override
    public AlumnoModel addStudent(AlumnoModel model) {
        return repository.save(model);
    }

    @Override
    public AlumnoModel updateStudent(AlumnoModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
