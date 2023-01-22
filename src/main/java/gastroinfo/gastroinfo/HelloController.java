package gastroinfo.gastroinfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("date", LocalDate.now());
        Map<String, Object> offer = Map.of(
                "place", Map.of("name", "Some restaurant", "address", "ul. Piotrkowska 123", "phone", "+48123456789"),
                "description", "Very nice meal",
                "price", "25.00");
        Map<String, Object> zone = Map.of("name", "Some zone", "offers", List.of(offer, offer));
        model.addAttribute("zones", List.of(zone, zone, zone));
        return "hello";
    }
}
