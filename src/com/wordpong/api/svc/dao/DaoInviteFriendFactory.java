package com.wordpong.api.svc.dao;



public class DaoInviteFriendFactory {
	public static DaoInviteFriend getDaoInviteFriend() {
		return new DaoInviteFriendImpl();
	}
}
