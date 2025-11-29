package com.services;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.BookClub;
import com.Meeting;

public class MeetingService {

    private ArrayList<Meeting> meetings = new ArrayList<>();
    private static final String FILE_NAME = "meetings.xls";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        saveMeetings();
    }

    public void loadMeetings(ArrayList<BookClub> clubs) {

        meetings.clear();
        File f = new File(FILE_NAME);

        if (!f.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = reader.readLine(); // header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                int id = Integer.parseInt(parts[0]);
                int clubId = Integer.parseInt(parts[1]);
                String type = parts[2];
                Date date = sdf.parse(parts[3]);
                String location = parts[4];

                BookClub club = clubs.stream()
                    .filter(c -> c.getId() == clubId)
                    .findFirst().orElse(null);

                if (club != null) {
                    Meeting m = new Meeting(id, club, type, date, location);
                    meetings.add(m);
                    club.getMeetings().add(m);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveMeetings() {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            
            writer.println("id;bookClubId;type;date;location");

            for (Meeting m : meetings) {
                writer.printf(
                    "%d;%d;%s;%s;%s%n",
                    m.getId(),
                    m.getBookClub().getId(),
                    m.getType(),
                    sdf.format(m.getDate()),
                    m.getLocation()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
