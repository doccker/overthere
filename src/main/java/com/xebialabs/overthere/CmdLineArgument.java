package com.xebialabs.overthere;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

/**
 * Represents a single command line argument.
 */
@SuppressWarnings("serial")
public class CmdLineArgument implements Serializable {

	private String arg;

	private boolean isPassword;

	private CmdLineArgument(String arg, boolean password) {
		this.arg = arg;
		isPassword = password;
	}

	/**
	 * Creates a regular argument.
	 * 
	 * @param arg
	 *            the argument string.
	 * @return the created argument.
	 */
	public static CmdLineArgument arg(String arg) {
		checkNotNull(arg, "Cannot create null argument");
		return new CmdLineArgument(arg, false);
	}

	/**
	 * Creates a password argument.
	 * 
	 * @param arg
	 *            the argument string.
	 * @return the created argument.
	 */
	public static CmdLineArgument password(String arg) {
		checkNotNull(arg, "Cannot create null password argument");
		return new CmdLineArgument(arg, true);
	}

	/**
	 * Returns the argument string.
	 * 
	 * @return the argument string.
	 */
	public String getArg() {
		return arg;
	}

	/**
	 * Tests whether this argument is a password argument.
	 * 
	 * @return <code>true</code> if and only if this argument is a password argument.
	 */
	public boolean isPassword() {
		return isPassword;
	}

	/**
	 * Returns a string representation of this argument. If this argument is a password argument and it will be displayed as a log, it is replaced by eight
	 * stars.
	 * 
	 * @param forLogging
	 *            <code>true</code> if this string representation will be used for logging.
	 * @return the string representation of this argument.
	 */
	public String toString(boolean forLogging) {
		if (isPassword() && forLogging) {
			return "********";
		}
		return arg;
	}

	/**
	 * Invokes <code>toString(true)</code>.
	 */
	@Override
	public String toString() {
		return toString(true);
	}

}
