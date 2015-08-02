package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Book;

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
                saveCheckoutItemToRepository(itemId, readerId) : getUnsuccessfulCheckoutMessage();
    }

    public String returnCheckedItem(String itemId, String readerId) {
        return isCheckedOut(itemId, readerId) ? returnCheckedItemToRepository(itemId) : getUnsuccessfulReturnMessage();
    }

    private boolean isExistItem(String itemId) {
        return getItemsFromRepository().containsKey(itemId);
    }

    private boolean isCheckedOut(String itemId) {
        return getCheckedItemsFromRepository().containsKey(itemId);
    }

    private boolean isCheckedOut(String itemId, String readerId) {
        return isCheckedOut(itemId) && getCheckedItemsFromRepository().containsValue(readerId);
    }

    protected abstract Map<String, T> getItemsFromRepository();

    protected abstract Map<String, String> getCheckedItemsFromRepository();

    protected abstract void sortItemList(List<T> itemList);

    protected abstract String saveCheckoutItemToRepository(String itemId, String readerId);

    protected abstract String returnCheckedItemToRepository(String itemId);

    protected abstract String getUnsuccessfulCheckoutMessage();

    protected abstract String getUnsuccessfulReturnMessage();

    public abstract String generateItemColumnHeader();

    public abstract String generateItemColumnContent(T item);
}
