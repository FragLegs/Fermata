package com.fermata.ui.custom.PianoKey;

import javax.swing.event.*;
import java.beans.*;

import com.fermata.music.midi.MidiHelpers;

public class DefaultPianoKeyModel implements PianoKeyModel {
	/** The listeners waiting for model changes. */
	protected EventListenerList listenerList = new EventListenerList();
	
	// the type of piano key (i.e. a C key is LEFT, a D key is CENTER, an E key is RIGHT, a C# key is BLACK)
	protected PianoKeyType type;
	
	// the midi value for this key
	protected int midiValue = 0;
	
	// whether this key is currently down (pressed)
	protected boolean down = false;

	// constructor
	public DefaultPianoKeyModel(int mVal)
	{
		midiValue = mVal;
		type = MidiHelpers.MidiToPianoKeyType(mVal);
		down = false;
	}
	
	@Override
	public int getMidiValue() {
		return midiValue;
	}

	@Override
	public PianoKeyType getType() {
		return type;
	}

	@Override
	public boolean getDown() {
		return down;
	}

	@Override
	public void setDown(boolean b) {
		down = b;
		this.fireStateChanged();
	}

	@Override
	public void addChangeListener(ChangeListener x) {
		listenerList.add(ChangeListener.class, x);
		
	}

	@Override
	public void removeChangeListener(ChangeListener x) {
		listenerList.remove(ChangeListener.class, x);
		
	}
	
	protected void fireStateChanged() {
        ChangeEvent event = new ChangeEvent(this);
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ChangeListener.class) {
                ((ChangeListener) listeners[i + 1]).stateChanged(event);
            }
        }
    }
}
