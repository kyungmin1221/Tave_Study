package shop.pingping2.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.pingping2.board.config.auth.SessionUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

// "/" 경로로 오는 요청을 처리하는 Controller //

@RequiredArgsConstructor
@Controller             // 해당 클래스가 컨트롤러임을 알려주는 어노테이션
public class BaseController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());
        }

        return "index";

    }
}
