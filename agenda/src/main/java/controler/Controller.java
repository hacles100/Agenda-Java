package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contatos(request, response);

		} else if (action.equals("/insert")) {
			novoContato(request, response);
			
		}else {
			response.sendRedirect("index.html");
		}

		// teste de conexao
		// dao.testeConexao();
	}

	// Listar contatos

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}

	// Novo Contato

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		   
		// teste de recebimento dos dados do form
		
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("phone"));
//		System.out.println(request.getParameter("email"));
//		
		// Setar as variaveis Javabeans
		contato.setNome(request.getParameter("nome"));
		contato.setPhone(request.getParameter("phone"));
		contato.setEmail(request.getParameter("email"));
		
//	Invocar o metodo inserirContato passando o objeto contato
		
		dao.inserirContato(contato);
		
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main"); 
		
	}

}
