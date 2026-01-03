import java.awt.*;
import java.awt.event.*;
public class week_1 extends Frame implements ActionListener
{
    TextField t1,t2,t3;
    Button add,sub,mul,div,clr;
    Label l1,l2,l3;
    week_1()
    {
        setVisible(true);
        setLayout(null);
        setBounds(0,0,500,500);
        setBackground(Color.magenta);

        l1=new Label("Number 1:");
        l1.setBounds(50,50,60,30);
        l1.setForeground(Color.cyan);
        l2=new Label("Number 2:");
        l2.setBounds(250,50,60,30);
        l2.setForeground(Color.cyan);
        l3=new Label("Result:");
        l3.setBounds(165,120,40,30);
        l3.setForeground(Color.cyan);

        t1=new TextField();
        t1.setBounds(110,50,100,30);
        t1.setForeground(Color.cyan);
        t1.setBackground(Color.black);
        t2=new TextField();
        t2.setBounds(310,50,100,30);
        t2.setForeground(Color.cyan);
        t2.setBackground(Color.black);
        t3=new TextField();
        t3.setBounds(210,120,130,30);
        t3.setForeground(Color.cyan);
        t3.setBackground(Color.black);

        add=new Button("+");
        add.setBounds(100,200,50,30);
        add.setForeground(Color.red);
        sub=new Button("-");
        sub.setBounds(200,200,50,30);
        sub.setForeground(Color.blue);
        mul=new Button("*");
        mul.setBounds(300,200,50,30);
        mul.setForeground(Color.pink);
        div=new Button("/");
        div.setBounds(150,260,50,30);
        div.setForeground(Color.yellow);
        clr=new Button("Clear");
        clr.setBounds(250,260,50,30);
        clr.setForeground(Color.green);

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(clr);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clr.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clr)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            return;
        }
        try
        {
            Double d1=Double.parseDouble(t1.getText());
            Double d2=Double.parseDouble(t2.getText());
            Double result=0.0;

            if(ae.getSource()==add)
            {
                result=d1+d2;
            }
            else if(ae.getSource()==sub)
            {
                result=d1-d2;
            }
            else if(ae.getSource()==mul)
            {
                result=d1*d2;
            }
            else if(ae.getSource()==div)
            {
                if(d2==0)
                {
                    t3.setText("Zero Division Error");
                    return;
                }
                result=d1/d2;
            }
            t3.setText(String.valueOf(result)); 
        }
        catch(NumberFormatException n)
        {
            t3.setText("Invalid Input!!");
        }
    }
    public static void main(String vn[])
    {
        new week_1();
    }
}