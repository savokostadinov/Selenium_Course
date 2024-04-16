//package page.object.pattern;
//
//import org.junit.Test;
//
//public class CompositionTest {
//    @Test
//    public void aTestUsingComposition() {
//        InventoryPage inventoryPage = new InventoryPage(driver);
//        inventoryPage.open();
//
//        //If you want to interact with the header
//        HeaderComponent header = new HeaderComponent(driver);
//        header.search("backpack");
//
//        //If you want to interact with items on the page
//        InventoryCollectionComponent collection = new InventoryCollectionComponent(driver);
//        //Here is us using composition to reference an Item inside of the Collection
//        collection.item.addToCart(ItemType.hoodie);
//    }
//}
