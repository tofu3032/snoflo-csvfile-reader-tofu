package org.snoflo.service;

import java.util.List;

import org.snoflo.model.Book;

public class ViewService {

    public void showPromptMainMenu() {
        System.out.println("---------------------------------");
        System.out.println("도서관리 프로그램 시작");
        System.out.println("---------------------------------");
    }

    public void showSelectMenu() {
        System.out.println("---------------------------------");
        System.out.println("메뉴 선택");
        System.out.println("1. 파일 및 행 수 지정하기");
        System.out.println("2. 작가명으로 검색");
        System.out.println("---------------------------------");
    }

    public void showPromptFindByAuthor() {
        System.out.println("-----------------------------");
        System.out.println("----- Author로 검색하기 -----");
        System.out.println("-----------------------------");
    }

    public void showResultFindByAuthor(List<Book> list) {
        System.out.println();
        System.out.println("listByAuthor : " + list);
    }

    public void showPromptGenerateCsvFile() {
        System.out.println("-----------------------------");
        System.out.println("----- 파일 생성하기 -----");
        System.out.println("-----------------------------");
    }

    public void showPromptWriteCsvFileName() {
        System.out.println("-----------------------------");
        System.out.println("----- 1. 파일명을 입력해주세요 -----");
        System.out.println("-----------------------------");
    }

    public void showPromptWriteCsvFileRow() {
        System.out.println("-----------------------------");
        System.out.println("----- 2. 행 수를 입력해주세요. -----");
        System.out.println("-----------------------------");
    }

    public void showResultGenerateCsvFile() {
        System.out.println("파일 생성이 완료되었습니다.");
    }

}
