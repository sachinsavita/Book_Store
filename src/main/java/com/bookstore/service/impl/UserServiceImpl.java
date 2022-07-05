package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.security.PasswordResetToken;
import com.bookstore.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token)
	{
		return passwordResetRepository.findByToken(token);
	}
	
	@Override
	public void createPasswordResetTokenForUser(final User user, final String token)
	{
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

}
