package mUndm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class ConvertTimestampToLocalDateTime<T> extends AbstractBeanField<T>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		
		long ts = Long.parseLong(value);
		
		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(ts), TimeZone.getDefault().toZoneId());  
		
		return dateTime;
	}

}
