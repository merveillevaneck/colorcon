# colorcon
static java class that provides color output to console through in-string markup labels.

## use

ansi reset:		/
ansi bold:		b
ansi white:		w	white
ansi black:			black
ansi red:		r	red
ansi green:		g	green	
ansi yellow:	y	yellow
ansi blue:			blue
ansi purple:	p	purple
ansi cyan:		c 	cyan

ansi black background:		bb
ansi white background: 		wb
ansi red background:		rb

ansi black underline:		bu
ansi white underline:		wu
ansi red underline:			ru
ansi green underline:		gu
ansi yellow undelrine:		yu
ansi blue underline:			blueu
ansi purple underline:		pu
ansi cyan underline:		cu


The above tgs may be used at the beginning of a java string, with the string
then logged to console/terminal through the Console.log() method. The class will
automatically parse the string for tags and replace the tags in-string with the
corresponding ansi color code. When using the tag, only incllude the opening tag
of the color/effect that you want to include, and use the ansi reset tag (</>)
at the end of the current string or the beginning of the next string to reset
the color of the output.
##

##exmple code:

```java
String blackred = "<black>Hello, World! </><red>I am alive!";
Console.log(blackred);
```

If you wish to add more color codes to this class, simply find the corresponding
ansi color code and add it to the list of static final ANSI strings, and add the
corresponding case in the switch statement that returns the corresponding ANSI
color code when a specific tag if found.

The parsing method parses the tags recursively.

##Installation

If you wish to use this class, simply clone the repo into your working direcory
and copy the Console.java file into your project.

##Happy hacking!
