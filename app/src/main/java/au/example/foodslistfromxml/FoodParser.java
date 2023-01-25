package au.example.foodslistfromxml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class FoodParser {
    private XmlPullParser xpp;

    public FoodParser(XmlPullParser xpp) throws XmlPullParserException, IOException {
        this.xpp = xpp;
    }

    public ArrayList<Food> getFoodsList() {
        ArrayList<Food> foodsList = new ArrayList<>();
        try {
            String nodeName = "";

            String foodName = "";
            String calories = "";

            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_TAG) {
                    if ( xpp.getName().equals("name")) {
                        nodeName = "name";
                    }
                    else if (xpp.getName().equals("calories")) {
                        nodeName = "calories";
                    }
                    else {
                        nodeName = "";
                    }
                }
                else if(eventType == XmlPullParser.TEXT) {
                    if (nodeName.equals("name")) {
                        foodName = xpp.getText();
                    }
                    else if (nodeName.equals("calories")) {
                        calories = xpp.getText();
                    }
                }
                else if(eventType == XmlPullParser.END_TAG && xpp.getName().equals("food")) {
                    foodsList.add(new Food(foodName, calories));
                }

                eventType = xpp.next();
            }
            return foodsList;
        }
            catch (Throwable t) {
            return foodsList;
        }
    }
}
