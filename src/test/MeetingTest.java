package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.Creator;
import com.AppSystem;
import com.Meeting;

public class MeetingTest {

	@Test
	public void testConstructor() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String type = "Presencial";
		Date date = new Date();
		String location = "Av. Bento Gonçalves, 9500 - Agronomia, Porto Alegre - RS, 91509-900";
		
		Meeting newMeeting = new Meeting(newCreator, type, date, location);
		
		assertEquals(Meeting.getNumMeetingsCreated(), newMeeting.getId());
		assertEquals(newCreator, newMeeting.getCreator());
		assertEquals(0, newMeeting.getParticipants().size());
		assertEquals(type, newMeeting.getType());
		assertEquals(date, newMeeting.getDate());
		assertEquals(location, newMeeting.getLocation());
		
	}
	
	@Test
	public void testCreateMeeting() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String type = "Presencial";
		Date date = new Date();
		String location = "Av. Bento Gonçalves, 9500 - Agronomia, Porto Alegre - RS, 91509-900";
		
		Meeting newMeeting = new Meeting(newCreator, type, date, location);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createMeeting(newMeeting);
		
		assertEquals(1, appSystem.getMeetings().size());
		
	}
	
	@Test
	public void testDeleteMeeting() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String type = "Presencial";
		Date date = new Date();
		String location = "Av. Bento Gonçalves, 9500 - Agronomia, Porto Alegre - RS, 91509-900";
		
		Meeting newMeeting = new Meeting(newCreator, type, date, location);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createMeeting(newMeeting);
		appSystem.deleteMeeting(newMeeting);
		
		assertEquals(0, appSystem.getMeetings().size());
		
	}

}
