package eecs40.rssfeed;

import de.vogella.rss.model.FeedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.vogella.rss.read.RSSFeedParser;
import de.vogella.rss.model.Feed;

public class RSSFeed implements RSSFeedInterface {
    private RSSFeedParser parse;
    private String name;
    private String url;
    private List<FeedMessage> oldStand = new ArrayList();
    private List<FeedMessage> newStand = new ArrayList();
    private List<FeedMessage> tempList = new ArrayList();

    public RSSFeed(String feedURL, String feedName){
        url = feedURL;
        name = feedName;
    }

    public Feed getFeed() {
        parse = new RSSFeedParser(url);
        return parse.readFeed();
    }
    public int size(){
        return oldStand.size();
    }
    public int getLastNumUpdate(){
        return newStand.size() - oldStand.size();
    }

    public int read(){
        tempList = getFeed().getMessages();
        if (newStand.isEmpty()){
            newStand = tempList;
            return tempList.size();
        }
        else if (!tempList.get(0).getGuid().equals(newStand.get(0).getGuid())){
            int counter = 0;
            oldStand.clear();
            oldStand.addAll(newStand);
            while (!tempList.get(counter).getGuid().equals(oldStand.get(0).getGuid())){
                newStand.add(0, tempList.get(counter));
                counter++;
                if (counter == tempList.size()){
                    break;
                }
            }
        return newStand.size() - oldStand.size();
        }
        else return 0;
    }

    @Override
    public Iterator<FeedMessage> iterator() {
        return iterator();
    }
}
