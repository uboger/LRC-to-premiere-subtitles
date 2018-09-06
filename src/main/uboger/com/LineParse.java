package main.uboger.com;
/**
 * 
 * @author Uboger
 * 解析单行lrc格式歌词
 *
 */
public class LineParse {
	/*
	 * 解析完成后的返回字符串数组
	 */
	private String[] timeContent = new String[2];
	/*
	 * 要解析的内容
	 */
	private String content="";
	private String pContent;
	/**
	 * 匹配标题内容
	 */
	private String headReg = "\\[([t|T|a|A]{1}[i|I|r|R|l|L]{1})[\\:].{0,}\\]";
			//"\\[[t|T|a|A][i|I|r|R|l|L]\\:[.]{0,}\\]";
	//			String reg = "\\[[t|T|a|A][i|I|r|R|l|L]\\:.{0,}\\]";
	/**
	 * 匹配非标题的一整行
	 */
	private String lineReg = "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\].{0,}";

	public LineParse(String lineContent) {
		this.content = lineContent;
		this.pContent = lineContent;

	}
	public boolean isHead() {
		return pContent.matches(headReg);
	}

	
	
	
	
	
	protected void lineParse() {
		//System.out.println(content);
		if (isHead()) {// 如果标题格式
			/*
			 * 当标题五内容时另作处理
			 * 表达式匹配第二种情况
			 * 两种情况：
			 * 一、[ar:罗心洁]
			 * 二、[al:]
			 */
			String reg = "\\[[t|T|a|A][i|I|r|R|l|L]\\:\\]";
			boolean canDo = content.matches(reg);
			content = content.replace("[", "").replace("]", "");
			if (canDo) {
				timeContent = (content+"未知").split(":");
			} else {
				
				timeContent = content.split(":");
			}

		} else {
			if (isLRC()) {
				System.out.println("=================>>>>>>>>>>>>");
				/**
				 * 正则表达式当有时间没有内容的时候另作处理
				 * 表达式匹配第二种情况
				 * 两种情况：
				 * 一、[00:14.37]演唱：罗心洁
				 * 二、[00:30.74]
				 */
				String reg = "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\]";
				boolean canDo = content.matches(reg);
				content = content.substring(1);
				content=content.replace(".", ":");
				if(canDo){
					timeContent[0]= content.replace("]", "");
					timeContent[1]=" ";
				}else{
					timeContent = content.split("]");
				}
			}
		}
	}

	public boolean isEmptyTimeContent() {
		String reg = "\\[([0-9]{2}\\:[0-5][0-9]\\.[0-9]{2})\\]";
		return pContent.matches(reg);
	}

	public boolean isLRC() {
		return pContent.matches(lineReg);
	}



	public String[] getTimeContent() {
		return timeContent;
	}

	public void setTimeContent(String[] timeContent) {
		this.timeContent = timeContent;
	}

}
