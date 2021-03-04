package trash;

import connect.DBConnect;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FakeDate2 {
    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
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
        Random random = new Random();
        int year = 2020;
        int month = 12;
        int day = 1;
        int hour = 8;
        int minute = 0;
        for (int i = 1; i < 32; i++) {
            day = i;
            for (int j = 0; j < 20; j++) {
                Timestamp workTime = new Timestamp(new Date(year - 1900, month - 1, day, hour, minute).getTime());
                String id = listId.get(j);
                String query = "INSERT INTO workdata VALUES ('" + id + "', '8TO12', '" + workTime + "')";
                connect.excuteQueryUpdate(query);
            }
            for (int j = 0; j < 20; j++) {
                Timestamp workTime = new Timestamp(new Date(year - 1900, month - 1, day, hour + 4, minute).getTime());
                String id = listId.get(j);
                String query = "INSERT INTO workdata VALUES ('" + id + "', '12TO17', '" + workTime + "')";
                connect.excuteQueryUpdate(query);
            }
            for (int j = 0; j < 20; j++) {
                Timestamp workTime = new Timestamp(new Date(year - 1900, month - 1, day, hour + 9, minute).getTime());
                String id = listId.get(j);
                String query = "INSERT INTO workdata VALUES ('" + id + "', '17TO20', '" + workTime + "')";
                connect.excuteQueryUpdate(query);
            }
            for (int j = 0; j < 20; j++) {
                Timestamp workTime = new Timestamp(new Date(year - 1900, month - 1, day, hour + 12, minute).getTime());
                String id = listId.get(j);
                String query = "INSERT INTO workdata VALUES ('" + id + "', '20TO23', '" + workTime + "')";
                connect.excuteQueryUpdate(query);
            }

        }



    }
}
