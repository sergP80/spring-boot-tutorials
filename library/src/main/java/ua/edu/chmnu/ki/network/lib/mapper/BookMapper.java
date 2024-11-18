package ua.edu.chmnu.ki.network.lib.mapper;

import org.mapstruct.*;
import ua.edu.chmnu.ki.network.lib.persistence.entity.Book;
import ua.edu.chmnu.ki.network.lib.web.dto.BookDTO;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {AuthorMapper.class, CatalogMapper.class}
)
public interface BookMapper {

    Book mapTo(BookDTO source);

    BookDTO mapTo(Book source);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Book mapWith(BookDTO source, @MappingTarget Book target);
}
