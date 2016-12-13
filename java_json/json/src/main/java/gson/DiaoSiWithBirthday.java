package gson;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DiaoSiWithBirthday {

	private String name;
	private String school;
	private boolean has_girlfriend;
	private double age;
	private Object car;
	private Object house;
	private List<String> major;
	private String comment;
	private Date birthday;
	
	private transient String ignore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public boolean isHas_girlfriend() {
		return has_girlfriend;
	}
	public void setHas_girlfriend(boolean has_girlfriend) {
		this.has_girlfriend = has_girlfriend;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public Object getCar() {
		return car;
	}
	public void setCar(Object car) {
		this.car = car;
	}
	public Object getHouse() {
		return house;
	}
	public void setHouse(Object house) {
		this.house = house;
	}
	
	public List<String> getMajor() {
		return major;
	}
	public void setMajor(List<String> major) {
		this.major = major;
	}
	public String getIgnore() {
		return ignore;
	}
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "DiaoSi [name=" + name + ", school=" + school + ", has_girlfriend=" + has_girlfriend + ", age=" + age
				+ ", car=" + car + ", house=" + house + ", major=" + major + ", comment=" + comment
				+ ", birthday=" + birthday + "]";
	}
	
	

}
