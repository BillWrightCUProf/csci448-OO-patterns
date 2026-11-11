package ooconcepts.design.chords;

import java.util.List;

public class Song {
    private String title;
    private List<INote> notes;

    public Song(String title, List<INote> notes) {
        this.title = title;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void play() {
        System.out.println("Playing song: " + title);
        for (INote note : notes) {
            System.out.print( note.getName() + " ");
        }
        System.out.println();
    }
}
