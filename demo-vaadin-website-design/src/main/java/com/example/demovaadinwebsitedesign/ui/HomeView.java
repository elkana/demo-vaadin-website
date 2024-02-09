package com.example.demovaadinwebsitedesign.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout{
    public HomeView() {
        add(new H1("Home"));
    }
}
