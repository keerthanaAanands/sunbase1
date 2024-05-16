package sunbase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        Part filePart = request.getPart("file");

        if (text != null && !text.isEmpty()) {
            processText(text);
        } else if (filePart != null && filePart.getSize() > 0) {
            InputStream fileContent = filePart.getInputStream();
            processFile(fileContent);
        }

        response.sendRedirect("upload.html");
    }

    private void processText(String text) {
        List<String> embeddings = generateEmbeddings(text);
        Database.saveEmbeddings(embeddings);
    }

    private void processFile(InputStream fileContent) {
        String text = readTextFromFile(fileContent);
        List<String> embeddings = generateEmbeddings(text);
        Database.saveEmbeddings(embeddings);
    }

    private String readTextFromFile(InputStream fileContent) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private List<String> generateEmbeddings(String text) {
        // Placeholder method for generating embeddings
        List<String> embeddings = new ArrayList<>();
        // Example: Split text into chunks and convert each chunk into embeddings
        // embeddings.add(embedChunk(chunk));
        embeddings.add(text); // For simplicity, just add the text as an embedding
        return embeddings;
    }
}
