package portalMaven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.chenlb.mmseg4j.Word;

public class SegCompute {
	public static void main(String[] args) {
		// load data
		String text = ReadUtil.readAll("/Users/wanghaoxian/Desktop/portal/seg/textAll.txt");
		String[] strs = text.split("\n");
		// load dictionary
		File file = new File("/Users/wanghaoxian/Desktop/portal/seg/data");
		Dictionary dic = Dictionary.getInstance(file);
		Seg seg = null;
		seg = new SimpleSeg(dic);
		
		HashMap<String,Integer> wordsCount = new HashMap<String,Integer>();

		try {
			FileWriter writer = new FileWriter(new File("/Users/wanghaoxian/Desktop/portal/seg/process01.txt"));
			for (String txt : strs) {
				txt = txt.trim();
				MMSeg mmSeg = new MMSeg(new StringReader(txt), seg);
				Word word = null;
				ArrayList<Word> words = new ArrayList<Word>();
				while ((word = mmSeg.next()) != null) {
					words.add(word);
				}
				if (words.size() < 2)
					continue;
				ArrayList<String> results = SegCompute.newStrings(words);
				for(String result : results){
					if(wordsCount.containsKey(result)){
						wordsCount.put(result, wordsCount.get(result)+1);
					}else{
						wordsCount.put(result,1);
					}
				}
			}
			System.out.println(wordsCount.size());
			Iterator<Entry<String, Integer>> iter = wordsCount.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String,Integer> entry = iter.next();
				if(entry.getValue()>30 || entry.getValue()<20)
					continue;
				writer.write(entry.getKey() + "|" + entry.getValue() + "\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> newStrings(ArrayList<Word> words){
		ArrayList<String> result = new ArrayList<String>();
		for(int wordCount = 2;wordCount<words.size();wordCount++){
			if(wordCount > 5)
				break;
			for(int i = 0;i<words.size()-wordCount+1;i++){
				String str = "";
				for(int j = 0;j<wordCount;j++){
					str = str+words.get(i+j).toString();
				}
				result.add(str);
			}
			
		}
		return result;
	}
}
