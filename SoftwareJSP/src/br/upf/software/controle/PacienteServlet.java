package br.upf.software.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.software.beans.Doenca;
import br.upf.software.beans.Paciente;
import br.upf.software.dao.GenericDao;

@WebServlet("/Admin/Paciente/PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long seralVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		List<Paciente> pacientes = new ArrayList<>();
		GenericDao<Paciente> dao = new GenericDao<>(Paciente.class);
		GenericDao<Doenca> daoDoenca = new GenericDao<>(Doenca.class);
		// 1 - Descobrir qual a operação e executar
		String oper = request.getParameter("oper");
		oper = oper == null ? "listar" : oper;
		String abrir = "";
		switch (oper) {
		case "listar":
			// fazer operação
			pacientes = dao.getInstanciasList();
			abrir = "ListPaciente.jsp";
			break;
		case "novo":
			// fazer operação
			abrir = "FormPaciente.jsp";
			break;
		case "gravar": {
			// fazer operacão
			Paciente p = new Paciente(
					request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")),
					request.getParameter("nome"),
					request.getParameter("email"),
					new Doenca(request.getParameter("doenca").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("doenca"))));

			if (p.getEmail().length() <= 0) {
				request.setAttribute("erro", "O E-mail é obrigatório!");
				abrir = "FormPaciente.jsp";
				request.setAttribute("paciente", p);
			 
			}if (p.getNome().length() <=0) {
				request.setAttribute("erro", "O nome é obrigatório!");
				abrir = "FormPaciente.jsp";
				request.setAttribute("paciente", p);
			}  else
				try {
					dao.merge(p);
					pacientes = dao.getInstanciasList();
					abrir = "ListPaciente.jsp";
				} catch (Exception e) {
					abrir = "FormPaciente.jsp";
					request.setAttribute("paciente", p);
					request.setAttribute("erro", e.getMessage());
				}
		
			break;
		}
		case "excluir": {
			try {
				dao.remove(Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
			}
			pacientes = dao.getInstanciasList();
			abrir = "ListPaciente.jsp";
			break;
		}
		case "alterar":
			try {
				Paciente p = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("paciente", p); // colocar na requisição para
													// o JSP usar
				abrir = "FormPaciente.jsp";
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				pacientes = dao.getInstanciasList();
				abrir = "ListPaciente.jsp";
			}

			break;

		}
		request.getSession().setAttribute("pacientes", pacientes);
		request.setAttribute("doencas", daoDoenca.getInstanciasList());

		// 2 - Encaminhar para JPS dar resposta
		// response.sendRedirect(abrir);
		request.getRequestDispatcher(abrir).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
