package hello.servlet.web.frontcontroller.v3recap;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerRecap {

    ModelView process(Map<String, String> paramMap);
}
