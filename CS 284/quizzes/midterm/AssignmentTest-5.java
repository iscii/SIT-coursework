import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.jh61b.junit.JUnitUtilities;

public class AssignmentTest {
	@Test
	@GradedTest(name = "Test addAll()", max_score = 10)
	public void testAddAll() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey "));

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"), new Music(\"Space Cadet\", \"Metro Boomin\"), "
					+ "new Music(\"100\", \"The Game\"), new Music(\"L@D\", \"A@AP Rocky\"), "
					+ "new Music(\"Hot Man\", \"Bobby Shmurda\"), new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), "
					+ "new Music(\"Im Sad\", \"Aubrey \")]";

			Spotify spotify = new Spotify();
			spotify.addAll(songs);

			String ans = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
					+ "  2) Space Cadet          : Metro Boomin\n" + "  3) 100                  : The Game\n"
					+ "  4) L@D                  : A@AP Rocky\n" + "  5) Hot Man              : Bobby Shmurda\n"
					+ "  6) Men in Paris         : Kanye East and Jay-Y\n" + "  7) Im Sad               : Aubrey \n";

			String expAns = ans; // .replaceAll("\\s", "");
			String actAns = spotify.toString(); // .replaceAll("\\s", "");

			if (!expAns.replaceAll("\\s", "").equals(actAns.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns, actAns));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test addSong()", max_score = 10)
	public void testAddSong() {
		try {
			Spotify spotify = new Spotify();

			spotify.addSong(new Music("Happy birthday", "shawn"));
			spotify.addSong(new Music("Space Cadet", "Metro Boomin"));
			spotify.addSong(new Music("100", "The Game"));
			spotify.addSong(new Music("L@D", "A@AP Rocky"));
			spotify.addSong(new Music("Hot Man", "Bobby Shmurda"));
			spotify.addSong(new Music("Men in Paris", "Kanye East and Jay-Y"));
			spotify.addSong(new Music("Im Sad", "Aubrey "));

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"), new Music(\"Space Cadet\", \"Metro Boomin\"), "
					+ "new Music(\"100\", \"The Game\"), new Music(\"L@D\", \"A@AP Rocky\"), "
					+ "new Music(\"Hot Man\", \"Bobby Shmurda\"), new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), "
					+ "new Music(\"Im Sad\", \"Aubrey \")]";

			String ans = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
					+ "  2) Space Cadet          : Metro Boomin\n" + "  3) 100                  : The Game\n"
					+ "  4) L@D                  : A@AP Rocky\n" + "  5) Hot Man              : Bobby Shmurda\n"
					+ "  6) Men in Paris         : Kanye East and Jay-Y\n" + "  7) Im Sad               : Aubrey \n";

			String expAns = ans; // .replaceAll("\\s", "");
			String actAns = spotify.toString(); // .replaceAll("\\s", "");

			if (!expAns.replaceAll("\\s", "").equals(actAns.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns, actAns));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test removeSong()", max_score = 10)
	public void testRemoveSong() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey "));
			Spotify spotify = new Spotify();
			add(spotify, songs);

			spotify.removeSong();

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"), new Music(\"Space Cadet\", \"Metro Boomin\"), "
					+ "new Music(\"100\", \"The Game\"), new Music(\"L@D\", \"A@AP Rocky\"), "
					+ "new Music(\"Hot Man\", \"Bobby Shmurda\"), new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), "
					+ "new Music(\"Im Sad\", \"Aubrey \")]";

			String ans = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Hot Man              : Bobby Shmurda\n"
					+ "  5) Men in Paris         : Kanye East and Jay-Y\n" + "  6) Im Sad               : Aubrey \n";

			String expAns = ans; // .replaceAll("\\s", "");
			String actAns = spotify.toString(); // .replaceAll("\\s", "");

			if (!expAns.replaceAll("\\s", "").equals(actAns.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns, actAns));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test next1()", max_score = 10)
	public void testNext1() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey"));
			songs.add(new Music("Happy birthday", "shawn"));
			Spotify spotify = new Spotify();

			add(spotify, songs);

			for (int i = 0; i < 3; i++) {
				spotify.nextSong();
			}

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"),"
					+ "new Music(\"Space Cadet\", \"Metro Boomin\"), new Music(\"100\", \"The Game\"), "
					+ "new Music(\"L@D\", \"A@AP Rocky\"), new Music(\"Hot Man\", \"Bobby Shmurda\"), "
					+ "new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), new Music(\"Im Sad\", \"Aubrey\"), "
					+ "new Music(\"Happy birthday\", \"shawn\")]";

			String ans1 = "=====[Current Queue]=====\n" + "  1) L@D                  : A@AP Rocky\n"
					+ "  2) Hot Man              : Bobby Shmurda\n"
					+ "  3) Men in Paris         : Kanye East and Jay-Y\n" + "  4) Im Sad               : Aubrey \n"
					+ "  5) Happy birthday       : shawn\n" + "  6) Happy birthday       : shawn\n"
					+ "  7) Space Cadet          : Metro Boomin\n" + "  8) 100                  : The Game\n";

			String expAns1 = ans1; // .replaceAll("\\s", "");
			String actAns1 = spotify.toString(); // .replaceAll("\\s", "");

			if (!expAns1.replaceAll("\\s", "").equals(actAns1.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns1, actAns1));
			}

			assertEquals(ans1.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test next2()", max_score = 10)
	public void testNext2() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey"));
			songs.add(new Music("Happy birthday", "shawn"));
			Spotify spotify = new Spotify();

			add(spotify, songs);

			for (int i = 0; i < 3; i++) {
				spotify.nextSong();
			}

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"),"
					+ "new Music(\"Space Cadet\", \"Metro Boomin\"), new Music(\"100\", \"The Game\"), "
					+ "new Music(\"L@D\", \"A@AP Rocky\"), new Music(\"Hot Man\", \"Bobby Shmurda\"), "
					+ "new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), new Music(\"Im Sad\", \"Aubrey\"), "
					+ "new Music(\"Happy birthday\", \"shawn\")]";

			for (int i = 0; i < 12; i++) {
				spotify.nextSong();
			}

			String ans2 = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
					+ "  2) Happy birthday       : shawn\n" + "  3) Space Cadet          : Metro Boomin\n"
					+ "  4) 100                  : The Game\n" + "  5) L@D                  : A@AP Rocky\n"
					+ "  6) Hot Man              : Bobby Shmurda\n"
					+ "  7) Men in Paris         : Kanye East and Jay-Y\n" + "  8) Im Sad               : Aubrey \n";

			String expAns2 = ans2;
			String actAns2 = spotify.toString();

			if (!expAns2.replaceAll("\\s", "").equals(actAns2.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns2, actAns2));
			}

			assertEquals(ans2.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test prev1()", max_score = 5)
	public void testPrev1() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
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

			add(spotify, songs);

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

			if (!expAns1.replaceAll("\\s", "").equals(actAns1.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns1, actAns1));
			}

			assertEquals(ans1.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test prev2()", max_score = 5)
	public void testPrev2() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
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

			add(spotify, songs);

			for (int i = 0; i < 3; i++) {
				spotify.prevSong();
			}

			for (int i = 0; i < 4; i++) {
				spotify.prevSong();
			}

			String ans2 = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Hot Man              : Bobby Shmurda\n"
					+ "  5) Men in Paris         : Kanye East and Jay-Y\n" + "  6) Im Sad               : Aubrey \n"
					+ "  7) Happy birthday       : shawn\n" + "  8) Happy birthday       : shawn\n";

			String expAns2 = ans2;
			String actAns2 = spotify.toString();

			if (!expAns2.replaceAll("\\s", "").equals(actAns2.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns2, actAns2));
			}

			assertEquals(ans2.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test prev3()", max_score = 10)
	public void testPrev3() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
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

			add(spotify, songs);

			for (int i = 0; i < 3; i++) {
				spotify.prevSong();
			}

			for (int i = 0; i < 4; i++) {
				spotify.prevSong();
			}

			for (int i = 0; i < 12; i++) {
				spotify.prevSong();
			}

			String ans3 = "=====[Current Queue]=====\n" + "  1) Men in Paris         : Kanye East and Jay-Y\n"
					+ "  2) Im Sad               : Aubrey \n" + "  3) Happy birthday       : shawn\n"
					+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
					+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n"
					+ "  8) Hot Man              : Bobby Shmurda\n";

			String expAns3 = ans3;
			String actAns3 = spotify.toString();

			if (!expAns3.replaceAll("\\s", "").equals(actAns3.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, expAns3, actAns3));
			}

			assertEquals(ans3.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	@Test
	@GradedTest(name = "Test currentSong()", max_score = 10)
	public void testCurrentSong() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey "));

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"), "
					+ "new Music(\"Space Cadet\", \"Metro Boomin\"), new Music(\"100\", \"The Game\"), "
					+ "new Music(\"L@D\", \"A@AP Rocky\"), new Music(\"Hot Man\", \"Bobby Shmurda\"), "
					+ "new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), new Music(\"Im Sad\", \"Aubrey \")]";

			Spotify spotify = new Spotify();
			assertNull(spotify.currentSong());
			add(spotify, songs);

			String answerString = "Happy birthday       : shawn"; // .replaceAll("\\s", "");
			String actualString = spotify.currentSong().toString(); // .replaceAll("\\s", "");

			if (!answerString.replaceAll("\\s", "").equals(actualString.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, answerString, actualString));
			}

			assertEquals("Happy birthday       : shawn".replaceAll("\\s", ""),
					spotify.currentSong().toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}

	}

	@Test
	@GradedTest(name = "Test Hidden", max_score = 20, visibility = "hidden")
	public void testHidden() {
		try {
			ArrayList<Music> songs = new ArrayList<>();
			songs.add(new Music("Happy birthday", "shawn"));
			songs.add(new Music("Space Cadet", "Metro Boomin"));
			songs.add(new Music("100", "The Game"));
			songs.add(new Music("L@D", "A@AP Rocky"));
			songs.add(new Music("Hot Man", "Bobby Shmurda"));
			songs.add(new Music("Men in Paris", "Kanye East and Jay-Y"));
			songs.add(new Music("Im Sad", "Aubrey "));

			String inputString = "[new Music(\"Happy birthday\", \"shawn\"), "
					+ "new Music(\"Space Cadet\", \"Metro Boomin\"), new Music(\"100\", \"The Game\"), "
					+ "new Music(\"L@D\", \"A@AP Rocky\"), new Music(\"Hot Man\", \"Bobby Shmurda\"), "
					+ "new Music(\"Men in Paris\", \"Kanye East and Jay-Y\"), new Music(\"Im Sad\", \"Aubrey \")]";

			Spotify spotify = new Spotify();

			spotify.addAll(songs);
			String ans = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
					+ "  2) Space Cadet          : Metro Boomin\n" + "  3) 100                  : The Game\n"
					+ "  4) L@D                  : A@AP Rocky\n" + "  5) Hot Man              : Bobby Shmurda\n"
					+ "  6) Men in Paris         : Kanye East and Jay-Y\n" + "  7) Im Sad               : Aubrey \n";

			if (!ans.replaceAll("\\s", "").equals(spotify.toString().replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, ans, spotify.toString()));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			String curAns = "Happy birthday       : shawn"; // .replaceAll("\\s", "");
			String actCurAns = spotify.currentSong().toString(); // .replaceAll("\\s", "");

			if (!curAns.equals(actCurAns)) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns, actCurAns));
			}

			assertEquals("Happy birthday       : shawn".replaceAll("\\s", ""),
					spotify.currentSong().toString().replaceAll("\\s", ""));

			spotify.removeSong();
			ans = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Hot Man              : Bobby Shmurda\n"
					+ "  5) Men in Paris         : Kanye East and Jay-Y\n" + "  6) Im Sad               : Aubrey \n";

			String curAns1 = ans; // .replaceAll("\\s", "");
			String actAns1 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns1.replaceAll("\\s", "").equals(actAns1.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns1, actAns1));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			spotify.addSong(new Music("Happy birthday", "shawn"));
			ans = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Hot Man              : Bobby Shmurda\n"
					+ "  5) Men in Paris         : Kanye East and Jay-Y\n" + "  6) Im Sad               : Aubrey \n"
					+ "  7) Happy birthday       : shawn\n";

			String curAns2 = ans; // .replaceAll("\\s", "");
			String actAns2 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns2.replaceAll("\\s", "").equals(actAns2.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns2, actAns2));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 3; i++) {
				spotify.nextSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) Hot Man              : Bobby Shmurda\n"
					+ "  2) Men in Paris         : Kanye East and Jay-Y\n" + "  3) Im Sad               : Aubrey \n"
					+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
					+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n";

			String curAns3 = ans; // .replaceAll("\\s", "");
			String actAns3 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns3.replaceAll("\\s", "").equals(actAns3.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns3, actAns3));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 3; i++) {
				spotify.prevSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Hot Man              : Bobby Shmurda\n"
					+ "  5) Men in Paris         : Kanye East and Jay-Y\n" + "  6) Im Sad               : Aubrey \n"
					+ "  7) Happy birthday       : shawn\n";

			String curAns4 = ans; // .replaceAll("\\s", "");
			String actAns4 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns4.replaceAll("\\s", "").equals(actAns4.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns4, actAns4));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 4; i++) {
				spotify.prevSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) Hot Man              : Bobby Shmurda\n"
					+ "  2) Men in Paris         : Kanye East and Jay-Y\n" + "  3) Im Sad               : Aubrey \n"
					+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
					+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n";

			String curAns5 = ans; // .replaceAll("\\s", "");
			String actAns5 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns5.replaceAll("\\s", "").equals(actAns5.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns5, actAns5));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 12; i++) {
				spotify.nextSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) 100                  : The Game\n"
					+ "  2) L@D                  : A@AP Rocky\n" + "  3) Hot Man              : Bobby Shmurda\n"
					+ "  4) Men in Paris         : Kanye East and Jay-Y\n" + "  5) Im Sad               : Aubrey \n"
					+ "  6) Happy birthday       : shawn\n" + "  7) Space Cadet          : Metro Boomin\n";

			String curAns6 = ans; // .replaceAll("\\s", "");
			String actAns6 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns6.replaceAll("\\s", "").equals(actAns6.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns6, actAns6));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 12; i++) {
				spotify.prevSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) Hot Man              : Bobby Shmurda\n"
					+ "  2) Men in Paris         : Kanye East and Jay-Y\n" + "  3) Im Sad               : Aubrey \n"
					+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
					+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n";

			String curAns7 = ans; // .replaceAll("\\s", "");
			String actAns7 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns7.replaceAll("\\s", "").equals(actAns7.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns7, actAns7));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			ArrayList<Music> songs2 = new ArrayList<>();
			songs2.add(new Music("Nikes On My Feet", "Mac Miller"));
			songs2.add(new Music("Life Is Good", "Future "));
			songs2.add(new Music("SICKO MODE", "Travis Scott"));

			spotify.addAll(songs2);
			ans = "=====[Current Queue]=====\n" + "  1) Hot Man              : Bobby Shmurda\n"
					+ "  2) Men in Paris         : Kanye East and Jay-Y\n" + "  3) Im Sad               : Aubrey \n"
					+ "  4) Happy birthday       : shawn\n" + "  5) Space Cadet          : Metro Boomin\n"
					+ "  6) 100                  : The Game\n" + "  7) L@D                  : A@AP Rocky\n"
					+ "  8) Nikes On My Feet     : Mac Miller\n" + "  9) Life Is Good         : Future \n"
					+ " 10) SICKO MODE           : Travis Scott\n";

			String curAns8 = ans; // .replaceAll("\\s", "");
			String actAns8 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns8.replaceAll("\\s", "").equals(actAns8.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns8, actAns8));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			for (int i = 0; i < 8; i++) {
				spotify.nextSong();
			}

			ans = "=====[Current Queue]=====\n" + "  1) Life Is Good         : Future \n"
					+ "  2) SICKO MODE           : Travis Scott\n" + "  3) Hot Man              : Bobby Shmurda\n"
					+ "  4) Men in Paris         : Kanye East and Jay-Y\n" + "  5) Im Sad               : Aubrey \n"
					+ "  6) Happy birthday       : shawn\n" + "  7) Space Cadet          : Metro Boomin\n"
					+ "  8) 100                  : The Game\n" + "  9) L@D                  : A@AP Rocky\n"
					+ " 10) Nikes On My Feet     : Mac Miller\n";

			String curAns9 = ans; // .replaceAll("\\s", "");
			String actAns9 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns9.replaceAll("\\s", "").equals(actAns9.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns9, actAns9));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			String curAns10 = "Life Is Good         : Future"; // .replaceAll("\\s", "");
			String actAns10 = spotify.currentSong().toString(); // .replaceAll("\\s", "");

			if (!curAns10.replaceAll("\\s", "").equals(actAns10.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns10, actAns10));
			}

			assertEquals("Life Is Good         : Future".replaceAll("\\s", ""),
					spotify.currentSong().toString().replaceAll("\\s", ""));

			for (int i = 0; i < 15; i++) {
				spotify.prevSong();
			}
			ans = "=====[Current Queue]=====\n" + "  1) Happy birthday       : shawn\n"
					+ "  2) Space Cadet          : Metro Boomin\n" + "  3) 100                  : The Game\n"
					+ "  4) L@D                  : A@AP Rocky\n" + "  5) Nikes On My Feet     : Mac Miller\n"
					+ "  6) Life Is Good         : Future \n" + "  7) SICKO MODE           : Travis Scott\n"
					+ "  8) Hot Man              : Bobby Shmurda\n"
					+ "  9) Men in Paris         : Kanye East and Jay-Y\n" + " 10) Im Sad               : Aubrey \n";

			String curAns11 = ans; // .replaceAll("\\s", "");
			String actAns11 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns11.replaceAll("\\s", "").equals(actAns11.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns11, actAns11));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));

			spotify.removeSong();
			ans = "=====[Current Queue]=====\n" + "  1) Space Cadet          : Metro Boomin\n"
					+ "  2) 100                  : The Game\n" + "  3) L@D                  : A@AP Rocky\n"
					+ "  4) Nikes On My Feet     : Mac Miller\n" + "  5) Life Is Good         : Future \n"
					+ "  6) SICKO MODE           : Travis Scott\n" + "  7) Hot Man              : Bobby Shmurda\n"
					+ "  8) Men in Paris         : Kanye East and Jay-Y\n" + "  9) Im Sad               : Aubrey \n";

			String curAns12 = ans; // .replaceAll("\\s", "");
			String actAns12 = spotify.toString(); // .replaceAll("\\s", "");

			if (!curAns12.replaceAll("\\s", "").equals(actAns12.replaceAll("\\s", ""))) {
				System.out.println(JUnitUtilities.get_error_message("", inputString, curAns12, actAns12));
			}

			assertEquals(ans.replaceAll("\\s", ""), spotify.toString().replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			assertEquals(1, 0);
		}
	}

	private void add(Spotify spotify, Collection<Music> listOfSongs) {
		boolean flag = false;
		if (spotify.current == null) {
			spotify.current = new Node();
			flag = true;
		}

		Node temp;
		if (spotify.last == null) {
			temp = spotify.current;
		} else {
			temp = spotify.last;
		}

		for (Music m : listOfSongs) {
			temp.next = new Node(m);
			temp = temp.next;
		}
		spotify.last = temp;

		if (flag) {
			spotify.current = spotify.current.next;
		}
		spotify.last.next = spotify.current;

	}
}