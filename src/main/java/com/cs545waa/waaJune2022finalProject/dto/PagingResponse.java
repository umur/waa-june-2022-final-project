package com.cs545waa.waaJune2022finalProject.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PagingResponse<T> {
  long total;
  int pageSize;
  int current;
  int totalPage;
  List<T> data;
  public PagingResponse(Page page){
    this.total = page.getTotalElements();
    this.pageSize = page.getPageable().getPageSize();
    this.current = page.getPageable().getPageNumber();
    this.data = page.getContent();
    this.totalPage = page.getTotalPages();
  }
}
