package CalProject.CalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import com.cal.search.pojos.CalActivitiesResp;
import com.cal.search.pojos.CalBlock;
import com.cal.search.pojos.CalBlockResp;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	public static String convertEpochToDateformat(String timeStamp) {

		Long l = Long.parseLong(timeStamp);
		Date date = new Date(l);
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd'%20'HH:mm",
				Locale.ENGLISH);
		String formatted = format.format(date);
		System.out.println(formatted);

		return formatted;

	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
    	
        	
        	URL url=new URL("http://appmon.vip.qa.ebay.com/logview/environment/raptorqasql/rlogid/t6shrefv%252Bbms%25600ijml6%253Cpo9%253Fvjwgct.30%253E7-15652295b07-0xa4/eventDetail");
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			
			con.setRequestProperty("Accept-Language", "en-US");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			
			ObjectMapper mapper = new ObjectMapper();
			
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			
			CalBlock opmsCalBlock = mapper.readValue(response.toString(), CalBlock.class);
			
			List<CalBlockResp> calBlockResp=opmsCalBlock.getCalBlockResp();
            		
			List<CalActivitiesResp> calActivitesResp=calBlockResp.get(0).getCalActivitesResp();
			
			for(CalActivitiesResp singleBlock:calActivitesResp){
				
				
				String requestPath,requestPayload,responsePayload=null;
				
				if(singleBlock.getName()!=null && singleBlock.getName().equals("BadInstrumentation")){
					
					System.out.println("BadInstrumentation  " +singleBlock.getData());
					
				}
				
				
				if(null!=singleBlock.getCalActivitesResp()){
					
					
					List<CalActivitiesResp> innerBlock=singleBlock.getCalActivitesResp();
					
					
					for(CalActivitiesResp childCalActivities:innerBlock){
						
						if(childCalActivities.getType().equals("GINGER_CLIENT") && childCalActivities.getName().equals("RequestPath")){
							
							requestPath=childCalActivities.getData();
							
							System.out.println("RequestPath - "+ requestPath);
						}
						
						
						if(childCalActivities.getType().equals("GINGER_CLIENT") && childCalActivities.getName().equals("RequestPayload")){
													
							requestPayload=childCalActivities.getData();
							
							System.out.println("RequestPayload - "+ requestPayload);
						}
						
						if(childCalActivities.getType().equals("GINGER_CLIENT") && childCalActivities.getName().equals("ResponsePayload")){
							
							responsePayload= childCalActivities.getData();
							
					 		System.out.println("ResponsePayload - "+ responsePayload);
						}						
					}				
					
				}
			}
			
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
