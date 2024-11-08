package ua.edu.chmnu.ki.network.lib.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.edu.chmnu.ki.network.lib.persistence.entity.Book;
import ua.edu.chmnu.ki.network.lib.web.dto.BookFilterDTO;

import java.util.stream.Stream;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(
            "SELECT book FROM Book book JOIN FETCH Author author"
    )
    Stream<Book> streamAll();

    @Query(
            """
                                                SELECT book FROM Book book
                                                LEFT JOIN Author author ON author.id = book.author.id
                                                WHERE ((:#{#filter.id} IS NULL OR book.id = :#{#filter.id})
                                                 AND (:#{#filter.title} IS NULL OR book.title LIKE CONCAT('%', COALESCE(cast(:#{#filter.title} as string) , '') , '%'))
                                                 AND (:#{#filter.author} IS NULL OR author.name LIKE CONCAT('%', COALESCE(CAST(:#{#filter.author} as string) , ''), '%'))
                                                 AND (:#{#filter.description} IS NULL OR book.description LIKE CONCAT('%', COALESCE(CAST(:#{#filter.description} as string) , ''), '%'))
                                                 AND (:#{#filter.pages} IS NULL OR book.pages = :#{#filter.pages})
                                                 AND (:#{#filter.price} IS NULL OR book.price = :#{#filter.price})
                                                 AND (:#{#filter.minPrice} IS NULL OR book.price >= :#{#filter.minPrice})
                                                 AND (:#{#filter.maxPrice} IS NULL OR book.price <= :#{#filter.maxPrice}))
                                                 AND (:#{#filter.search} IS NULL OR
                                                     book.title LIKE CONCAT('%', COALESCE(cast(:#{#filter.search} as string) , '') , '%')
                                                     OR book.description LIKE CONCAT('%', COALESCE(cast(:#{#filter.search} as string) , '') , '%')
                                                     OR author.name LIKE CONCAT('%', COALESCE(cast(:#{#filter.search} as string) , '') , '%')
                                                 )
                                                 ORDER BY book.id ASC, book.author.name ASC
                    """
    )
    Stream<Book> streamAllByFilter(@Param("filter") BookFilterDTO filter);
}