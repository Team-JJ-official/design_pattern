public class Main {
    public static void main(String[] args) {
        String[] bookNames = {"Alice", "Bob", "Curl", "Dump"};
        BookShelf bookShelf = new BookShelf(4);
        for (int i = 0; i < bookNames.length; i++) {
            bookShelf.appendBook(new Book(bookNames[i]));
        }
        
        Iterator it = bookShelf.iterator();
        // Iterator it = bookShelf.iteratorReverse();

        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }

        BookShelfBidirectional bookShelfBidirectional = new BookShelfBidirectional(4);
        for (int i = 0; i < bookNames.length; i++) {
            bookShelfBidirectional.appendBook(new Book(bookNames[i]));
        }

        IteratorBidirectional itb = bookShelfBidirectional.iterator();
        System.out.println(((Book)itb.next()).getName());
        System.out.println(((Book)itb.next()).getName());
        System.out.println(((Book)itb.prev()).getName());
        System.out.println(((Book)itb.prev()).getName());
    }
}
