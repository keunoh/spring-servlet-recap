package hello.servlet.web.frontcontroller.v3recap;

import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3recap.controller.MemberFormControllerRecap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerRecap", urlPatterns = "/servlet/recap/*")
public class FrontControllerRecap extends HttpServlet {

    private Map<String, ControllerRecap> controllerStore = new HashMap<>();

    public FrontControllerRecap() {
        controllerStore.put("servlet/recap/my-form", new MemberFormControllerRecap());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerRecap controllerRecap = controllerStore.get(requestURI);
        if (controllerRecap == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(
                        paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        ModelAndView mv = controllerRecap.process(paramMap);

        String viewName = mv.getViewName();

        MyView view = new MyView("/WEB-INF/" + viewName + ".jsp");

        view.render(mv.getModel(), request, response);

    }
}
