package technology.uboger.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LRC implements Serializable{
	private List<HeadContent> titles = new ArrayList<HeadContent>();
	private List<TimePoint> lyrics = new ArrayList<TimePoint>();
	public List<HeadContent> getTitles() {
		return titles;
	}
	public void setTitles(List<HeadContent> titles) {
		this.titles = titles;
	}
	public List<TimePoint> getLyrics() {
		return lyrics;
	}
	public void setLyrics(List<TimePoint> lyrics) {
		this.lyrics = lyrics;
	}


}
