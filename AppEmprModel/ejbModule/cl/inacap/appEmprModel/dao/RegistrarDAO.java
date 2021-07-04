package cl.inacap.appEmprModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.appEmprModel.dto.Registrar;

/**
 * Session Bean implementation class RegistrarDAO
 */
@Stateless
@LocalBean
public class RegistrarDAO implements RegistrarDAOLocal {

	private static List<Registrar> registros = new ArrayList<>();
	
	@Override
	public void save(Registrar registrar) {
		registros.add(registrar);
	}

	@Override
	public List<Registrar> getAll() {
		// TODO Auto-generated method stub
		return registros;
	}

	@Override
	public void delete(Registrar registrar) {
		// TODO Auto-generated method stub
		registros.remove(registrar);
	}

	@Override
	public List<Registrar> filterByName(String nombre) {
		
		return registros.stream().filter(c->c.getNombre().contains(nombre)).collect(Collectors.toList());
	}

}
