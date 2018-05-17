package egen.WeatherMVCProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@Api(tags="Weathers of different cities")
public class WeatherController {
	
	@Autowired
	private WeatherService ser;
	
	@ApiOperation(value = "all rows" , notes="to get all rows in database")
	@ApiResponses({
		@ApiResponse(code=200,message="Success"),
		@ApiResponse(code=500,message="Internal Server error")
	})
	@RequestMapping(value="/get-all",method=RequestMethod.GET)
	public List<Weather> getAll(){
		return ser.getAll();
	}
	@RequestMapping(value="/get-by-name/{city}",method=RequestMethod.GET)
	public List<Weather> getByName(@PathVariable String city){
		return ser.getByName(city);
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void create(@RequestBody Weather w){
		 ser.create(w);
	}
	@RequestMapping(value="/get-all-cities",method=RequestMethod.GET)
	public List<String> getAllCities(){
		return ser.getAllCities();
	}
	@RequestMapping(value="/get-latest-weather/{city}",method=RequestMethod.GET)
	public Weather getLatestWeatherCity(@PathVariable String city){
		return ser.getLatestWeatherCity(city);
	}
	@RequestMapping(value="/get-latest-description/{city}",method=RequestMethod.GET)
	public String getLatestDescription(@PathVariable String city){
		return ser.getLatestDescription(city);
	}
	@RequestMapping(value="/get-latest-humidity/{city}",method=RequestMethod.GET)
	public int getLatestHumidity(@PathVariable String city){
		return ser.getLatesthumidity(city);
	}
	@RequestMapping(value="/get-latest-pressure/{city}",method=RequestMethod.GET)
	public int getLatestPressure(@PathVariable String city){
		return ser.getLatestPressure(city);
	}
	@RequestMapping(value="/get-latest-temperature/{city}",method=RequestMethod.GET)
	public int getLatestTemperature(@PathVariable String city){
		return ser.getLatestTemperature(city);
	}
	@RequestMapping(value="/get-latest-wind/{city}",method=RequestMethod.GET)
	public Wind getLatestWind(@PathVariable String city){
		return ser.getLatestWind(city);
	}
	
}
