package hello.servlet.web.frontcontroller.v3recap;

import hello.servlet.web.frontcontroller.ModelAndView;

import java.util.Map;

public interface ControllerRecap {

    ModelAndView process(Map<String, String> paramMap);
}
