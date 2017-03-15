Objectives: The TechnicalQuestion project is to find the keywords of that page. 

Algorithms: The project divide the whole text into different length of substrings(one-word, two-word…) and each length forms a collection. WordCount function counts the number of appearances of each substrings in a collection and automatically filter the less frequent ones until the size of collection is less than 5. Then it removes the duplicate substring that contains in the longer substrings. In this way, the leftover substrings are the most frequent words in the page and minimize the duplicates.

The TechnicalQuestion project contains five major components: GUI, Manager, WebCrawler, ContentExtractor and StringProcessor


-GUI
GUI part uses JFrame to visualize the input and output to user. It has (a TextField that prompt user to enter an URL,) a Process button to trigger the ActionListener and process the input and a TextArea to display the result.

-Manager
Manager is intended to manage and connect all different component. In Manager, it will initiate new WebCrawler, ContentExtractor and StringProcessor. It returns the final result to GUI and display to user.

-WebCrawler
WebCrawler uses JSoup library to crawl any webpage that provided by user and return a Document object

-ContentExtractor
ContentExtractor has two main parts: parse and stemming. Parse function uses Jsoup Document object to extract title and body text and remove the stop words from them. In order to emphasize the importance of words in title, I add title words into a ArrayList<String> twice. The arraylist is then processed StringProcesssor

-StringProcessor
StringProcessor receives the wordList passed from ContentExtractor and processes them in numWord times to divide the whole content into substrings of 1,2, 3…numWord length. 
Then the wordCount function uses HashMap to count the number of appearance of each substrings. There is an initial appearance index of 3 so the filter function can extract all substrings that appeared more than 3 times. if there are more than 5 in each collection of n-length words(which means they are not really KEYwords), the program will increment the appearance index until the collection size is less than 5.
Last but not least, I would like to remove some duplicates that some words of length 1 may contains in the words of length 2 or 3 too. In this case, remove the words of length 1.

-Known Problem
If the website has robot file and refuse the crawler to crawl its page, the “robot check” string will be returned