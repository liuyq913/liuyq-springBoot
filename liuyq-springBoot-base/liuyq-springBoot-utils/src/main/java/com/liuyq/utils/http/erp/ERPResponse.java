package com.liuyq.utils.http.erp;

import java.io.Serializable;

/**
 * @company: beitai.com
 * @package: com.btjf.business.personal.approvalorder.pojo
 * @description: B2C与消费贷链接基础返回
 * @author: cy123
 * @date: 2017/3/20 15:49
 * @email: cheny@cheok.com
 */
public class ERPResponse<T> implements Serializable {

    private static final long serialVersionUID = 5596721451819059278L;
    private Integer code;
    private String message;
    private T object;
    private Page page;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public class Page {
        private Integer currentPage;
        private Integer pageRecords;
        private Integer totalPages;
        private Integer totalRecords;
        private Integer startRecord;
        private Integer nextPage;
        private Integer previousPage;
        private Boolean hasNextPage;
        private Boolean hasPreviousPage;

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPageRecords() {
            return pageRecords;
        }

        public void setPageRecords(Integer pageRecords) {
            this.pageRecords = pageRecords;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Integer getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
        }

        public Integer getStartRecord() {
            return startRecord;
        }

        public void setStartRecord(Integer startRecord) {
            this.startRecord = startRecord;
        }

        public Integer getNextPage() {
            return nextPage;
        }

        public void setNextPage(Integer nextPage) {
            this.nextPage = nextPage;
        }

        public Integer getPreviousPage() {
            return previousPage;
        }

        public void setPreviousPage(Integer previousPage) {
            this.previousPage = previousPage;
        }

        public Boolean getHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(Boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public Boolean getHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(Boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }
    }
}
