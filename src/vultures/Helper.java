package vultures;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {

	public static Timestamp convertToTimestamp(String str) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	    Date parsedDate = (Date) dateFormat.parse(str);
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    return timestamp;
	}
}
