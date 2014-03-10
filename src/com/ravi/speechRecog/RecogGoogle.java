package com.ravi.speechRecog;

public class RecogGoogle {

	
	public static String googleResponse(String filename) throws Exception{
		
		    Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US);
        GoogleResponse out = rec.getRecognizedDataForWave(filename);
        System.out.println(out.getResponse());
		
		return out.getResponse();
	}
	
	
}
