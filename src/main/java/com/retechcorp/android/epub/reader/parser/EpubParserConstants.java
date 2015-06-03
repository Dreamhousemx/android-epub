package com.retechcorp.android.epub.reader.parser;

/**
 * Created by Meng on 15/4/8.
 */
public interface EpubParserConstants {

    public static final String JSON_KEY_TEXT = "text";
    public static final String JSON_KEY_TEXT_SIZE = "textSize";
    public static final String JSON_KEY_TEXT_COLOR = "textColor";

    public static final String CONSTANT_LABEL_PACKAGE = "package";
    public static final String CONSTANT_LABEL_UNIQUE_IDENTIFIER = "unique-identifier";
    public static final String CONSTANT_LABEL_VERSION = "version";

    public static final String CONSTANT_LABEL_METADATA = "metadata";
    public static final String CONSTANT_LABEL_MANIFEST = "manifest";
    public static final String CONSTANT_LABEL_SPINE = "spine";
    public static final String CONSTANT_LABEL_GUIDE = "guide";
    public static final String CONSTANT_LABEL_DC_IDENTIFIER = "dc:identifier";
    public static final String CONSTANT_LABEL_ID = "id";
    public static final String CONSTANT_LABEL_DC_TITLE = "dc:title";
    public static final String CONSTANT_LABEL_DC_LANGUAGE = "dc:language";
    public static final String CONSTANT_LABEL_DC_CREATOR = "dc:creator";
    public static final String CONSTANT_LABEL_DC_PUBLISHER = "dc:publisher";
    public static final String CONSTANT_LABEL_ITEM = "item";
    public static final String CONSTANT_LABEL_HREF = "href";
    public static final String CONSTANT_LABEL_MEDIA_TYPE = "media-type";
    public static final String CONSTANT_LABEL_MEDIA_TYPE_VALUE_APPLICATION_XHTML_XML = "application/xhtml+xml";
    public static final String CONSTANT_LABEL_TOC = "toc";
    public static final String CONSTANT_LABEL_ITEM_REF = "itemref";
    public static final String CONSTANT_LABEL_ID_REF = "idref";
    public static final String CONSTANT_LABEL_REFERENCE = "reference";
    public static final String CONSTANT_LABEL_TITLE = "title";
    public static final String CONSTANT_LABEL_TYPE = "type";

    public static final String NCX_LABEL_VERSION = "version";
    public static final String NCX_LABEL_NAVMAP = "navMap";
    public static final String NCX_LABEL_NCX = "ncx";
    public static final String NCX_LABEL_NAV = "nav";
    public static final String NCX_LABEL_SECTION = "section";
    public static final String NCX_LABEL_A = "a";
    public static final String NCX_LABEL_LI = "li";
    public static final String NCX_LABEL_A_HREF = "href";
    public static final String NCX_LABEL_NAVPOINT = "navPoint";
    public static final String NCX_LABEL_ID = "id";
    public static final String NCX_LABEL_PLAYORDER = "playOrder";
    public static final String NCX_LABEL_TEXT = "text";
    public static final String NCX_LABEL_SRC = "src";
    public static final String NCX_LABEL_CONTENT = "content";


    public static final String CONSTANT_HTML_TAG_NAME_A = "a";
    public static final String CONSTANT_HTML_TAG_NAME_ABBR = "abbr";
    public static final String CONSTANT_HTML_TAG_NAME_ACRONYM = "acronym";
    public static final String CONSTANT_HTML_TAG_NAME_ADDRESS = "address";
    public static final String CONSTANT_HTML_TAG_NAME_APPLET = "applet";
    public static final String CONSTANT_HTML_TAG_NAME_AREA = "area";
    public static final String CONSTANT_HTML_TAG_NAME_ARTICLE = "article";
    public static final String CONSTANT_HTML_TAG_NAME_ASIDE = "aside";
    public static final String CONSTANT_HTML_TAG_NAME_AUDIO = "audio";
    public static final String CONSTANT_HTML_TAG_NAME_B = "b";
    public static final String CONSTANT_HTML_TAG_NAME_BASE = "base";
    public static final String CONSTANT_HTML_TAG_NAME_BASEFONT = "basefont";
    public static final String CONSTANT_HTML_TAG_NAME_BDI = "bdi";
    public static final String CONSTANT_HTML_TAG_NAME_BDO = "bdo";
    public static final String CONSTANT_HTML_TAG_NAME_BIG = "big";
    public static final String CONSTANT_HTML_TAG_NAME_BLOCKQUOTE = "blockquote";
    public static final String CONSTANT_HTML_TAG_NAME_BODY = "body";
    public static final String CONSTANT_HTML_TAG_NAME_BR = "br";
    public static final String CONSTANT_HTML_TAG_NAME_BUTTON = "button";
    public static final String CONSTANT_HTML_TAG_NAME_CANVAS = "canvas";
    public static final String CONSTANT_HTML_TAG_NAME_CAPTION = "caption";
    public static final String CONSTANT_HTML_TAG_NAME_CENTER = "center";
    public static final String CONSTANT_HTML_TAG_NAME_CITE = "cite";
    public static final String CONSTANT_HTML_TAG_NAME_CODE = "code";
    public static final String CONSTANT_HTML_TAG_NAME_COL = "col";
    public static final String CONSTANT_HTML_TAG_NAME_COLGROUP = "colgroup";
    public static final String CONSTANT_HTML_TAG_NAME_COMMAND = "command";
    public static final String CONSTANT_HTML_TAG_NAME_DATALIST = "datalist";
    public static final String CONSTANT_HTML_TAG_NAME_DD = "dd";
    public static final String CONSTANT_HTML_TAG_NAME_DEL = "del";
    public static final String CONSTANT_HTML_TAG_NAME_DETAILS = "details";
    public static final String CONSTANT_HTML_TAG_NAME_DFN = "dfn";
    public static final String CONSTANT_HTML_TAG_NAME_DIR = "dir";
    public static final String CONSTANT_HTML_TAG_NAME_DIV = "div";
    public static final String CONSTANT_HTML_TAG_NAME_DL = "dl";
    public static final String CONSTANT_HTML_TAG_NAME_DT = "dt";
    public static final String CONSTANT_HTML_TAG_NAME_EM = "em";
    public static final String CONSTANT_HTML_TAG_NAME_EMBED = "embed";
    public static final String CONSTANT_HTML_TAG_NAME_FIELDSET = "fieldset";
    public static final String CONSTANT_HTML_TAG_NAME_FIGCAPTION = "figcaption";
    public static final String CONSTANT_HTML_TAG_NAME_FIGURE = "figure";
    public static final String CONSTANT_HTML_TAG_NAME_FONT = "font";
    public static final String CONSTANT_HTML_TAG_NAME_FOOTER = "footer";
    public static final String CONSTANT_HTML_TAG_NAME_FORM = "form";
    public static final String CONSTANT_HTML_TAG_NAME_FRAME = "frame";
    public static final String CONSTANT_HTML_TAG_NAME_FRAMESET = "frameset";
    public static final String CONSTANT_HTML_TAG_NAME_H1 = "h1";
    public static final String CONSTANT_HTML_TAG_NAME_H2 = "h2";
    public static final String CONSTANT_HTML_TAG_NAME_H3 = "h3";
    public static final String CONSTANT_HTML_TAG_NAME_H4 = "h4";
    public static final String CONSTANT_HTML_TAG_NAME_H5 = "h5";
    public static final String CONSTANT_HTML_TAG_NAME_H6 = "h6";
    public static final String CONSTANT_HTML_TAG_NAME_HEAD = "head";
    public static final String CONSTANT_HTML_TAG_NAME_HEADER = "header";
    public static final String CONSTANT_HTML_TAG_NAME_HGROUP = "hgroup";
    public static final String CONSTANT_HTML_TAG_NAME_HR = "hr";
    public static final String CONSTANT_HTML_TAG_NAME_HTML = "html";
    public static final String CONSTANT_HTML_TAG_NAME_I = "i";
    public static final String CONSTANT_HTML_TAG_NAME_IFRAME = "iframe";
    public static final String CONSTANT_HTML_TAG_NAME_IMG = "img";
    public static final String CONSTANT_HTML_TAG_NAME_IMAGE = "image";
    public static final String CONSTANT_HTML_TAG_NAME_INPUT = "input";
    public static final String CONSTANT_HTML_TAG_NAME_INS = "ins";
    public static final String CONSTANT_HTML_TAG_NAME_ISINDEX = "isindex";
    public static final String CONSTANT_HTML_TAG_NAME_KBD = "kbd";
    public static final String CONSTANT_HTML_TAG_NAME_KEYGEN = "keygen";
    public static final String CONSTANT_HTML_TAG_NAME_LABEL = "label";
    public static final String CONSTANT_HTML_TAG_NAME_LEGEND = "legend";
    public static final String CONSTANT_HTML_TAG_NAME_LI = "li";
    public static final String CONSTANT_HTML_TAG_NAME_LINK = "link";
    public static final String CONSTANT_HTML_TAG_NAME_MAP = "map";
    public static final String CONSTANT_HTML_TAG_NAME_MARK = "mark";
    public static final String CONSTANT_HTML_TAG_NAME_MENU = "menu";
    public static final String CONSTANT_HTML_TAG_NAME_META = "meta";
    public static final String CONSTANT_HTML_TAG_NAME_METER = "meter";
    public static final String CONSTANT_HTML_TAG_NAME_NAV = "nav";
    public static final String CONSTANT_HTML_TAG_NAME_NOFRAMES = "noframes";
    public static final String CONSTANT_HTML_TAG_NAME_NOSCRIPT = "noscript";
    public static final String CONSTANT_HTML_TAG_NAME_OBJECT = "object";
    public static final String CONSTANT_HTML_TAG_NAME_OL = "ol";
    public static final String CONSTANT_HTML_TAG_NAME_OPTGROUP = "optgroup";
    public static final String CONSTANT_HTML_TAG_NAME_OPTION = "option";
    public static final String CONSTANT_HTML_TAG_NAME_OUTPUT = "output";
    public static final String CONSTANT_HTML_TAG_NAME_P = "p";
    public static final String CONSTANT_HTML_TAG_NAME_PARAM = "param";
    public static final String CONSTANT_HTML_TAG_NAME_PRE = "pre";
    public static final String CONSTANT_HTML_TAG_NAME_PROGRESS = "progress";
    public static final String CONSTANT_HTML_TAG_NAME_Q = "q";
    public static final String CONSTANT_HTML_TAG_NAME_RP = "rp";
    public static final String CONSTANT_HTML_TAG_NAME_RT = "rt";
    public static final String CONSTANT_HTML_TAG_NAME_RUBY = "ruby";
    public static final String CONSTANT_HTML_TAG_NAME_S = "s";
    public static final String CONSTANT_HTML_TAG_NAME_SAMP = "samp";
    public static final String CONSTANT_HTML_TAG_NAME_SCRIPT = "script";
    public static final String CONSTANT_HTML_TAG_NAME_SECTION = "section";
    public static final String CONSTANT_HTML_TAG_NAME_SELECT = "select";
    public static final String CONSTANT_HTML_TAG_NAME_SMALL = "small";
    public static final String CONSTANT_HTML_TAG_NAME_SOURCE = "source";
    public static final String CONSTANT_HTML_TAG_NAME_SPAN = "span";
    public static final String CONSTANT_HTML_TAG_NAME_STRIKE = "strike";
    public static final String CONSTANT_HTML_TAG_NAME_STRONG = "strong";
    public static final String CONSTANT_HTML_TAG_NAME_STYLE = "style";
    public static final String CONSTANT_HTML_TAG_NAME_SUB = "sub";
    public static final String CONSTANT_HTML_TAG_NAME_SUMMARY = "summary";
    public static final String CONSTANT_HTML_TAG_NAME_SUP = "sup";
    public static final String CONSTANT_HTML_TAG_NAME_TABLE = "table";
    public static final String CONSTANT_HTML_TAG_NAME_TBODY = "tbody";
    public static final String CONSTANT_HTML_TAG_NAME_TD = "td";
    public static final String CONSTANT_HTML_TAG_NAME_TEXTAREA = "textarea";
    public static final String CONSTANT_HTML_TAG_NAME_TFOOT = "tfoot";
    public static final String CONSTANT_HTML_TAG_NAME_TH = "th";
    public static final String CONSTANT_HTML_TAG_NAME_THEAD = "thead";
    public static final String CONSTANT_HTML_TAG_NAME_TIME = "time";
    public static final String CONSTANT_HTML_TAG_NAME_TITLE = "title";
    public static final String CONSTANT_HTML_TAG_NAME_TR = "tr";
    public static final String CONSTANT_HTML_TAG_NAME_TT = "tt";
    public static final String CONSTANT_HTML_TAG_NAME_U = "u";
    public static final String CONSTANT_HTML_TAG_NAME_UL = "ul";
    public static final String CONSTANT_HTML_TAG_NAME_VAR = "var";
    public static final String CONSTANT_HTML_TAG_NAME_VIDEO = "video";
    public static final String CONSTANT_HTML_TAG_NAME_WBR = "wbr";
    public static final String CONSTANT_HTML_TAG_ATTRIBUTE_HREF = "href";
    public static final String CONSTANT_HTML_TAG_ATTRIBUTE_XLINK_HREF = "xlink:href";
    public static final String CONSTANT_HTML_TAG_ATTRIBUTE_SRC = "src";

    /**
     * 行间距
     */
    public static final int CONSTANT_LINE_SPACING = 20;
    /**
     * 字间距
     */
    public static final int CONSTANT_WORD_SPACING = 10;
    /**
     * 渲染视图的个数
     */
    public static final int CONSTANT_ENDER = 3;
    /**
     * 前进和后退的缓冲区大小
     */
    public static final int CONSTANT_CACHE = 7;

}
