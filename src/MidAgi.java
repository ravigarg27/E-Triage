

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;

import com.ravi.Final.Final;
import com.ravi.Final.Triage;
import com.ravi.postProcess.NER;
import com.ravi.speechRecog.RecogGoogle;


public class MidAgi extends BaseAgiScript
{

    String name_response="";
    String age_response="";
    String breathe_response="";
    String complaint_response="";
    String conscious_response="";
    String firstaid_response="";
    String location_response="";
    String pain_response="";
    String time_response="";
    String roadaccident_response="";
    String multiple_injury_response="";
    String walk_response;
    
    String caseofPatient;
    @Override
    public void service(AgiRequest arg0, AgiChannel arg1) throws AgiException {
        
        try {
            name_response = RecogGoogle.googleResponse("response/name_response.wav");
            name_response = NER.name(name_response);
            System.out.println(name_response);
            age_response = RecogGoogle.googleResponse("response/age_response.wav");
            age_response = NER.age(age_response);
            System.out.println(age_response);
            time_response = RecogGoogle.googleResponse("response/time_response.wav");
            time_response = NER.time(time_response);
            System.out.println(time_response);
            
            breathe_response = RecogGoogle.googleResponse("response/breathe_response.wav");
            conscious_response = RecogGoogle.googleResponse("response/complaint_response.wav");
            pain_response = RecogGoogle.googleResponse("response/pain_response.wav");
            walk_response = RecogGoogle.googleResponse("response/walk_response.wav");
            multiple_injury_response = RecogGoogle.googleResponse("response/multiple_injury_response.wav");
            roadaccident_response = RecogGoogle.googleResponse("response/roadaccident_response.wav");
            firstaid_response = RecogGoogle.googleResponse("response/firstaid_response.wav");
            
            location_response = RecogGoogle.googleResponse("response/location_response.wav");
            complaint_response = RecogGoogle.googleResponse("response/complaint_response.wav");
            
            
            System.out.println("Breath Response: "+breathe_response);
            System.out.println("Consious Response: "+conscious_response);
            System.out.println("Pain Response: "+pain_response);
            System.out.println("Walk Response: "+walk_response);
            System.out.println("Multiple Injury Response: "+multiple_injury_response);
            System.out.println("Road Accident Response: "+roadaccident_response);
            System.out.println("First Aid Response: "+firstaid_response);
            System.out.println("Location Response: "+location_response);
            System.out.println("Complaint Response: "+complaint_response);
            
            Triage triage = new Triage();
            caseofPatient = triage.algo(conscious_response, breathe_response, walk_response, firstaid_response, roadaccident_response, pain_response, multiple_injury_response, age_response, time_response);
            System.out.println("Case of Patient: "+caseofPatient);
            
            String[] args = new String[4];
            args[0]="orthopedist";
            args[3]=roadaccident_response;
            args[1]="12.9382";
            args[2]="77.6228";
                    
            System.out.println("#########Final Results#########");
            Final.main(args);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
