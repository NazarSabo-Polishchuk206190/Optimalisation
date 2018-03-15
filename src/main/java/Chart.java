

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

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( line1 );
        dataset.addSeries( line2 );
        dataset.addSeries( line3 );
        return dataset;
    }

    public static void main( String[ ] args ) {
        Chart chart = new Chart("Metoda graficzna",
                "Rozwiązanie graficzne");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}