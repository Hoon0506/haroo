package haroo.service;

import com.haroo.survey.dao.SurveyDAO;

public class SurveyService {
	private static SurveyService service = new SurveyService();
	
	public static SurveyService getInstance() {
		Object dao = SurveyDAO.classgetInstance();
		return service;
	}
}
