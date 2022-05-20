package como.lolaroca.practicaFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("practicaFinal")
public class PracticaFinalController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
