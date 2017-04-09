package finalProject.entity;

import java.sql.Date;

public class HasProgram {
	private int id;
	private int userId;
	private int programId;
	private Date startDate;
	private Date endDate;
	
	public HasProgram() {
		id = -1;
		userId = -1;
		programId = -1;
		startDate = null;
		endDate = null;
	}

	public HasProgram(int id, int userId, int programId, Date startDate, Date endDate) {
		this.id = id;
		this.userId = userId;
		this.programId = programId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
