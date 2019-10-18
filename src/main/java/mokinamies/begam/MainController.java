package mokinamies.begam;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller    
@RequestMapping(path="/restfull")
public class MainController {

	@Autowired 
	EntityManagerFactory factory;
	
	@Autowired
	private BegikaiRepository BegikaiRepository;
	
	@Autowired
	private TrasosRepository TrasosRepository;
	
	@Autowired
	private BegtosTrasosRepository BegtosTrasosRepository;
	
	// Ataskaita
	@GetMapping(path="/ataskaita")
	public @ResponseBody List ataskaita(@RequestParam Integer begikas_id) {	
		
		Ataskaita ataskaita = new Ataskaita(factory);
		
		return ataskaita.begtosTrasos(begikas_id);
						
	}	
		
	// Begikai SQL valdymas	
	
	@GetMapping(path="/all_begikai")
	public @ResponseBody Iterable<Begikai> getAllBegikai() {
			
		return BegikaiRepository.findAll();
	}
	
	@GetMapping(path="/begikas")
	public @ResponseBody Optional<Begikai> Begikai(@RequestParam Integer id) {
		
		return BegikaiRepository.findById (id);
	}
		
	@GetMapping(path="/pradzia")
	public @ResponseBody Pirminis pirmas() {
		
		Pirminis pirminis = new Pirminis();
		
		pirminis.setBegikai((List<Begikai>) BegikaiRepository.findAll());
		pirminis.setTrasos((List<Trasos>) TrasosRepository.findAll());
		
		return pirminis;
	}
	
	@GetMapping(path="/prideti_begika") 
	public @ResponseBody String addNewBegikas (@RequestParam String pav
			, @RequestParam Integer metai)
			{
					
		Begikai n = new Begikai();
		n.setPav(pav);
		n.setMetai(metai);
		BegikaiRepository.save(n);
		return "Saved";
	}	
		

	
	// Trasos SQL valdymas	
	
		@GetMapping(path="/all_trasos")
		public @ResponseBody Iterable<Trasos> getAllTrasos() {
				
			return TrasosRepository.findAll();
		}
			
		@GetMapping(path="/prideti_trasa") 
		public @ResponseBody String addNewTrasa (@RequestParam String pav
				, @RequestParam Integer ilgis)
				{
						
			Trasos n = new Trasos();
			n.setPav(pav);
			n.setIlgis(ilgis);
			TrasosRepository.save(n);
			return "Saved";
		}
			
		// Begtos trasos SQL valdymas	
		
		@GetMapping(path="/all_begtos_trasos")
		public @ResponseBody Iterable<BegtosTrasos> getAllBegtosTrasos() {
					
			return BegtosTrasosRepository.findAll();
		}
				
		@GetMapping(path="/prideti_begta_trasa") 
		public @ResponseBody String addNewBegtaTrasa (@RequestParam Integer begikas_id
				, @RequestParam Integer trasa_id
				, @RequestParam Integer data
				, @RequestParam Integer atstumas
				, @RequestParam Integer laikas)
				{
							
			BegtosTrasos n = new BegtosTrasos();
				n.setBegikas_id(begikas_id);
				n.setTrasa_id(trasa_id);
				n.setData(data);
				n.setAtstumas(atstumas);
				n.setLaikas(laikas);
				BegtosTrasosRepository.save(n);
				return "Saved";
		}

}