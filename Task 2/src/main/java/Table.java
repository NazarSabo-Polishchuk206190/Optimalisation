import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class Table extends JFrame
{
    public Table()
    {
        Object[] Cj = new Object[] {null, null, null, null, -100, -400, 0, 0, 0, 0, null};
        //headers for the table
        String[] columns = new String[] {
                "i", "baza", "cB", "x0 = b", "P1", "P2", "P3", "P4", "P5", "P6", "ratio"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1,     "x1",   0,      14, 1,    2, 1, 0, 0, 0, 0 },
                {2,     "x2",   0,      14, 9,    0, 0, 1, 0, 0, 0 },
                {3,     "x3",   0,      14, 0,   12, 0, 0, 1, 0, 0 },
                {4,     "x4",   0,       0, 1, -0.8, 0, 0, 0, 1, 0 },
                {null,  null,   null,    0, 0,    0, 0, 0, 0, 0, 0 }
        };
        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Metoda Simplex");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Table();
            }
        });
    }
}