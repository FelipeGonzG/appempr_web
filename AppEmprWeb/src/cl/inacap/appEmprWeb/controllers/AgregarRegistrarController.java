package cl.inacap.appEmprWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.appEmprModel.dao.RegistrarDAO;
import cl.inacap.appEmprModel.dao.RegistrarDAOLocal;
import cl.inacap.appEmprModel.dto.Registrar;

/**
 * Servlet implementation class AgregarRegistrarController
 */
@WebServlet("/AgregarRegistrarController.do")
public class AgregarRegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private RegistrarDAOLocal registrarDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarRegistrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/vistas/agregarRegistrar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<>();
		
		String rut = request.getParameter("rut-txt").trim();
		if(rut.isEmpty()) {
			errores.add("Debe ingresar un rut");
		}
		String nombre = request.getParameter("nombre-txt").trim();
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
		String apellido = request.getParameter("apellido-txt").trim();
		if(apellido.isEmpty()) {
			errores.add("Debe ingresar un apellido");
		}
		String edadTxt = request.getParameter("edad-txt").trim();
		int edad=0;
		try {
			edad = Integer.parseInt(edadTxt);
		}catch(Exception ex) {
			errores.add("La edad debe ser numerica");
		}
		String empresa = request.getParameter("empresa-txt").trim();
		if(empresa.isEmpty()) {
			errores.add("Debe ingresar una empresa");
		}
		String estado = request.getParameter("estado-select").trim();
		if(estado.isEmpty()) {
			errores.add("Debe ingresar un estado");
		}
		String region = request.getParameter("region-select").trim();
		if(region.isEmpty()) {
			errores.add("Debe ingresar una region");
		}
		
		if(errores.isEmpty()) {
			Registrar registrar = new Registrar();
			registrar.setRut(rut);
			registrar.setNombre(nombre);
			registrar.setApellido(apellido);
			registrar.setEdad(edad);
			registrar.setEmpresa(empresa);
			registrar.setEstado(estado);
			registrar.setRegion(region);
			registrarDAO.save(registrar);
			request.setAttribute("mensaje", "Asistente Registrado");
		}else {
			request.setAttribute("errores", errores);
		}
		
		doGet(request,response);
		
		
	}

}
