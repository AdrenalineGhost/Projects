package be.ugent.iii.vbhttp;


import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class VbHttpController {

    @PostMapping("toonWaarden")
    public String toonWaarden (@ModelAttribute Adres adres, Model model) {
        model.addAttribute("adres", adres);
        return "toon";
    }

    @GetMapping("/stelCookieIn")
    public String setCookie(HttpServletResponse response) {
        // create a cookie
        Cookie cookie = new Cookie("nieuw", "waarde");

        //add cookie to response
        response.addCookie(cookie);

        return "CookieToegevoegd";
    }
}
