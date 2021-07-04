package cl.inacap.appEmprWeb.controllers;

import java.io.IOException;
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
 * Servlet implementation class VerRegistrarController
 */
@WebServlet("/VerRegistrarController.do")
public class VerRegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private RegistrarDAOLocal registrarDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerRegistrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Registrar> registros = registrarDAO.getAll();
		
		request.setAttribute("registros", registros);
		
		request.getRequestDispatcher("WEB-INF/vistas/verRegistrar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
