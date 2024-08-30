package org.snoflo.service;

import java.util.List;

import org.snoflo.model.Book;

public class ViewService {

    public void showMenuFindByAuthor() {
        System.out.println("-----------------------------");
        System.out.println("---- Author로 검색하기 -----");
        System.out.println("-----------------------------");
    }

    public void showResultFindByAuthor(List<Book> list) {
        System.out.println();
        System.out.println("listByAuthor : " + list);
    }

}
