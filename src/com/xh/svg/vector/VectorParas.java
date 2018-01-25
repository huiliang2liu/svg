package com.xh.svg.vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.xh.ifaces.ISVG;
import com.xh.svg.ASVGParser;
import com.xh.util.XhLog;
import com.xh.util.XhPhoneInformation;

/**
 * @version 创建时间：2018-1-9 下午6:24:21 项目：repair 包名：com.xh.svg.vector
 *          文件名：VectorParas1.java 作者：lhl 说明:
 */

public class VectorParas extends ASVGParser {
	private final static String WIDTH = "width";
	private final static String HEIGHT = "height";
	private final static String VIEWPORT_HEIGHT = "viewportHeight";
	private final static String VIEWPORT_WIDTH = "viewportWidth";
	private final static String FILL_COLOR = "fillColor";
	private final static String PATH_DATA = "pathData";
	private final static String STROKE_WIDTH = "strokeWidth";
	private final static String STROKE_COLOR = "strokeColor";
	private final static String STROKE_ALPHA = "strokeAlpha";
	private final static String STROKE_LINE_CAP = "strokeLineCap";
	private final static String STROKE_JOIN = "strokeJoin";
	private final static String STROKE_DASHARRAY = "strokeDasharray";
	private final static String STOKE_DASHOFFSET = "strokeDashoffset";
	private final static String ID = "id";
	private final static String TEXT = "text";
	private final static String TEXT_COLOR = "textColor";
	private final static String TEXT_ALPHA = "textAlpha";
	private final static String TEXT_SUBPIXEL = "textSubpixel";
	private final static String TEXT_UNDERLINE = "textUnderline";
	private final static String TEXT_STRIKE_THRU = "textStrikeThru";
	private final static String TEXT_FAKE_BOLD = "textFakeBoldText";
	private final static String X = "x";
	private final static String Y = "y";
	private final static String H_OFFSET = "hOffset";
	private final static String V_OFFSET = "vOffset";
	private final static String TEXT_PATH = "textPath";
	private static VectorParas vectorParas;

	public VectorParas(XhPhoneInformation information) {
		super(information);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected SAXParasHandler parasHandler() {
		// TODO Auto-generated method stub
		return new VectorParasHandler();
	}

	public static VectorParas init(XhPhoneInformation information) {
		if (vectorParas == null) {
			synchronized ("VectorParas") {
				if (vectorParas == null)
					vectorParas = new VectorParas(information);
			}
		}
		return vectorParas;
	}

	private class VectorParasHandler extends SAXParasHandler {
		VectorEntity vectorEntity;

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			vectorEntity = new VectorEntity(information);
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			if (qName.equals("vector")) {
				if (attributes != null) {
					for (int i = 0; i < attributes.getLength(); i++) {
						String key = attributes.getLocalName(i);
						String value = attributes.getValue(i);
						if (key.equals(WIDTH)) {
							vectorEntity.setWidth(value);
						} else if (key.equals(HEIGHT)) {
							vectorEntity.setHeigth(value);
						} else if (key.equals(VIEWPORT_HEIGHT)) {
							vectorEntity.setViewBoxHeigth(value);
						} else if (key.equals(VIEWPORT_WIDTH)) {
							vectorEntity.setViewBoxWidth(value);
						}
					}
				}
			} else if (qName.equals("path")) {
				if (attributes != null) {
					PathData pathData = new PathData();
					for (int i = 0; i < attributes.getLength(); i++) {
						String key = attributes.getLocalName(i);
						String value = attributes.getValue(i);
						XhLog.e(key);
						if (key.equals(FILL_COLOR)) {
							pathData.setFillColor(value);
						} else if (key.equals(PATH_DATA)) {
							pathData.setPath(value);
						} else if (key.equals(STROKE_WIDTH)) {
							pathData.setStrokeWidth(Float.valueOf(value));
						} else if (key.equals(STROKE_COLOR)) {
							pathData.setStrokeColor(value);
						} else if (key.equals(STROKE_ALPHA)) {
							pathData.setStrokeAlpha(Float.valueOf(value));
						} else if (key.equals(STROKE_LINE_CAP)) {
							pathData.setStrokeLineCap(value);
						} else if (key.equals(STROKE_JOIN)) {
							pathData.setStrokeLineCap(value);
						} else if (key.equals(STROKE_DASHARRAY)) {
							pathData.setStrokeDasharray(value);
						} else if (key.equals(STOKE_DASHOFFSET)) {
							pathData.setStrokeDashoffset(value);
						} else if (key.equals(ID)) {
							pathData.setId(value);
						}
					}
					vectorEntity.add(pathData);
				}
			} else if (qName.equals("text")) {
				TextData textData = new TextData();
				for (int i = 0; i < attributes.getLength(); i++) {
					String key = attributes.getLocalName(i);
					String value = attributes.getValue(i);
					XhLog.e(key);
					if (key.equals(TEXT)) {
						textData.setText(value);
					} else if (key.equals(TEXT_COLOR)) {
						textData.setTextColor(value);
					} else if (key.equals(TEXT_ALPHA)) {
						textData.setTextAlpha(value);
					} else if (key.equals(TEXT_SUBPIXEL)) {
						textData.setSubpixelText(Boolean.valueOf(value));
					} else if (key.equals(TEXT_UNDERLINE)) {
						textData.setUnderlineText(Boolean.valueOf(value));
					} else if (key.equals(TEXT_STRIKE_THRU)) {
						textData.setStrikeThruText(Boolean.valueOf(value));
					} else if (key.equals(TEXT_FAKE_BOLD)) {
						textData.setFakeBoldText(Boolean.valueOf(value));
					} else if (key.equals(X)) {
						textData.setX(Float.valueOf(value));
					} else if (key.equals(Y)) {
						textData.setY(Float.valueOf(value));
					} else if (key.equals(H_OFFSET)) {
						textData.sethOffset(Float.valueOf(value));
					} else if (key.equals(V_OFFSET)) {
						textData.setvOffset(Float.valueOf(value));
					} else if (key.equals(TEXT_PATH)) {
						vectorEntity.id2pathData(value);
					}
				}
				vectorEntity.add(textData);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}

		@Override
		public ISVG svg() {
			// TODO Auto-generated method stub
			return vectorEntity;
		}
	}
}
