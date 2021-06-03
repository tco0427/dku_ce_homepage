package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
