package ua.edu.chmnu.ki.network.lib.filter.dto;

import lombok.Data;
import ua.edu.chmnu.ki.network.lib.filter.EntityFilter;
import ua.edu.chmnu.ki.network.lib.filter.RangeFilter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

@Data
public class BookFilterDTO implements EntityFilter {

    private Integer id;

    private String title;

    private String description;

    private String author;

    private BigDecimal price;

    private BigDecimal priceMin;

    private BigDecimal priceMax;

    private RangeFilter<BigDecimal> priceRange;

    private Integer pages;

    private RangeFilter<Integer> pageRange;

    private Integer year;

    private RangeFilter<Year> yearRange;

    private RangeFilter<LocalDate> dateRange;

    private String search;

    public boolean hasSearch() {
        return search != null && !search.isBlank();
    }

    public boolean hasId() {
        return id != null;
    }

    public boolean hasTitle() {
        return title != null && !title.isBlank();
    }

    public boolean hasDescription() {
        return description != null && !description.isBlank();
    }

    public boolean hasAuthor() {
        return author != null && !author.isBlank();
    }

    public boolean hasPrice() {
        return price != null;
    }

    public boolean hasPages() {
        return pages != null;
    }

    public boolean hasYear() {
        return year != null;
    }
}
