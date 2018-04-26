package portalMaven;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.chenlb.mmseg4j.Word;

public class Test {
	public static void main(String[] args){
		File file = new File("/Users/wanghaoxian/Desktop/portal/seg/data");
		Dictionary dic = Dictionary.getInstance(file);
		Seg seg = null;
		seg = new SimpleSeg(dic);
		String txt = "北京大学图书馆";
		
		
		MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
		Word word = null;
		try {
			ArrayList<Word> words = new ArrayList<Word>();
			while ((word = mmSeg.next()) != null) {
				words.add(word);
				System.out.print(word + "|");
			}
			ArrayList<String> result = SegCompute.newStrings(words);
			for(String str : result){
				System.out.print("\n"+str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
