import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.util.ArrayList;

class Chart extends ApplicationFrame {

    public Chart( String applicationTitle, String chartTitle ) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "x1" ,
                "x2" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                false , true , false);


        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 600 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.BLACK );
        renderer.setSeriesPaint( 1 , Color.BLACK );
        renderer.setSeriesPaint( 2 , Color.BLACK );
        renderer.setSeriesPaint( 3 , Color.BLACK );
        renderer.setSeriesPaint( 4 , Color.BLACK );
        renderer.setSeriesPaint( 5 , Color.BLUE );
        renderer.setSeriesPaint( 6 , Color.BLUE );
        renderer.setSeriesPaint( 7 , Color.red );
        renderer.setSeriesPaint( 8 , Color.red );
        renderer.setSeriesPaint( 9 , Color.yellow );

        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesShapesVisible(3, false);
        renderer.setSeriesShapesVisible(4, false);
        renderer.setSeriesShapesVisible(5, false);
        renderer.setSeriesShapesVisible(6, false);
        renderer.setSeriesShapesVisible(7, false);
        renderer.setSeriesShapesVisible(8, false);
       // renderer.setSeriesShapesVisible(9, false);

        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 4 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 5 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 6 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 7 , new BasicStroke( 5.0f ) );
        renderer.setSeriesStroke( 8 , new BasicStroke( 5.0f ) );
        renderer.setSeriesStroke( 9 , new BasicStroke( 8.0f ) );

        plot.setRenderer( renderer );
        setContentPane( chartPanel );


    }

    public static ArrayList<Point> SolutionList1 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList2 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList3 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList4 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList5 = new ArrayList<Point>();

    private XYDataset createDataset( ) {

        SolutionList1 = Limits.Limit(App.x1,App.y1,App.res1);
        SolutionList2 =  Limits.Limit(App.x2,App.y2,App.res2);
        SolutionList3 =  Limits.Limit(App.x3,App.y3,App.res3);
        SolutionList4 =  Limits.Limit(App.x4,App.y4,App.res4);
        SolutionList5 =  Limits.Limit(App.x5,App.y5,App.res5);

        final XYSeries line1 = new XYSeries( "Line1" );
        for(int i=0; i<SolutionList1.size(); i++) {
            line1.add(SolutionList1.get(i).getX(), SolutionList1.get(i).getY());
        }
        final XYSeries line2 = new XYSeries( "Line2" );
        for(int i=0; i<SolutionList2.size(); i++) {
            line2.add(SolutionList2.get(i).getX(), SolutionList2.get(i).getY());
        }

        final XYSeries line3 = new XYSeries( "Line3" );
        for(int i=0; i<SolutionList3.size(); i++) {
            line3.add(SolutionList3.get(i).getX(), SolutionList3.get(i).getY());
        }

        final XYSeries line4 = new XYSeries( "Line4" );
        for(int i=0; i<SolutionList4.size(); i++) {
            line4.add(SolutionList4.get(i).getX(), SolutionList4.get(i).getY());
        }

        final XYSeries line5 = new XYSeries( "Line5" );
        for(int i=0; i<SolutionList5.size(); i++) {
            line5.add(SolutionList5.get(i).getX(), SolutionList5.get(i).getY());
        }

        final XYSeries linex = new XYSeries( "Linex" );
        for(int i=0; i<30; i++) {
            linex.add(i, 0);
        }

        final XYSeries liney = new XYSeries( "Liney" );
        for(int i=0; i<30; i++) {
            liney.add(0,i );
        }

            final XYSeries pointSet = new XYSeries("Point1");
        pointSet.add(App.interPoints().get(4).getX(), App.interPoints().get(4).getY());
        pointSet.add(App.interPoints().get(0).getX(), App.interPoints().get(0).getY());
        pointSet.add(4,0);
        pointSet.add(6.80f, 0);
        pointSet.add(App.interPoints().get(5).getX(), App.interPoints().get(5).getY());

        final XYSeries pointSet2 = new XYSeries("Point2");
        pointSet2.add(App.interPoints().get(0).getX(), App.interPoints().get(0).getY());
        pointSet2.add(App.interPoints().get(1).getX(), App.interPoints().get(1).getY());
        pointSet2.add(App.interPoints().get(5).getX(), App.interPoints().get(5).getY());

        final XYSeries result1 = new XYSeries("Result");
        result1.add(App.result().getX(), App.result().getY());

        final XYSeriesCollection dataset = new XYSeriesCollection( );

        dataset.addSeries( line1 );
        dataset.addSeries( line2 );
        dataset.addSeries( line3 );
        dataset.addSeries( line4 );
        dataset.addSeries( line5 );
        dataset.addSeries( linex );
        dataset.addSeries( liney );
        dataset.addSeries( pointSet);
        dataset.addSeries( pointSet2);
        dataset.addSeries( result1);

        return dataset;
    }

    public static void main( String[ ] args ) {

        double max = App.result().getX()*App.ex + App.result().getY()*App.ey;

        Chart chart = new Chart("Metoda graficzna",
                "Rozwiązanie graficzne:" + " Fmax (" + App.result().getX() + "," +
                                                                App.result().getY() +") = " +
                                                                + max);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );

        System.out.print("Result is point(" +App.result().getX()+", "+App.result().getY()+")");
    }
}