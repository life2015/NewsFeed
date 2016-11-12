package com.twtstudio.jcy.newsfeed.model;

import java.util.List;

/**
 * Created by jcy on 16-11-4.
 *
 * @TwtStudio Mobile Develop Team
 */

public class Sources {

    /**
     * status : ok
     * sources : [{"id":"abc-news-au","name":"ABC News (AU)","description":"Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.","url":"http://www.abc.net.au/news","category":"general","language":"en","country":"au","urlsToLogos":{"small":"http://i.newsapi.org/abc-news-au-s.png","medium":"http://i.newsapi.org/abc-news-au-m.png","large":"http://i.newsapi.org/abc-news-au-l.png"},"sortBysAvailable":["top"]},]
     */

    public String status;
    /**
     * id : abc-news-au
     * name : ABC News (AU)
     * description : Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.
     * url : http://www.abc.net.au/news
     * category : general
     * language : en
     * country : au
     * urlsToLogos : {"small":"http://i.newsapi.org/abc-news-au-s.png","medium":"http://i.newsapi.org/abc-news-au-m.png","large":"http://i.newsapi.org/abc-news-au-l.png"}
     * sortBysAvailable : ["top"]
     */

    public List<SourcesBean> sources;

    public static class SourcesBean {
        public String id;
        public String name;
        public String description;
        public String url;
        public String category;
        public String language;
        public String country;
        /**
         * small : http://i.newsapi.org/abc-news-au-s.png
         * medium : http://i.newsapi.org/abc-news-au-m.png
         * large : http://i.newsapi.org/abc-news-au-l.png
         */

        public UrlsToLogosBean urlsToLogos;
        public List<String> sortBysAvailable;

        public static class UrlsToLogosBean {
            public String small;
            public String medium;
            public String large;
        }
    }
}
