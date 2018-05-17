package egen.WeatherMVCProject;

import javax.persistence.Embeddable;
@Embeddable
public class Wind {
	public Wind() {
		super();
	}
	float speed;
	int degrees;
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getDegrees() {
		return degrees;
	}
	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}
}
