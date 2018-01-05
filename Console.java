/**
 * Util for handling application logs. Imitates JavaScripts console.log() syntax.
 * Has support for ANSI codes by injecting codes into <></> tags
 */
public class Console {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_BLACK_UNDERLINED = "\033[4;30m";  
    public static final String ANSI_RED_UNDERLINED = "\033[4;31m";   
    public static final String ANSI_GREEN_UNDERLINED = "\033[4;32m";
    public static final String ANSI_YELLOW_UNDERLINED = "\033[4;33m";
    public static final String ANSI_BLUE_UNDERLINED = "\033[4;34m"; 
    public static final String ANSI_PURPLE_UNDERLINED = "\033[4;35m";
    public static final String ANSI_CYAN_UNDERLINED = "\033[4;36m"; 
    public static final String ANSI_WHITE_UNDERLINED = "\033[4;37m";


    public static String level = "INFO";

    /**
     * Set the current log level to record.
     *
     * @param _level
     */
    public static void setLevel(String _level) {
        level = _level;
    }

    /**
     * Maps a string to an ANSI code
     *
     * @param code
     * @return ANSI
     */
    private static String getANSI(String code) {
        switch (code) {

            case "/":
                return ANSI_RESET;
            case "b":
                return ANSI_BOLD;
			case "bb": 
				return ANSI_BLACK_BACKGROUND;
			case "wb":
				return ANSI_WHITE_BACKGROUND;
			case "rb":
				return ANSI_RED;
			case "bu":
				return ANSI_BLACK_UNDERLINED;
			case "wu":
				return ANSI_WHITE_UNDERLINED;
			case "ru":
				return ANSI_RED_BACKGROUND;
			case "gu":
				return ANSI_GREEN_UNDERLINED;
			case "yu":
				return ANSI_CYAN_UNDERLINED;
			case "blueu":
				return ANSI_BLUE_UNDERLINED;
			case "pu":
				return ANSI_PURPLE_UNDERLINED;
			case "cu":
				return ANSI_CYAN_UNDERLINED;
            case "red":
            case "r":
                return ANSI_RED;
            case "green":
            case "g":
                return ANSI_GREEN;
            case "yellow":
            case "y":
                return ANSI_YELLOW;
            case "blue":
                return ANSI_BLUE;
            case "purple":
            case "p":
                return ANSI_PURPLE;
            case "cyan":
            case "c":
                return ANSI_CYAN;
            case "white":
            case "w":
                return ANSI_WHITE;
			case "black":
				return ANSI_BLACK;
            default:
                return "";
        }
    }

    /**
     * Search for <color></> tags and replace them with ANSI codes
     *
     * @param string
     * @return String
     */
    private static String _parse(String string) {
        String _parsed = string;

        if (string.contains("<") && string.contains(">")) {
            Integer start = string.indexOf("<");
            Integer end = string.indexOf(">");
            if (start + 1 < end) {
                String ansi = getANSI(string.substring(start + 1, end));

                _parsed = string.substring(0, start) + ansi + string.substring(end + 1);
                return _parse(_parsed);
            }
        }

        return _parsed;
    }

    /**
     * Log out the parsed string [INFO]
     *
     * @param string
     */
    public static void log(String string) {
        System.out.println(_parse("</>" + string + "</>"));
    }

    /**
     * Log out the parsed string if in DEBUG mode [DEBUG]
     *
     * ANSI - <blue><b>
     *
     * @param string
     */
    public static void debug(String string) {
        if (level.equals("DEBUG") || level.equals("ALL")) {
            log("<b><blue>" + string);
        }
    }

    /**
     * Log out the parsed string [ERROR]
     *
     * ANSI - <red><b>
     *
     * @param string
     */
    public static void error(String string) {
        log("<red>" + string);
    }
}
