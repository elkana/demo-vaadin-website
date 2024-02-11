package com.example.demovaadinwebsitedesign.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "pricing", layout = MainLayout.class)
public class PricingView extends VerticalLayout {
    public PricingView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        var h1 = new H1();
        h1.getElement().setProperty("innerHTML", "Millions of Creative Assets.<br>Unlimited Downloads");
        h1.addClassName("price-header");
        // var btn = new Button("Click Me");
        // btn.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY,
        // ButtonVariant.LUMO_SUCCESS);

        var btn1 = new Button("Large", new Icon(VaadinIcon.ARROW_RIGHT));
        var btn2 = new Button("Small", new Icon(VaadinIcon.ARROW_UP));
        var btn3 = new Button("Medium", new Icon(VaadinIcon.ARROW_FORWARD));
        var btn4 = new Button("X-Large", new Icon(VaadinIcon.ARROW_CIRCLE_LEFT));
        var btns = new HorizontalLayout(btn1, btn2, btn3, btn4);
        btns.setSpacing(true);

        add(h1, btns, new Paragraph(), priceTheme1(), priceTheme1(), priceTheme1());
    }

    private VerticalLayout priceTheme1() {
        var h2 = new H2("Murah");

        var p = new Paragraph("Murah karena laris");

        var box = new VerticalLayout(h2, p);
        box.addClassName("price-theme1");

        return box;
    }
}
