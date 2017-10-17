package de.ddkfm.logicsimfx.views;

import de.ddkfm.logicsimfx.models.LogicValue;

public class Connection {
    private LogicValue start;
    private LogicValue end;

    public LogicValue getStart() {
        return start;
    }

    public void setStart(LogicValue start) {
        this.start = start;
    }

    public LogicValue getEnd() {
        return end;
    }

    public void setEnd(LogicValue end) {
        this.end = end;
    }
}
