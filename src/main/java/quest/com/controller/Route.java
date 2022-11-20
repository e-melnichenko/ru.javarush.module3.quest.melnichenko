package quest.com.controller;

public final class Route {
    public static final String AUTH = "/auth";
    public static final String SIGN_IN = AUTH + "/sign-in";
    public static final String SIGN_UP = AUTH + "/sign-up";
    public static final String USER_NOT_FOUND = AUTH + "/user-not-found";
    public static final String LOGOUT = "/logout";

    public static final String HOME = "/";
    public static final String GAME = "/game";
    public static final String NEW_GAME = GAME + "/new";
    public static final String GAME_ANSWER = GAME + "/answer";
    public static final String WIN = "/win";
    public static final String LOSE = "/lose";
}
