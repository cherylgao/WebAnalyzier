import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;

public class Manager {
	String URL;
	int numWord;

	public Manager(String URL, int numWord) {
		this.URL = URL;
		this.numWord = numWord;

	}

	public ArrayList<ArrayList<String>> manage() throws Exception {
		WebCrawler wc = new WebCrawler(URL);
		Document doc = wc.connect();
		ContentExtractor se = new ContentExtractor(doc);
		StringProcessor sp;
		sp = new StringProcessor(numWord, se.parse());
		ArrayList<ArrayList<String>> result = sp.process();
		return result;
	}
}
