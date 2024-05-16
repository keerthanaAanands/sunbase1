package sunbase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        String responseText = generateResponse(query);
        request.setAttribute("responseText", responseText);
        request.getRequestDispatcher("/chat.jsp").forward(request, response);
    }

    private String generateResponse(String query) {
        // Generate response using RAG model
        return "Response to query: " + query;
    }
}
