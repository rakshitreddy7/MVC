package egen.WeatherMVCProject;

import java.util.Comparator;

public class MyComparator implements Comparator<Weather> {

	@Override
	public int compare(Weather w1, Weather w2) {
		if(w1.getTimestamp().toLocalDateTime().compareTo(w2.getTimestamp().toLocalDateTime())>0) {
			return -1;
		}
		else if(w1.getTimestamp().toLocalDateTime().compareTo(w2.getTimestamp().toLocalDateTime())<0) {
			return 1;
		}
		else {			
			return 0;
		}
	}
}
