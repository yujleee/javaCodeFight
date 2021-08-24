package com.example.demo.vo;

public class Sist_log {
	private int no;
	private String uri;
	private String time;
	private int stay;
	private String ip;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStay() {
		return stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Sist_log(int no, String uri, String time, int stay, String ip) {
		super();
		this.no = no;
		this.uri = uri;
		this.time = time;
		this.stay = stay;
		this.ip = ip;
	}
	public Sist_log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
