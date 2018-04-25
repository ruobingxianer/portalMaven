package portalMaven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.chenlb.mmseg4j.Word;

public class SegCompute {
	public static void main(String[] args){
		String text = ReadUtil.readAll("/Users/wanghaoxian/Desktop/portal/seg/index.txt");
		String[] strs = text.split("\n");
		File file = new File("/Users/wanghaoxian/Desktop/portal/seg/data");
		Dictionary dic = Dictionary.getInstance(file);
		Seg seg = null;
		seg = new SimpleSeg(dic);
		try {
			FileWriter writer = new FileWriter(new File("/Users/wanghaoxian/Desktop/portal/seg/indexcontent.txt"));
			for(String txt : strs){
				MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
				Word word = null;
				writer.write(txt + "|");
				while ((word = mmSeg.next()) != null) {
					if (word != null) {
						writer.write(word + "|");
					}
				}
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
