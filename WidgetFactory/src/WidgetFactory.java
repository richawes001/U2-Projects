import javax.swing.*;

public class WidgetFactory {

    /*
    Lessons L1 - L3

    You have been asked by the manager of the Widget Factory to create a program which will tell how many days it will take to produce a number of widgets.
    It should also output the cost of the widgets, the cost to produce the widget and the profit.

    Specific Details:
     - 10 Widgets are made each hour
     - Plant runs 2 shifts of 8 hours a day, requiring 5 workers a shift
     - each worker makes $16.50 an hour
     - each widget sells for $10

     Programming Details:
     - prompt the user for the number of widgets using pop-up boxes
     - display # of widgets, # of days, Cost of production, Cost of widgets and profit
     - 2 or more (preferably more) methods - at least 1 to calculate # of day and one to calculate production costs
     - only WHOLE number of days, no half or partial days.
     - Output should be in proper currency form

     Example Run:

     Number of Widgets: 1000
     # of Days: 7
     Cost of Widgets: $10,000.00
     Cost of Production: $9,240.00
     Profit: $760.00

     */

    /* The Plan

        1. Get Inputs
        2. Calculate Number of Days to make that many widgets
        3. Calculate the Widget Cost
        4. Calculate the Production Cost (Number of hours * Pay per Hour) * Number of People Per Shift
        5. Calculate Profit
        6. Display Results

     */

    static double hourlyCost = 16.50;
    static double widgetCost = 10.00;

    public static void main(String[] args) {

        //1.
        int widgets = getInput("Please enter how many widgets you purchased.");
        //2.
        double numDays = numDays(widgets);
        //3.
        double widgetCost = widgetCost(widgets);
        //4.
        double productionCost = productionCost(widgets);
        //5.
        double profit = profit(widgetCost, productionCost);
        //6.
        JOptionPane.showMessageDialog(null,"The amount of days it takes to produce that many widgets is: " + numDays);
        JOptionPane.showMessageDialog(null,"The cost of buying that many widgets is: $" + widgetCost);
        JOptionPane.showMessageDialog(null,"The production cost of that many widgets is: $" + productionCost);
        JOptionPane.showMessageDialog(null,"The profit from selling that many widgets is: $" + profit);

        System.exit(0);

    }

    //get input from the user

    public static int getInput(String message){

        return Integer.parseInt(JOptionPane.showInputDialog(message));

    }

    //calculation to get number of days

    public static double numDays(int widgets){

        double rawTime = widgets * 360;
        double time = rawTime;

        return Math.ceil(time/57600);

    }

    //calculation to get the widget cost

    public static double widgetCost(int widgets){

        return widgets * widgetCost;

    }

    //calculation to get the production cost (BROKEN)

    public static double productionCost(int widgets){

        int rawTime = widgets * 360;
        int time = rawTime;
        int numHours = time/3600;

        return (numHours * hourlyCost) * 5;

    }

    //calculation to get the profit

    public static double profit(double widgetCost, double productionCost){

        return widgetCost - productionCost;

    }

}
