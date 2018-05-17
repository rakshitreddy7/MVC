package egen.WeatherMVCProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ServiceImpl implements WeatherService{
	@Autowired
	private WeatherRepository repo;
	
	@Transactional(readOnly=true)
	public Weather getLatestWeatherCity(String name) {
		int flag=0;
		List<Weather> list=repo.getAll();
		List<Weather> fin=new ArrayList<Weather>();
		for(int i=0;i<list.size();i++) {
			Weather w=list.get(i);
			if(w.getCity().equals(name)) {
				flag=1;
				fin.add(w);
			}
		}
		if(flag!=1) {
			 new NotFoundException("Weather with name: "+name+"does not exists");
		}
		Collections.sort(fin,new MyComparator());
		return fin.get(0);			
	}
	@Transactional(readOnly=true)
	public List<Weather> getAll() {
		return repo.getAll();
	}
	@Transactional(readOnly=true)
	public List<Weather> getByName(String name) {
		return repo.getByName(name);
	}
	@Transactional
	public void create(Weather w) {
		repo.create(w);
	}
	@Transactional(readOnly=true)
	public List<String> getAllCities() {
		return repo.getAllCities();
	}
	@Transactional(readOnly=true)
	public String getLatestDescription(String name) {
		Weather w=getLatestWeatherCity(name);
		return w.getDescription();
	}
	@Transactional(readOnly=true)
	public int getLatesthumidity(String name) {
		Weather w=getLatestWeatherCity(name);
		return w.getHumidity();
	}
	@Transactional(readOnly=true)
	public int getLatestPressure(String name) {
		Weather w=getLatestWeatherCity(name);
		return w.getPressure();
	}
	@Transactional(readOnly=true)
	public int getLatestTemperature(String name) {
		Weather w=getLatestWeatherCity(name);
		return w.getTemperature();
	}
	@Transactional(readOnly=true)
	public Wind getLatestWind(String name) {
		Weather w=getLatestWeatherCity(name);
		return w.getWind();
	}
}
