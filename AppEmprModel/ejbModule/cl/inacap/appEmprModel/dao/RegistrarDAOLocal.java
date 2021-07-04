package cl.inacap.appEmprModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.appEmprModel.dto.Registrar;

@Local
public interface RegistrarDAOLocal {

	void save(Registrar registrar);
	List<Registrar> getAll();
	void delete(Registrar registrar);
	List<Registrar> filterByName(String nombre);
}
