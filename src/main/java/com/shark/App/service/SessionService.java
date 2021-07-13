package com.shark.App.service;


import com.shark.App.model.auth.Session;
import com.shark.App.repository.SessionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Component

public class SessionService {

    SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public String getLoginByToken(String token) {
        return sessionRepository.getLoginByToken(token);
    }

    public void saveSession(Session session) {
        sessionRepository.saveSession(session);
    }

    public boolean checkSessionRepository(Session session) {
        return sessionRepository.checkSessionRepository(session);
    }

    public void deleteSession(Session session) {
        sessionRepository.deleteSession(session);
    }

    public List<Session> getAll() {
        return sessionRepository.getSessionsRepository();
    }

    public Session getSessionByToken(String token) {
        return sessionRepository.getSessionByToken(token);
    }



}
