package logOfJava;

import java.util.ArrayList;
import java.util.List;

public class Job {
	// 기본 스탯
	// 체력 기본 수치 : 50 * 배수
	// 근력 + 지능 기본 수치 : 5 * 배수
	// 행운 기본 수치 : 10% * 배수
	// 보너스 기본 수치 : 10% * 배수
	private String job;
	private int jobHP;
	private int jobATK;
	private int jobINT;
	private int jobLUCK;
	private int jobBONUS;
	
	// 배수용 배열
	private int[] statList = new int[5];
	
	// 기본 생성자
	public Job() {}
	
	public Job(String job) {
		this.job = job;
		
		switch(job) {
		case "검사" :
			this.jobHP = 150;
			this.jobATK = 15;
			this.jobINT = 5;
			this.jobLUCK = 20;
			this.jobBONUS = 10;
			
			statList[0] = 3;
			statList[1] = 3;
			statList[2] = 1;
			statList[3] = 2;
			statList[4] = 1;
			break;
		case "궁수" :
			this.jobHP = 100;
			this.jobATK = 10;
			this.jobINT = 10;
			this.jobLUCK = 20;
			this.jobBONUS = 20;
			
			statList[0] = 2;
			statList[1] = 2;
			statList[2] = 2;
			statList[3] = 2;
			statList[4] = 2;
			break;
		case "마법사" :
			this.jobHP = 50;
			this.jobATK = 5;
			this.jobINT = 15;
			this.jobLUCK = 30;
			this.jobBONUS = 20;
			
			statList[0] = 1;
			statList[1] = 1;
			statList[2] = 3;
			statList[3] = 3;
			statList[4] = 2;
			break;
		case "도적" :
			this.jobHP = 100;
			this.jobATK = 5;
			this.jobINT = 5;
			this.jobLUCK = 30;
			this.jobBONUS = 30;
			
			statList[0] = 2;
			statList[1] = 1;
			statList[2] = 1;
			statList[3] = 3;
			statList[4] = 3;
			break;
		default :
		}
	}
	
	// getter, setter
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getJobHP() {
		return jobHP;
	}

	public void setJobHP(int jobHP) {
		this.jobHP = jobHP;
	}

	public int getJobATK() {
		return jobATK;
	}

	public void setJobATK(int jobATK) {
		this.jobATK = jobATK;
	}

	public int getJobINT() {
		return jobINT;
	}

	public void setJobINT(int jobINT) {
		this.jobINT = jobINT;
	}

	public int getJobLUCK() {
		return jobLUCK;
	}

	public void setJobLUCK(int jobLUCK) {
		this.jobLUCK = jobLUCK;
	}

	public int getJobBONUS() {
		return jobBONUS;
	}

	public void setJobBONUS(int jobBONUS) {
		this.jobBONUS = jobBONUS;
	}

	public int[] getStatList() {
		return statList;
	}

	public void setStatList(int[] statList) {
		this.statList = statList;
	}
}
