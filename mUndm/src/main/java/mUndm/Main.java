package mUndm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import mUndm.merkmal.VarianzMerkmal;
import testserver.base.Connector;
import testserver.mean.GetDataResponse;
import testserver.mean.MeanExercise;
import testserver.mean.MeanResultRequest;
import testserver.median.MedianExercise;
import testserver.median.MedianResultRequest;

public class Main {

	public static final String UNTERARM = "01324180";
	public static final String OBERARM = "01324185";
	public static final String OBERSCHENKEL = "01324189";
	public static final String UNTERSCHENKEL = "01324188";
	public static final String RUECKEN = "01324181";
	
	public static final int WINDOW = 120;
	public static final int WINDOW_NEXT = 1;
	
	public static void main(String[] args) throws Exception {
	    List<Record> records = readFile("/home/tobias/Dokumente/mUndm/messdaten/2018_daten_grp9/stehen_P2.csv");
		
	    List<Double> filtered = records.parallelStream()
	    		.filter(r -> r.getId().equals(UNTERARM))
	    		.map(r -> r.getAccelX())
	    		.collect(Collectors.toList());
	    
	    List<RecordMerkmal> out = new ArrayList<>();
	    
	    for (int i = 0; i + WINDOW < filtered.size(); i = i + WINDOW_NEXT) {
	    	RecordMerkmal recordOut = new RecordMerkmal();
	    	recordOut.setAccelX(new VarianzMerkmal().getValue(filtered.subList(i, i + WINDOW)));
	    	out.add(recordOut);
		}
	    
		
		writeFile("/home/tobias/Dokumente/mUndm/auswaertung/stehen_varianz.csv", out);
//		doExercises();
	}
	
	private static <T extends Object> void writeFile(String file, List<T> records) throws Exception {
//		new File(file).createNewFile();
		
		Writer writer = new FileWriter(file);
	    StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
	    		.withQuotechar(' ').build();
	    beanToCsv.write(records);
	    
	    writer.flush();
	    writer.close();
	}

	private static void doExercises() throws Exception {
		Connector connector = new Connector();

	    connector.doExercise("mean", MeanExercise::responseToMeanRequest, GetDataResponse.class, MeanResultRequest.class);
	    connector.doExercise("median", MedianExercise::responseToMedianRequest, GetDataResponse.class, MedianResultRequest.class);
	}
	
	
	private static List<Record> readFile(String file) throws FileNotFoundException {
		List<Record> records = new CsvToBeanBuilder<Record>(new FileReader(file))
	    		 .withSkipLines(1)
	    		 .withType(Record.class)
	    		 .build().parse();
		return records;
	}
}
