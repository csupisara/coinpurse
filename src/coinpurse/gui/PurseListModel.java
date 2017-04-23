package coinpurse.gui;

import java.awt.Font;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * This class provides a ListModel interface for querying
 * the contents of the purse. It is a kind of adapter.
 */
public class PurseListModel extends AbstractListModel<Valuable> implements Observer{
	private Purse purse;
	private ListModel<Valuable> listModel;
	private JList<Valuable> listview;
	private JFrame frame;

	/** Initialize PurseListModel */
	public PurseListModel( Purse purse ) {  
		/* get a reference to purse's list of money */ 
		this.purse = purse;
		frame = new JFrame( "Purse Contents" );
		frame.setSize( 250, 400 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return purse.count();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Valuable getElementAt( int index ) {
		return purse.getList().get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update( Observable o, Object arg ) {
		//Notify the JList that ListModel has changed.
		fireContentsChanged( this, 0, getSize()-1 );
		listview.setModel( this );
	}

	/** create the component */
	public void initComponent() {
		listModel = new PurseListModel( purse );
		listview = new JList<>( listModel );
		final int FONT_SIZE = 24;
		listview.setFont( new Font( Font.DIALOG, Font.PLAIN, FONT_SIZE ) );
		frame.add( listview );
	}

	/** Start the program */
	public void run() {
		initComponent();
		this.frame.setVisible( true );
	}
}

