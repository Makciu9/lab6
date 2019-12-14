

public class TestResult {

        private String URL;
        private Long time;

        public TestResult(String URL, Long time ) {
            this.URL = URL;
            this.time = time;
        }
        public String getURL() {
            return URL;
        }

        public Long getTime() {
            return time;
        }
    }

