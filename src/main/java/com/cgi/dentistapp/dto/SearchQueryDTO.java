package com.cgi.dentistapp.dto;

import javax.validation.constraints.Size;

/**
 * Created by tuules on 13/04/2017.
 * <p>
 * Holds a search query.
 * The search works on either the GPs' or the dentists' names (or both) as the specs did not specify the functionality
 */

public class SearchQueryDTO {
    @Size(min = 2, max = 100)
    private String dentistName;

    @Size(min = 2, max = 100)
    private String gpName;

    public SearchQueryDTO(String dentistName, String gpName) {
        this.dentistName = dentistName;
        this.gpName = gpName;
    }

    public SearchQueryDTO() {
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }
}
