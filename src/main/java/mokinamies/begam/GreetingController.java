package mokinamies.begam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/begikai")
	public String begikai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "begikai";
	    
	}
		
}