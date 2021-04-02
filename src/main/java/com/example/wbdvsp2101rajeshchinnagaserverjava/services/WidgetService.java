package com.example.wbdvsp2101rajeshchinnagaserverjava.services;

import com.example.wbdvsp2101rajeshchinnagaserverjava.models.Widget;
import com.example.wbdvsp2101rajeshchinnagaserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;
   /* private List<Widget> widgets = new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1l, "Welcome to Widgets");
        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1l, "This is a paragraph");
        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2l, "Welcome to WebDev");
        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1l, "Lorem ipsum");
        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
        widgets.add(w4);
    }*/
    // implement crud operations
    public Widget createWidgetForTopic(Widget widget) {
        return repository.save(widget);
       /* Long id = (new Date()).getTime();
        widget.setId(id);
        widgets.add(widget);
        return widget;*/
    }
    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
        //return (List<Widget>) repository.findAll();
        //return widgets;
    }
    public List<Widget> findWidgetsForTopic(String topicId) {
        /*List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                ws.add(w);
            }
        }
        return ws;*/
        return repository.findWidgetsForTopic(topicId);
    }
    public Widget findWidgetById(Long id) {
        /*for(Widget w: widgets) {
            if(w.getId().equals(id)) {
                return w;
            }
        }
        return null;*/
       // return repository.findById(id).get();
        return repository.findWidgetById(id);
    }
    public Integer updateWidget(Long id, Widget newWidget) {
        Widget originalWidget = repository.findById(id).get();
        if (newWidget.getText() != null) {
            originalWidget.setText(newWidget.getText());
        }
        if (newWidget.getType() != null) {
            originalWidget.setType(newWidget.getType());
        }
        if (newWidget.getSize() != null) {
            originalWidget.setSize(newWidget.getSize());
        }
        if (newWidget.getText() != null) {
            originalWidget.setText(newWidget.getText());
        }
        if (newWidget.getWidth() != null) {
            originalWidget.setWidth(newWidget.getWidth());
        }
        if (newWidget.getHeight() != null) {
            originalWidget.setHeight(newWidget.getHeight());
        }
        if (newWidget.getSrc() != null) {
            originalWidget.setSrc(newWidget.getSrc());
        }
        repository.save(originalWidget);
        return -1;
        /*for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;*/
    }
    public Integer deleteWidget(Long id) {

        repository.deleteById(id);
        return 1;
       /* int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                index = i;
            }
        }
        if(index >= 0) {
            widgets.remove(index);
            return 1;
        }
        return -1;*/
    }

}