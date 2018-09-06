package technology.uboger.dao;

import main.uboger.com.LRCParse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;


public class XMLDom {
	/**
	 * 用于转载LRC歌词
	 */
	private Document newDoc;
	/**
	 * 用于装载模板xml
	 */
	private Document mubanDoc;
	/**
	 * 默认的Premiere 字幕模板文件。可以通过setMuban来设置
	 */
	private String muban = "muban.xml";
	/**
	 * 
	 * @param fileName 要解析的lrc歌词文件
	 * @throws Exception
	 */
	public XMLDom(String fileName) throws Exception{
		mubanDoc = XMLTools.parse(muban);
		this.newDoc = mubanDoc;
		
		//获取lrc歌词
		LRCParse parse = new LRCParse(fileName);
		LRC lrc = parse.getLrc();
		
		//xml根节点
		Element root  = newDoc.getRootElement();
		
		/**
		 *   	<p begin="00:02:02:00" end="00:02:55:00" region="pop1" style="basic" tts:origin="36.40625% 86.25%">
		  *             <style/>
		  *          <span>中华人民共和国
		  *            <style tts:fontSize="62px"/>
		  *     </span>
		  *   	</p>
		  *   创建上面的一个实例节点 并插入到
		  *   <bady><div>在这里插入新的节点</div></bady>
		  *   
		  */ 
		
		Element body = root.element("body");
		
		Element divNode = body.element("div");
		   for(Object o :lrc.getLyrics()){
			   Element pElement = divNode.addElement("p")
					   .addAttribute("begin",((TimePoint)o).getLrcTimeBegain())
					   .addAttribute("end", ((TimePoint)o).getLrcTimeEnd())
					   .addAttribute("region", "pop1")
					   .addAttribute("style", "basic")
					   .addAttribute("tts:origin", "10% 78.744%");
					   pElement.addElement("style");
					   pElement.addElement("span")
					   .addText(((TimePoint)o).getLrcString())
					   .addElement("style")
					   .addAttribute("tts:fontSize", "36px");
		   }
		
		
		
		
		
	}
	public void setMuban(String mubanName){
		this.muban = mubanName;
	}
	public Document getNewXMLDom(){
		return newDoc;
	}

}
