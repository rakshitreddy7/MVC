package egen.WeatherMVCProject;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface WeatherService {
	public List<Weather> getAll();
	public List<Weather> getByName(String name);
	public void create(Weather w);
	
	public List<String> getAllCities();
	public Weather getLatestWeatherCity(String name);
	public String getLatestDescription(String name);
	public int getLatesthumidity(String name);
	public int getLatestPressure(String name);
	public int getLatestTemperature(String name);
	public Wind getLatestWind(String name);
}
