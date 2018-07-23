package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! <br> this is me Pejman";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public String resume(HttpServletResponse response){
        response.setHeader("Content-Type","text/html");
        return "{<br>" +
                "  &nbsp;\"basics\": {<br>" +
                "    &nbsp;&nbsp;\"name\": \"Pejman Tabassomi\",<br>" +
                "    &nbsp;&nbsp;\"label\": \"Senior Pre Sales Consultant\",<br>" +
                "    &nbsp;&nbsp;\"picture\": \"\",<br>" +
                "    &nbsp;&nbsp;\"email\": \"pejman.tabassomi@gmail.com\",<br>" +
                "    &nbsp;&nbsp;\"phone\": \"+33667739621\",<br>" +
                "    &nbsp;&nbsp;\"summary\": \"A summary of Pejman...\",<br>" +
                "    &nbsp;&nbsp;\"location\": {<br>" +
                "      &nbsp;&nbsp;&nbsp;&nbsp;\"address\": \"14 av Stephane Mallarme\",<br>" +
                "      &nbsp;&nbsp;&nbsp;&nbsp;\"postalCode\": \"75017\",<br>" +
                "      &nbsp;&nbsp;&nbsp;&nbsp;\"city\": \"Paris\",<br>" +
                "      &nbsp;&nbsp;&nbsp;&nbsp;\"countryCode\": \"FR\",<br>" +
                "    },<br>" +
                "  &nbsp;\"work\": [{<br>" +
                "    &nbsp;&nbsp;\"company\": \"Pivotal\",<br>" +
                "    &nbsp;&nbsp;\"position\": \"Platform Architect\",<br>" +
                "    &nbsp;&nbsp;\"website\": \"https://pivotal.io\",<br>" +
                "    &nbsp;&nbsp;\"startDate\": \"TBD\",<br>" +
                "    &nbsp;&nbsp;\"endDate\": \"Why would this end?\",<br>" +
                "  &nbsp;\"education\": [{<br>" +
                "    &nbsp;\"institution\": \"University Pierre et Marie Curie\",<br>" +
                "    &nbsp;\"area\": \"Applied Mathematics & Fluid mechanics\",<br>" +
                "    &nbsp;\"studyType\": \"French third cycle (D.E.A)\",<br>" +
                "  }],<br>" +
                "  &nbsp;\"languages\": [{<br>" +
                "    &nbsp;&nbsp;\"name\": \"English\",<br>" +
                "    &nbsp;&nbsp;\"level\": \"Native speaker\"<br>" +
                "  }],<br>" +
                "  &nbsp;\"interests\": [{<br>" +
                "    &nbsp;&nbsp;\"name\": \"Tennis, Krav Maga\",<br>" +
                "}";
    }








}
