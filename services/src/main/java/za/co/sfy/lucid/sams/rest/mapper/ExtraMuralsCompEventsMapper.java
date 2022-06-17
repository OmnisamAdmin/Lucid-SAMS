package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ExtraMuralsCompEventsRequest;
import za.co.sfy.sams.lucid.schema.ExtraMuralsCompEvents;

@Component
public class ExtraMuralsCompEventsMapper {

	public ExtraMuralsCompEvents extraMuralsCompEventsRequestToExtraMuralsCompEvents(
			ExtraMuralsCompEventsRequest extraMuralsCompEventsRequest) {

		ExtraMuralsCompEvents extraMuralsCompEvents = new ExtraMuralsCompEvents();

		Integer compID = extraMuralsCompEventsRequest.getCompID();
		if (null != compID) {
			extraMuralsCompEvents.setCompID(Integer.valueOf(compID));
		} else {
			extraMuralsCompEvents.setCompID(Integer.valueOf(0));
		}

		String eventAfrDesc = extraMuralsCompEventsRequest.getEventAfrDesc();
		if (null != eventAfrDesc) {
			extraMuralsCompEvents.setEventAfrDesc(extraMuralsCompEventsRequest.getEventAfrDesc());
		}

		extraMuralsCompEvents.setEventDate(extraMuralsCompEventsRequest.getEventDate());

		String eventDesc = extraMuralsCompEventsRequest.getEventDesc();
		if (null != eventDesc) {
			extraMuralsCompEvents.setEventDesc(extraMuralsCompEventsRequest.getEventDesc());
		}

		Integer eventID = extraMuralsCompEventsRequest.getEventID();
		if (null != eventID) {
			extraMuralsCompEvents.setEventID(Integer.valueOf(eventID));
		} else {
			extraMuralsCompEvents.setEventID(Integer.valueOf(0));

		}
		String eventTimeEnd = extraMuralsCompEventsRequest.getEventTimeEnd();
		if (null != eventTimeEnd) {
			extraMuralsCompEvents.setEventTimeEnd(extraMuralsCompEventsRequest.getEventTimeEnd());
		}

		String eventTimeStart = extraMuralsCompEventsRequest.getEventTimeStart();
		if (null != eventTimeStart) {
			extraMuralsCompEvents.setEventTimeStart(extraMuralsCompEventsRequest.getEventTimeStart());
		}

		return extraMuralsCompEvents;
	}

}