package com.fm.www.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.fm.www.dao.face.VisitCountDao;


public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		VisitCountDao visitCountDAO = new VisitCountDao();
        
        int todayCount = 0;
        int totalCount = 0;
        
        // 전체 방문자 수 +1
        try {
            visitCountDAO.setVisitTotalCount();
             // 오늘 방문자 수
             todayCount = visitCountDAO.getVisitTodayCount();
          
             // 전체 방문자 수
             totalCount = visitCountDAO.getVisitTotalCount();
        } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }
        
        HttpSession session = se.getSession();
        
        // 세션 속성에 담아준다.
        session.setAttribute("totalCount", totalCount); // 전체 방문자 수
        session.setAttribute("todayCount", todayCount); // 오늘 방문자 수
    }
 
     @Override
     public void sessionDestroyed(HttpSessionEvent arg0) {
      // TODO Auto-generated method stub
     }
}


