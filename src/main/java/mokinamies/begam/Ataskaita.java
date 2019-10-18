package mokinamies.begam;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

public class Ataskaita {

	protected Session em;
	protected EntityManagerFactory factory;	
		
	public SessionFactory sessionFactory() {
			
		if (this.factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
			return this.factory.unwrap(SessionFactory.class);
	}	
	  
	public Ataskaita(EntityManagerFactory factory) {
		  
		this.factory = factory; 
		this.em = this.sessionFactory().openSession(); 
				
	}				
	
	public List<ObjectNode> begtosTrasos(Integer begikas_id) {
		  
		String formuojam =
	  				
			" SELECT "
			+ "`data`"
			+ ", `atstumas`"
			+ ", `laikas`"
			+ ", `trasos`.`pav` "
			+ "FROM `begtos_trasos` "
			+ "LEFT JOIN `trasos` "
			+ "ON `trasa_id` = `trasos`.`id` "
			+ "WHERE `begtos_trasos`.`begikas_id` =" + begikas_id + " " 
			+ "ORDER BY `atstumas`"
	  		+ "";
		
	    Query query = em.createNativeQuery ( formuojam, Tuple.class );
	    
	    List<Tuple> rs = query.getResultList();
	    
	    List<ObjectNode> json = _toJson(rs);
	   
	    return json ;
	}	  		
	
	private List<ObjectNode> _toJson(List<Tuple> results) {

		List<ObjectNode> json = new ArrayList<ObjectNode>();

		ObjectMapper mapper = new ObjectMapper();

		for (Tuple t : results)
		{
		    List<TupleElement<?>> cols = t.getElements();

		    ObjectNode one = mapper.createObjectNode();

		    for (TupleElement col : cols)
		    {
		    	one.put(col.getAlias(), t.get(col.getAlias()).toString());
		    }

		    json.add(one);
		}

		return json;
	}
	
}
