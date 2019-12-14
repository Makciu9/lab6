public class SearchResult {
    private String URL;
    private int count;

    public SearchResult(String Url, int count ) {
        this.URL = Url;
        this.count = count;
    }
        public String getURL() {
            return URL;
        }

        public int getCount() {
            return count;
        }
    }

