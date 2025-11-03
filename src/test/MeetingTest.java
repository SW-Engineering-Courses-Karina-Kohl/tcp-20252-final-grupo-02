package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.Creator;
import main.Meeting;

public class MeetingTest {

	@Test
	public void testConstructor() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String type = "Presencial";
		Date date = new Date();
		String location = "Av. Bento Gonçalves, 9500 - Agronomia, Porto Alegre - RS, 91509-900";
		
		Meeting newMeeting = new Meeting(newCreator, type, date, location);
		
		assertEquals(1, newMeeting.getId());
		assertEquals(newCreator, newMeeting.getCreator());
		assertEquals(0, newMeeting.getParticipants().size());
		assertEquals(type, newMeeting.getType());
		assertEquals(date, newMeeting.getDate());
		assertEquals(location, newMeeting.getLocation());
		assertEquals(1, Meeting.getNumMeetingsCreated());
		
	}

}
