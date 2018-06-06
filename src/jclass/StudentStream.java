package jclass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStream {
	private String name;
	private double fee;
	private double scholarship;
	public StudentStream(String name, double fee, double scholarship) {
		super();
		this.name = name;
		this.fee = fee;
		this.scholarship = scholarship;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getScholarship() {
		return scholarship;
	}
	public void setScholarship(double scholarship) {
		this.scholarship = scholarship;
	}
	public double feePaid(double fee, double scholarship) {
		return this.fee-this.scholarship;
	}
	public static void main(String[] args) {
		List<StudentStream> slist = new ArrayList<StudentStream>();
		slist.add(new StudentStream("Reshma",2000.0, 1000.0));
		slist.add(new StudentStream("Pavan",3000.0,2000.0));
		slist.add(new StudentStream("Amber",3000.0,2000.0));
		slist.add(new StudentStream("Alice",4000.0,2000.0));
		
		Double studstream = slist.stream().collect(Collectors.averagingDouble(s->s.feePaid(s.getFee(), s.getScholarship())));
		System.out.println("Students average fee"+studstream);
		List<String> studname = slist.stream().filter(s->s.feePaid(s.getFee(), s.getScholarship())>studstream).map(s->s.getName()).collect(Collectors.toList());
		System.out.println("Student names paying more than average fee"+studname.toString());
	}
	
}
