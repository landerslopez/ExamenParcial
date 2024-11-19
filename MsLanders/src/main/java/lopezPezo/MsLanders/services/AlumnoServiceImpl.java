package lopezPezo.MsLanders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.repository.IAlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    IAlumnoRepository repository;

    @Override
    public List<AlumnoModel> findAllStudent() {
        return (List<AlumnoModel>) repository.findAll();
    }

    @Override
    public AlumnoModel findByIdStudent(Integer id) {
        return (AlumnoModel) repository.findById(id).get();
    }

    @Override
    public AlumnoModel addStudent(AlumnoModel model) {
        return repository.save(model);
    }

    @Override
    public AlumnoModel updateStudent(AlumnoModel model, int id) {
        AlumnoModel u = repository.findById((Integer) id).orElse(null);
        if (u == null) {
            throw new EntityNotFoundException("Estudiante con ID " + id + " no existe");
        }
        u.setNombre(model.getNombre());
        u.setNota(model.getNota());
        return repository.save(u);
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
