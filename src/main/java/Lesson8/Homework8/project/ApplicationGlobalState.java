package Lesson8.Homework8.project;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "jynwb58MTqZESIGogbpxyvi0BcPtcEFT";
    private final String DATA_FILE = "weather.db";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }



    public String getSelectedCity() {
        return selectedCity;
    }
    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
    public String getApiKey() {
        return this.API_KEY;
    }
    public String getDbFileName() { return this.DATA_FILE; }
}
