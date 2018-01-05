# colorcon
static java class that provides color output to console through in-string markup labels.

## use

<l1>ansi reset:		/<l1>
<l1>ansi bold:		b<l1>
<l1>ansi white:		w	white<l1>
<l1>ansi black:			black<l1>
<l1>ansi red:		r	red<l1>
<l1>ansi green:		g	green<l1>
<l1>ansi yellow:	y	yellow<l1>
<l1>ansi blue:			blue<l1>
<l1>ansi purple:	p	purple<l1>
<l1>ansi cyan:		c 	cyan<l1>

<l1>ansi black background:		bb<l1>
<l1>ansi white background: 		wb<l1>
<l1>ansi red background:		rb<l1>

<l1>ansi black underline:		bu<l1>
<l1>ansi white underline:		wu<l1>
<l1>ansi red underline:			ru<l1>
<l1>ansi green underline:		gu<l1>
<l1>ansi yellow undelrine:		yu<l1>
<l1>ansi blue underline:				blueu<l1>
<l1>ansi purple underline:		pu<l1>
<l1>ansi cyan underline:		cu<l1>


The above tgs may be used at the beginning of a java string, with the string
then logged to console/terminal through the Console.log() method. The class will
automatically parse the string for tags and replace the tags in-string with the
corresponding ansi color code. When using the tag, only incllude the opening tag
of the color/effect that you want to include, and use the ansi reset tag (</>)
at the end of the current string or the beginning of the next string to reset
the color of the output.
##

##example code:

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
