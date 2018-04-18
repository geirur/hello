package messageme;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
@RestController
public class PingMeController {

    private static final String template1= "Ping %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/pingme")
    public PingMe pingme(@RequestParam(value="name", defaultValue="Pang") String name) {
        return new PingMe(counter.incrementAndGet(),
                String.format(template1, name));
    }
}
