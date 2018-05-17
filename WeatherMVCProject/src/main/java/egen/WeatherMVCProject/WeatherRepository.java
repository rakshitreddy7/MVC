package egen.WeatherMVCProject;

import java.util.List;


public interface WeatherRepository {
	
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
