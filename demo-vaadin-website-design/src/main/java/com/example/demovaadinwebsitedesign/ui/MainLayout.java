package com.example.demovaadinwebsitedesign.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayout extends AppLayout {

    public MainLayout() {
        H2 title = new H2("Homepage");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("line-height", "var(--lumo-size-l)").set("margin", "0 var(--lumo-space-m)");

        // configure popup menu on avatar
        var avatarMenu = new ContextMenu();
        avatarMenu.setOpenOnClick(true);
        var subMenuTheme = avatarMenu.addItem("Theme");
        subMenuTheme.getSubMenu().addItem("Light", click -> changeTheme(false));
        subMenuTheme.getSubMenu().addItem("Dark", click -> changeTheme(true));
        avatarMenu.add(new Hr());

        avatarMenu.addItem("Login", click -> gotoLogin());

        var avatar = new Avatar();
        avatar.getThemeNames().add("spacing-s");
        avatarMenu.setTarget(avatar);

        // configure header
        var topMenu = getTopNav();
        var headerLayout = new HorizontalLayout(new DrawerToggle(), title, topMenu,
                // https://vaadin.com/docs/latest/components/button -> button with icon
                // new Button("Add Task", new Icon(VaadinIcon.PLUS), e -> addTask()),
                // new Text(serviceSecurity.getUserDetail().getFullName()),
                avatar);
        // headerLayout.setPadding(true);
        headerLayout.setWidthFull();
        headerLayout.expand(topMenu);
        addToNavbar(headerLayout);

        // configure drawer
        // var nav = getSideNav();
        // var scroller = new Scroller(nav);
        // scroller.setClassName(LumoUtility.Padding.SMALL);
        // addToDrawer(scroller);
    }

    private SideNav getSideNav() {
        var sideNav = new SideNav();
        sideNav.addItem(new SideNavItem("Dashboard", "/", VaadinIcon.DASHBOARD.create()),
                new SideNavItem("Tasks", "/todo", VaadinIcon.LIST.create()));
        // if (serviceSecurity.isAdmin()) {
        //     sideNav.addItem(new SideNavItem("Admin", "/admin", VaadinIcon.RECORDS.create()));
        //     sideNav.addItem(
        //             new SideNavItem("Admin w/Paging", "/adminPaging", VaadinIcon.RECORDS.create()));
        // }
        // new SideNavItem("Orders", "/orders", VaadinIcon.CART.create()),
        // new SideNavItem("Customers", "/customers", VaadinIcon.USER_HEART.create()),
        // new SideNavItem("Products", "/products", VaadinIcon.PACKAGE.create()),
        // new SideNavItem("Analytics", "/analytics", VaadinIcon.CHART.create()),
        // );
        return sideNav;
    }

    private HorizontalLayout getTopNav() {
        var navigation = new HorizontalLayout();
        navigation.addClassNames(LumoUtility.JustifyContent.CENTER, LumoUtility.Gap.SMALL,
                LumoUtility.Height.MEDIUM);
        navigation.add(createLink("All"), createLink("Open"), createLink("Completed"),
                createLink("Cancelled"));
        return navigation;
    }


    // https://vaadin.com/blog/toggle-dark-lumo-theme-variant-dynamically
    private void changeTheme(boolean dark) {
        // e.getSource().setLabel(!isDark?"Switch to light": "Switch to dark");
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }

    private void gotoLogin() {
        //
    }

    private RouterLink createLink(String viewName) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        // Demo has no routes
        // link.setRoute(viewClass.java);

        link.addClassNames(LumoUtility.Display.FLEX, LumoUtility.AlignItems.CENTER,
                LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.TextColor.SECONDARY,
                LumoUtility.FontWeight.MEDIUM);
        link.getStyle().set("text-decoration", "none");

        return link;
    }
}
