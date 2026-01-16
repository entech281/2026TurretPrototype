package frc.robot.controllers;

import frc.robot.fake.TalonAdapter;

public abstract class BaseTalonController extends BaseController{

    protected TalonAdapter talon = null;
    protected TalonSettings settings = null;
    protected boolean reversed = false;
    private boolean enabled = true;
    public BaseTalonController(TalonAdapter talon, TalonSettings settings, boolean reversed) {
        super(reversed);
        this.talon = talon;
        this.settings = settings;
    }
    
    public boolean isEnabled(){
        return enabled;
    }
    
    public boolean isReversed(){
        return reversed;
    }

    public void configure() {
        // Apply talon settings. The adapter is a lightweight stub so we
        // can't rely on CTRE ErrorCode here; just attempt configuration.
        try {
            settings.configureTalon(talon);
            talon.configPeakCurrentLimit(0);
            this.enabled = true;
        } catch (Exception ex) {
            this.enabled = false;
        }
    }
}