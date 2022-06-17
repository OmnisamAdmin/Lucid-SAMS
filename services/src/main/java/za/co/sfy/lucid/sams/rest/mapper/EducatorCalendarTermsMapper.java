package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorCalendarTermsRequest;
import za.co.sfy.sams.lucid.schema.EducatorCalendarTerms;

@Component
public class EducatorCalendarTermsMapper {

	private final SharedMapper sharedMapper;

	public EducatorCalendarTermsMapper(final SharedMapper sharedMapper) {
		this.sharedMapper = sharedMapper;
	}

	public EducatorCalendarTerms educatorCalendarTermsRequestToEducatorCalendarTerms(
			EducatorCalendarTermsRequest educatorCalendarTermsRequest) throws LucidSamsExecutionException {

		EducatorCalendarTerms educatorCalendarTerms = new EducatorCalendarTerms();

		String currentYear = educatorCalendarTermsRequest.getCurrentYear();
		if (null != currentYear) {
			educatorCalendarTerms.setCurrentYear(educatorCalendarTermsRequest.getCurrentYear());
		}

		String endDate = educatorCalendarTermsRequest.getEndDate();
		if (null != endDate) {
			educatorCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar(endDate));
		} else {
			educatorCalendarTerms.setEndDate(sharedMapper.dateToXMLGregorianCalendar());
		}

		Integer id = educatorCalendarTermsRequest.getId();
		if (null != id) {
			educatorCalendarTerms.setId(Integer.valueOf(id));
		} else {
			educatorCalendarTerms.setId(Integer.valueOf(0));
		}

		String quater = educatorCalendarTermsRequest.getQuater();
		if (null != quater) {
			educatorCalendarTerms.setQuater(educatorCalendarTermsRequest.getQuater());
		}

		String startDate = educatorCalendarTermsRequest.getStartDate();
		if (null != startDate) {
			educatorCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar(startDate));
		} else {
			educatorCalendarTerms.setStartDate(sharedMapper.dateToXMLGregorianCalendar());
		}

		Integer term = educatorCalendarTermsRequest.getTerm();
		if (null != term) {
			educatorCalendarTerms.setTerm(Integer.valueOf(term));
		} else {
			educatorCalendarTerms.setTerm(Integer.valueOf(0));
		}

		return educatorCalendarTerms;
	}
}