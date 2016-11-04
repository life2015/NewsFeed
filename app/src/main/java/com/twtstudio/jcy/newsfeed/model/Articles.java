package com.twtstudio.jcy.newsfeed.model;

import java.util.List;

/**
 * Created by jcy on 16-11-4.
 *
 * @TwtStudio Mobile Develop Team
 */

public class Articles {

    /**
     * status : ok
     * source : abc-news-au
     * sortBy : top
     * articles : [{"author":"http://www.abc.net.au/news/alexandra-beech/6902724","title":"Abuse victims to get up to $150k each under new compo scheme","description":"The Federal Government has announced a compensation scheme for victims of institutional child sexual abuse, with survivors able to access up to $150,000 each.","url":"http://www.abc.net.au/news/2016-11-04/government-announces-redress-for-abuse-victims/7996092","urlToImage":"http://www.abc.net.au/news/image/5799844-1x1-700x700.jpg","publishedAt":"2016-11-04T05:04:00Z"},{"author":null,"title":"Live: Proteas strike back on day two as Australia's batting order crumbles","description":"Australia struggles to close the deficit on day two as wickets tumble. Follow all the action in our live blog.","url":"http://www.abc.net.au/news/2016-11-04/australia-south-africa-first-test-waca-day-two-live-blog/7995462","urlToImage":"http://www.abc.net.au/news/image/7996552-1x1-700x700.jpg","publishedAt":"2016-11-04T06:09:09Z"},{"author":"http://www.abc.net.au/news/henry-belot/7953986","title":"Scott Ludlam takes leave of absence to treat depression, anxiety","description":"Greens senator Scott Ludlam will take a leave of absence from Parliament to treat depression and anxiety.","url":"http://www.abc.net.au/news/2016-11-04/scott-ludlam-takes-leave-of-absence-to-treat-depression/7996788","urlToImage":"http://www.abc.net.au/news/image/7280618-1x1-700x700.jpg","publishedAt":"2016-11-04T05:32:28Z"},{"author":"http://www.abc.net.au/news/zoe-daniel/166858","title":"The upshot of a 'yuge' week is clear: Trump has a clear shot at winning","description":"It's fitting, isn't it, that after a campaign that's been topsy-turvy in so many ways we enter the straight with almost unreadable polls and an election that looks like being a photo finish.","url":"http://www.abc.net.au/news/2016-11-04/zoe-daniel-us-election-trump-clinton-on-home-straight/7995428","urlToImage":"http://www.abc.net.au/news/image/7995764-1x1-700x700.jpg","publishedAt":"2016-11-04T04:46:43Z"},{"author":null,"title":"'Ferocious' western Sydney fire spreads from Cranebrook to Llandilo","description":"Hundreds of firefighters battle a ferocious out-of-control bushfire that earlier threatened homes in Cranebrook and has now spread to nearby Llandilo in western Sydney.","url":"http://www.abc.net.au/news/2016-11-04/fire-fighters-battling-major-bushfire-in-western-sydney/7996460","urlToImage":"http://www.abc.net.au/news/image/7996812-1x1-700x700.jpg","publishedAt":"2016-11-04T06:22:14Z"},{"author":null,"title":"Man accused of murdering toddler 'cuddled her before hiding body'","description":"A Supreme Court jury watches a video re-enactment detailing how the man accused of fatally bashing a toddler disposed of her body in the roof of her home.","url":"http://www.abc.net.au/news/2016-11-04/nikki-francis-coslovich-john-torney-freaked-out-hiding-body/7996818","urlToImage":"http://www.abc.net.au/news/image/6726812-1x1-700x700.jpg","publishedAt":"2016-11-04T05:56:39Z"},{"author":null,"title":"Pair jailed over $3.6m Brett Whiteley art fraud","description":"Two men involved in one of the country's biggest art frauds, where fake Brett Whiteley paintings were produced and sold, are sentenced to jail.","url":"http://www.abc.net.au/news/2016-11-04/brett-whiteley-fraud--mohamed-siddique-peter-gant-sentenced/7996600","urlToImage":"http://www.abc.net.au/news/image/6307898-1x1-700x700.jpg","publishedAt":"2016-11-04T05:44:39Z"},{"author":"http://www.abc.net.au/news/jane-norman/5873958","title":"Turnbull won't fight inquiry on freedom of speech laws","description":"Malcolm Turnbull indicates he will not stand in the way of an inquiry into freedom of speech, as he faces calls from his own backbench for changes to the Racial Discrimination Act.","url":"http://www.abc.net.au/news/2016-11-04/turnbull-wont-block-inquiry-into-freedom-of-speech/7996366","urlToImage":"http://www.abc.net.au/news/image/7959366-1x1-700x700.jpg","publishedAt":"2016-11-04T05:33:42Z"},{"author":null,"title":"No malicious intent in Phillip Hughes' death, coroner finds","description":"Phillip Hughes' death from a fatal bouncer would not have been prevented even if he was wearing modern protection available at the time, the NSW coroner finds.","url":"http://www.abc.net.au/news/2016-11-04/phillip-hughes-inquest-coroner-hands-down-findings/7994808","urlToImage":"http://www.abc.net.au/news/image/5923508-1x1-700x700.jpg","publishedAt":"2016-11-04T03:12:18Z"},{"author":"http://www.abc.net.au/news/lucia-stein/7093484","title":"Viral giant huntsman spider photograph an 'optical illusion': expert","description":"A giant huntsman spider photographed by a Queensland animal rescuer last year is quite normal in size, an arachnologist says.","url":"http://www.abc.net.au/news/2016-11-04/viral-huntsman-spider-photograph-an-'optical-illusion':-expert/7995590","urlToImage":"http://www.abc.net.au/news/image/7996022-1x1-700x700.jpg","publishedAt":"2016-11-04T02:25:05Z"}]
     */

    public String status;
    public String source;
    public String sortBy;
    /**
     * author : http://www.abc.net.au/news/alexandra-beech/6902724
     * title : Abuse victims to get up to $150k each under new compo scheme
     * description : The Federal Government has announced a compensation scheme for victims of institutional child sexual abuse, with survivors able to access up to $150,000 each.
     * url : http://www.abc.net.au/news/2016-11-04/government-announces-redress-for-abuse-victims/7996092
     * urlToImage : http://www.abc.net.au/news/image/5799844-1x1-700x700.jpg
     * publishedAt : 2016-11-04T05:04:00Z
     */

    public List<ArticlesBean> articles;

    public static class ArticlesBean {
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public String publishedAt;
    }
}
