package in.akshaypack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.akshaypack.entity.BookNew;

public interface BookRepo extends JpaRepository<BookNew, Integer>{

}
