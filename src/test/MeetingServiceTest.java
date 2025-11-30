package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.Book;
import com.BookClub;
import com.services.MeetingService;
import com.Meeting;
import com.Creator;

public class MeetingServiceTest {
	
	private static final String TEST_PATH = "src/data/files/Meetings.csv";
	private static final Date date1 = new Date();
	private static final Creator creator = new Creator("joão", "silva", "99999999999", "joaosilva@example.com", "Senha");
	private static final BookClub bookClub1 = new BookClub(creator, "booky");
	private static final BookClub bookClub2 = new BookClub(creator, "livry");
    private static final Meeting meeting1 = new Meeting(0, bookClub1, "casa", date1, "Shopping");
    private static final Meeting meeting2 = new Meeting(1, bookClub1, "casa", date1, "Shopping");
    private static final Meeting meeting3 = new Meeting(2, bookClub1, "casa", date1, "Shopping");
    // Limpa o arquivo antes de cada teste
    private void resetFile() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();
        f.createNewFile();
    }
	
	@Test
	public void testGetMeetings() throws IOException {
		
		resetFile();
		
		ArrayList<Meeting> meetings = new ArrayList<>();
		
		meetings.add(meeting1);
		meetings.add(meeting2);
		meetings.add(meeting3);
		
		MeetingService meetingService = new MeetingService();
		
		meetingService.addMeeting(meeting1);
		meetingService.addMeeting(meeting2);
		meetingService.addMeeting(meeting3);
		
		assertEquals(meetings, meetingService.getMeetings());
		
	}
	
	@Test
	public void testSaveLoadMeetings() throws IOException {
		
		resetFile();
		
		ArrayList<Meeting> meetings = new ArrayList<>();
		
		meetings.add(meeting1);
		meetings.add(meeting2);
		meetings.add(meeting3);
		
		MeetingService meetingService1 = new MeetingService();
		
		meetingService1.addMeeting(meeting1);
		meetingService1.addMeeting(meeting2);
		meetingService1.addMeeting(meeting3);
		
		MeetingService meetingService2 = new MeetingService();
		
		meetingService1.saveMeetings();
		
		ArrayList<BookClub> bookClubList = new ArrayList<>();
		
		bookClubList.add(bookClub1);
		bookClubList.add(bookClub2);
		
		
		meetingService2.loadMeetings(bookClubList);
		
		assertEquals(meetings, meetingService1.getMeetings());
		
		for (int i = 0; i < meetings.size(); i++) {
			
			System.out.println(meetings.get(i).toString());
			
			assertEquals(meetings.get(i), meetingService2.getMeetings().get(i));
			
		}
		
	}
	

}
