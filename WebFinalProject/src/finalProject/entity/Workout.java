package finalProject.entity;

public class Workout {
	private int id;
	private int tier1Id;
	private int tier2Id;
	private int tier3Id;
	
	public Workout() {
		this.id = -1;
		this.tier1Id = 0;
		this.tier2Id = 0;
		this.tier3Id = 0;
	}
	
	
	public Workout(int id, int tier1Id, int tier2Id, int tier3Id) {
		this.id = id;
		this.tier1Id = tier1Id;
		this.tier2Id = tier2Id;
		this.tier3Id = tier3Id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTier1Id() {
		return tier1Id;
	}


	public void setTier1Id(int tier1Id) {
		this.tier1Id = tier1Id;
	}


	public int getTier2Id() {
		return tier2Id;
	}


	public void setTier2Id(int tier2Id) {
		this.tier2Id = tier2Id;
	}


	public int getTier3Id() {
		return tier3Id;
	}


	public void setTier3Id(int tier3Id) {
		this.tier3Id = tier3Id;
	}
	
}
