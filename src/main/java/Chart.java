

import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
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
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> ff3b1e804bcac1a64b6b0a5995e46f51d6c9980c

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
<<<<<<< HEAD
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset( ) {
        final XYSeries line1 = new XYSeries( "Line1" );
        //line1.add(App.SolutionList1.get(0).getX(), App.SolutionList1.get(0).getY());
        line1.add(0,0);
        line1.add(5, 5);

        final XYSeries line2 = new XYSeries( "Line2" );
        line2.add( 1.0 , 4.0 );
        line2.add( 2.0 , 5.0 );
        line2.add( 3.0 , 6.0 );

        final XYSeries line3 = new XYSeries( "Line3" );
        line3.add( 3.0 , 4.0 );
        line3.add( 4.0 , 5.0 );
        line3.add( 5.0 , 6.0 );
=======
        renderer.setSeriesPaint( 0 , Color.BLACK );
        renderer.setSeriesPaint( 1 , Color.BLACK );
        renderer.setSeriesPaint( 2 , Color.BLACK );
        renderer.setSeriesPaint( 3 , Color.BLACK );
        renderer.setSeriesPaint( 4 , Color.BLACK );
        renderer.setSeriesPaint( 5 , Color.BLUE );
        renderer.setSeriesPaint( 6 , Color.BLUE );


        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesShapesVisible(3, false);
        renderer.setSeriesShapesVisible(4, false);
        renderer.setSeriesShapesVisible(5, false);
        renderer.setSeriesShapesVisible(6, false);

        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 4 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 5 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 6 , new BasicStroke( 4.0f ) );
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
>>>>>>> ff3b1e804bcac1a64b6b0a5995e46f51d6c9980c

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( line1 );
        dataset.addSeries( line2 );
        dataset.addSeries( line3 );
<<<<<<< HEAD
        return dataset;
    }

=======
        dataset.addSeries( line4 );
        dataset.addSeries( line5 );
        dataset.addSeries( linex );
        dataset.addSeries( liney );
        return dataset;
    }

    public static void print(ArrayList<Point> SolList){
        for(int i=0; i<SolList.size(); i++) {
            System.out.print("X= " + SolList.get(i).getX());
            System.out.println("Y= " + SolList.get(i).getY() + "//" + i);
        }
    }

>>>>>>> ff3b1e804bcac1a64b6b0a5995e46f51d6c9980c
    public static void main( String[ ] args ) {
        Chart chart = new Chart("Metoda graficzna",
                "Rozwiązanie graficzne");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
<<<<<<< HEAD
=======
        print(SolutionList1);
        print(SolutionList2);
        print(SolutionList3);
        print(SolutionList4);
        print(SolutionList5);

        //App.Solve();
        Limits.intersectionList(SolutionList1, SolutionList2, SolutionList3, SolutionList4, SolutionList5);
>>>>>>> ff3b1e804bcac1a64b6b0a5995e46f51d6c9980c
    }
}