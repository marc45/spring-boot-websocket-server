package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Greeting message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message;
    }

    @RequestMapping(value="/test/{message}", method= RequestMethod.GET)
    public ResponseEntity<?> test(@PathVariable String message) throws Exception {
        this.template.convertAndSend("/topic/greetings", new Greeting("SYSTEM", message));
        return new ResponseEntity< String >("OK", HttpStatus.OK);
    }

}
