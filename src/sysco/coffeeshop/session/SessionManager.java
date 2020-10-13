package sysco.coffeeshop.session;

import java.util.Vector;

import sysco.coffeeshop.appManager.ObjectManager;

public class SessionManager implements ObjectManager<Session> {
	private Vector<Session> sessions;

	public Vector<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Vector<Session> sessions) {
		this.sessions = sessions;
	}

	// CONSTRUCTORS
	public SessionManager(Vector<Session> sessions) {
		this.sessions = sessions;
	}

	public SessionManager() {
		this.sessions = new Vector<Session>();
	}

	@Override
	public void create(Session obj) {
		sessions.add(obj);
	}

	@Override
	public void delete(String username) {
		for (Session session : sessions) {
			if (session.getUsername().equals(username)) {
				this.sessions.remove(session);
			}
		}
	}

	@Override
	public Session read(String username) {
		for (Session session : sessions) {
			if (session.getUsername().equals(username)) {
				return session;
			}
		}
		return null;
	}

	@Override
	public boolean exists(Session obj) {
		for (Session session : sessions) {
			if (session.getUsername().equals(obj.getUsername()) && session.getPassword().equals(obj.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String msg = "";
		for (Session session : sessions) {
			msg += session.getUsername().toString() + "\n";
			msg += session.getPassword().toString() + "\n\n";
		}
		return msg;
	}

}
