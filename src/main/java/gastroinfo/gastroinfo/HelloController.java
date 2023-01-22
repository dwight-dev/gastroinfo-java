package gastroinfo.gastroinfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("date", LocalDate.now());
        return "hello";
    }
}
