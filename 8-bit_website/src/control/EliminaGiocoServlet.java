package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GiocoBean;
import model.GiocoDAO;


@WebServlet("/EliminaGioco")
public class EliminaGiocoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EliminaGiocoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String nomeG = request.getParameter("giocoElim_combo");
			
			GiocoDAO.eliminaGioco(nomeG);
			
			ArrayList<GiocoBean> lista = GiocoDAO.getItems();

			HttpSession session = request.getSession();
			session.setAttribute("listaGiochi", lista);
			 session.setAttribute("controlloAdminEliminazione", false);
			
			response.sendRedirect("admin.jsp");
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
