package ru.sbrf.socialnetwork.objects.requests;

/**
 * Created by Ivan on 27/11/2016.
 */
public class Pagination {
    private final int itemsPerPage;
    private final int pageIndex;

    public Pagination(int itemsPerPage, int pageIndex) {
        this.itemsPerPage = itemsPerPage;
        this.pageIndex = pageIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}
