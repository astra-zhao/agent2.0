package com.publics;
import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.jsp.*;
import net.sf.navigator.displayer.MenuDisplayerMapping;
import net.sf.navigator.displayer.MessageResourcesMenuDisplayer;
import net.sf.navigator.menu.MenuComponent;
public class PermissionsFormMenuDisplayer2
		extends
			MessageResourcesMenuDisplayer {
	private static final MessageFormat itemMessage = new MessageFormat(
			"<tr><td class=\"smd-menu-item\">{0} {1} {2} {3}</td></tr>");
	public PermissionsFormMenuDisplayer2() {
	}
	public void init(PageContext pageContext, MenuDisplayerMapping mapping) {
		super.init(pageContext, mapping);
		try {
			out.println(displayStrings.getMessage("smd.style"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	public void display(MenuComponent menu) throws JspException, IOException {
		out.println(displayStrings.getMessage("smd.menu.top"));
		displayComponents(menu, 0, 0);
		out.println(displayStrings.getMessage("smd.menu.bottom"));
	}
	protected void displayComponents(MenuComponent menu, int level, int f)
			throws JspException, IOException {
		MenuComponent components[] = menu.getMenuComponents();
		if (components.length > 0) {
			if (isAllowed(menu)) {
				out.print(getMenuItem(menu, getSpace(level + 2), 1));
			} else {
				out.print(getMenuItem(menu, getSpace(level + 2), 0));
			}
			for (int i = 0; i < components.length; i++) {
				if (components[i].getMenuComponents().length > 0) {
					if (isAllowed(components[i])) {
						displayComponents(components[i], level + 2, 1);
					} else {
						displayComponents(components[i], level + 2, 0);
					}
				} else if (isAllowed(components[i])) {
					out.println(getMenuItem(components[i], getSpace(level + 6),
							1));
				} else {
					out.println(getMenuItem(components[i], getSpace(level + 6),
							0));
				}
			}
		} else {
			if (isAllowed(menu)) {
				out.print(getMenuItem(menu, getSpace(level + 2), 1));
			} else {
				out.print(getMenuItem(menu, getSpace(level + 2), 0));
			}
		}
	}
	protected String getSpace(int length) {
		String space = "";
		for (int i = 0; i < length; i++)
			space = space + "&nbsp;" + "&nbsp;";
		return space;
	}
	protected String getImage(MenuComponent menu) {
		String imageTag;
		if (menu.getImage() == null || menu.getImage().equals(""))
			imageTag = "";
		else
			imageTag = displayStrings.getMessage("smd.menu.item.image", menu
					.getImage(), super.getMenuToolTip(menu));
		return imageTag;
	}
	protected static final String nbsp = "&nbsp;";
	private String getMenuItem(MenuComponent menu, String space, int f) {
		if (f == 0)
			return itemMessage.format(new String[]{space, "", "",
					getMessage(menu.getTitle())});
		else
			return itemMessage.format(new String[]{space, "", "",
					getMessage(menu.getTitle())});
	}
}