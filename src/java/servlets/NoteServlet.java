
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit = request.getParameter("edit");
                
        if(edit == null){
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        return;
        }
        else if(edit.equals("true")){
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return;
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        //This is where the program breaks and I can't figure out why.
        //I tested to see if note.txt exists/is being found, and it is, but it won't pull the strings from each line with br.readLine().
         
        String oldTitle = br.readLine();
        String oldContent = br.readLine();
        
        request.setAttribute("titleAttribute", oldTitle);
        request.setAttribute("contentAttribute", oldContent);
        
        Note theNote = new Note(oldTitle, oldContent);
        
        String newTitle = request.getParameter("tbox");
        String newContent = request.getParameter("cbox");
        
        theNote.setTitle(newTitle);
        theNote.setContent(newContent);
        
        pw.println(theNote.getTitle());
        pw.println(theNote.getContent());
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        //stop the code call after loading the JSP (VERY IMPORTANT)
        return;
    }

}
