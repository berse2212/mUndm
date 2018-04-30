package mUndm;

import com.opencsv.bean.CsvBindByPosition;

import mUndm.merkmal.Merkmal;

public class RecordMerkmal {

	@CsvBindByPosition(position = 0)
	private double accelX;	
	@CsvBindByPosition(position = 1)
	private double accelY;
	@CsvBindByPosition(position = 2)
	private double accelZ;
	@CsvBindByPosition(position = 3)
	private double gyroX;
	@CsvBindByPosition(position = 4)
	private double gyroY;
	@CsvBindByPosition(position = 5)
	private double gyroZ;
	@CsvBindByPosition(position = 6)
	private double magnetX;
	@CsvBindByPosition(position = 7)
	private double magnetY;
	@CsvBindByPosition(position = 8)
	private double magnetZ;
	
	public RecordMerkmal(Record record, Merkmal merkmal) {
		this.accelX = merkmal.getValue(record.getAccelX());
		this.accelY = record.getAccelY();
		this.accelZ = record.getAccelZ();
		this.gyroX = record.getGyroX();
		this.gyroY = record.getGyroY();
		this.gyroZ = record.getGyroZ();
		this.magnetX = record.getMagnetX();
		this.magnetY = record.getMagnetY();
		this.magnetZ = record.getMagnetZ();
	}
	
	public RecordMerkmal() {
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
}
