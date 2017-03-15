import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringProcessor {
	int numWord;
	List<String> wordList;

	public StringProcessor(int numWord, List<String> wordList) {
		this.numWord = numWord;
		this.wordList = wordList;
	}

	public ArrayList<ArrayList<String>> process() throws IOException {
		ArrayList<ArrayList<String>> bigCount = new ArrayList<>();
		for (int i = 1; i <= numWord; i++) {
			int initial = 3;// initial number of appearances, will increase automatically if there are too many results
			HashMap<String, Integer> list = wordCount(wordList, i);
			if (list != null) {
				ArrayList<String> tmpClean = filter(list, initial);
				// if the collection size is over 5, then increment the initial index to raise the number of appearance required
				while (tmpClean.size() > 5) {
					initial++;
					tmpClean = filter(list, initial - i);
				}
				bigCount.add(new ArrayList(tmpClean));
			}
		}
		// remove duplicates(if two one-words are contained in one two-words,
		// remove the one-words)
		for (int i = bigCount.size() - 1; i >= 0; i--) {
			ArrayList<String> cur = bigCount.get(i);
			for (int j = i - 1; j >= 0; j--) {
				ArrayList<String> compare = bigCount.get(j);
				for (int x = 0; x < cur.size(); x++) {
					for (int y = 0; y < compare.size(); y++) {
						String l = cur.get(x);
						String s = compare.get(y);
						if (isSubstring(s, l)) {
							compare.remove(y);
							y--;
						}

					}
				}
			}
		}
		return bigCount;
	}

	public HashMap<String, Integer> wordCount(List<String> text, int numWord) {
		HashMap<String, Integer> map = new HashMap<>();
		if (text == null || text.size() == 0)
			return null;
		for (int i = 0; i < text.size() - numWord + 1; i++) {
			String tmp = text.get(i);
			//modify the word length: 2-word substring, 3-word substring...
			for (int j = 1; j < numWord; j++) {
				tmp += " ";
				tmp += text.get(i + j);
			}
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}

		return map;
	}

	public ArrayList<String> filter(HashMap<String, Integer> map, int count) {
		ArrayList<String> result = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= count)
				result.add(entry.getKey());
		}
		return result;

	}

	public boolean isSubstring(String s, String l) {
		// to see if the short string is a substring of the long one(if long one contains the short word)
		if (s.length() > l.length())
			return false;
		else {
			int j = 0;
			for (int i = 0; i < l.length() && j < s.length(); i++) {
				if (l.charAt(i) == s.charAt(j))
					j++;
				else
					j = 0;
			}
			if (j == s.length())
				return true;
			else
				return false;
		}
	}

}
