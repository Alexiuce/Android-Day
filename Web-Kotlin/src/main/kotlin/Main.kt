import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by caijinzhu on 2018/2/13.
 */


@WebServlet("/home")
class HomeController: HttpServlet(){
    /* get */
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.writer?.write("HomeController ..")

    }
}