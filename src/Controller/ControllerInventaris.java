package Controller;

import java.util.HashMap;
import java.util.List;

import ObjectInstances.Item;

public class ControllerInventaris {
    private HashMap<Integer,Item> listItem = new HashMap<>();
    private int idItem = 1;

    public void showMenuInventaris() {
        
    }

    public void Exec() {
        
    }

    public void addItem(Item item) {
        this.listItem.put(idItem++, item);
    }
    
    public void addBatchItem(List<Item> batchItem) {
        for (Item item : batchItem) {
            this.listItem.put(idItem++, item);
        }
    }

    public HashMap<Integer, Item> getListInventaris() {
        return listItem;
    }
}
