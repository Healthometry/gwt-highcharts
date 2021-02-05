package org.moxieapps.gwt.highcharts.showcase.client.stock;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;


public class ColumnRangeChartExample extends BaseChartExample {
    public ColumnRangeChartExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "stock/ColumnRangeChartExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new ColumnRangeChartExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Column Range";
            }

            @Override
            public String getIcon() {
                return "icons/16/stock_chart.png";
            }
        };
    }

    @Override
    public BaseChart createChart() {

        final StockChart chart = new StockChart();

        final Number[][] temperature = new Number[][]{
                {t(2008, 12, 31), -5.8, 0.1},
                {t(2009, 1, 1), -4.1, 1.4},
                {t(2009, 1, 2), -0.5, 4.1},
                {t(2009, 1, 3), -8.9, -0.7},
                {t(2009, 1, 4), -9.7, -3.7},
                {t(2009, 1, 5), -3.4, 3.2},
                {t(2009, 1, 6), -3.9, -0.2},
                {t(2009, 1, 7), -2.4, 6.7},
                {t(2009, 1, 8), 3.8, 6.9},
                {t(2009, 1, 9), 3.1, 6.8},
                {t(2009, 1, 10), 0.0, 7.6},
                {t(2009, 1, 11), 5.6, 9.4},
                {t(2009, 1, 12), 3.6, 6.5},
                {t(2009, 1, 13), -3.6, 3.8},
                {t(2009, 1, 14), -6.0, -1.5},
                {t(2009, 1, 15), -3.8, 2.4},
                {t(2009, 1, 16), 1.5, 4.2},
                {t(2009, 1, 17), 0.0, 4.5},
                {t(2009, 1, 18), -1.1, 3.6},
                {t(2009, 1, 19), 0.5, 5.1},
                {t(2009, 1, 20), 0.0, 2.5},
                {t(2009, 1, 21), -0.6, 2.1},
                {t(2009, 1, 22), 0.8, 4.7},
                {t(2009, 1, 23), 0.6, 4.4},
                {t(2009, 1, 24), -3.9, 1.4},
                {t(2009, 1, 25), -4.3, 2.0},
                {t(2009, 1, 26), -6.1, -0.4},
                {t(2009, 1, 27), -0.3, 1.9},
                {t(2009, 1, 28), -2.9, 2.7},
                {t(2009, 1, 29), -4.0, -1.0},
                {t(2009, 1, 30), -4.4, -1.9},
                {t(2009, 1, 31), -5.0, -2.7},
                {t(2009, 2, 1), -5.2, -2.3},
                {t(2009, 2, 2), -6.3, -0.6},
                {t(2009, 2, 3), -5.4, -0.6},
                {t(2009, 2, 4), -2.1, 1.4},
                {t(2009, 2, 5), -4.6, 1.5},
                {t(2009, 2, 6), -5.4, 0.6},
                {t(2009, 2, 7), -8.7, -2.6},
                {t(2009, 2, 8), -5.2, 1.3},
                {t(2009, 2, 9), -8.6, -2.2},
                {t(2009, 2, 10), -8.5, 0.1},
                {t(2009, 2, 11), -4.8, 1.7},
                {t(2009, 2, 12), -8.3, 1.4},
                {t(2009, 2, 13), -8.6, 1.1},
                {t(2009, 2, 14), -3.2, 1.5},
                {t(2009, 2, 15), -0.7, 4.1},
                {t(2009, 2, 16), 0.2, 3.2},
                {t(2009, 2, 17), 0.0, 3.9},
                {t(2009, 2, 18), 1.2, 4.5},
                {t(2009, 2, 19), 1.3, 5.7},
                {t(2009, 2, 20), 1.0, 2.3},
                {t(2009, 2, 21), 1.1, 5.5},
                {t(2009, 2, 22), 1.0, 6.5},
                {t(2009, 2, 23), 0.9, 3.7},
                {t(2009, 2, 24), 1.5, 4.3},
                {t(2009, 2, 25), 0.5, 5.4},
                {t(2009, 2, 26), -4.9, 3.8},
                {t(2009, 2, 27), -5.4, 1.4},
                {t(2009, 2, 28), -1.9, 4.0},
                {t(2009, 3, 1), 0.9, 8.1},
                {t(2009, 3, 2), 1.7, 8.1},
                {t(2009, 3, 3), 0.0, 9.1},
                {t(2009, 3, 4), 2.5, 7.7},
                {t(2009, 3, 5), 2.1, 5.6},
                {t(2009, 3, 6), 1.5, 6.9},
                {t(2009, 3, 7), 0.6, 7.9},
                {t(2009, 3, 8), 1.9, 9.4},
                {t(2009, 3, 9), 1.8, 7.0},
                {t(2009, 3, 10), 0.2, 8.6},
                {t(2009, 3, 11), -0.3, 5.9},
                {t(2009, 3, 12), 1.6, 8.3},
                {t(2009, 3, 13), -0.4, 8.8},
                {t(2009, 3, 14), -2.0, 5.4},
                {t(2009, 3, 15), 2.2, 6.7},
                {t(2009, 3, 16), 0.0, 7.2},
                {t(2009, 3, 17), 0.8, 9.3},
                {t(2009, 3, 18), -1.7, 7.5},
                {t(2009, 3, 19), -2.0, 6.3},
                {t(2009, 3, 20), -0.3, 5.7},
                {t(2009, 3, 21), 1.7, 5.9},
                {t(2009, 3, 22), -0.8, 5.7},
                {t(2009, 3, 23), -3.5, 5.7},
                {t(2009, 3, 24), -2.6, 5.0},
                {t(2009, 3, 25), -0.7, 8.0},
                {t(2009, 3, 26), -2.8, 6.0},
                {t(2009, 3, 27), -2.9, 6.1},
                {t(2009, 3, 28), 0.3, 7.0},
                {t(2009, 3, 29), 0.5, 7.5},
                {t(2009, 3, 30), 1.6, 4.7},
                {t(2009, 3, 31), -1.4, 7.3},
                {t(2009, 4, 1), 2.8, 6.8},
                {t(2009, 4, 2), 3.4, 12.0},
                {t(2009, 4, 3), 0.6, 13.5},
                {t(2009, 4, 4), 5.5, 8.3},
                {t(2009, 4, 5), 3.3, 8.3},
                {t(2009, 4, 6), 0.6, 13.5},
                {t(2009, 4, 7), 3.0, 13.7},
                {t(2009, 4, 8), 6.6, 15.2},
                {t(2009, 4, 9), 5.6, 10.3},
                {t(2009, 4, 10), 5.6, 15.2},
                {t(2009, 4, 11), 4.1, 10.0},
                {t(2009, 4, 12), 0.4, 11.8},
                {t(2009, 4, 13), 0.5, 13.6},
                {t(2009, 4, 14), 3.8, 15.6},
                {t(2009, 4, 15), 6.0, 11.6},
                {t(2009, 4, 16), 3.9, 13.9},
                {t(2009, 4, 17), 0.8, 14.3},
                {t(2009, 4, 18), 2.9, 17.3},
                {t(2009, 4, 19), 7.1, 12.2},
                {t(2009, 4, 20), 2.4, 12.9},
                {t(2009, 4, 21), 4.7, 12.9},
                {t(2009, 4, 22), 2.0, 16.3},
                {t(2009, 4, 23), 9.5, 17.4},
                {t(2009, 4, 24), 3.4, 16.7},
                {t(2009, 4, 25), 6.7, 19.1},
                {t(2009, 4, 26), 4.9, 15.8},
                {t(2009, 4, 27), 8.4, 15.3},
                {t(2009, 4, 28), 4.1, 18.6},
                {t(2009, 4, 29), 6.6, 19.9},
                {t(2009, 4, 30), 8.7, 21.4},
                {t(2009, 5, 1), 9.2, 16.4},
                {t(2009, 5, 2), 6.2, 12.9},
                {t(2009, 5, 3), 0.0, 13.4},
                {t(2009, 5, 4), 4.5, 11.2},
                {t(2009, 5, 5), 3.2, 14.3},
                {t(2009, 5, 6), 3.1, 13.7},
                {t(2009, 5, 7), 6.4, 14.6},
                {t(2009, 5, 8), 5.0, 13.5},
                {t(2009, 5, 9), 4.8, 11.5},
                {t(2009, 5, 10), 3.5, 13.0},
                {t(2009, 5, 11), 4.5, 15.0},
                {t(2009, 5, 12), 2.0, 17.0},
                {t(2009, 5, 13), 4.3, 18.3},
                {t(2009, 5, 14), 4.5, 18.8},
                {t(2009, 5, 15), 8.0, 20.7},
                {t(2009, 5, 16), 7.4, 20.7},
                {t(2009, 5, 17), 8.4, 17.7},
                {t(2009, 5, 18), 8.3, 15.2},
                {t(2009, 5, 19), 8.3, 17.9},
                {t(2009, 5, 20), 6.7, 17.0},
                {t(2009, 5, 21), 7.6, 17.5},
                {t(2009, 5, 22), 6.6, 17.3},
                {t(2009, 5, 23), 8.7, 17.7},
                {t(2009, 5, 24), 8.9, 17.7},
                {t(2009, 5, 25), 8.4, 11.5},
                {t(2009, 5, 26), 5.9, 14.2},
                {t(2009, 5, 27), 5.1, 16.9},
                {t(2009, 5, 28), 8.3, 16.0},
                {t(2009, 5, 29), 6.2, 22.6},
                {t(2009, 5, 30), 7.8, 22.6},
                {t(2009, 5, 31), 7.3, 21.7},
                {t(2009, 6, 1), 8.7, 16.2},
                {t(2009, 6, 2), 7.3, 13.9},
                {t(2009, 6, 3), 3.9, 15.5},
                {t(2009, 6, 4), 6.4, 17.3},
                {t(2009, 6, 5), 2.9, 17.9},
                {t(2009, 6, 6), 3.9, 17.9},
                {t(2009, 6, 7), 6.5, 16.8},
                {t(2009, 6, 8), 8.0, 14.2},
                {t(2009, 6, 9), 7.8, 16.2},
                {t(2009, 6, 10), 8.6, 15.3},
                {t(2009, 6, 11), 8.2, 18.2},
                {t(2009, 6, 12), 9.5, 17.0},
                {t(2009, 6, 13), 5.7, 18.7},
                {t(2009, 6, 14), 7.0, 16.9},
                {t(2009, 6, 15), 4.3, 15.8},
                {t(2009, 6, 16), 3.6, 19.1},
                {t(2009, 6, 17), 10.8, 15.0},
                {t(2009, 6, 18), 8.6, 16.3},
                {t(2009, 6, 19), 10.7, 17.0},
                {t(2009, 6, 20), 9.7, 18.9},
                {t(2009, 6, 21), 9.8, 20.6},
                {t(2009, 6, 22), 12.8, 19.5},
                {t(2009, 6, 23), 8.6, 24.1},
                {t(2009, 6, 24), 10.9, 26.6},
                {t(2009, 6, 25), 13.5, 28.0},
                {t(2009, 6, 26), 12.5, 23.2},
                {t(2009, 6, 27), 14.0, 28.1},
                {t(2009, 6, 28), 14.9, 29.5},
                {t(2009, 6, 29), 16.9, 22.5},
                {t(2009, 6, 30), 14.3, 27.7},
                {t(2009, 7, 1), 14.5, 27.8},
                {t(2009, 7, 2), 15.5, 29.6},
                {t(2009, 7, 3), 16.7, 30.7},
                {t(2009, 7, 4), 16.5, 25.0},
                {t(2009, 7, 5), 17.8, 25.7},
                {t(2009, 7, 6), 13.5, 24.8},
                {t(2009, 7, 7), 10.5, 21.4},
                {t(2009, 7, 8), 9.2, 23.8},
                {t(2009, 7, 9), 11.6, 21.8},
                {t(2009, 7, 10), 10.7, 23.7},
                {t(2009, 7, 11), 11.0, 23.3},
                {t(2009, 7, 12), 11.6, 23.7},
                {t(2009, 7, 13), 11.8, 20.7},
                {t(2009, 7, 14), 12.6, 22.4},
                {t(2009, 7, 15), 13.6, 19.6},
                {t(2009, 7, 16), 11.4, 22.6},
                {t(2009, 7, 17), 13.2, 25.0},
                {t(2009, 7, 18), 14.2, 21.6},
                {t(2009, 7, 19), 13.1, 17.1},
                {t(2009, 7, 20), 12.2, 15.5},
                {t(2009, 7, 21), 12.0, 20.8},
                {t(2009, 7, 22), 12.0, 17.1},
                {t(2009, 7, 23), 12.7, 18.3},
                {t(2009, 7, 24), 12.4, 19.4},
                {t(2009, 7, 25), 12.6, 19.9},
                {t(2009, 7, 26), 11.9, 20.2},
                {t(2009, 7, 27), 11.0, 19.3},
                {t(2009, 7, 28), 10.8, 17.8},
                {t(2009, 7, 29), 11.8, 18.5},
                {t(2009, 7, 30), 10.8, 16.1},
                {t(2009, 7, 31), 9.0, 19.9},
                {t(2009, 8, 1), 11.0, 20.2},
                {t(2009, 8, 2), 12.6, 22.5},
                {t(2009, 8, 3), 14.5, 22.7},
                {t(2009, 8, 4), 11.9, 24.0},
                {t(2009, 8, 5), 16.0, 21.5},
                {t(2009, 8, 6), 13.8, 24.8},
                {t(2009, 8, 7), 13.7, 21.5},
                {t(2009, 8, 8), 13.6, 22.1},
                {t(2009, 8, 9), 10.5, 22.3},
                {t(2009, 8, 10), 12.8, 18.4},
                {t(2009, 8, 11), 11.9, 18.4},
                {t(2009, 8, 12), 10.9, 16.4},
                {t(2009, 8, 13), 8.8, 16.8},
                {t(2009, 8, 14), 7.3, 13.6},
                {t(2009, 8, 15), 10.7, 14.0},
                {t(2009, 8, 16), 12.3, 17.5},
                {t(2009, 8, 17), 9.9, 18.4},
                {t(2009, 8, 18), 7.7, 16.0},
                {t(2009, 8, 19), 12.7, 26.5},
                {t(2009, 8, 20), 12.8, 20.3},
                {t(2009, 8, 21), 10.6, 17.7},
                {t(2009, 8, 22), 11.3, 18.5},
                {t(2009, 8, 23), 11.3, 13.8},
                {t(2009, 8, 24), null, null},
                {t(2009, 8, 25), 10.0, 15.1},
                {t(2009, 8, 26), 9.6, 16.5},
                {t(2009, 8, 27), 12.7, 13.8},
                {t(2009, 8, 28), 11.1, 17.1},
                {t(2009, 8, 29), 11.9, 15.3},
                {t(2009, 8, 30), 10.8, 12.6},
                {t(2009, 8, 31), 11.5, 14.8},
                {t(2009, 9, 1), 10.0, 13.7},
                {t(2009, 9, 2), 9.3, 16.8},
                {t(2009, 9, 3), 11.1, 18.0},
                {t(2009, 9, 4), 10.4, 11.8},
                {t(2009, 9, 5), null, null},
                {t(2009, 9, 6), 10.8, 14.7},
                {t(2009, 9, 7), 9.0, 13.1},
                {t(2009, 9, 8), 11.4, 16.6},
                {t(2009, 9, 9), 9.7, 15.6},
                {t(2009, 9, 10), 10.4, 14.0},
                {t(2009, 9, 11), 10.0, 13.6},
                {t(2009, 9, 12), 8.3, 17.5},
                {t(2009, 9, 13), 6.1, 15.7},
                {t(2009, 9, 14), 5.5, 14.4},
                {t(2009, 9, 15), 8.5, 13.6},
                {t(2009, 9, 16), 8.8, 12.8},
                {t(2009, 9, 17), 9.4, 15.6},
                {t(2009, 9, 18), 6.7, 17.1},
                {t(2009, 9, 19), 9.3, 14.9},
                {t(2009, 9, 20), 8.4, 15.0},
                {t(2009, 9, 21), 9.5, 15.2},
                {t(2009, 9, 22), 7.7, 11.1},
                {t(2009, 9, 23), 7.1, 11.9},
                {t(2009, 9, 24), 10.0, 15.8},
                {t(2009, 9, 25), 13.9, 16.0},
                {t(2009, 9, 26), 8.0, 15.1},
                {t(2009, 9, 27), 4.4, 8.9},
                {t(2009, 9, 28), 4.7, 6.9},
                {t(2009, 9, 29), null, null},
                {t(2009, 9, 30), null, null},
                {t(2009, 10, 1), 3.6, 3.6},
                {t(2009, 10, 2), 3.0, 6.8},
                {t(2009, 10, 3), 2.8, 9.0},
                {t(2009, 10, 4), 1.5, 7.5},
                {t(2009, 10, 5), 0.5, 5.8},
                {t(2009, 10, 6), 3.3, 9.1},
                {t(2009, 10, 7), 3.4, 5.3},
                {t(2009, 10, 8), 0.7, 6.7},
                {t(2009, 10, 9), -2.5, 6.2},
                {t(2009, 10, 10), 0.4, 8.5},
                {t(2009, 10, 11), 0.2, 9.6},
                {t(2009, 10, 12), -2.5, 5.3},
                {t(2009, 10, 13), -3.1, 5.4},
                {t(2009, 10, 14), 2.3, 8.5},
                {t(2009, 10, 15), 4.4, 10.8},
                {t(2009, 10, 16), 0.2, 7.8},
                {t(2009, 10, 17), -1.2, 7.2},
                {t(2009, 10, 18), 2.8, 6.4},
                {t(2009, 10, 19), -0.8, 7.2},
                {t(2009, 10, 20), 1.0, 9.7},
                {t(2009, 10, 21), 1.3, 4.2},
                {t(2009, 10, 22), 2.9, 11.4},
                {t(2009, 10, 23), 4.7, 9.0},
                {t(2009, 10, 24), 3.3, 10.8},
                {t(2009, 10, 25), 0.0, 7.1},
                {t(2009, 10, 26), 0.0, 2.0},
                {t(2009, 10, 27), -1.1, 5.4},
                {t(2009, 10, 28), -1.3, 4.5},
                {t(2009, 10, 29), 0.3, 4.3},
                {t(2009, 10, 30), -0.7, 4.9},
                {t(2009, 10, 31), 4.5, 7.3},
                {t(2009, 11, 1), 0.0, 4.4},
                {t(2009, 11, 2), 0.0, 0.0},
                {t(2009, 11, 3), 0.0, 6.7},
                {t(2009, 11, 4), -2.2, 5.2},
                {t(2009, 11, 5), -2.6, 1.7},
                {t(2009, 11, 6), -1.7, 10.3},
                {t(2009, 11, 7), 0.0, 5.2},
                {t(2009, 11, 8), -1.9, 0.8},
                {t(2009, 11, 9), -2.6, -0.2},
                {t(2009, 11, 10), -2.6, 1.2},
                {t(2009, 11, 11), -4.4, -1.7},
                {t(2009, 11, 12), -5.2, 0.2},
                {t(2009, 11, 13), null, null},
                {t(2009, 11, 14), 1.3, 8.9},
                {t(2009, 11, 15), -0.1, 3.9},
                {t(2009, 11, 16), 1.7, 5.9},
                {t(2009, 11, 17), 4.5, 6.3},
                {t(2009, 11, 18), 4.8, 5.9},
                {t(2009, 11, 19), 4.9, 10.4},
                {t(2009, 11, 20), 2.4, 8.6},
                {t(2009, 11, 21), 2.4, 4.6},
                {t(2009, 11, 22), 1.9, 5.2},
                {t(2009, 11, 23), 2.9, 5.7},
                {t(2009, 11, 24), 2.9, 4.9},
                {t(2009, 11, 25), 3.9, 7.6},
                {t(2009, 11, 26), 0.8, 5.7},
                {t(2009, 11, 27), 0.0, 4.8},
                {t(2009, 11, 28), 1.5, 3.4},
                {t(2009, 11, 29), -3.8, 1.5},
                {t(2009, 11, 30), -3.3, 1.7},
                {t(2009, 12, 1), -2.8, -0.7},
                {t(2009, 12, 2), -2.7, 3.8},
                {t(2009, 12, 3), -0.7, 4.2},
                {t(2009, 12, 4), 0.3, 6.1},
                {t(2009, 12, 5), 2.9, 9.8},
                {t(2009, 12, 6), 0.0, 6.8},
                {t(2009, 12, 7), 0.6, 2.8},
                {t(2009, 12, 8), 0.1, 5.1},
                {t(2009, 12, 9), 2.8, 3.9},
                {t(2009, 12, 10), -1.2, 2.2},
                {t(2009, 12, 11), -4.0, -0.4},
                {t(2009, 12, 12), -0.7, 0.7},
                {t(2009, 12, 13), 0.5, 1.6},
                {t(2009, 12, 14), -1.0, 1.5},
                {t(2009, 12, 15), -7.8, -1.0},
                {t(2009, 12, 16), -11.9, -7.9},
                {t(2009, 12, 17), -13.5, -7.9},
                {t(2009, 12, 18), -7.8, -1.7},
                {t(2009, 12, 19), -11.2, -0.6},
                {t(2009, 12, 20), -13.1, -7.2},
                {t(2009, 12, 21), -13.2, -5.2},
                {t(2009, 12, 22), -10.9, -7.7},
                {t(2009, 12, 23), -8.4, -1.5},
                {t(2009, 12, 24), -6.1, -1.2},
                {t(2009, 12, 25), -2.6, -1.2},
                {t(2009, 12, 26), -2.9, 0.7},
                {t(2009, 12, 27), -2.7, 0.7},
                {t(2009, 12, 28), -10.8, -1.3},
                {t(2009, 12, 29), -11.1, -8.0},
                {t(2009, 12, 30), -12.2, -6.5}
        };

        chart.setType(Series.Type.COLUMN_RANGE)
                .setRangeSelector(
                        new RangeSelector()
                                .setSelected(1)
                )
                .setChartTitleText("Temperature variations by day")
                .setToolTip(
                        new ToolTip()
                                .setValueSuffix("C")
                )
                .addSeries(
                        chart.createSeries()
                                .setName("Temperatures")
                                .setPoints(temperature)
                )
        ;

        return chart;
    }

    static final DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    private long t(int year, int month, int day) {
        return dateTimeFormat.parse(year + "-" + (month + 1) + "-" + day).getTime();
    }
}