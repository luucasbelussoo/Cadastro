package br.upf.software.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.software.beans.Doenca;
import br.upf.software.dao.GenericDao;

@WebServlet("/Admin/Doenca/DoencaServlet")
public class DoencaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoencaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Doenca> doencas = new ArrayList<>();
		GenericDao<Doenca> dao = new GenericDao<>(Doenca.class);

		String oper = request.getParameter("oper");
		oper = oper == null ? "listar" : oper;
		String abrir = "";
		switch (oper){ 
		
		case "listar":
			
			doencas = dao.getInstanciasList();
			
			abrir = "ListDoenca.jsp";
			break;
		 case "novo":{
			abrir = "FormDoenca.jsp";
		
		 }break;
		case "gravar":{
			Doenca d = new Doenca(
					request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")),
					request.getParameter("descricao"));
			if (d.getDescricao().length() <= 0) {
				request.setAttribute("Erro", "A descrição é obrigatória");
				abrir = "FormDoenca.jsp";
				request.setAttribute("doenca", d);
			} else
				try {
					dao.merge(d);
					doencas = dao.getInstanciasList();
					abrir = "ListDoenca.jsp";
				} catch (Exception e) {
					abrir = "FormDoenca.jsp";
					request.setAttribute("Doenca", d);
					request.setAttribute("erro", e.getMessage());
				}
			break;
		}case "excluir": {
			try {
				dao.remove(Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
			}
			doencas = dao.getInstanciasList();
			abrir="ListDoenca.jsp";
			break;
			
		} case "alterar" :
			try{
				Doenca d = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("doenca", d);
				abrir="FormDoenca.jsp";
			}catch(Exception e){
				request.setAttribute("erro", e.getMessage());
				doencas = dao.getInstanciasList();
				abrir= "ListDoenca.jsp";
			}
		
		break;
		}

	request.getSession().setAttribute("doencas",doencas);

	request.getRequestDispatcher(abrir).forward(request,response);

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
