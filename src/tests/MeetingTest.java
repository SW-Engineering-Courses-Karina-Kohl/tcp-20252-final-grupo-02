package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.Creator;
import com.Meeting;

public class MeetingTest {

	@Test
	public void testBuilderMeeting() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String expectedType = "Presencial";
		Date expectedDate = new Date();
		String expectedLocation = "Av. Bento Gonçalves, 9500 - Agronomia, Porto Alegre - RS, 91509-900";
		
		Meeting newMeeting = new Meeting(newCreator, expectedType, expectedDate, expectedLocation);
		
		assertEquals(1, newMeeting.getId());
		assertEquals(newCreator, newMeeting.getCreator());
		assertEquals(0, newMeeting.getParticipants().size());
		assertEquals(expectedType, newMeeting.getType());
		assertEquals(expectedDate, newMeeting.getDate());
		assertEquals(expectedLocation, newMeeting.getLocation());
		assertEquals(1, Meeting.getNumMeetingsCreated());
		
	}

}
