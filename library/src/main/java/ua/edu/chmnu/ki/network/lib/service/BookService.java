package ua.edu.chmnu.ki.network.lib.service;

import ua.edu.chmnu.ki.network.lib.web.dto.BookDTO;
import ua.edu.chmnu.ki.network.lib.filter.dto.BookFilterDTO;

public interface BookService extends CrudService<BookDTO>, SearchService<BookDTO, BookFilterDTO> {
}
