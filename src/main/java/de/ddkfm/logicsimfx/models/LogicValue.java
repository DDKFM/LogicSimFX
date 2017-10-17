package de.ddkfm.logicsimfx.models;

import de.mschaedlich.logic.recognizer.logic.Logic;
import de.mschaedlich.logic.recognizer.logic.LogicParser;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicValue {
    private Map<String, BooleanProperty> inputs = new HashMap<String, BooleanProperty>();
    private Map<String, BooleanProperty> outputs = new HashMap<String, BooleanProperty>();
    private Map<String, String> functions = new HashMap<String, String>();
    private BooleanProperty changedProperty = new SimpleBooleanProperty(false);

    public void call(String input, boolean value) {
        Map<String, Boolean> inputMap = new HashMap<>();
        for (String key : this.inputs.keySet()) {
            inputMap.put(key, this.inputs.get(key).getValue());
        }
        for(String output : this.outputs.keySet()) {
            String function = this.functions.get(output);
            LogicParser parser = new LogicParser(function);
            Logic logic = parser.parse();
            boolean result = logic.getResult(inputMap);
            this.outputs.get(output).setValue(result);
        }

    }
    public Map<String, BooleanProperty> getInputs() {
        return inputs;
    }

    public void setInputs(Map<String, BooleanProperty> inputs) {
        for (Map.Entry<String, BooleanProperty> entry : inputs.entrySet()) {
            this.setInput(entry.getKey(), entry.getValue());
        }
    }
    public void setInput(String key, BooleanProperty value) {
        this.inputs.put(key, value);
        BooleanProperty property = this.inputs.get(key);
        property.addListener(((observable, oldValue, newValue) -> {
            this.call(key, newValue);
            this.changedProperty.setValue(!this.changedProperty.getValue());
        }));
    }

    public boolean getChangedProperty() {
        return changedProperty.get();
    }

    public BooleanProperty changedPropertyProperty() {
        return changedProperty;
    }

    public void setChangedProperty(boolean changedProperty) {
        this.changedProperty.set(changedProperty);
    }

    public Map<String, BooleanProperty> getOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, BooleanProperty> outputs) {
        this.outputs = outputs;
    }

    public Map<String, String> getFunctions() {
        return functions;
    }

    public void setFunctions(Map<String, String> functions) {
        this.functions = functions;
    }
    public void addFunction(String key, String function) {
        this.functions.put(key, function);
    }
}
