import java.lang.management.ClassLoadingMXBean;
import java.util.ArrayList;
import java.util.Collection;

// A music object is made up 2 string; song name and artist
class Music {
	String song;
	String artist;

	public Music(String song, String artist) {
		this.song = song;
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return String.format("%-21s: %s", song, artist);
	}
}

// Each node will hold on to a song and the following song in the queue (the next node)
class Node {
	Music song;
	Node next;

	public Node(Music song) {
		this.song = song;
	}

	public Node() {
	}

	@Override
	public String toString() {
		if (song == null) {
			return "";
		}
		return song.toString();
	}
}

public class Spotify {
	Node current;
	Node last;

	/*
	 * TODO: You will take in a list of songs, in the form of arraylist, linkedlist,
	 * etc (Collection) and you will add that to the end of your queue
	 */
	public void addAll(Collection<Music> listOfSongs) {
		for (Music music : listOfSongs) {
			Node n = new Node(music);
			if(this.current == null ){
				this.current = n;
				this.last = n;
				continue;
			}
			this.last.next = n;
			this.last = this.last.next;
		}
		this.last.next = this.current;
	}

	/*
	 * TODO: You will remove the song that is in the 1st position
	 */
	public void removeSong() {
		//Node t = this.current;
		this.current = this.current.next;
		this.last.next = this.current;
	}

	/*
	 * TODO: You will add a song to the end of the queue
	 */
	public void addSong(Music song) {
		Node n = new Node(song);
		if(this.current == null){
			this.current = n;
			this.last = n;
		}
		this.last.next = n;
		this.last = this.last.next;
		this.last.next = this.current;
	}

	/*
	 * TODO: You will rotate the queue so that we are now listening to the next song
	 */
	public void nextSong() {
		Node n = this.current;
		this.current = this.current.next;
		this.last = n;
		this.last.next = this.current;
	}

	/*
	 * TODO: You will rotate the queue so that we are now listening to the previous
	 * song
	 */
	public void prevSong() {
		Node n = this.last;
		Node temp = current;
		while (temp.next != null) {
			if(temp.next == last){
				this.last = temp;
				break;
			}
			temp = temp.next;
		}
		this.current = n;
	}

	/*
	 * TODO: You will tell us the song in the 1st position
	 */
	public Music currentSong() {
		return this.current == null ? null : this.current.song;
	}

	// use String.format( "%3s) %s\n", i, theCurrentNode );
	// i: the count starting at 1
	// theCurrentNode: current song node
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("=====[Current Queue]=====\n");
		if (current == null) {
			stringBuilder.append("no songs\n");
			return stringBuilder.toString();
		}
		Node temp = current;

		int i = 1;
		while (temp.next != null && temp.next != last.next) {
			System.out.println(temp);
			System.out.println(temp.next);
			stringBuilder.append(String.format("%3s) %s\n", i, temp));
			temp = temp.next;
			i++;
		}

		stringBuilder.append(String.format("%3s) %s\n", i, temp));

		return stringBuilder.toString();

	}

	public static void main(String[] args) {
		// Example 1
		/* ArrayList<Music> songs = new ArrayList<>();
		songs.add(new Music("Happy birthday", "shawn"));
		songs.add(new Music("Space Cadet", "Metro Boomin"));
		songs.add(new Music("100", "The Game"));

		Spotify spotify = new Spotify();
		spotify.addAll(songs);

		String ans = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
				+ "  2) Space Cadet          : Metro Boomin\n" + "  3) 100                  : The Game\n";

		String expectedAnswer = ans.replaceAll("\\s", "");
		String actualAnswer = spotify.toString().replaceAll("\\s", "");

		System.out.println(expectedAnswer);
		System.out.println(actualAnswer);

		if (expectedAnswer.equals(actualAnswer)) {
			System.out.println("Example 1 working");
		} else {
			System.out.println("Issue in example 1");
		} */

		//Prev

		/* ArrayList<Music> songs = new ArrayList<>();
		songs.add(new Music("Happy birthday", "shawn"));
		songs.add(new Music("Space Cadet", "Metro Boomin"));
		songs.add(new Music("100", "The Game"));
		songs.add(new Music("L@D", "A@AP Rocky"));
		songs.add(new Music("Hot Man", "Bobby Shmurda"));
		songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
		songs.add(new Music("Im Sad", "Aubrey"));
		songs.add(new Music("Happy birthday", "shawn"));

		String inputString = "[new Music(\"Happy birthday\", \"shawn\"),"
				+ "new Music(\"Space Cadet\", \"Metro Boomin\"), new Music(\"100\", \"The Game\"), "
				+ "new Music(\"L@D\", \"A@AP Rocky\"), new Music(\"Hot Man\", \"Bobby Shmurda\"), "
				+ "new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), new Music(\"Im Sad\", \"Aubrey\"), "
				+ "new Music(\"Happy birthday\", \"shawn\")]";

		Spotify spotify = new Spotify();
		spotify.addAll(songs);

		System.out.println(spotify);

		for (int i = 0; i < 3; i++) {
			spotify.prevSong();
		}
		String ans1 = "=====[Current Queue]=====\n" + "  1) Men in Paris         : Kanye East and Jay-Y\n"
				+ "  2) Im Sad               : Aubrey \n" + "  3) Happy birthday       : shawn\n"
				+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
				+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n"
				+ "  8) Hot Man              : Bobby Shmurda\n";

		String expAns1 = ans1;
		String actAns1 = spotify.toString();

		//System.out.println(spotify);

		System.out.println(expAns1);
		System.out.println(actAns1); */
	}
}
