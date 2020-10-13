package entity;

/**
 * 返回码
 */
public class StatusCode {
    public static final int OK = 20000;// success
    public static final int ERROR = 20001;// failed
    public static final int LOGINERROR = 20002;// username or password false
    public static final int ACCESSERROR = 20003;// authority not enough
    public static final int REMOTEERROR = 20004;//remote call fail
    public static final int REPERROR = 20005;// repeat call
    public static final int NOTFOUNDERROR = 20006;// no found data
}
