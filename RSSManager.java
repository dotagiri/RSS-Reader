package eecs40.rssmanager;

import eecs40.observer.RSSFeedObserver;
import eecs40.rssfeed.RSSFeedInterface;

import java.util.ArrayList;
import java.util.List;

public class RSSManager extends AbstractRSSManager {
    private List<RSSFeedInterface> interfaceStand = new ArrayList();
    private List<RSSFeedObserver> observerStand = new ArrayList();

    private long myInterval;
    // Add RSSFeed
    public void addFeed(RSSFeedInterface f){
        interfaceStand.add(f);
    }
    // remove RSSFeed
    public void removeFeed(RSSFeedInterface f){
        interfaceStand.remove(f);
    }
    // getFeedList
    public List<RSSFeedInterface> getFeedList(){
        return interfaceStand;
    }
    // add observer
    public void addObserver(RSSFeedObserver ob){
        observerStand.add(ob);
    }
    // remove observer
    public void removeObserver(RSSFeedObserver ob){
        observerStand.remove(ob);
    }
    // remove observer
    public List<RSSFeedObserver> getObserverList(){
        return observerStand;
    }
    public void setInterval(long interval){
        myInterval = interval;
    }
    // get fetch interval
    public long getInterval(){
        return myInterval;
    }
}
