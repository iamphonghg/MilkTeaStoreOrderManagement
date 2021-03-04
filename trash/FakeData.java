package trash;

import connect.DBConnect;
import model.Item;
import view.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class FakeData {
    private static final DBConnect connect = new DBConnect();

    public static void main(String[] args) {

        List<String> listId = new ArrayList<>();
        listId.add("NV0001");
        listId.add("NV0002");
        listId.add("NV0003");
        listId.add("NV0004");
        listId.add("NV0005");
        listId.add("NV0006");
        listId.add("NV0007");
        listId.add("NV0008");
        listId.add("NV0009");
        listId.add("NV0010");
        listId.add("NV0011");
        listId.add("NV0012");
        listId.add("NV0013");
        listId.add("NV0014");
        listId.add("NV0015");
        listId.add("NV0016");
        listId.add("NV0017");
        listId.add("NV0018");
        listId.add("NV0019");
        listId.add("NV0020");
        List<Item> listMilkTea = loadItemListFromDBToList("TRÀ SỮA");
        int totalMilkTeaItem = listMilkTea.size();
        List<Item> listFruitTea = loadItemListFromDBToList("TRÀ HOA QUẢ");
        int totalFruitTeaItem = listFruitTea.size();
        List<Item> listMacchiato = loadItemListFromDBToList("MACCHIATO");
        int totalMacchiatoItem = listMacchiato.size();
        List<Item> listTopping = loadItemListFromDBToList("TOPPING");
        int totalToppingItem = listTopping.size();
        List<Item> listFood = loadItemListFromDBToList("ĐỒ ĂN VẶT");
        int totalFoodItem = listFood.size();
//        System.out.println(numberOfMilkTeaItem);      27
//        System.out.println(numberOfFruitTeaItem);     12
//        System.out.println(numberOfMacchiatoItem);    10
//        System.out.println(numberOfToppingItem);      14
//        System.out.println(numberOfFoodItem);         8

        Random random = new Random();
        int year = 2020;
        int month = 12;
        int day = 1;
        int hour = 8;
        int minute = 0;
        Timestamp tmpCreatedTime = new Timestamp(new Date(year - 1900, month - 1, day, hour, minute).getTime());
        Timestamp tmpCompletedTime = new Timestamp(new Date(year - 1900, month - 1, day, hour, minute).getTime() + 3600000);
        //String query = "INSERT INTO bill VALUES ('4', 20, '" + tmpCreatedTime + "', '" + tmpCompletedTime + "', null, null, null)";
        for (int j = 1; j < 32; j++) {
            day = j;
            int numberOfBillInDay = random.nextInt(100 - 30 + 1) + 30;
            int count = 1;
            int billNumber = 0;
            ResultSet rs = connect.excuteQuerySelect("SELECT count(*) FROM bill");
            try {
                while (rs.next()) {
                    billNumber = rs.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(numberOfBillInDay);
            while (count < numberOfBillInDay + 1) {
                hour = random.nextInt(22 - 8 + 1) + 8;
                minute = random.nextInt(59 - 0 + 1) + 0;
                Timestamp createdTime = new Timestamp(new Date(year - 1900, month - 1, day, hour, minute).getTime());
                int numberOfMilkTea = random.nextInt(5 - 1 + 1) + 1;
                int numberOfFruitTea = random.nextInt(5 - 0 + 1) + 0;
                int numberOfMacchiato = random.nextInt(5 - 0 + 1) + 0;
                int numberOfFood = random.nextInt(5 - 0 + 1) + 0;
                int totalDrinkType = numberOfMilkTea + numberOfFruitTea + numberOfMacchiato;

    //            System.out.println("Milktea " + numberOfMilkTea);
                List<Item> tmpListMilkTea = new ArrayList<>();
                String[] sizeMilkTea = new String[numberOfMilkTea];
                Integer[] quantityMilkTea = new Integer[numberOfMilkTea];
                while (numberOfMilkTea - 1 >= 0) {
                    int indexMilkTea = 0;
                    do {
                        indexMilkTea = random.nextInt(26 - 0 + 1) + 0;
                    } while (!checkRandomDuplicated(tmpListMilkTea, listMilkTea, indexMilkTea));
                    tmpListMilkTea.add(listMilkTea.get(indexMilkTea));

    //                System.out.println("size " + (tmpListMilkTea.size() - 1));
                    int randomSize = random.nextInt(1 - 0 + 1) + 0;
                    if (randomSize == 0) {
                        sizeMilkTea[tmpListMilkTea.size() - 1] = "M";
                    } else {
                        sizeMilkTea[tmpListMilkTea.size() - 1] = "L";
                    }

                    int randomQuantity = random.nextInt(5 - 1 + 1) + 1;
                    quantityMilkTea[tmpListMilkTea.size() - 1] = randomQuantity;

                    numberOfMilkTea--;
                }

                List<Item> tmpListFruitTea = new ArrayList<>();
                String[] sizeFruitTea = new String[0];
                Integer[] quantityFruitTea = new Integer[0];
                if (numberOfFruitTea != 0) {
                    sizeFruitTea = new String[numberOfFruitTea];
                    quantityFruitTea = new Integer[numberOfFruitTea];
                    while (numberOfFruitTea - 1 >= 0) {
                        int indexFruitTea = 0;
                        do {
                            indexFruitTea = random.nextInt(11 - 0 + 1) + 0;
                        } while (!checkRandomDuplicated(tmpListFruitTea, listFruitTea, indexFruitTea));
                        tmpListFruitTea.add(listFruitTea.get(indexFruitTea));

                        int randomSize = random.nextInt(1 - 0 + 1) + 0;
                        if (randomSize == 0) {
                            sizeFruitTea[tmpListFruitTea.size() - 1] = "M";
                        } else {
                            sizeFruitTea[tmpListFruitTea.size() - 1] = "L";
                        }

                        int randomQuantity = random.nextInt(5 - 1 + 1) + 1;
                        quantityFruitTea[tmpListFruitTea.size() - 1] = randomQuantity;

                        numberOfFruitTea--;
                    }
                }

                List<Item> tmpListMacchiato = new ArrayList<>();
                String[] sizeMacchiato = new String[0];
                Integer[] quantityMacchiato = new Integer[0];
                if (numberOfMacchiato != 0) {
                    sizeMacchiato = new String[numberOfMacchiato];
                    quantityMacchiato = new Integer[numberOfMacchiato];
                    while (numberOfMacchiato - 1 >= 0) {
                        int indexMacchiato = 0;
                        do {
                            indexMacchiato = random.nextInt(9 - 0 + 1) + 0;
                        } while (!checkRandomDuplicated(tmpListMacchiato, listMacchiato, indexMacchiato));
                        tmpListMacchiato.add(listMacchiato.get(indexMacchiato));

                        int randomSize = random.nextInt(1 - 0 + 1) + 0;
                        if (randomSize == 0) {
                            sizeMacchiato[tmpListMacchiato.size() - 1] = "M";
                        } else {
                            sizeMacchiato[tmpListMacchiato.size() - 1] = "L";
                        }

                        int randomQuantity = random.nextInt(5 - 1 + 1) + 1;
                        quantityMacchiato[tmpListMacchiato.size() - 1] = randomQuantity;

                        numberOfMacchiato--;
                    }
                }

                List<Item> tmpListFood = new ArrayList<>();
                String[] sizeFood = null;
                Integer[] quantityFood = new Integer[0];
                if (numberOfFood != 0) {
                    sizeFood = new String[numberOfFood];
                    quantityFood = new Integer[numberOfFood];
                    while (numberOfFood - 1 >= 0) {
                        int indexFood = 0;
                        do {
                            indexFood = random.nextInt(7 - 0 + 1) + 0;
                        } while (!checkRandomDuplicated(tmpListFood, listFood, indexFood));
                        tmpListFood.add(listFood.get(indexFood));

                        int randomSize = random.nextInt(1 - 0 + 1) + 0;
                        if (randomSize == 0) {
                            sizeFood[tmpListFood.size() - 1] = "M";
                        } else {
                            sizeFood[tmpListFood.size() - 1] = "L";
                        }

                        int randomQuantity = random.nextInt(5 - 1 + 1) + 1;
                        quantityFood[tmpListFood.size() - 1] = randomQuantity;

                        numberOfFood--;
                    }
                }

                int totalQuantityMilkTea = 0;
                for (Integer i : quantityMilkTea) {
                    totalQuantityMilkTea += i;
                }

                int timeMakeMilkTea = totalQuantityMilkTea * 45;

                int totalQuantityFruitTea = 0;
                for (Integer i : quantityFruitTea) {
                    totalQuantityFruitTea += i;
                }

                int timeMakeFruitTea = totalQuantityFruitTea * 30;

                int totalQuantityMacchiato = 0;
                for (Integer i : quantityMacchiato) {
                    totalQuantityMacchiato += i;
                }

                int timeMakeMacchiato = totalQuantityMacchiato * 60;

                int totalQuantityFood = 0;
                for (Integer i : quantityFood) {
                    totalQuantityFood += i;
                }



                long totalTimeMake = timeMakeMilkTea + timeMakeFruitTea + timeMakeMacchiato;

                Timestamp completedTime = new Timestamp(new Date(year - 1900, month - 1, day, hour, minute).getTime() + totalTimeMake * 1000);
                System.out.println(createdTime);
                System.out.println(completedTime);

                int totalQuantityDrink = totalQuantityMilkTea + totalQuantityFruitTea + totalQuantityMacchiato;
                int totalQuantity = totalQuantityDrink * 2 + totalQuantityFood;
                System.out.println(totalQuantity);

                List<Item> tmpListTopping = new ArrayList<>();
                Integer[] quantityTopping = null;
                if (totalQuantityDrink > 10) {
                    int numberOfTopping = 3;
                    quantityTopping = new Integer[3];
                    while (numberOfTopping - 1 >= 0) {
                        int indexTopping = 0;
                        do {
                            indexTopping = random.nextInt(13 - 0 + 1) + 0;
                        } while (!checkRandomDuplicated(tmpListTopping, listTopping, indexTopping));
                        tmpListTopping.add(listTopping.get(indexTopping));
                        numberOfTopping--;
                    }
                    quantityTopping[0] = random.nextInt((totalQuantityDrink / 2 - 1) - 1 + 1) + 1;
                    quantityTopping[1] = random.nextInt((totalQuantityDrink / 2 - 1) - 1 + 1) + 1;
                    quantityTopping[2] = totalQuantityDrink - quantityTopping[0] - quantityTopping[1];
                } else {
                    quantityTopping = new Integer[1];
                    int indexTopping = random.nextInt(13 - 0 + 1) + 0;
                    tmpListTopping.add(listTopping.get(indexTopping));
                    quantityTopping[0] = totalQuantityDrink;
                }

                int totalCostMilkTea = 0;
                int totalDiscountMilkTea = 0;
                for (int i = 0; i < tmpListMilkTea.size(); i++) {
                    if (sizeMilkTea[i].equals("M")) {
                        totalCostMilkTea += tmpListMilkTea.get(i).getPriceM() * quantityMilkTea[i];
                    } else {
                        totalCostMilkTea += tmpListMilkTea.get(i).getPriceL() * quantityMilkTea[i];
                    }
                    totalDiscountMilkTea += tmpListMilkTea.get(i).getPromo() * quantityMilkTea[i];
                }
                System.out.println(totalCostMilkTea);
                System.out.println(totalDiscountMilkTea);


                int totalCostFruitTea = 0;
                int totalDiscountFruitTea = 0;
                for (int i = 0; i < tmpListFruitTea.size(); i++) {
                    if (sizeFruitTea[i].equals("M")) {
                        totalCostFruitTea += tmpListFruitTea.get(i).getPriceM() * quantityFruitTea[i];
                    } else {
                        totalCostFruitTea += tmpListFruitTea.get(i).getPriceL() * quantityFruitTea[i];
                    }
                    totalDiscountFruitTea += tmpListFruitTea.get(i).getPromo() * quantityFruitTea[i];
                }
                System.out.println(totalCostFruitTea);
                System.out.println(totalDiscountFruitTea);

                int totalCostMacchiato = 0;
                int totalDiscountMacchiato = 0;
                for (int i = 0; i < tmpListMacchiato.size(); i++) {
                    if (sizeMacchiato[i].equals("M")) {
                        totalCostMacchiato += tmpListMacchiato.get(i).getPriceM() * quantityMacchiato[i];
                    } else {
                        totalCostMacchiato += tmpListMacchiato.get(i).getPriceL() * quantityMacchiato[i];
                    }
                    totalDiscountMacchiato += tmpListMacchiato.get(i).getPromo() * quantityMacchiato[i];
                }
                System.out.println(totalCostMacchiato);
                System.out.println(totalDiscountMacchiato);

                int totalCostFood = 0;
                int totalDiscountFood = 0;
                for (int i = 0; i < tmpListFood.size(); i++) {
                    if (sizeFood[i].equals("M")) {
                        totalCostFood += tmpListFood.get(i).getPriceM() * quantityFood[i];
                    } else {
                        totalCostFood += tmpListFood.get(i).getPriceL() * quantityFood[i];
                    }
                    totalDiscountFood += tmpListFood.get(i).getPromo() * quantityFood[i];
                }
                System.out.println(totalCostFood);
                System.out.println(totalDiscountFood);

                int totalCostTopping = 0;
                int totalDiscountTopping = 0;
                for (int i = 0; i < tmpListTopping.size(); i++) {
                    totalCostTopping += tmpListTopping.get(i).getPriceM() * quantityTopping[i];
                    totalDiscountTopping += tmpListTopping.get(i).getPromo() * quantityTopping[i];
                }
                System.out.println(totalCostTopping);
                System.out.println(totalDiscountTopping);

                int finalCost = totalCostMilkTea + totalCostFruitTea + totalCostMacchiato + totalCostFood + totalCostTopping;
                int totalDiscount = totalDiscountMilkTea + totalDiscountFruitTea + totalDiscountMacchiato + totalDiscountFood + totalDiscountTopping;
                System.out.println("tổng tiền " + finalCost);
                System.out.println("tổng giảm " + totalDiscount);

                String staffOrderedId = listId.get(random.nextInt(19 - 0 + 1) + 0);
                String queryAddNewBill = "INSERT INTO bill VALUES (" + (billNumber + 1) + ", " + totalQuantity + ", '" + createdTime + "', '" + completedTime + "', null, " + totalDiscount + ", " + finalCost + ", '" + staffOrderedId + "')";
                connect.excuteQueryUpdate(queryAddNewBill);

                for (int i = 0; i < tmpListMilkTea.size(); i++) {
                    String query = "INSERT INTO detailbill VALUES (" + (billNumber + 1) + ", '" + tmpListMilkTea.get(i).getName() + "', '" + sizeMilkTea[i] + "', " + quantityMilkTea[i] + ")";
                    System.out.println(query);
                    connect.excuteQueryUpdate(query);
                }

                for (int i = 0; i < tmpListFruitTea.size(); i++) {
                    String query = "INSERT INTO detailbill VALUES (" + (billNumber + 1) + ", '" + tmpListFruitTea.get(i).getName() + "', '" + sizeFruitTea[i] + "', " + quantityFruitTea[i] + ")";
                    System.out.println(query);
                    connect.excuteQueryUpdate(query);
                }

                for (int i = 0; i < tmpListMacchiato.size(); i++) {
                    String query = "INSERT INTO detailbill VALUES (" + (billNumber + 1) + ", '" + tmpListMacchiato.get(i).getName() + "', '" + sizeMacchiato[i] + "', " + quantityMacchiato[i] + ")";
                    System.out.println(query);
                    connect.excuteQueryUpdate(query);
                }

                for (int i = 0; i < tmpListTopping.size(); i++) {
                    String query = "INSERT INTO detailbill VALUES (" + (billNumber + 1) + ", '" + tmpListTopping.get(i).getName() + "', 'M', " + quantityTopping[i] + ")";
                    System.out.println(query);
                    connect.excuteQueryUpdate(query);
                }

                for (int i = 0; i < tmpListFood.size(); i++) {
                    String query = "INSERT INTO detailbill VALUES (" + (billNumber + 1) + ", '" + tmpListFood.get(i).getName() + "', '" + sizeFood[i] + "', " + quantityFood[i] + ")";
                    System.out.println(query);
                    connect.excuteQueryUpdate(query);
                }

                billNumber++;
                count++;
            }
        }

    }

    public static List<Item> loadItemListFromDBToList(String nameType) {
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM item WHERE item_type = '" + nameType + "' ORDER BY item_name ASC";
        ResultSet resultSet = connect.excuteQuerySelect(query);
        try {
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("item_name"), resultSet.getString("item_type").trim(),
                        resultSet.getInt("price_sizem"), resultSet.getInt("price_sizel"),
                        resultSet.getString("item_status"), resultSet.getInt("discount_promo"));
                itemList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public static boolean checkRandomDuplicated(List<Item> tmpList, List<Item> mainList, Integer randomIndex) {
        for (Item i : tmpList) {
            if (i.equals(mainList.get(randomIndex))) {
                return false;
            }
        }
        return true;
    }
}
