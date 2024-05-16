package com.app.BookARoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.BookARoom.dao.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
}
