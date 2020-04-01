
package com.android.form.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Control {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("type")
    @Expose(serialize = false)
    private String type;
    @SerializedName("required")
    @Expose(serialize = false)
    private Boolean required;
    @SerializedName("min_length")
    @Expose(serialize = false)
    private Integer minLength;
    @SerializedName("max_length")
    @Expose(serialize = false)
    private Integer maxLength;
    @SerializedName("regex")
    @Expose(serialize = false)
    private String regex;
    @SerializedName("options")
    @Expose(serialize = false)
    private List<String> options = null;
    @SerializedName("api_key")
    @Expose(serialize = false)
    private String apiKey;
    @SerializedName("api_value")
    @Expose
    private String apiValue = null;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiValue() {
        return apiValue;
    }

    public void setApiValue(String apiValue) {
        this.apiValue = apiValue;
    }

}
