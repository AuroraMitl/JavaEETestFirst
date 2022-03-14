import logic.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServletTest")
public class FirstServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");

        Cart cart =(Cart)session.getAttribute("cart");

        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if(cart == null)
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
            session.setAttribute("cart", cart);

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Your count is, " + count + "!</h1>");
        pw.println("</html>");

    }
}
