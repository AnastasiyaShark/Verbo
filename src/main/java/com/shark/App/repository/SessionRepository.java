package com.shark.App.repository;

import com.shark.App.model.auth.Session;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Vector;
@Getter
@ToString
@Repository
//@Component
public class SessionRepository {

    private final List<Session> sessionsRepository;

    public SessionRepository() {
        this.sessionsRepository = new Vector<>();
    }


    public void saveSession(Session session) {
        sessionsRepository.add(session);
    }

    public boolean checkSessionRepository(Session session) {
        for (Session session1 : sessionsRepository) {

//            || session1.getEmail().equals(session.getEmail())
            if (session1.getToken().equals(session.getToken()) ) {
                return false;
            }
        }
        return true;
    }

    public void deleteSession(Session session) {
        sessionsRepository.remove(session);
    }


    public String getLoginByToken(String token) {
        for (Session session : sessionsRepository) {
            if (session.getToken().equals(token)) {
                return session.getEmail();
            }
        }
        return null;
    }

    public Session getSessionByToken(String token) {
        for (Session session : sessionsRepository) {
            if (session.getToken().equals(token)) {
                return session;
            }
        }
        return null;
    }

    //    public List<Session> getSessionsRepository() {
//        return sessionsRepository;
//    }

}
