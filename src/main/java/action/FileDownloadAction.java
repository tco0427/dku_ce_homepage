package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownloadAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context=request.getSession().getServletContext();
        String path=context.getRealPath("");
        String fileName=request.getAttribute("fileName").toString();

        String fullPath=path+fileName;
        File downloadFile=new File(fullPath);
        FileInputStream inputStream=new FileInputStream(downloadFile);
        String mimeType=context.getMimeType(fullPath);
        if(mimeType==null){
            mimeType="application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int)downloadFile.length());
        String headerKey="Content-Disposition";
        String headerValue=String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey,headerValue);

        OutputStream outputStream=response.getOutputStream();
        byte[] buffer=new byte[1024];
        int bytesRead=-1;
        while((bytesRead=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
}
