package portalMaven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regEx {
	
	public static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	public static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	public static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	public static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符
	public static final String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";// 定义所有w标签
	public static final String regEx_zhushi = "<!--[\\w\\W\r\\n]*?-->"; // 定义注释标签的正则表达式
	public static final String regEx_biaodian_cn_a = "[\u3002\uff1b\uff0c\uff1a\u201c\u201d\uff08\uff09\u3001\uff1f\u300a\u300b]";
	public static final String regEx_biaodian_cn_b = "。 ；  ， ： “ ”（ ） 、 ？ 《 》";
	public static final String regEx_biaodian_en = "[-,.?:;'\"!`]|(-{2})|(/.{3})|(/(/))|(/[/])";
	public static final String regEx_number = "[0-9]";
	public static final String regEx_cn = "[\\u4e00-\\u9fa5]";
	
	public static void main(String[] args){
		String str = "2018";
		Pattern p = Pattern.compile(regEx.regEx_cn);  
		Matcher m = p.matcher(str); 
		System.out.println(m.find());
		
		
	}

}
