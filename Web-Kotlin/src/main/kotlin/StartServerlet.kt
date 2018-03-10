import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by caijinzhu on 2018/2/13.
 */


@WebServlet("/seller")
class QuickStartServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println(req.toString())
        resp?.writer?.write("hello kotlin servlet")
    }


}