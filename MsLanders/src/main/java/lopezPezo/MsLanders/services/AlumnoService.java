package lopezPezo.MsLanders.services;

import java.util.List;

import lopezPezo.MsLanders.model.AlumnoModel;

public interface AlumnoService {

    public List<AlumnoModel> findAllStudent();

    public AlumnoModel findByIdStudent(Integer id);

    public AlumnoModel addStudent(AlumnoModel model);

    public AlumnoModel updateStudent(AlumnoModel model, int id);

    public Boolean deleteStudent(Integer id);    
}
