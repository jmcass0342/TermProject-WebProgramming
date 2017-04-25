package finalProject.entity;

public class Exercise {
	private int id;
	private String exerciseName;
	private String video;
	private int tier;
	
	public Exercise() {
		this.id = -1;
		this.exerciseName = null;
		this.video = null;
		this.tier = 0;
	}
	
	public Exercise(int id, String exerciseName, String video, int tier) {
		this.id = id;
		this.exerciseName = exerciseName;
		this.video = video;
		this.tier = tier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
	
	
	
}
