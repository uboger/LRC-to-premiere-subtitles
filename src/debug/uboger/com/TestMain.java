package debug.uboger.com;

import java.util.HashMap;
import java.util.Map;

import main.uboger.com.LRCParse;
import main.uboger.com.LineParse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.junit.Test;

import technology.uboger.dao.LRC;
import technology.uboger.dao.TimePoint;
import technology.uboger.dao.XMLDom;
import technology.uboger.dao.XMLTools;

public class TestMain {
	@Test
	public void test1(){
		String str = "[01:35.49]该怎么交换 你才能看见我眼里的伤";
		LineParse lp = new LineParse(str);
		System.out.println(lp.getTimeContent()[0]);
		System.out.println(lp.getTimeContent()[1]);
		
	}
	@Test
	public void test2(){
		String str = "[ti:你的北京我的西江]";
		LineParse lp = new LineParse(str);
		System.out.println(lp.getTimeContent()[0]);
		System.out.println(lp.getTimeContent()[1]);
		
	}
	
	/*　基础语法 "^([]{})([]{})([]{})$"
	　　正则字符串 = "开始（[包含内容]{长度}）（[包含内容]{长度}）（[包含内容]{长度}）结束" 
	　　
	　　?,*,+,\d,\w 这些都是简写的,完全可以用[]和{}代替，在(?:)(?=)(?!)(?<=)(?<!)(?i)(*?)(+?)这种特殊组合情况下除外。
	　　初学者可以忽略?,*,+,\d,\w一些简写标示符，学会了基础使用再按表自己去等价替换
		[ti:你的北京我的西江]
		[ar:罗心洁]
		[al:]
		
		[00:00.74]你的北京我的西江
		[00:05.43]作词：玉镯儿 张超
		[00:09.49]作曲：张超
		[00:14.37]演唱：罗心洁
		[00:30.74]
		[00:33.28]从西江到北京有多远
		[00:38.99]也许你的心里更遥远
		[00:44.49]香山十月 阳光一样温暖
		
		
		
		　基础语法 "^([]{})([]{})([]{})$"
	　　正则字符串 = "开始（[包含内容]{长度}）（[包含内容]{长度}）（[包含内容]{长度}）结束" 
	
	*/
	@Test
	public void testReg(){
		//String reg1 = "[a|A][i|I|r|R|l|L]{2}\\:[.]{1,}";
		//格式是否正确
		String reg = "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\].{1,}";
		boolean b = "[09:59.09] ".matches(reg);
		System.out.println(b);
		
	}
	@Test
	public void testAl(){
		
		//格式是否正确
		String al = "[al:]";
		LineParse lp = new LineParse(al);
		System.out.println(lp.getTimeContent()[0]);
		System.out.println(lp.getTimeContent()[1]);
		
	}
	@Test
	public void testRegTi(){
		String reg = "\\[([t|T|a|A]{1}[i|I|r|R|l|L]{1})[\\:].{0,}\\]";
		//格式是否正确
		boolean b = "[ti:你的北京我的西江]".matches(reg);
		
		LineParse lp = new LineParse("[ti:你的北京我的西江]");
		
		System.out.println(lp.isHead());
		System.out.println(b);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testRegEmptyFormat(){
		String reg = "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\]";
		//String reg = "\\[[t|T|a|A][i|I|r|R|l|L]\\:.{0,}\\]";
		//格式是否正确
		//String reg1= "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\].{1,}";
		boolean b = "[00:30.74]".matches(reg);
		System.out.println(b);
		
	}
	@Test
	public void testEmptyLine(){
		
		//格式是否正确
		String al = "[00:14.37]";
		LineParse lp = new LineParse(al);
		
		
		System.out.println(lp.getTimeContent()[0]);
		System.out.println(lp.getTimeContent()[1]);
		
	}
	
	@Test
	public void tes12(){
		
		try {
			XMLDom am = new XMLDom("C:\\Users\\Uboger\\Desktop\\你的北京我的西江.lrc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void test13() throws Exception{
		Document newDoc = null;
		LRCParse parse = new LRCParse("你的北京我的西江.lrc");
		LRC lrc = parse.getLrc();
			newDoc = XMLTools.parse("muban.xml");
			Element root = newDoc.getRootElement();
			
			Element body = root.element("body");
			
			Element divNode = body.element("div");
			   for(Object o :lrc.getLyrics()){
				   Element pElement = divNode.addElement("p")
						   .addAttribute("begin",((TimePoint)o).getLrcTimeBegain())
						   .addAttribute("end", ((TimePoint)o).getLrcTimeEnd())
						   .addAttribute("region", "pop1")
						   .addAttribute("style", "basic")
						   .addAttribute("tts:origin", "36.4% 86%")
						   .addElement("style/")
						   .addElement("span")
						   .addText(((TimePoint)o).getLrcString())
						   .addElement("style")
						   .addAttribute("tts:fontSize", "18px");
			   }
			
			
			System.out.println("=============>>>>>>>><<<<<<<<<<<<================");
			System.out.println(body.asXML());
			System.out.println("=============>>>>>>>><<<<<<<<<<<<================");
	}
}
