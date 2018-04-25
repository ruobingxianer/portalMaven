package portalMaven;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.chenlb.mmseg4j.Word;

public class MmsegTest {

	public static void main(String args[]) {
		
		File file = new File("/Users/wanghaoxian/Desktop/portal/seg/data");
		Dictionary dic = Dictionary.getInstance(file);
		Seg seg = null;
		seg = new SimpleSeg(dic);
		// seg = new ComplexSeg(dic);
		String txt = "陈建龙";
		
		
		MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
		Word word = null;
		try {
			while ((word = mmSeg.next()) != null) {
				if (word != null) {
					System.out.print(word + "|");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
