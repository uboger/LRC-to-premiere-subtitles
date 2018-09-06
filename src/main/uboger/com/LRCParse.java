package main.uboger.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;

import technology.uboger.dao.HeadContent;
import technology.uboger.dao.LRC;
import technology.uboger.dao.TimePoint;

public class LRCParse {
	private File LRCDocs;// 歌词文件对象

	private BufferedReader bf;// 逐行读取歌词文件对象

	private Reader in;// 歌词文件流

	private String filePath;// 歌词文件路径

	private LRC lrc = new LRC();

	public LRC getLrc() {
		return lrc;
	}

	public LRCParse() {// 无参构造函数
	}

	public LRCParse(String path) {
		LRCDocs = new File(path);
		System.out.print("歌词文件努力加载中");
		Random ran = new Random();
		for (int i = 0; i <= (ran.nextInt(4) + 2); i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		System.out.println("歌词加载" + (LRCDocs.isFile() ? "成功!" : "失败!"));

		parse();

	}

	public void parse() {
		try {
			in = new InputStreamReader(new FileInputStream(LRCDocs));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bf = new BufferedReader(in);

	


		try {

			String currentLine = "";
			
			String nextLine = "";
			
			while ((nextLine = bf.readLine()) != null) {
			
			//debug发现第一行读取到一个空格，所以要清除空格
				
				
				if(!currentLine.equals("")&&!nextLine.equals("")){
					
					LineParse  parse = new LineParse(currentLine);
					
					LineParse nlp = new LineParse(nextLine);
					TimePoint tp = new TimePoint();
					//System.out.print(currentLine + parse.isHead());
					//System.out.println();
					if(parse.isHead()){
						
						parse.lineParse();
						HeadContent hc = new HeadContent();
						hc.setDuty(parse.getTimeContent()[0]);
						hc.setName(parse.getTimeContent()[1]);
						lrc.getTitles().add(hc);
					}
					if(parse.isLRC()){
						//System.out.println(currentLine);
						parse.lineParse();
						nlp.lineParse();
						tp.setLrcString(parse.getTimeContent()[1]);
						tp.setLrcTimeBegain(parse.getTimeContent()[0]);
						tp.setLrcTimeEnd(nlp.getTimeContent()[0]);
						this.lrc.getLyrics().add(tp);
					}
				
				}
				if(!nextLine.equals("")){//如果有内容
					int i =nextLine.charAt(0);
					if(i==65279)
						//删除65279
						nextLine = nextLine.substring(1);
					currentLine = nextLine;
					nextLine = "";
				}else{
					//continue;
				}
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		new LRCParse(filePath);

	}

	public static void main(String[] args) throws Exception {
		LRCParse parse = new LRCParse("你的北京我的西江.lrc");


		// String str = "[00:00.74]你的北京我的西江";

		// System.out.println(str.substring(1));

	}

}
