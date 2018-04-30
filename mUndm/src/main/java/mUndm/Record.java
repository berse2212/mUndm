package mUndm;

import java.time.LocalDateTime;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

public class Record {

	@CsvBindByPosition(position = 0)
	private String id;
	@CsvCustomBindByPosition(position = 1, converter = ConvertTimestampToLocalDateTime.class)
	private LocalDateTime timestamp;
	@CsvBindByPosition(position = 2)
	private double accelX;	
	@CsvBindByPosition(position = 3)
	private double accelY;
	@CsvBindByPosition(position = 4)
	private double accelZ;
	@CsvBindByPosition(position = 5)
	private double gyroX;
	@CsvBindByPosition(position = 6)
	private double gyroY;
	@CsvBindByPosition(position = 7)
	private double gyroZ;
	@CsvBindByPosition(position = 8)
	private double magnetX;
	@CsvBindByPosition(position = 9)
	private double magnetY;
	@CsvBindByPosition(position = 10)
	private double magnetZ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public double getAccelX() {
		return accelX;
	}
	public void setAccelX(double accelX) {
		this.accelX = accelX;
	}
	public double getAccelY() {
		return accelY;
	}
	public void setAccelY(double accelY) {
		this.accelY = accelY;
	}
	public double getAccelZ() {
		return accelZ;
	}
	public void setAccelZ(double accelZ) {
		this.accelZ = accelZ;
	}
	public double getGyroX() {
		return gyroX;
	}
	public void setGyroX(double gyroX) {
		this.gyroX = gyroX;
	}
	public double getGyroY() {
		return gyroY;
	}
	public void setGyroY(double gyroY) {
		this.gyroY = gyroY;
	}
	public double getGyroZ() {
		return gyroZ;
	}
	public void setGyroZ(double gyroZ) {
		this.gyroZ = gyroZ;
	}
	public double getMagnetX() {
		return magnetX;
	}
	public void setMagnetX(double magnetX) {
		this.magnetX = magnetX;
	}
	public double getMagnetY() {
		return magnetY;
	}
	public void setMagnetY(double magnetY) {
		this.magnetY = magnetY;
	}
	public double getMagnetZ() {
		return magnetZ;
	}
	public void setMagnetZ(double magnetZ) {
		this.magnetZ = magnetZ;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", timestamp=" + timestamp + ", accelX=" + accelX + ", accelY=" + accelY
				+ ", accelZ=" + accelZ + ", gyroX=" + gyroX + ", gyroY=" + gyroY + ", gyroZ=" + gyroZ + ", magnetX="
				+ magnetX + ", magnetY=" + magnetY + ", magnetZ=" + magnetZ + "]";
	}
	
}
