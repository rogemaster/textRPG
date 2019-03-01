package textRPGt2.window;

public class Histo {
	private int time;
	private String story;
	
	public Histo(int time, String story) {
		super();
		this.time = time;
		this.story = story;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}

	public String toString(){
		
		return "[" + time + "]" + story;
		
	}
	
	
}
