package org.moxieapps.gwt.highcharts.showcase.client.line;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.Canvas;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.PlotBandLabel;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;
import org.moxieapps.gwt.highcharts.showcase.client.BaseChartExample;
import org.moxieapps.gwt.highcharts.showcase.client.ExampleFactory;

import java.util.Date;

public class SplineWithPlotBandsExample extends BaseChartExample {

    public SplineWithPlotBandsExample(String title, String icon) {
        super(title, icon);
    }

    @Override
    public String getSourcePath() {
        return "line/SplineWithPlotBandsExample.java.html";
    }

    public static ExampleFactory getFactory() {
        return new ExampleFactory() {
            @Override
            public Canvas createChartCanvas() {
                return new SplineWithPlotBandsExample(getTitle(), getIcon());
            }

            @Override
            public String getTitle() {
                return "Spline with Plot Bands";
            }

            @Override
            public String getIcon() {
                return "icons/16/spline_chart.png";
            }
        };
    }

    @Override
    public Chart createChart() {

        final Chart chart = new Chart()
            .setType(Series.Type.SPLINE)
            .setChartTitleText("Wind speed during two days")
            .setChartSubtitleText("October 6th and 7th 2009 at two locations in Vik i Sogn, Norway")
            .setToolTip(new ToolTip()
                .setFormatter(new ToolTipFormatter() {
                    public String format(ToolTipData toolTipData) {
                        return DateTimeFormat.getFormat("d. MMMM YYYY HH:00").format(
                            new Date(toolTipData.getXAsLong())
                        ) + ": " + toolTipData.getYAsDouble() + " m/s";
                    }
                })
            )
            .setSplinePlotOptions(new SplinePlotOptions()
                .setLineWidth(4)
                .setHoverStateLineWidth(5)
                .setMarker(new Marker()
                    .setEnabled(false)
                    .setHoverState(new Marker()
                        .setEnabled(true)
                        .setSymbol(Marker.Symbol.CIRCLE)
                        .setRadius(5)
                        .setLineWidth(1)
                    )
                )
                .setPointInterval(3600000)  // one hour
                .setPointStart(
                    DateTimeFormat.getFormat("yyyy-MM-dd").parse("2009-10-06").getTime()
                )
            );

        // TODO: Add navigation menu item style override

        chart.getXAxis()
            .setType(Axis.Type.DATE_TIME);

        // TODO: Update plot band label colors to utilize the theme color if available.  E.g. Highcharts.theme.textColor

        final YAxis axis = chart.getYAxis();
        final Color blueColor = new Color(68, 170, 213, 0.1);
        final Color clearColor = new Color(0, 0, 0, 0);
        axis.setAxisTitleText("Wind speed (m/s)")
            .setMin(0)
            .setMinorGridLineWidth(0)
            .setGridLineWidth(0)
            .setAlternateGridColor(null)
            .setPlotBands(
                axis.createPlotBand()   // Light air
                    .setFrom(0.3)
                    .setTo(1.5)
                    .setColor(blueColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Light air")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // Light breeze
                    .setFrom(1.5)
                    .setTo(3.3)
                    .setColor(clearColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Light breeze")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // Gentle breeze
                    .setFrom(3.3)
                    .setTo(5.5)
                    .setColor(blueColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Gentle breeze")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // Moderate breeze
                    .setFrom(5.5)
                    .setTo(8)
                    .setColor(clearColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Moderate breeze")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // Fresh breeze
                    .setFrom(8)
                    .setTo(11)
                    .setColor(blueColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Fresh breeze")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // Strong breeze
                    .setFrom(11)
                    .setTo(14)
                    .setColor(clearColor)
                    .setLabel(new PlotBandLabel()
                        .setText("Strong breeze")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    ),
                axis.createPlotBand()   // High wind
                    .setFrom(14)
                    .setTo(15)
                    .setColor(blueColor)
                    .setLabel(new PlotBandLabel()
                        .setText("High wind")
                        .setStyle(new Style()
                            .setColor("#606060")
                        )
                    )
            );

        chart.addSeries(chart.createSeries()
            .setName("Hestavollane")
            .setPoints(new Number[]{
                4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9, 7.1,
                7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8, 5.9, 7.4,
                8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4, 12.1, 9.5, 7.5,
                7.1, 7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8, 2.9, 1.3, 4.4, 4.2,
                3.0, 3.0
            })
        );
        chart.addSeries(chart.createSeries()
            .setName("Voll")
            .setPoints(new Number[] {
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3, 0.0,
                0.0, 0.4, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7, 3.9, 1.7, 2.3,
                3.0, 3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0, 0.9, 0.4, 0.3, 0.5, 0.4
            })
        );

        return chart;
    }
}
