package technology.uboger.dao;

import java.io.Serializable;

/**
 * 时间线上的某个片段
 * 
 * @author Uboger
 *
 */
public class TimePoint implements Serializable{
	/*
	 * 一句歌的开始时间
	 */
	private String lrcTimeBegain;
	/*
	 * 一句歌的结束时间
	 */
	private String lrcTimeEnd;
	/*
	 * 一句歌的歌词内容
	 */
	private String lrcString;

	public String getLrcTimeBegain() {
		return lrcTimeBegain;
	}
	public void setLrcTimeBegain(String lrcTimeBegain) {
		this.lrcTimeBegain = lrcTimeBegain;
	}
	public String getLrcTimeEnd() {
		return lrcTimeEnd;
	}
	public void setLrcTimeEnd(String lrcTimeEnd) {
		this.lrcTimeEnd = lrcTimeEnd;
	}
	public String getLrcString() {
		return lrcString;
	}
	public void setLrcString(String lrcString) {
		this.lrcString = lrcString;
	}
}
