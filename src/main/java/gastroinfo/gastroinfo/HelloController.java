package gastroinfo.gastroinfo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class HelloController {

    private final JdbcTemplate jdbc;

    @GetMapping("/")
    public String hello(Model model) {

        model.addAttribute("date", LocalDate.now());
        List<Map<String, Object>> maps = jdbc.queryForList("select offer as description, price, name, address, phone from offers join places on offers.place_id = places.id");
        Map<String, Object> zone = Map.of("name", "Some zone", "offers", maps);
        model.addAttribute("zones", List.of(zone, zone, zone));
        return "hello";
    }
}
