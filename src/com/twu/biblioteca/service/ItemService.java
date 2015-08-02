package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class ItemService<T> {

    public List<T> listItems() {
        Map<String, T> items = getItemsFromRepository();
        Map<String, String> checkedItems = getCheckedItemsFromRepository();
        List<T> itemList = new ArrayList<T>();
        for(String itemId : items.keySet()) {
            if(!checkedItems.containsKey(itemId)) {
                itemList.add(items.get(itemId));
            }
        }
        sortItemList(itemList);
        return itemList;
    }

    public String checkoutItem(String itemId, String readerId) {
        return isExistItem(itemId) && !isCheckedOut(itemId) ?
                saveCheckoutBookToRepository(itemId, readerId) : getUnsuccessfulCheckoutMessage();
    }

    public String returnCheckedItem(String itemId) {
        return isCheckedOut(itemId) ? returnCheckedItemToRepository(itemId) : getUnsuccessfulReturnMessage();
    }

    private boolean isExistItem(String itemId) {
        return getItemsFromRepository().containsKey(itemId);
    }

    private boolean isCheckedOut(String itemId) {
        return getCheckedItemsFromRepository().containsKey(itemId);
    }

    protected abstract Map<String, T> getItemsFromRepository();

    protected abstract Map<String, String> getCheckedItemsFromRepository();

    protected abstract void sortItemList(List<T> itemList);

    protected abstract String saveCheckoutBookToRepository(String itemId, String readerId);

    protected abstract String returnCheckedItemToRepository(String itemId);

    protected abstract String getUnsuccessfulCheckoutMessage();

    protected abstract String getUnsuccessfulReturnMessage();
}
