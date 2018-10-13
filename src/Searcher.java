import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

/**
 * Servlet implementation class Searcher
 */

//@WebServlet("/Searcher")
public class Searcher extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public Searcher() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        String name = request.getParameter("search");
        System.out.println(name);
        search(name,request,response);
    }

    public void search(String text,HttpServletRequest request,HttpServletResponse response ) {
        System.out.println("Hello " + text);
        if (!text.isEmpty() && !text.equals(null) && !text.equals("")) {
            String index = "C:\\Users\\U65483\\Desktop\\uWin\\citeseer2_index";
            try {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
                IndexSearcher searcher = new IndexSearcher(reader);
                Analyzer analyzer = new StandardAnalyzer();
                QueryParser parser = new QueryParser("contents", analyzer);
                Query query = parser.parse(text);
                TopDocs results = searcher.search(query, 100);
                out.println("<br> Total matching documents: " + results.totalHits +" <br><br></br>");
                for (int i = 0; i < 10; i++) {
                    Document doc = searcher.doc(results.scoreDocs[i].doc);
                    String path = doc.get("path");
                    out.println((i + 1) + ". " + " <a href=\"\"> " + path + "</a>");
                    String title = doc.get("title");
                    //Click <a href="http://www.yahoo.com">here</a> to go to yahoo.
                    out.println("<p>");
                    if (title != null) {
                        out.println("   Title: " + doc.get("title").replace("?",""));
                    }
                    out.println("</p>");
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            try {
                response.sendRedirect(request.getContextPath());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}



