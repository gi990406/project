package net.softsociety.spring7.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter @Getter
@ToString
public class PageNavigator {
    // 멤버
    private int pagePerGroup;				// 그룹당 페이지수
    private int countPerPage;				// 한 페이지당 글 개수
    private int currentPage;  				// 현재 요청한 페이지
    private int totalRecordCount;			// 총 글 개수
    private int totalPageCount;				// 총 페이지 수
    private int totalGroupCount;			// 총 그룹 수(추가)
    private int currentGroup;   			// 현재 요청한 그룹
    private int startPageGroup;				// 현재 그룹의 첫 페이지
    private int endPageGroup;				// 현재 그룹의 마지막 페이지
    private int startRecord;				// 전체 레코드 중에서 현재 요청한 페이지 첫 글 번호
    private int endRecord;					// 전체 레코드 중에서 현재 요청한 페이지 마지막 글 번호

    // 생성자를 직접 작성
    public PageNavigator(int countPerPage, int pagePerGroup, int currentPage, int totalRecordCount) {
        // 초기화
        this.currentPage      = currentPage;
        this.totalRecordCount = totalRecordCount; // DB
        this.pagePerGroup     = pagePerGroup;
        this.countPerPage     = countPerPage;

        // 전체 페이지 수
        totalPageCount = totalRecordCount / 10;
        totalPageCount += (totalRecordCount % 10 == 0) ? 0 : 1;

        // 현재 페이지 요청 시 계산
        if(currentPage < 1) currentPage = 1;
        if(currentPage > totalPageCount) currentPage = totalPageCount;

        // 현재 그룹 계산 (수정)
        currentGroup = (currentPage - 1) / pagePerGroup;

        // 현재 그룹의 첫 페이지 계산
        startPageGroup = currentGroup * pagePerGroup + 1;
        startPageGroup = (startPageGroup < 1) ?  1 : startPageGroup;

        // 현재 그룹의 마지막 페이지 계산
        endPageGroup = startPageGroup * pagePerGroup; // 수정
        endPageGroup = (endPageGroup < totalPageCount ) ?  endPageGroup : totalPageCount;

        // 전체 그룹 수 (추가)
        totalGroupCount = totalPageCount / pagePerGroup;
        totalGroupCount += (totalPageCount % pagePerGroup == 0) ? 0 : 1;

        // 전체 레코드 중 현재 페이지의 첫 글 번호, 마지막 글번호
        startRecord = 1 + (currentPage - 1) * countPerPage;
        endRecord   = countPerPage + (currentPage - 1) * countPerPage;
    }
}