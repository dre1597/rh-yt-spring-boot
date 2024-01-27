package org.example.rhytspringboot.pagination;

import java.util.Collection;

public record Page<T>(
    int page,
    int size,
    int totalPages,
    long totalElements,
    Collection<? extends T> data
) {
  public static <U> Page<U> from(org.springframework.data.domain.Page<U> page) {
    return new Page<>(
        page.getNumber(),
        page.getSize(),
        page.getTotalPages(),
        page.getTotalElements(),
        page.getContent()
    );
  }
}
