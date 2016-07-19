package integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MainClass {

    private Collator collator;

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! \n It's a beautiful day";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/vote")
    @ResponseBody
    
    void collate(@RequestBody String body) {
    	decoder = new JsonDecode();
    	decoder.decode(body);
    }
    
    @RequestMapping("/start")
    @ResponseBody
    void start() {
    	collator = new Collator();
  
    }

    //@EnableAutoConfiguration
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainClass.class, args);
    }
}