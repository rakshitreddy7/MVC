package egen.WeatherMVCProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryImpl implements WeatherRepository{

	@PersistenceContext
	private EntityManager em;
	
	public List<Weather> getAll() {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getAll", Weather.class);
		List<Weather> list=query.getResultList();
		//System.out.println(list.get(0).getTimestamp());
		return list;
	}

	public List<Weather> getByName(String name) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getByName", Weather.class);
		query.setParameter("varCity", name);
		return query.getResultList();
	}

	public void create(Weather w) {
		
		em.persist(w);
	}

	public void deleteLatest(String name) {
		em.remove(getLatestWeatherCity(name));
	}
	
	public void deleteAll(String name) {
		List<Weather> list=getAll();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCity().equals(name)) {
				em.remove(list.get(i));
			}
		}
	}

	
	public List<String> getAllCities() {
		List<Weather> list=getAll();
		Map<String,Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<list.size();i++) {
			if(!map.containsKey(list.get(i).getCity())) {
				map.put(list.get(i).getCity(), 1);
			}
		}
		Set<String> set=map.keySet();
		return new ArrayList<String>(set);
	}

	public Weather getLatestWeatherCity(String name) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.latestWeather", Weather.class);
		query.setParameter("varName",name);
		List<Weather> list=query.getResultList();
		
		return null;
	}

	public String getLatestDescription(String name) {
		return getLatestWeatherCity(name).getDescription();
	}

	public int getLatesthumidity(String name) {
		return getLatestWeatherCity(name).getHumidity();
	}

	public int getLatestPressure(String name) {
		return getLatestWeatherCity(name).getPressure();
	}

	public int getLatestTemperature(String name) {
		return getLatestWeatherCity(name).getTemperature(); 
	}

	public Wind getLatestWind(String name) {
		return getLatestWeatherCity(name).getWind();
	}

}
