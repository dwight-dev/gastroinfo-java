package gastroinfo.gastroinfo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class HelloController {

    private final JdbcTemplate jdbc;

    @GetMapping("/")
    public String hello(Model model, LocalDate date) {

        if (date == null) {
            date = LocalDate.now();
        }
        model.addAttribute("date", date);
        List<Map<String, Object>> offers = jdbc.queryForList("select offer as description, price, name, address, phone, zone from offers join places on offers.place_id = places.id where date = ?", date);
        Map<String, List<Map<String, Object>>> zones = new HashMap<>();
        for (Map<String, Object> offer : offers) {
            zones.computeIfAbsent((String) offer.get("zone"), (k) -> new ArrayList<>()).add(offer);
        }
        model.addAttribute("zones", zones.entrySet().stream().map((e) -> Map.of("name", e.getKey(), "offers", e.getValue())));
        return "hello";
    }
}
