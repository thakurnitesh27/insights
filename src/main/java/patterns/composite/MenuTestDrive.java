package patterns.composite;

public class MenuTestDrive {

    public static void main(String[] args) {

        MenuComponent panCakeMenu=new Menu("PANCAKE","For breakfast");
        MenuComponent dinnerMenu=new Menu("DINNER", "Dinner ");
        MenuComponent cafeMenu=new Menu("CAFE", "Lunch");
        MenuComponent desertMenu=new Menu("DESSERT", "Dessert");

        MenuComponent allMenu=new Menu("ALLMENU","all menu");



        allMenu.add(panCakeMenu);
        allMenu.add(dinnerMenu);
        allMenu.add(cafeMenu);



        panCakeMenu.add(new MenuItem("PURI_SABJI","Delicious Puri Sabzi",100,true));
        panCakeMenu.add(new MenuItem("BREAD_AMLET","Bread Amlet",100,false));

        dinnerMenu.add(new MenuItem("SPECIAL_DINNER_THALI","Supreme Dinner Thali ",250,true));
        dinnerMenu.add(new MenuItem("CHICKEN_BIRYANI_DINNER_THALI","Chicken Biryani Dinner",350,false));


        cafeMenu.add(new MenuItem("SPECIAL_VEG_LUNCH","Delicious Lunch ",200,true));
        cafeMenu.add(new MenuItem("SPECIAL_NON_VEGLUNCH","Delicious Chicken Lunch ",300,false));


        desertMenu.add(new MenuItem("RASGULLA","2 piece rasgulla",80,true));
        desertMenu.add(new MenuItem("GAAZAR_HALWA","Ghee fried Halwa",120,true));
        desertMenu.add(new MenuItem("ICE_CREAM","Vanilla/Strawberry ice cream",80,true));
        desertMenu.add(new MenuItem("FALUDA","Faluda",100,true));


        //Dessert is part of cafe and dinner menu. It exists inside them-composed within it.But all are the part of same MenuComponent-no distinction
        //between menu item and menu.
        dinnerMenu.add(desertMenu);

        cafeMenu.add(desertMenu);


        Waitress waitress=new Waitress(allMenu);
        waitress.printMenu();
    }
}
