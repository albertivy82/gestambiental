package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

}
