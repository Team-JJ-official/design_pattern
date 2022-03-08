package _08_abstract_factory.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("クラス" + classname + " が見つかりません。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);

    public Page createYahooPage() {
        Link us_yahoo = createLink("Yahoo!", "https://www.yahoo.com/");
        Page yahooPage = createPage("Yahoo!", "Yahoo!");
        yahooPage.add(us_yahoo);
        return yahooPage;
    }
}
