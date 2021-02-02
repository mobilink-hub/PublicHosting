package com.amplifyframework.datastore.generated.model;



import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Vehicle type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Vehicles", authRules = {
        @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Vehicle implements Model {
    public static final QueryField ID = field("id");
    public static final QueryField DUMMY = field("dummy");
    public static final QueryField VEHICLE_SPEED = field("vehicleSpeed");
    public static final QueryField HORN_STATUS_SOUND = field("hornStatusSound");
    public static final QueryField AC_BLOWER_MODE = field("acBlowerMode");
    public static final QueryField BRAKE_PRESSURE = field("brakePressure");
    public static final QueryField ACCELERATOR_PEDAL_OPENING = field("acceleratorPedalOpening");
    public static final QueryField WIPER_FRONT_CONTROL_SETTING = field("wiperFrontControlSetting");
    public static final QueryField IGNITION_STATUS = field("ignitionStatus");
    public static final QueryField AC_BLOWER_LEVEL = field("acBlowerLevel");
    public static final QueryField STEERING_WHEEL_ANGLE = field("steeringWheelAngle");
    public static final QueryField AIR_RECIRCULATION_STATUS_OPERATION = field("airRecirculationStatusOperation");
    public static final QueryField AC_DRIVER_SETTING_TEMP = field("acDriverSettingTemp");
    public static final QueryField INSIDE_TEMP = field("insideTemp");
    public static final QueryField OUTSIDE_TEMP = field("outsideTemp");
    public static final QueryField DEFOGGER_FRONT_STATUS_OPERATION = field("defoggerFrontStatusOperation");
    public static final QueryField TRANSMISSION_GEAR_POSITION = field("transmissionGearPosition");
    public static final QueryField HEATER_STATUS_OPERATION = field("heaterStatusOperation");
    public static final QueryField CUSTOM_AM_RADIO_CHANNEL = field("customAmRadioChannel");
    public static final QueryField CUSTOM_FM_RADIO_CHANNEL = field("customFmRadioChannel");
    public static final QueryField CUSTOM_AUDIO_VOL = field("customAudioVol");
    public static final QueryField CUSTOM_AUDIO_MODE = field("customAudioMode");
    public static final QueryField CUSTOM_MUSIC_STATUS = field("customMusicStatus");
    public static final QueryField DOOR_RIGHT_FRONT_STATUS_OPEN = field("doorRightFrontStatusOpen");
    public static final QueryField DOOR_LEFT_FRONT_STATUS_OPEN = field("doorLeftFrontStatusOpen");
    public static final QueryField DOOR_RIGHT_REAR_STATUS_OPEN = field("doorRightRearStatusOpen");
    public static final QueryField DOOR_LEFT_REAR_STATUS_OPEN = field("doorLeftRearStatusOpen");
    public static final QueryField DOOR_TRUNK_STATUS_OPEN = field("doorTrunkStatusOpen");
    public static final QueryField DOOR_RIGHT_FRONT_STATUS_LOCK = field("doorRightFrontStatusLock");
    public static final QueryField DOOR_LEFT_FRONT_STATUS_LOCK = field("doorLeftFrontStatusLock");
    public static final QueryField DOOR_RIGHT_REAR_STATUS_LOCK = field("doorRightRearStatusLock");
    public static final QueryField DOOR_LEFT_REAR_STATUS_LOCK = field("doorLeftRearStatusLock");
    public static final QueryField DOOR_TRUNK_STATUS_LOCK = field("doorTrunkStatusLock");
    public static final QueryField HAZARD_LAMP_OPERATION_STATE = field("hazardLampOperationState");
    public static final QueryField LIGHT_HIGH_BEAM_STATUS_LIGHTING = field("lightHighBeamStatusLighting");
    public static final QueryField LIGHT_HEAD_STATUS_LIGHTING = field("lightHeadStatusLighting");
    public static final QueryField TURN_SIGNAL_STATUS_OPERATION = field("turnSignalStatusOperation");
    public static final QueryField LAMP_BREAK_STATUS_LIGHTING = field("lampBreakStatusLighting");
    public static final QueryField NAVI_DEST_MEASURING_LAT = field("naviDestMeasuringLat");
    public static final QueryField NAVI_DEST_MEASURING_LON = field("naviDestMeasuringLon");
    public static final QueryField GPS_STATUS_MEASURING_LON = field("gpsStatusMeasuringLon");
    public static final QueryField GPS_STATUS_MEASURING_LAT = field("gpsStatusMeasuringLat");
    public static final QueryField CUSTOM_SEAT_RIGHT_FRONT_OCCUPANT_TYPE = field("customSeatRightFrontOccupantType");
    public static final QueryField CUSTOM_SEAT_RIGHT_REAR_OCCUPANT_TYPE = field("customSeatRightRearOccupantType");
    public static final QueryField CUSTOM_SEAT_LEFT_FRONT_OCCUPANT_TYPE = field("customSeatLeftFrontOccupantType");
    public static final QueryField CUSTOM_SEAT_LEFT_REAR_OCCUPANT_TYPE = field("customSeatLeftRearOccupantType");
    public static final QueryField FUEL_REMAINING_PERCENT = field("fuelRemainingPercent");
    public static final QueryField CUSTOM_SENSOR_RIGHT_FRONT_LEVEL = field("customSensorRightFrontLevel");
    public static final QueryField CUSTOM_SENSOR_RIGHT_REAR_LEVEL = field("customSensorRightRearLevel");
    public static final QueryField CUSTOM_SENSOR_LEFT_FRONT_LEVEL = field("customSensorLeftFrontLevel");
    public static final QueryField CUSTOM_SENSOR_LEFT_REAR_LEVEL = field("customSensorLeftRearLevel");
    public static final QueryField TIMESTAMP = field("timestamp");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="Boolean") Boolean dummy;
    private final @ModelField(targetType="Float") Float vehicleSpeed;
    private final @ModelField(targetType="Boolean") Boolean hornStatusSound;
    private final @ModelField(targetType="Int") Integer acBlowerMode;
    private final @ModelField(targetType="Float") Float brakePressure;
    private final @ModelField(targetType="Float") Float acceleratorPedalOpening;
    private final @ModelField(targetType="Int") Integer wiperFrontControlSetting;
    private final @ModelField(targetType="Int") Integer ignitionStatus;
    private final @ModelField(targetType="Int") Integer acBlowerLevel;
    private final @ModelField(targetType="Float") Float steeringWheelAngle;
    private final @ModelField(targetType="Boolean") Boolean airRecirculationStatusOperation;
    private final @ModelField(targetType="Float") Float acDriverSettingTemp;
    private final @ModelField(targetType="Float") Float insideTemp;
    private final @ModelField(targetType="Float") Float outsideTemp;
    private final @ModelField(targetType="Boolean") Boolean defoggerFrontStatusOperation;
    private final @ModelField(targetType="Int") Integer transmissionGearPosition;
    private final @ModelField(targetType="Int") Integer heaterStatusOperation;
    private final @ModelField(targetType="Float") Float customAmRadioChannel;
    private final @ModelField(targetType="Float") Float customFmRadioChannel;
    private final @ModelField(targetType="Int") Integer customAudioVol;
    private final @ModelField(targetType="Int") Integer customAudioMode;
    private final @ModelField(targetType="Boolean") Boolean customMusicStatus;
    private final @ModelField(targetType="Boolean") Boolean doorRightFrontStatusOpen;
    private final @ModelField(targetType="Boolean") Boolean doorLeftFrontStatusOpen;
    private final @ModelField(targetType="Boolean") Boolean doorRightRearStatusOpen;
    private final @ModelField(targetType="Boolean") Boolean doorLeftRearStatusOpen;
    private final @ModelField(targetType="Boolean") Boolean doorTrunkStatusOpen;
    private final @ModelField(targetType="Boolean") Boolean doorRightFrontStatusLock;
    private final @ModelField(targetType="Boolean") Boolean doorLeftFrontStatusLock;
    private final @ModelField(targetType="Boolean") Boolean doorRightRearStatusLock;
    private final @ModelField(targetType="Boolean") Boolean doorLeftRearStatusLock;
    private final @ModelField(targetType="Boolean") Boolean doorTrunkStatusLock;
    private final @ModelField(targetType="Boolean") Boolean hazardLampOperationState;
    private final @ModelField(targetType="Boolean") Boolean lightHighBeamStatusLighting;
    private final @ModelField(targetType="Int") Integer lightHeadStatusLighting;
    private final @ModelField(targetType="Int") Integer turnSignalStatusOperation;
    private final @ModelField(targetType="Int") Integer lampBreakStatusLighting;
    private final @ModelField(targetType="Float") Float naviDestMeasuringLat;
    private final @ModelField(targetType="Float") Float naviDestMeasuringLon;
    private final @ModelField(targetType="Float") Float gpsStatusMeasuringLon;
    private final @ModelField(targetType="Float") Float gpsStatusMeasuringLat;
    private final @ModelField(targetType="Boolean") Boolean customSeatRightFrontOccupantType;
    private final @ModelField(targetType="Boolean") Boolean customSeatRightRearOccupantType;
    private final @ModelField(targetType="Boolean") Boolean customSeatLeftFrontOccupantType;
    private final @ModelField(targetType="Boolean") Boolean customSeatLeftRearOccupantType;
    private final @ModelField(targetType="Int") Integer fuelRemainingPercent;
    private final @ModelField(targetType="Int") Integer customSensorRightFrontLevel;
    private final @ModelField(targetType="Int") Integer customSensorRightRearLevel;
    private final @ModelField(targetType="Int") Integer customSensorLeftFrontLevel;
    private final @ModelField(targetType="Int") Integer customSensorLeftRearLevel;
    private final @ModelField(targetType="String") String timestamp;
    public String getId() {
        return id;
    }

    public Boolean getDummy() {
        return dummy;
    }

    public Float getVehicleSpeed() {
        return vehicleSpeed;
    }

    public Boolean getHornStatusSound() {
        return hornStatusSound;
    }

    public Integer getAcBlowerMode() {
        return acBlowerMode;
    }

    public Float getBrakePressure() {
        return brakePressure;
    }

    public Float getAcceleratorPedalOpening() {
        return acceleratorPedalOpening;
    }

    public Integer getWiperFrontControlSetting() {
        return wiperFrontControlSetting;
    }

    public Integer getIgnitionStatus() {
        return ignitionStatus;
    }

    public Integer getAcBlowerLevel() {
        return acBlowerLevel;
    }

    public Float getSteeringWheelAngle() {
        return steeringWheelAngle;
    }

    public Boolean getAirRecirculationStatusOperation() {
        return airRecirculationStatusOperation;
    }

    public Float getAcDriverSettingTemp() {
        return acDriverSettingTemp;
    }

    public Float getInsideTemp() {
        return insideTemp;
    }

    public Float getOutsideTemp() {
        return outsideTemp;
    }

    public Boolean getDefoggerFrontStatusOperation() {
        return defoggerFrontStatusOperation;
    }

    public Integer getTransmissionGearPosition() {
        return transmissionGearPosition;
    }

    public Integer getHeaterStatusOperation() {
        return heaterStatusOperation;
    }

    public Float getCustomAmRadioChannel() {
        return customAmRadioChannel;
    }

    public Float getCustomFmRadioChannel() {
        return customFmRadioChannel;
    }

    public Integer getCustomAudioVol() {
        return customAudioVol;
    }

    public Integer getCustomAudioMode() {
        return customAudioMode;
    }

    public Boolean getCustomMusicStatus() {
        return customMusicStatus;
    }

    public Boolean getDoorRightFrontStatusOpen() {
        return doorRightFrontStatusOpen;
    }

    public Boolean getDoorLeftFrontStatusOpen() {
        return doorLeftFrontStatusOpen;
    }

    public Boolean getDoorRightRearStatusOpen() {
        return doorRightRearStatusOpen;
    }

    public Boolean getDoorLeftRearStatusOpen() {
        return doorLeftRearStatusOpen;
    }

    public Boolean getDoorTrunkStatusOpen() {
        return doorTrunkStatusOpen;
    }

    public Boolean getDoorRightFrontStatusLock() {
        return doorRightFrontStatusLock;
    }

    public Boolean getDoorLeftFrontStatusLock() {
        return doorLeftFrontStatusLock;
    }

    public Boolean getDoorRightRearStatusLock() {
        return doorRightRearStatusLock;
    }

    public Boolean getDoorLeftRearStatusLock() {
        return doorLeftRearStatusLock;
    }

    public Boolean getDoorTrunkStatusLock() {
        return doorTrunkStatusLock;
    }

    public Boolean getHazardLampOperationState() {
        return hazardLampOperationState;
    }

    public Boolean getLightHighBeamStatusLighting() {
        return lightHighBeamStatusLighting;
    }

    public Integer getLightHeadStatusLighting() {
        return lightHeadStatusLighting;
    }

    public Integer getTurnSignalStatusOperation() {
        return turnSignalStatusOperation;
    }

    public Integer getLampBreakStatusLighting() {
        return lampBreakStatusLighting;
    }

    public Float getNaviDestMeasuringLat() {
        return naviDestMeasuringLat;
    }

    public Float getNaviDestMeasuringLon() {
        return naviDestMeasuringLon;
    }

    public Float getGpsStatusMeasuringLon() {
        return gpsStatusMeasuringLon;
    }

    public Float getGpsStatusMeasuringLat() {
        return gpsStatusMeasuringLat;
    }

    public Boolean getCustomSeatRightFrontOccupantType() {
        return customSeatRightFrontOccupantType;
    }

    public Boolean getCustomSeatRightRearOccupantType() {
        return customSeatRightRearOccupantType;
    }

    public Boolean getCustomSeatLeftFrontOccupantType() {
        return customSeatLeftFrontOccupantType;
    }

    public Boolean getCustomSeatLeftRearOccupantType() {
        return customSeatLeftRearOccupantType;
    }

    public Integer getFuelRemainingPercent() {
        return fuelRemainingPercent;
    }

    public Integer getCustomSensorRightFrontLevel() {
        return customSensorRightFrontLevel;
    }

    public Integer getCustomSensorRightRearLevel() {
        return customSensorRightRearLevel;
    }

    public Integer getCustomSensorLeftFrontLevel() {
        return customSensorLeftFrontLevel;
    }

    public Integer getCustomSensorLeftRearLevel() {
        return customSensorLeftRearLevel;
    }

    public String getTimestamp() {
        return timestamp;
    }

    private Vehicle(String id, Boolean dummy, Float vehicleSpeed, Boolean hornStatusSound, Integer acBlowerMode, Float brakePressure, Float acceleratorPedalOpening, Integer wiperFrontControlSetting, Integer ignitionStatus, Integer acBlowerLevel, Float steeringWheelAngle, Boolean airRecirculationStatusOperation, Float acDriverSettingTemp, Float insideTemp, Float outsideTemp, Boolean defoggerFrontStatusOperation, Integer transmissionGearPosition, Integer heaterStatusOperation, Float customAmRadioChannel, Float customFmRadioChannel, Integer customAudioVol, Integer customAudioMode, Boolean customMusicStatus, Boolean doorRightFrontStatusOpen, Boolean doorLeftFrontStatusOpen, Boolean doorRightRearStatusOpen, Boolean doorLeftRearStatusOpen, Boolean doorTrunkStatusOpen, Boolean doorRightFrontStatusLock, Boolean doorLeftFrontStatusLock, Boolean doorRightRearStatusLock, Boolean doorLeftRearStatusLock, Boolean doorTrunkStatusLock, Boolean hazardLampOperationState, Boolean lightHighBeamStatusLighting, Integer lightHeadStatusLighting, Integer turnSignalStatusOperation, Integer lampBreakStatusLighting, Float naviDestMeasuringLat, Float naviDestMeasuringLon, Float gpsStatusMeasuringLon, Float gpsStatusMeasuringLat, Boolean customSeatRightFrontOccupantType, Boolean customSeatRightRearOccupantType, Boolean customSeatLeftFrontOccupantType, Boolean customSeatLeftRearOccupantType, Integer fuelRemainingPercent, Integer customSensorRightFrontLevel, Integer customSensorRightRearLevel, Integer customSensorLeftFrontLevel, Integer customSensorLeftRearLevel, String timestamp) {
        this.id = id;
        this.dummy = dummy;
        this.vehicleSpeed = vehicleSpeed;
        this.hornStatusSound = hornStatusSound;
        this.acBlowerMode = acBlowerMode;
        this.brakePressure = brakePressure;
        this.acceleratorPedalOpening = acceleratorPedalOpening;
        this.wiperFrontControlSetting = wiperFrontControlSetting;
        this.ignitionStatus = ignitionStatus;
        this.acBlowerLevel = acBlowerLevel;
        this.steeringWheelAngle = steeringWheelAngle;
        this.airRecirculationStatusOperation = airRecirculationStatusOperation;
        this.acDriverSettingTemp = acDriverSettingTemp;
        this.insideTemp = insideTemp;
        this.outsideTemp = outsideTemp;
        this.defoggerFrontStatusOperation = defoggerFrontStatusOperation;
        this.transmissionGearPosition = transmissionGearPosition;
        this.heaterStatusOperation = heaterStatusOperation;
        this.customAmRadioChannel = customAmRadioChannel;
        this.customFmRadioChannel = customFmRadioChannel;
        this.customAudioVol = customAudioVol;
        this.customAudioMode = customAudioMode;
        this.customMusicStatus = customMusicStatus;
        this.doorRightFrontStatusOpen = doorRightFrontStatusOpen;
        this.doorLeftFrontStatusOpen = doorLeftFrontStatusOpen;
        this.doorRightRearStatusOpen = doorRightRearStatusOpen;
        this.doorLeftRearStatusOpen = doorLeftRearStatusOpen;
        this.doorTrunkStatusOpen = doorTrunkStatusOpen;
        this.doorRightFrontStatusLock = doorRightFrontStatusLock;
        this.doorLeftFrontStatusLock = doorLeftFrontStatusLock;
        this.doorRightRearStatusLock = doorRightRearStatusLock;
        this.doorLeftRearStatusLock = doorLeftRearStatusLock;
        this.doorTrunkStatusLock = doorTrunkStatusLock;
        this.hazardLampOperationState = hazardLampOperationState;
        this.lightHighBeamStatusLighting = lightHighBeamStatusLighting;
        this.lightHeadStatusLighting = lightHeadStatusLighting;
        this.turnSignalStatusOperation = turnSignalStatusOperation;
        this.lampBreakStatusLighting = lampBreakStatusLighting;
        this.naviDestMeasuringLat = naviDestMeasuringLat;
        this.naviDestMeasuringLon = naviDestMeasuringLon;
        this.gpsStatusMeasuringLon = gpsStatusMeasuringLon;
        this.gpsStatusMeasuringLat = gpsStatusMeasuringLat;
        this.customSeatRightFrontOccupantType = customSeatRightFrontOccupantType;
        this.customSeatRightRearOccupantType = customSeatRightRearOccupantType;
        this.customSeatLeftFrontOccupantType = customSeatLeftFrontOccupantType;
        this.customSeatLeftRearOccupantType = customSeatLeftRearOccupantType;
        this.fuelRemainingPercent = fuelRemainingPercent;
        this.customSensorRightFrontLevel = customSensorRightFrontLevel;
        this.customSensorRightRearLevel = customSensorRightRearLevel;
        this.customSensorLeftFrontLevel = customSensorLeftFrontLevel;
        this.customSensorLeftRearLevel = customSensorLeftRearLevel;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Vehicle vehicle = (Vehicle) obj;
            return ObjectsCompat.equals(getId(), vehicle.getId()) &&
                    ObjectsCompat.equals(getDummy(), vehicle.getDummy()) &&
                    ObjectsCompat.equals(getVehicleSpeed(), vehicle.getVehicleSpeed()) &&
                    ObjectsCompat.equals(getHornStatusSound(), vehicle.getHornStatusSound()) &&
                    ObjectsCompat.equals(getAcBlowerMode(), vehicle.getAcBlowerMode()) &&
                    ObjectsCompat.equals(getBrakePressure(), vehicle.getBrakePressure()) &&
                    ObjectsCompat.equals(getAcceleratorPedalOpening(), vehicle.getAcceleratorPedalOpening()) &&
                    ObjectsCompat.equals(getWiperFrontControlSetting(), vehicle.getWiperFrontControlSetting()) &&
                    ObjectsCompat.equals(getIgnitionStatus(), vehicle.getIgnitionStatus()) &&
                    ObjectsCompat.equals(getAcBlowerLevel(), vehicle.getAcBlowerLevel()) &&
                    ObjectsCompat.equals(getSteeringWheelAngle(), vehicle.getSteeringWheelAngle()) &&
                    ObjectsCompat.equals(getAirRecirculationStatusOperation(), vehicle.getAirRecirculationStatusOperation()) &&
                    ObjectsCompat.equals(getAcDriverSettingTemp(), vehicle.getAcDriverSettingTemp()) &&
                    ObjectsCompat.equals(getInsideTemp(), vehicle.getInsideTemp()) &&
                    ObjectsCompat.equals(getOutsideTemp(), vehicle.getOutsideTemp()) &&
                    ObjectsCompat.equals(getDefoggerFrontStatusOperation(), vehicle.getDefoggerFrontStatusOperation()) &&
                    ObjectsCompat.equals(getTransmissionGearPosition(), vehicle.getTransmissionGearPosition()) &&
                    ObjectsCompat.equals(getHeaterStatusOperation(), vehicle.getHeaterStatusOperation()) &&
                    ObjectsCompat.equals(getCustomAmRadioChannel(), vehicle.getCustomAmRadioChannel()) &&
                    ObjectsCompat.equals(getCustomFmRadioChannel(), vehicle.getCustomFmRadioChannel()) &&
                    ObjectsCompat.equals(getCustomAudioVol(), vehicle.getCustomAudioVol()) &&
                    ObjectsCompat.equals(getCustomAudioMode(), vehicle.getCustomAudioMode()) &&
                    ObjectsCompat.equals(getCustomMusicStatus(), vehicle.getCustomMusicStatus()) &&
                    ObjectsCompat.equals(getDoorRightFrontStatusOpen(), vehicle.getDoorRightFrontStatusOpen()) &&
                    ObjectsCompat.equals(getDoorLeftFrontStatusOpen(), vehicle.getDoorLeftFrontStatusOpen()) &&
                    ObjectsCompat.equals(getDoorRightRearStatusOpen(), vehicle.getDoorRightRearStatusOpen()) &&
                    ObjectsCompat.equals(getDoorLeftRearStatusOpen(), vehicle.getDoorLeftRearStatusOpen()) &&
                    ObjectsCompat.equals(getDoorTrunkStatusOpen(), vehicle.getDoorTrunkStatusOpen()) &&
                    ObjectsCompat.equals(getDoorRightFrontStatusLock(), vehicle.getDoorRightFrontStatusLock()) &&
                    ObjectsCompat.equals(getDoorLeftFrontStatusLock(), vehicle.getDoorLeftFrontStatusLock()) &&
                    ObjectsCompat.equals(getDoorRightRearStatusLock(), vehicle.getDoorRightRearStatusLock()) &&
                    ObjectsCompat.equals(getDoorLeftRearStatusLock(), vehicle.getDoorLeftRearStatusLock()) &&
                    ObjectsCompat.equals(getDoorTrunkStatusLock(), vehicle.getDoorTrunkStatusLock()) &&
                    ObjectsCompat.equals(getHazardLampOperationState(), vehicle.getHazardLampOperationState()) &&
                    ObjectsCompat.equals(getLightHighBeamStatusLighting(), vehicle.getLightHighBeamStatusLighting()) &&
                    ObjectsCompat.equals(getLightHeadStatusLighting(), vehicle.getLightHeadStatusLighting()) &&
                    ObjectsCompat.equals(getTurnSignalStatusOperation(), vehicle.getTurnSignalStatusOperation()) &&
                    ObjectsCompat.equals(getLampBreakStatusLighting(), vehicle.getLampBreakStatusLighting()) &&
                    ObjectsCompat.equals(getNaviDestMeasuringLat(), vehicle.getNaviDestMeasuringLat()) &&
                    ObjectsCompat.equals(getNaviDestMeasuringLon(), vehicle.getNaviDestMeasuringLon()) &&
                    ObjectsCompat.equals(getGpsStatusMeasuringLon(), vehicle.getGpsStatusMeasuringLon()) &&
                    ObjectsCompat.equals(getGpsStatusMeasuringLat(), vehicle.getGpsStatusMeasuringLat()) &&
                    ObjectsCompat.equals(getCustomSeatRightFrontOccupantType(), vehicle.getCustomSeatRightFrontOccupantType()) &&
                    ObjectsCompat.equals(getCustomSeatRightRearOccupantType(), vehicle.getCustomSeatRightRearOccupantType()) &&
                    ObjectsCompat.equals(getCustomSeatLeftFrontOccupantType(), vehicle.getCustomSeatLeftFrontOccupantType()) &&
                    ObjectsCompat.equals(getCustomSeatLeftRearOccupantType(), vehicle.getCustomSeatLeftRearOccupantType()) &&
                    ObjectsCompat.equals(getFuelRemainingPercent(), vehicle.getFuelRemainingPercent()) &&
                    ObjectsCompat.equals(getCustomSensorRightFrontLevel(), vehicle.getCustomSensorRightFrontLevel()) &&
                    ObjectsCompat.equals(getCustomSensorRightRearLevel(), vehicle.getCustomSensorRightRearLevel()) &&
                    ObjectsCompat.equals(getCustomSensorLeftFrontLevel(), vehicle.getCustomSensorLeftFrontLevel()) &&
                    ObjectsCompat.equals(getCustomSensorLeftRearLevel(), vehicle.getCustomSensorLeftRearLevel()) &&
                    ObjectsCompat.equals(getTimestamp(), vehicle.getTimestamp());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getDummy())
                .append(getVehicleSpeed())
                .append(getHornStatusSound())
                .append(getAcBlowerMode())
                .append(getBrakePressure())
                .append(getAcceleratorPedalOpening())
                .append(getWiperFrontControlSetting())
                .append(getIgnitionStatus())
                .append(getAcBlowerLevel())
                .append(getSteeringWheelAngle())
                .append(getAirRecirculationStatusOperation())
                .append(getAcDriverSettingTemp())
                .append(getInsideTemp())
                .append(getOutsideTemp())
                .append(getDefoggerFrontStatusOperation())
                .append(getTransmissionGearPosition())
                .append(getHeaterStatusOperation())
                .append(getCustomAmRadioChannel())
                .append(getCustomFmRadioChannel())
                .append(getCustomAudioVol())
                .append(getCustomAudioMode())
                .append(getCustomMusicStatus())
                .append(getDoorRightFrontStatusOpen())
                .append(getDoorLeftFrontStatusOpen())
                .append(getDoorRightRearStatusOpen())
                .append(getDoorLeftRearStatusOpen())
                .append(getDoorTrunkStatusOpen())
                .append(getDoorRightFrontStatusLock())
                .append(getDoorLeftFrontStatusLock())
                .append(getDoorRightRearStatusLock())
                .append(getDoorLeftRearStatusLock())
                .append(getDoorTrunkStatusLock())
                .append(getHazardLampOperationState())
                .append(getLightHighBeamStatusLighting())
                .append(getLightHeadStatusLighting())
                .append(getTurnSignalStatusOperation())
                .append(getLampBreakStatusLighting())
                .append(getNaviDestMeasuringLat())
                .append(getNaviDestMeasuringLon())
                .append(getGpsStatusMeasuringLon())
                .append(getGpsStatusMeasuringLat())
                .append(getCustomSeatRightFrontOccupantType())
                .append(getCustomSeatRightRearOccupantType())
                .append(getCustomSeatLeftFrontOccupantType())
                .append(getCustomSeatLeftRearOccupantType())
                .append(getFuelRemainingPercent())
                .append(getCustomSensorRightFrontLevel())
                .append(getCustomSensorRightRearLevel())
                .append(getCustomSensorLeftFrontLevel())
                .append(getCustomSensorLeftRearLevel())
                .append(getTimestamp())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Vehicle {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("dummy=" + String.valueOf(getDummy()) + ", ")
                .append("vehicleSpeed=" + String.valueOf(getVehicleSpeed()) + ", ")
                .append("hornStatusSound=" + String.valueOf(getHornStatusSound()) + ", ")
                .append("acBlowerMode=" + String.valueOf(getAcBlowerMode()) + ", ")
                .append("brakePressure=" + String.valueOf(getBrakePressure()) + ", ")
                .append("acceleratorPedalOpening=" + String.valueOf(getAcceleratorPedalOpening()) + ", ")
                .append("wiperFrontControlSetting=" + String.valueOf(getWiperFrontControlSetting()) + ", ")
                .append("ignitionStatus=" + String.valueOf(getIgnitionStatus()) + ", ")
                .append("acBlowerLevel=" + String.valueOf(getAcBlowerLevel()) + ", ")
                .append("steeringWheelAngle=" + String.valueOf(getSteeringWheelAngle()) + ", ")
                .append("airRecirculationStatusOperation=" + String.valueOf(getAirRecirculationStatusOperation()) + ", ")
                .append("acDriverSettingTemp=" + String.valueOf(getAcDriverSettingTemp()) + ", ")
                .append("insideTemp=" + String.valueOf(getInsideTemp()) + ", ")
                .append("outsideTemp=" + String.valueOf(getOutsideTemp()) + ", ")
                .append("defoggerFrontStatusOperation=" + String.valueOf(getDefoggerFrontStatusOperation()) + ", ")
                .append("transmissionGearPosition=" + String.valueOf(getTransmissionGearPosition()) + ", ")
                .append("heaterStatusOperation=" + String.valueOf(getHeaterStatusOperation()) + ", ")
                .append("customAmRadioChannel=" + String.valueOf(getCustomAmRadioChannel()) + ", ")
                .append("customFmRadioChannel=" + String.valueOf(getCustomFmRadioChannel()) + ", ")
                .append("customAudioVol=" + String.valueOf(getCustomAudioVol()) + ", ")
                .append("customAudioMode=" + String.valueOf(getCustomAudioMode()) + ", ")
                .append("customMusicStatus=" + String.valueOf(getCustomMusicStatus()) + ", ")
                .append("doorRightFrontStatusOpen=" + String.valueOf(getDoorRightFrontStatusOpen()) + ", ")
                .append("doorLeftFrontStatusOpen=" + String.valueOf(getDoorLeftFrontStatusOpen()) + ", ")
                .append("doorRightRearStatusOpen=" + String.valueOf(getDoorRightRearStatusOpen()) + ", ")
                .append("doorLeftRearStatusOpen=" + String.valueOf(getDoorLeftRearStatusOpen()) + ", ")
                .append("doorTrunkStatusOpen=" + String.valueOf(getDoorTrunkStatusOpen()) + ", ")
                .append("doorRightFrontStatusLock=" + String.valueOf(getDoorRightFrontStatusLock()) + ", ")
                .append("doorLeftFrontStatusLock=" + String.valueOf(getDoorLeftFrontStatusLock()) + ", ")
                .append("doorRightRearStatusLock=" + String.valueOf(getDoorRightRearStatusLock()) + ", ")
                .append("doorLeftRearStatusLock=" + String.valueOf(getDoorLeftRearStatusLock()) + ", ")
                .append("doorTrunkStatusLock=" + String.valueOf(getDoorTrunkStatusLock()) + ", ")
                .append("hazardLampOperationState=" + String.valueOf(getHazardLampOperationState()) + ", ")
                .append("lightHighBeamStatusLighting=" + String.valueOf(getLightHighBeamStatusLighting()) + ", ")
                .append("lightHeadStatusLighting=" + String.valueOf(getLightHeadStatusLighting()) + ", ")
                .append("turnSignalStatusOperation=" + String.valueOf(getTurnSignalStatusOperation()) + ", ")
                .append("lampBreakStatusLighting=" + String.valueOf(getLampBreakStatusLighting()) + ", ")
                .append("naviDestMeasuringLat=" + String.valueOf(getNaviDestMeasuringLat()) + ", ")
                .append("naviDestMeasuringLon=" + String.valueOf(getNaviDestMeasuringLon()) + ", ")
                .append("gpsStatusMeasuringLon=" + String.valueOf(getGpsStatusMeasuringLon()) + ", ")
                .append("gpsStatusMeasuringLat=" + String.valueOf(getGpsStatusMeasuringLat()) + ", ")
                .append("customSeatRightFrontOccupantType=" + String.valueOf(getCustomSeatRightFrontOccupantType()) + ", ")
                .append("customSeatRightRearOccupantType=" + String.valueOf(getCustomSeatRightRearOccupantType()) + ", ")
                .append("customSeatLeftFrontOccupantType=" + String.valueOf(getCustomSeatLeftFrontOccupantType()) + ", ")
                .append("customSeatLeftRearOccupantType=" + String.valueOf(getCustomSeatLeftRearOccupantType()) + ", ")
                .append("fuelRemainingPercent=" + String.valueOf(getFuelRemainingPercent()) + ", ")
                .append("customSensorRightFrontLevel=" + String.valueOf(getCustomSensorRightFrontLevel()) + ", ")
                .append("customSensorRightRearLevel=" + String.valueOf(getCustomSensorRightRearLevel()) + ", ")
                .append("customSensorLeftFrontLevel=" + String.valueOf(getCustomSensorLeftFrontLevel()) + ", ")
                .append("customSensorLeftRearLevel=" + String.valueOf(getCustomSensorLeftRearLevel()) + ", ")
                .append("timestamp=" + String.valueOf(getTimestamp()))
                .append("}")
                .toString();
    }

    public static BuildStep builder() {
        return new Builder();
    }

    /**
     * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
     * This is a convenience method to return an instance of the object with only its ID populated
     * to be used in the context of a parameter in a delete mutation or referencing a foreign key
     * in a relationship.
     * @param id the id of the existing item this instance will represent
     * @return an instance of this model with only ID populated
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public static Vehicle justId(String id) {
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
            throw new IllegalArgumentException(
                    "Model IDs must be unique in the format of UUID. This method is for creating instances " +
                            "of an existing object with only its ID field for sending as a mutation parameter. When " +
                            "creating a new object, use the standard builder method and leave the ID field blank."
            );
        }
        return new Vehicle(
                id,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public CopyOfBuilder copyOfBuilder() {
        return new CopyOfBuilder(id,
                dummy,
                vehicleSpeed,
                hornStatusSound,
                acBlowerMode,
                brakePressure,
                acceleratorPedalOpening,
                wiperFrontControlSetting,
                ignitionStatus,
                acBlowerLevel,
                steeringWheelAngle,
                airRecirculationStatusOperation,
                acDriverSettingTemp,
                insideTemp,
                outsideTemp,
                defoggerFrontStatusOperation,
                transmissionGearPosition,
                heaterStatusOperation,
                customAmRadioChannel,
                customFmRadioChannel,
                customAudioVol,
                customAudioMode,
                customMusicStatus,
                doorRightFrontStatusOpen,
                doorLeftFrontStatusOpen,
                doorRightRearStatusOpen,
                doorLeftRearStatusOpen,
                doorTrunkStatusOpen,
                doorRightFrontStatusLock,
                doorLeftFrontStatusLock,
                doorRightRearStatusLock,
                doorLeftRearStatusLock,
                doorTrunkStatusLock,
                hazardLampOperationState,
                lightHighBeamStatusLighting,
                lightHeadStatusLighting,
                turnSignalStatusOperation,
                lampBreakStatusLighting,
                naviDestMeasuringLat,
                naviDestMeasuringLon,
                gpsStatusMeasuringLon,
                gpsStatusMeasuringLat,
                customSeatRightFrontOccupantType,
                customSeatRightRearOccupantType,
                customSeatLeftFrontOccupantType,
                customSeatLeftRearOccupantType,
                fuelRemainingPercent,
                customSensorRightFrontLevel,
                customSensorRightRearLevel,
                customSensorLeftFrontLevel,
                customSensorLeftRearLevel,
                timestamp);
    }
    public interface BuildStep {
        Vehicle build();
        BuildStep id(String id) throws IllegalArgumentException;
        BuildStep dummy(Boolean dummy);
        BuildStep vehicleSpeed(Float vehicleSpeed);
        BuildStep hornStatusSound(Boolean hornStatusSound);
        BuildStep acBlowerMode(Integer acBlowerMode);
        BuildStep brakePressure(Float brakePressure);
        BuildStep acceleratorPedalOpening(Float acceleratorPedalOpening);
        BuildStep wiperFrontControlSetting(Integer wiperFrontControlSetting);
        BuildStep ignitionStatus(Integer ignitionStatus);
        BuildStep acBlowerLevel(Integer acBlowerLevel);
        BuildStep steeringWheelAngle(Float steeringWheelAngle);
        BuildStep airRecirculationStatusOperation(Boolean airRecirculationStatusOperation);
        BuildStep acDriverSettingTemp(Float acDriverSettingTemp);
        BuildStep insideTemp(Float insideTemp);
        BuildStep outsideTemp(Float outsideTemp);
        BuildStep defoggerFrontStatusOperation(Boolean defoggerFrontStatusOperation);
        BuildStep transmissionGearPosition(Integer transmissionGearPosition);
        BuildStep heaterStatusOperation(Integer heaterStatusOperation);
        BuildStep customAmRadioChannel(Float customAmRadioChannel);
        BuildStep customFmRadioChannel(Float customFmRadioChannel);
        BuildStep customAudioVol(Integer customAudioVol);
        BuildStep customAudioMode(Integer customAudioMode);
        BuildStep customMusicStatus(Boolean customMusicStatus);
        BuildStep doorRightFrontStatusOpen(Boolean doorRightFrontStatusOpen);
        BuildStep doorLeftFrontStatusOpen(Boolean doorLeftFrontStatusOpen);
        BuildStep doorRightRearStatusOpen(Boolean doorRightRearStatusOpen);
        BuildStep doorLeftRearStatusOpen(Boolean doorLeftRearStatusOpen);
        BuildStep doorTrunkStatusOpen(Boolean doorTrunkStatusOpen);
        BuildStep doorRightFrontStatusLock(Boolean doorRightFrontStatusLock);
        BuildStep doorLeftFrontStatusLock(Boolean doorLeftFrontStatusLock);
        BuildStep doorRightRearStatusLock(Boolean doorRightRearStatusLock);
        BuildStep doorLeftRearStatusLock(Boolean doorLeftRearStatusLock);
        BuildStep doorTrunkStatusLock(Boolean doorTrunkStatusLock);
        BuildStep hazardLampOperationState(Boolean hazardLampOperationState);
        BuildStep lightHighBeamStatusLighting(Boolean lightHighBeamStatusLighting);
        BuildStep lightHeadStatusLighting(Integer lightHeadStatusLighting);
        BuildStep turnSignalStatusOperation(Integer turnSignalStatusOperation);
        BuildStep lampBreakStatusLighting(Integer lampBreakStatusLighting);
        BuildStep naviDestMeasuringLat(Float naviDestMeasuringLat);
        BuildStep naviDestMeasuringLon(Float naviDestMeasuringLon);
        BuildStep gpsStatusMeasuringLon(Float gpsStatusMeasuringLon);
        BuildStep gpsStatusMeasuringLat(Float gpsStatusMeasuringLat);
        BuildStep customSeatRightFrontOccupantType(Boolean customSeatRightFrontOccupantType);
        BuildStep customSeatRightRearOccupantType(Boolean customSeatRightRearOccupantType);
        BuildStep customSeatLeftFrontOccupantType(Boolean customSeatLeftFrontOccupantType);
        BuildStep customSeatLeftRearOccupantType(Boolean customSeatLeftRearOccupantType);
        BuildStep fuelRemainingPercent(Integer fuelRemainingPercent);
        BuildStep customSensorRightFrontLevel(Integer customSensorRightFrontLevel);
        BuildStep customSensorRightRearLevel(Integer customSensorRightRearLevel);
        BuildStep customSensorLeftFrontLevel(Integer customSensorLeftFrontLevel);
        BuildStep customSensorLeftRearLevel(Integer customSensorLeftRearLevel);
        BuildStep timestamp(String timestamp);
    }


    public static class Builder implements BuildStep {
        private String id;
        private Boolean dummy;
        private Float vehicleSpeed;
        private Boolean hornStatusSound;
        private Integer acBlowerMode;
        private Float brakePressure;
        private Float acceleratorPedalOpening;
        private Integer wiperFrontControlSetting;
        private Integer ignitionStatus;
        private Integer acBlowerLevel;
        private Float steeringWheelAngle;
        private Boolean airRecirculationStatusOperation;
        private Float acDriverSettingTemp;
        private Float insideTemp;
        private Float outsideTemp;
        private Boolean defoggerFrontStatusOperation;
        private Integer transmissionGearPosition;
        private Integer heaterStatusOperation;
        private Float customAmRadioChannel;
        private Float customFmRadioChannel;
        private Integer customAudioVol;
        private Integer customAudioMode;
        private Boolean customMusicStatus;
        private Boolean doorRightFrontStatusOpen;
        private Boolean doorLeftFrontStatusOpen;
        private Boolean doorRightRearStatusOpen;
        private Boolean doorLeftRearStatusOpen;
        private Boolean doorTrunkStatusOpen;
        private Boolean doorRightFrontStatusLock;
        private Boolean doorLeftFrontStatusLock;
        private Boolean doorRightRearStatusLock;
        private Boolean doorLeftRearStatusLock;
        private Boolean doorTrunkStatusLock;
        private Boolean hazardLampOperationState;
        private Boolean lightHighBeamStatusLighting;
        private Integer lightHeadStatusLighting;
        private Integer turnSignalStatusOperation;
        private Integer lampBreakStatusLighting;
        private Float naviDestMeasuringLat;
        private Float naviDestMeasuringLon;
        private Float gpsStatusMeasuringLon;
        private Float gpsStatusMeasuringLat;
        private Boolean customSeatRightFrontOccupantType;
        private Boolean customSeatRightRearOccupantType;
        private Boolean customSeatLeftFrontOccupantType;
        private Boolean customSeatLeftRearOccupantType;
        private Integer fuelRemainingPercent;
        private Integer customSensorRightFrontLevel;
        private Integer customSensorRightRearLevel;
        private Integer customSensorLeftFrontLevel;
        private Integer customSensorLeftRearLevel;
        private String timestamp;
        @Override
        public Vehicle build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new Vehicle(
                    id,
                    dummy,
                    vehicleSpeed,
                    hornStatusSound,
                    acBlowerMode,
                    brakePressure,
                    acceleratorPedalOpening,
                    wiperFrontControlSetting,
                    ignitionStatus,
                    acBlowerLevel,
                    steeringWheelAngle,
                    airRecirculationStatusOperation,
                    acDriverSettingTemp,
                    insideTemp,
                    outsideTemp,
                    defoggerFrontStatusOperation,
                    transmissionGearPosition,
                    heaterStatusOperation,
                    customAmRadioChannel,
                    customFmRadioChannel,
                    customAudioVol,
                    customAudioMode,
                    customMusicStatus,
                    doorRightFrontStatusOpen,
                    doorLeftFrontStatusOpen,
                    doorRightRearStatusOpen,
                    doorLeftRearStatusOpen,
                    doorTrunkStatusOpen,
                    doorRightFrontStatusLock,
                    doorLeftFrontStatusLock,
                    doorRightRearStatusLock,
                    doorLeftRearStatusLock,
                    doorTrunkStatusLock,
                    hazardLampOperationState,
                    lightHighBeamStatusLighting,
                    lightHeadStatusLighting,
                    turnSignalStatusOperation,
                    lampBreakStatusLighting,
                    naviDestMeasuringLat,
                    naviDestMeasuringLon,
                    gpsStatusMeasuringLon,
                    gpsStatusMeasuringLat,
                    customSeatRightFrontOccupantType,
                    customSeatRightRearOccupantType,
                    customSeatLeftFrontOccupantType,
                    customSeatLeftRearOccupantType,
                    fuelRemainingPercent,
                    customSensorRightFrontLevel,
                    customSensorRightRearLevel,
                    customSensorLeftFrontLevel,
                    customSensorLeftRearLevel,
                    timestamp);
        }

        @Override
        public BuildStep dummy(Boolean dummy) {
            this.dummy = dummy;
            return this;
        }

        @Override
        public BuildStep vehicleSpeed(Float vehicleSpeed) {
            this.vehicleSpeed = vehicleSpeed;
            return this;
        }

        @Override
        public BuildStep hornStatusSound(Boolean hornStatusSound) {
            this.hornStatusSound = hornStatusSound;
            return this;
        }

        @Override
        public BuildStep acBlowerMode(Integer acBlowerMode) {
            this.acBlowerMode = acBlowerMode;
            return this;
        }

        @Override
        public BuildStep brakePressure(Float brakePressure) {
            this.brakePressure = brakePressure;
            return this;
        }

        @Override
        public BuildStep acceleratorPedalOpening(Float acceleratorPedalOpening) {
            this.acceleratorPedalOpening = acceleratorPedalOpening;
            return this;
        }

        @Override
        public BuildStep wiperFrontControlSetting(Integer wiperFrontControlSetting) {
            this.wiperFrontControlSetting = wiperFrontControlSetting;
            return this;
        }

        @Override
        public BuildStep ignitionStatus(Integer ignitionStatus) {
            this.ignitionStatus = ignitionStatus;
            return this;
        }

        @Override
        public BuildStep acBlowerLevel(Integer acBlowerLevel) {
            this.acBlowerLevel = acBlowerLevel;
            return this;
        }

        @Override
        public BuildStep steeringWheelAngle(Float steeringWheelAngle) {
            this.steeringWheelAngle = steeringWheelAngle;
            return this;
        }

        @Override
        public BuildStep airRecirculationStatusOperation(Boolean airRecirculationStatusOperation) {
            this.airRecirculationStatusOperation = airRecirculationStatusOperation;
            return this;
        }

        @Override
        public BuildStep acDriverSettingTemp(Float acDriverSettingTemp) {
            this.acDriverSettingTemp = acDriverSettingTemp;
            return this;
        }

        @Override
        public BuildStep insideTemp(Float insideTemp) {
            this.insideTemp = insideTemp;
            return this;
        }

        @Override
        public BuildStep outsideTemp(Float outsideTemp) {
            this.outsideTemp = outsideTemp;
            return this;
        }

        @Override
        public BuildStep defoggerFrontStatusOperation(Boolean defoggerFrontStatusOperation) {
            this.defoggerFrontStatusOperation = defoggerFrontStatusOperation;
            return this;
        }

        @Override
        public BuildStep transmissionGearPosition(Integer transmissionGearPosition) {
            this.transmissionGearPosition = transmissionGearPosition;
            return this;
        }

        @Override
        public BuildStep heaterStatusOperation(Integer heaterStatusOperation) {
            this.heaterStatusOperation = heaterStatusOperation;
            return this;
        }

        @Override
        public BuildStep customAmRadioChannel(Float customAmRadioChannel) {
            this.customAmRadioChannel = customAmRadioChannel;
            return this;
        }

        @Override
        public BuildStep customFmRadioChannel(Float customFmRadioChannel) {
            this.customFmRadioChannel = customFmRadioChannel;
            return this;
        }

        @Override
        public BuildStep customAudioVol(Integer customAudioVol) {
            this.customAudioVol = customAudioVol;
            return this;
        }

        @Override
        public BuildStep customAudioMode(Integer customAudioMode) {
            this.customAudioMode = customAudioMode;
            return this;
        }

        @Override
        public BuildStep customMusicStatus(Boolean customMusicStatus) {
            this.customMusicStatus = customMusicStatus;
            return this;
        }

        @Override
        public BuildStep doorRightFrontStatusOpen(Boolean doorRightFrontStatusOpen) {
            this.doorRightFrontStatusOpen = doorRightFrontStatusOpen;
            return this;
        }

        @Override
        public BuildStep doorLeftFrontStatusOpen(Boolean doorLeftFrontStatusOpen) {
            this.doorLeftFrontStatusOpen = doorLeftFrontStatusOpen;
            return this;
        }

        @Override
        public BuildStep doorRightRearStatusOpen(Boolean doorRightRearStatusOpen) {
            this.doorRightRearStatusOpen = doorRightRearStatusOpen;
            return this;
        }

        @Override
        public BuildStep doorLeftRearStatusOpen(Boolean doorLeftRearStatusOpen) {
            this.doorLeftRearStatusOpen = doorLeftRearStatusOpen;
            return this;
        }

        @Override
        public BuildStep doorTrunkStatusOpen(Boolean doorTrunkStatusOpen) {
            this.doorTrunkStatusOpen = doorTrunkStatusOpen;
            return this;
        }

        @Override
        public BuildStep doorRightFrontStatusLock(Boolean doorRightFrontStatusLock) {
            this.doorRightFrontStatusLock = doorRightFrontStatusLock;
            return this;
        }

        @Override
        public BuildStep doorLeftFrontStatusLock(Boolean doorLeftFrontStatusLock) {
            this.doorLeftFrontStatusLock = doorLeftFrontStatusLock;
            return this;
        }

        @Override
        public BuildStep doorRightRearStatusLock(Boolean doorRightRearStatusLock) {
            this.doorRightRearStatusLock = doorRightRearStatusLock;
            return this;
        }

        @Override
        public BuildStep doorLeftRearStatusLock(Boolean doorLeftRearStatusLock) {
            this.doorLeftRearStatusLock = doorLeftRearStatusLock;
            return this;
        }

        @Override
        public BuildStep doorTrunkStatusLock(Boolean doorTrunkStatusLock) {
            this.doorTrunkStatusLock = doorTrunkStatusLock;
            return this;
        }

        @Override
        public BuildStep hazardLampOperationState(Boolean hazardLampOperationState) {
            this.hazardLampOperationState = hazardLampOperationState;
            return this;
        }

        @Override
        public BuildStep lightHighBeamStatusLighting(Boolean lightHighBeamStatusLighting) {
            this.lightHighBeamStatusLighting = lightHighBeamStatusLighting;
            return this;
        }

        @Override
        public BuildStep lightHeadStatusLighting(Integer lightHeadStatusLighting) {
            this.lightHeadStatusLighting = lightHeadStatusLighting;
            return this;
        }

        @Override
        public BuildStep turnSignalStatusOperation(Integer turnSignalStatusOperation) {
            this.turnSignalStatusOperation = turnSignalStatusOperation;
            return this;
        }

        @Override
        public BuildStep lampBreakStatusLighting(Integer lampBreakStatusLighting) {
            this.lampBreakStatusLighting = lampBreakStatusLighting;
            return this;
        }

        @Override
        public BuildStep naviDestMeasuringLat(Float naviDestMeasuringLat) {
            this.naviDestMeasuringLat = naviDestMeasuringLat;
            return this;
        }

        @Override
        public BuildStep naviDestMeasuringLon(Float naviDestMeasuringLon) {
            this.naviDestMeasuringLon = naviDestMeasuringLon;
            return this;
        }

        @Override
        public BuildStep gpsStatusMeasuringLon(Float gpsStatusMeasuringLon) {
            this.gpsStatusMeasuringLon = gpsStatusMeasuringLon;
            return this;
        }

        @Override
        public BuildStep gpsStatusMeasuringLat(Float gpsStatusMeasuringLat) {
            this.gpsStatusMeasuringLat = gpsStatusMeasuringLat;
            return this;
        }

        @Override
        public BuildStep customSeatRightFrontOccupantType(Boolean customSeatRightFrontOccupantType) {
            this.customSeatRightFrontOccupantType = customSeatRightFrontOccupantType;
            return this;
        }

        @Override
        public BuildStep customSeatRightRearOccupantType(Boolean customSeatRightRearOccupantType) {
            this.customSeatRightRearOccupantType = customSeatRightRearOccupantType;
            return this;
        }

        @Override
        public BuildStep customSeatLeftFrontOccupantType(Boolean customSeatLeftFrontOccupantType) {
            this.customSeatLeftFrontOccupantType = customSeatLeftFrontOccupantType;
            return this;
        }

        @Override
        public BuildStep customSeatLeftRearOccupantType(Boolean customSeatLeftRearOccupantType) {
            this.customSeatLeftRearOccupantType = customSeatLeftRearOccupantType;
            return this;
        }

        @Override
        public BuildStep fuelRemainingPercent(Integer fuelRemainingPercent) {
            this.fuelRemainingPercent = fuelRemainingPercent;
            return this;
        }

        @Override
        public BuildStep customSensorRightFrontLevel(Integer customSensorRightFrontLevel) {
            this.customSensorRightFrontLevel = customSensorRightFrontLevel;
            return this;
        }

        @Override
        public BuildStep customSensorRightRearLevel(Integer customSensorRightRearLevel) {
            this.customSensorRightRearLevel = customSensorRightRearLevel;
            return this;
        }

        @Override
        public BuildStep customSensorLeftFrontLevel(Integer customSensorLeftFrontLevel) {
            this.customSensorLeftFrontLevel = customSensorLeftFrontLevel;
            return this;
        }

        @Override
        public BuildStep customSensorLeftRearLevel(Integer customSensorLeftRearLevel) {
            this.customSensorLeftRearLevel = customSensorLeftRearLevel;
            return this;
        }

        @Override
        public BuildStep timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
         * This should only be set when referring to an already existing object.
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         * @throws IllegalArgumentException Checks that ID is in the proper format
         */
        public BuildStep id(String id) throws IllegalArgumentException {
            this.id = id;

//        try {
//            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
//        } catch (Exception exception) {
//          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
//                    exception);
//        }

            return this;
        }
    }


    public final class CopyOfBuilder extends Builder {
        private CopyOfBuilder(String id, Boolean dummy, Float vehicleSpeed, Boolean hornStatusSound, Integer acBlowerMode, Float brakePressure, Float acceleratorPedalOpening, Integer wiperFrontControlSetting, Integer ignitionStatus, Integer acBlowerLevel, Float steeringWheelAngle, Boolean airRecirculationStatusOperation, Float acDriverSettingTemp, Float insideTemp, Float outsideTemp, Boolean defoggerFrontStatusOperation, Integer transmissionGearPosition, Integer heaterStatusOperation, Float customAmRadioChannel, Float customFmRadioChannel, Integer customAudioVol, Integer customAudioMode, Boolean customMusicStatus, Boolean doorRightFrontStatusOpen, Boolean doorLeftFrontStatusOpen, Boolean doorRightRearStatusOpen, Boolean doorLeftRearStatusOpen, Boolean doorTrunkStatusOpen, Boolean doorRightFrontStatusLock, Boolean doorLeftFrontStatusLock, Boolean doorRightRearStatusLock, Boolean doorLeftRearStatusLock, Boolean doorTrunkStatusLock, Boolean hazardLampOperationState, Boolean lightHighBeamStatusLighting, Integer lightHeadStatusLighting, Integer turnSignalStatusOperation, Integer lampBreakStatusLighting, Float naviDestMeasuringLat, Float naviDestMeasuringLon, Float gpsStatusMeasuringLon, Float gpsStatusMeasuringLat, Boolean customSeatRightFrontOccupantType, Boolean customSeatRightRearOccupantType, Boolean customSeatLeftFrontOccupantType, Boolean customSeatLeftRearOccupantType, Integer fuelRemainingPercent, Integer customSensorRightFrontLevel, Integer customSensorRightRearLevel, Integer customSensorLeftFrontLevel, Integer customSensorLeftRearLevel, String timestamp) {
            super.id(id);
            super.dummy(dummy)
                    .vehicleSpeed(vehicleSpeed)
                    .hornStatusSound(hornStatusSound)
                    .acBlowerMode(acBlowerMode)
                    .brakePressure(brakePressure)
                    .acceleratorPedalOpening(acceleratorPedalOpening)
                    .wiperFrontControlSetting(wiperFrontControlSetting)
                    .ignitionStatus(ignitionStatus)
                    .acBlowerLevel(acBlowerLevel)
                    .steeringWheelAngle(steeringWheelAngle)
                    .airRecirculationStatusOperation(airRecirculationStatusOperation)
                    .acDriverSettingTemp(acDriverSettingTemp)
                    .insideTemp(insideTemp)
                    .outsideTemp(outsideTemp)
                    .defoggerFrontStatusOperation(defoggerFrontStatusOperation)
                    .transmissionGearPosition(transmissionGearPosition)
                    .heaterStatusOperation(heaterStatusOperation)
                    .customAmRadioChannel(customAmRadioChannel)
                    .customFmRadioChannel(customFmRadioChannel)
                    .customAudioVol(customAudioVol)
                    .customAudioMode(customAudioMode)
                    .customMusicStatus(customMusicStatus)
                    .doorRightFrontStatusOpen(doorRightFrontStatusOpen)
                    .doorLeftFrontStatusOpen(doorLeftFrontStatusOpen)
                    .doorRightRearStatusOpen(doorRightRearStatusOpen)
                    .doorLeftRearStatusOpen(doorLeftRearStatusOpen)
                    .doorTrunkStatusOpen(doorTrunkStatusOpen)
                    .doorRightFrontStatusLock(doorRightFrontStatusLock)
                    .doorLeftFrontStatusLock(doorLeftFrontStatusLock)
                    .doorRightRearStatusLock(doorRightRearStatusLock)
                    .doorLeftRearStatusLock(doorLeftRearStatusLock)
                    .doorTrunkStatusLock(doorTrunkStatusLock)
                    .hazardLampOperationState(hazardLampOperationState)
                    .lightHighBeamStatusLighting(lightHighBeamStatusLighting)
                    .lightHeadStatusLighting(lightHeadStatusLighting)
                    .turnSignalStatusOperation(turnSignalStatusOperation)
                    .lampBreakStatusLighting(lampBreakStatusLighting)
                    .naviDestMeasuringLat(naviDestMeasuringLat)
                    .naviDestMeasuringLon(naviDestMeasuringLon)
                    .gpsStatusMeasuringLon(gpsStatusMeasuringLon)
                    .gpsStatusMeasuringLat(gpsStatusMeasuringLat)
                    .customSeatRightFrontOccupantType(customSeatRightFrontOccupantType)
                    .customSeatRightRearOccupantType(customSeatRightRearOccupantType)
                    .customSeatLeftFrontOccupantType(customSeatLeftFrontOccupantType)
                    .customSeatLeftRearOccupantType(customSeatLeftRearOccupantType)
                    .fuelRemainingPercent(fuelRemainingPercent)
                    .customSensorRightFrontLevel(customSensorRightFrontLevel)
                    .customSensorRightRearLevel(customSensorRightRearLevel)
                    .customSensorLeftFrontLevel(customSensorLeftFrontLevel)
                    .customSensorLeftRearLevel(customSensorLeftRearLevel)
                    .timestamp(timestamp);
        }

        @Override
        public CopyOfBuilder dummy(Boolean dummy) {
            return (CopyOfBuilder) super.dummy(dummy);
        }

        @Override
        public CopyOfBuilder vehicleSpeed(Float vehicleSpeed) {
            return (CopyOfBuilder) super.vehicleSpeed(vehicleSpeed);
        }

        @Override
        public CopyOfBuilder hornStatusSound(Boolean hornStatusSound) {
            return (CopyOfBuilder) super.hornStatusSound(hornStatusSound);
        }

        @Override
        public CopyOfBuilder acBlowerMode(Integer acBlowerMode) {
            return (CopyOfBuilder) super.acBlowerMode(acBlowerMode);
        }

        @Override
        public CopyOfBuilder brakePressure(Float brakePressure) {
            return (CopyOfBuilder) super.brakePressure(brakePressure);
        }

        @Override
        public CopyOfBuilder acceleratorPedalOpening(Float acceleratorPedalOpening) {
            return (CopyOfBuilder) super.acceleratorPedalOpening(acceleratorPedalOpening);
        }

        @Override
        public CopyOfBuilder wiperFrontControlSetting(Integer wiperFrontControlSetting) {
            return (CopyOfBuilder) super.wiperFrontControlSetting(wiperFrontControlSetting);
        }

        @Override
        public CopyOfBuilder ignitionStatus(Integer ignitionStatus) {
            return (CopyOfBuilder) super.ignitionStatus(ignitionStatus);
        }

        @Override
        public CopyOfBuilder acBlowerLevel(Integer acBlowerLevel) {
            return (CopyOfBuilder) super.acBlowerLevel(acBlowerLevel);
        }

        @Override
        public CopyOfBuilder steeringWheelAngle(Float steeringWheelAngle) {
            return (CopyOfBuilder) super.steeringWheelAngle(steeringWheelAngle);
        }

        @Override
        public CopyOfBuilder airRecirculationStatusOperation(Boolean airRecirculationStatusOperation) {
            return (CopyOfBuilder) super.airRecirculationStatusOperation(airRecirculationStatusOperation);
        }

        @Override
        public CopyOfBuilder acDriverSettingTemp(Float acDriverSettingTemp) {
            return (CopyOfBuilder) super.acDriverSettingTemp(acDriverSettingTemp);
        }

        @Override
        public CopyOfBuilder insideTemp(Float insideTemp) {
            return (CopyOfBuilder) super.insideTemp(insideTemp);
        }

        @Override
        public CopyOfBuilder outsideTemp(Float outsideTemp) {
            return (CopyOfBuilder) super.outsideTemp(outsideTemp);
        }

        @Override
        public CopyOfBuilder defoggerFrontStatusOperation(Boolean defoggerFrontStatusOperation) {
            return (CopyOfBuilder) super.defoggerFrontStatusOperation(defoggerFrontStatusOperation);
        }

        @Override
        public CopyOfBuilder transmissionGearPosition(Integer transmissionGearPosition) {
            return (CopyOfBuilder) super.transmissionGearPosition(transmissionGearPosition);
        }

        @Override
        public CopyOfBuilder heaterStatusOperation(Integer heaterStatusOperation) {
            return (CopyOfBuilder) super.heaterStatusOperation(heaterStatusOperation);
        }

        @Override
        public CopyOfBuilder customAmRadioChannel(Float customAmRadioChannel) {
            return (CopyOfBuilder) super.customAmRadioChannel(customAmRadioChannel);
        }

        @Override
        public CopyOfBuilder customFmRadioChannel(Float customFmRadioChannel) {
            return (CopyOfBuilder) super.customFmRadioChannel(customFmRadioChannel);
        }

        @Override
        public CopyOfBuilder customAudioVol(Integer customAudioVol) {
            return (CopyOfBuilder) super.customAudioVol(customAudioVol);
        }

        @Override
        public CopyOfBuilder customAudioMode(Integer customAudioMode) {
            return (CopyOfBuilder) super.customAudioMode(customAudioMode);
        }

        @Override
        public CopyOfBuilder customMusicStatus(Boolean customMusicStatus) {
            return (CopyOfBuilder) super.customMusicStatus(customMusicStatus);
        }

        @Override
        public CopyOfBuilder doorRightFrontStatusOpen(Boolean doorRightFrontStatusOpen) {
            return (CopyOfBuilder) super.doorRightFrontStatusOpen(doorRightFrontStatusOpen);
        }

        @Override
        public CopyOfBuilder doorLeftFrontStatusOpen(Boolean doorLeftFrontStatusOpen) {
            return (CopyOfBuilder) super.doorLeftFrontStatusOpen(doorLeftFrontStatusOpen);
        }

        @Override
        public CopyOfBuilder doorRightRearStatusOpen(Boolean doorRightRearStatusOpen) {
            return (CopyOfBuilder) super.doorRightRearStatusOpen(doorRightRearStatusOpen);
        }

        @Override
        public CopyOfBuilder doorLeftRearStatusOpen(Boolean doorLeftRearStatusOpen) {
            return (CopyOfBuilder) super.doorLeftRearStatusOpen(doorLeftRearStatusOpen);
        }

        @Override
        public CopyOfBuilder doorTrunkStatusOpen(Boolean doorTrunkStatusOpen) {
            return (CopyOfBuilder) super.doorTrunkStatusOpen(doorTrunkStatusOpen);
        }

        @Override
        public CopyOfBuilder doorRightFrontStatusLock(Boolean doorRightFrontStatusLock) {
            return (CopyOfBuilder) super.doorRightFrontStatusLock(doorRightFrontStatusLock);
        }

        @Override
        public CopyOfBuilder doorLeftFrontStatusLock(Boolean doorLeftFrontStatusLock) {
            return (CopyOfBuilder) super.doorLeftFrontStatusLock(doorLeftFrontStatusLock);
        }

        @Override
        public CopyOfBuilder doorRightRearStatusLock(Boolean doorRightRearStatusLock) {
            return (CopyOfBuilder) super.doorRightRearStatusLock(doorRightRearStatusLock);
        }

        @Override
        public CopyOfBuilder doorLeftRearStatusLock(Boolean doorLeftRearStatusLock) {
            return (CopyOfBuilder) super.doorLeftRearStatusLock(doorLeftRearStatusLock);
        }

        @Override
        public CopyOfBuilder doorTrunkStatusLock(Boolean doorTrunkStatusLock) {
            return (CopyOfBuilder) super.doorTrunkStatusLock(doorTrunkStatusLock);
        }

        @Override
        public CopyOfBuilder hazardLampOperationState(Boolean hazardLampOperationState) {
            return (CopyOfBuilder) super.hazardLampOperationState(hazardLampOperationState);
        }

        @Override
        public CopyOfBuilder lightHighBeamStatusLighting(Boolean lightHighBeamStatusLighting) {
            return (CopyOfBuilder) super.lightHighBeamStatusLighting(lightHighBeamStatusLighting);
        }

        @Override
        public CopyOfBuilder lightHeadStatusLighting(Integer lightHeadStatusLighting) {
            return (CopyOfBuilder) super.lightHeadStatusLighting(lightHeadStatusLighting);
        }

        @Override
        public CopyOfBuilder turnSignalStatusOperation(Integer turnSignalStatusOperation) {
            return (CopyOfBuilder) super.turnSignalStatusOperation(turnSignalStatusOperation);
        }

        @Override
        public CopyOfBuilder lampBreakStatusLighting(Integer lampBreakStatusLighting) {
            return (CopyOfBuilder) super.lampBreakStatusLighting(lampBreakStatusLighting);
        }

        @Override
        public CopyOfBuilder naviDestMeasuringLat(Float naviDestMeasuringLat) {
            return (CopyOfBuilder) super.naviDestMeasuringLat(naviDestMeasuringLat);
        }

        @Override
        public CopyOfBuilder naviDestMeasuringLon(Float naviDestMeasuringLon) {
            return (CopyOfBuilder) super.naviDestMeasuringLon(naviDestMeasuringLon);
        }

        @Override
        public CopyOfBuilder gpsStatusMeasuringLon(Float gpsStatusMeasuringLon) {
            return (CopyOfBuilder) super.gpsStatusMeasuringLon(gpsStatusMeasuringLon);
        }

        @Override
        public CopyOfBuilder gpsStatusMeasuringLat(Float gpsStatusMeasuringLat) {
            return (CopyOfBuilder) super.gpsStatusMeasuringLat(gpsStatusMeasuringLat);
        }

        @Override
        public CopyOfBuilder customSeatRightFrontOccupantType(Boolean customSeatRightFrontOccupantType) {
            return (CopyOfBuilder) super.customSeatRightFrontOccupantType(customSeatRightFrontOccupantType);
        }

        @Override
        public CopyOfBuilder customSeatRightRearOccupantType(Boolean customSeatRightRearOccupantType) {
            return (CopyOfBuilder) super.customSeatRightRearOccupantType(customSeatRightRearOccupantType);
        }

        @Override
        public CopyOfBuilder customSeatLeftFrontOccupantType(Boolean customSeatLeftFrontOccupantType) {
            return (CopyOfBuilder) super.customSeatLeftFrontOccupantType(customSeatLeftFrontOccupantType);
        }

        @Override
        public CopyOfBuilder customSeatLeftRearOccupantType(Boolean customSeatLeftRearOccupantType) {
            return (CopyOfBuilder) super.customSeatLeftRearOccupantType(customSeatLeftRearOccupantType);
        }

        @Override
        public CopyOfBuilder fuelRemainingPercent(Integer fuelRemainingPercent) {
            return (CopyOfBuilder) super.fuelRemainingPercent(fuelRemainingPercent);
        }

        @Override
        public CopyOfBuilder customSensorRightFrontLevel(Integer customSensorRightFrontLevel) {
            return (CopyOfBuilder) super.customSensorRightFrontLevel(customSensorRightFrontLevel);
        }

        @Override
        public CopyOfBuilder customSensorRightRearLevel(Integer customSensorRightRearLevel) {
            return (CopyOfBuilder) super.customSensorRightRearLevel(customSensorRightRearLevel);
        }

        @Override
        public CopyOfBuilder customSensorLeftFrontLevel(Integer customSensorLeftFrontLevel) {
            return (CopyOfBuilder) super.customSensorLeftFrontLevel(customSensorLeftFrontLevel);
        }

        @Override
        public CopyOfBuilder customSensorLeftRearLevel(Integer customSensorLeftRearLevel) {
            return (CopyOfBuilder) super.customSensorLeftRearLevel(customSensorLeftRearLevel);
        }

        @Override
        public CopyOfBuilder timestamp(String timestamp) {
            return (CopyOfBuilder) super.timestamp(timestamp);
        }
    }

}
