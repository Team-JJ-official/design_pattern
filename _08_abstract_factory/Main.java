package _08_abstract_factory;

import _08_abstract_factory.factory.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main ListFactory");
            System.out.println("Example 2: java Main TableFactory");
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);

        Link asahi = factory.createLink("朝日新聞", "https://www.asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "https://www.yomiuri.co.jp/");

        Link us_yahoo = factory.createLink("Yahoo!", "https://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "https://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "https://www.excite.com/");
        Link google = factory.createLink("Google", "https://www.google.com/");

        Link dailygoals = factory.createLink("DailyGoals", "https://daily-goals.team-jj.com");
        Link gamecenterJJ = factory.createLink("GameCenterJJ", "https://game-center.team-jj.com");
        Link mcJJ = factory.createLink("Minecraft JJserver Status", "https://minecraft.team-jj.com/status"); 

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi, yomiuri);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo, jp_yahoo);

        Tray traysearch = factory.createTray("サーチエンジン");
        traysearch.add(trayyahoo, excite, google);
        
        Tray trayjj = factory.createTray("TEAM JJ");
        trayjj.add(dailygoals, gamecenterJJ, mcJJ);

        Page page = factory.createPage("LinkPage", "TEAM JJ");
        page.add(traynews, traysearch, trayjj);
        page.output();

        Page yahooPage = factory.createYahooPage();
        yahooPage.output();
    }
}
