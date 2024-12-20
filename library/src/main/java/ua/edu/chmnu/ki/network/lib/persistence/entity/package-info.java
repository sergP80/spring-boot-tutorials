@GenericGenerators({
        @GenericGenerator(
                name = "CATALOG_GENERATOR",
                strategy = "enhanced-sequence",
                parameters = {@Parameter(name = "sequence_name", value = "library.catalog_id_seq")}
        ),
        @GenericGenerator(
                name = "AUTHOR_GENERATOR",
                strategy = "enhanced-sequence",
                parameters = {@Parameter(name = "sequence_name", value = "library.author_id_seq")}
        ),
        @GenericGenerator(
                name = "BOOK_GENERATOR",
                strategy = "enhanced-sequence",
                parameters = {@Parameter(name = "sequence_name", value = "library.book_id_seq")}
        )
})
package ua.edu.chmnu.ki.network.lib.persistence.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Parameter;