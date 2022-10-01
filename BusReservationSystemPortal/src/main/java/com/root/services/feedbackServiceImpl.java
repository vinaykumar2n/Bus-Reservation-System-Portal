package com.root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.root.exceptions.BusException;
import com.root.exceptions.FeedBackException;
import com.root.models.Bus;
import com.root.models.Feedback;
import com.root.models.User;
import com.root.repository.BusDao;
import com.root.repository.UserDao;
import com.root.repository.feedbackDao;

@Service
public class feedbackServiceImpl implements feedbackService {

	@Autowired
	private feedbackDao fdao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private BusDao busDao;

	@Override
	public Feedback addFeedBack(Feedback feedBack, Integer uid, Integer bid) throws BusException, Exception {
		Optional<Bus> busOptional = busDao.findById(bid);
		if (busOptional.isEmpty()) {

			throw new BusException("bus is not present with this id");
		}

		Optional<User> userOptional = userDao.findById(uid);

		if (userOptional.isEmpty()) {

			throw new Exception("user id is not matched with database ++++++++++++++++++++++++++++++++++++++");
		}

		feedBack.setBus(busOptional.get());
		feedBack.setUser(userOptional.get());
		Feedback feedback = fdao.save(feedBack);

		return feedBack;
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback) throws FeedBackException {

		Optional<Feedback> fedOptional = fdao.findById(feedback.getFeedBackId());

		if (fedOptional.isPresent()) {

			return fdao.save(feedback);

		}

		throw new FeedBackException("not any feedback present");
	}

	@Override
	public Feedback viewFeedback(Integer id) throws FeedBackException {
		// TODO Auto-generated method stub
		Optional<Feedback> fedOptional = fdao.findById(id);
		if (fedOptional.isPresent()) {

			return fedOptional.get();

		}
		throw new FeedBackException("not any data related with this id");
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws FeedBackException {
		// TODO Auto-generated method stub
		Optional<List<Feedback>> fedOptional = Optional.of(fdao.findAll());
		if (fedOptional.isPresent()) {

			return fedOptional.get();

		}
		throw new FeedBackException("not any record in database");
	}

}
