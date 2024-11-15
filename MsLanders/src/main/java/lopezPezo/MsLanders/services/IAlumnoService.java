package lopezPezo.MsLanders.services;

import java.util.List;

import lopezPezo.MsLanders.model.AlumnoModel;

public interface IAlumnoService {

    public List<AlumnoModel> findAll();

    public AlumnoModel findById(Integer id);

    public AlumnoModel add(AlumnoModel model);

    public AlumnoModel update(AlumnoModel model);

    public Boolean delete(Integer id);    
}
