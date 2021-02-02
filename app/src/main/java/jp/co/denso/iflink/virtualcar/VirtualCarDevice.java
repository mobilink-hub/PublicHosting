package jp.co.denso.iflink.virtualcar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.datastore.generated.model.Vehicle;


import jp.co.toshiba.iflink.epaapi.EPAdata;

import jp.co.toshiba.iflink.imsif.IfLinkConnector;
import jp.co.toshiba.iflink.imsif.DeviceConnector;
import jp.co.toshiba.iflink.imsif.IfLinkSettings;
import jp.co.toshiba.iflink.imsif.IfLinkAlertException;
import jp.co.toshiba.iflink.ui.PermissionActivity;

public class VirtualCarDevice extends DeviceConnector {
    /**
     * ログ出力用タグ名.
     */

    private static final String TAG = "VIRTUALCAR-DEV";
    /**
     * メッセージを取得するキー.
     */
    /**
     * ログ出力切替フラグ.
     */
    private boolean bDBG = true;
    //Toast Sample start
    /**
     * 処理実行のハンドラ.
     */
    private Handler handler = new Handler(Looper.getMainLooper());
    //Toast Sample end
    //If Sample start
    /**
     * 設定パラメータ.
     */
    /**
     * データ送信用タイマー.
     */
    private Vehicle oldVehicle;
    private String username,password,vehicleId;
    // <param-name,graphqlのデータ型>
    private Map<String,String> ifTaskList = new HashMap<String,String>()
    {
        {
            put("vehicleSpeed", "float");
            put("hornStatusSound", "int");
            put("acBlowerMode", "int");
            put("brakePressure", "float");
            put("acceleratorPedalOpening", "float");
            put("wiperFrontControlSetting", "int");
            put("ignitionStatus", "int");
            put("acBlowerLevel", "int");
            put("steeringWheelAngle", "float");
            put("airRecirculationStatusOperation", "int");
            put("acDriverSettingTemp", "float");
            put("insideTemp", "float");
            put("outsideTemp", "float");
            put("defoggerFrontStatusOperation", "int");
            put("transmissionGearPosition", "int");
            put("heaterStatusOperation", "int");
            put("customAmRadioChannel", "float");
            put("customFmRadioChannel", "float");
            put("customAudioVol", "int");
            put("customAudioMode", "int");
            put("customMusicStatus", "int");
            put("doorRightFrontStatusOpen", "int");
            put("doorLeftFrontStatusOpen", "int");
            put("doorRightRearStatusOpen", "int");
            put("doorLeftRearStatusOpen", "int");
            put("doorTrunkStatusOpen", "int");
            put("doorRightFrontStatusLock", "int");
            put("doorLeftFrontStatusLock", "int");
            put("doorRightRearStatusLock", "int");
            put("doorLeftRearStatusLock", "int");
            put("doorTrunkStatusLock", "int");
            put("hazardLampOperationState", "int");
            put("lightHighBeamStatusLighting", "int");
            put("lightHeadStatusLighting", "int");
            put("turnSignalStatusOperation", "int");
            put("lampBreakStatusLighting", "int");
            put("naviDestMeasuringLat", "float");
            put("naviDestMeasuringLon", "float");
            put("gpsStatusMeasuringLon", "float");
            put("gpsStatusMeasuringLat", "float");
            put("customSensorRightFrontLevel", "int");
            put("customSensorRightRearLevel", "int");
            put("customSensorLeftFrontLevel", "int");
            put("customSensorLeftRearLevel", "int");
            put("geofence","int");
        }
    };
    // <param-name,iflinkのデータ型>
    private Map<String,String> thenTaskList = new HashMap<String, String>(){
        {
            put("vehicleSpeed", "float");
            put("hornStatusSound", "int");
            put("acBlowerMode", "int");
            put("brakePressure", "float");
            put("acceleratorPedalOpening", "float");
            put("wiperFrontControlSetting", "int");
            put("ignitionStatus", "int");
            put("acBlowerLevel", "int");
            put("steeringWheelAngle", "float");
            put("airRecirculationStatusOperation", "int");
            put("acDriverSettingTemp", "float");
            put("insideTemp", "float");
            put("outsideTemp", "float");
            put("defoggerFrontStatusOperation", "int");
            put("transmissionGearPosition", "int");
            put("heaterStatusOperation", "int");
            put("customAmRadioChannel", "float");
            put("customFmRadioChannel", "float");
            put("customAudioVol", "int");
            put("customAudioMode", "int");
            put("customMusicStatus", "int");
            put("doorRightFrontStatusOpen", "int");
            put("doorLeftFrontStatusOpen", "int");
            put("doorRightRearStatusOpen", "int");
            put("doorLeftRearStatusOpen", "int");
            put("doorTrunkStatusOpen", "int");
            put("doorRightFrontStatusLock", "int");
            put("doorLeftFrontStatusLock", "int");
            put("doorRightRearStatusLock", "int");
            put("doorLeftRearStatusLock", "int");
            put("doorTrunkStatusLock", "int");
            put("hazardLampOperationState", "int");
            put("lightHighBeamStatusLighting", "int");
            put("lightHeadStatusLighting", "int");
            put("turnSignalStatusOperation", "int");
            put("lampBreakStatusLighting", "int");
            put("naviDestMeasuringLat", "float");
            put("naviDestMeasuringLon", "float");
            put("gpsStatusMeasuringLon", "float");
            put("gpsStatusMeasuringLat", "float");
            put("customSensorRightFrontLevel", "int");
            put("customSensorRightRearLevel", "int");
            put("customSensorLeftFrontLevel", "int");
            put("customSensorLeftRearLevel", "int");
            put("geofence", "int");
            put("doorStatusOpen","");
            put("doorStatusLock","");
        }
    };
    private ApiOperation subscribe;
    private boolean isAmplifyReady = false;
    /**
     * コンストラクタ.
     *
     * @param ims IMS
     */

    public VirtualCarDevice(final IfLinkConnector ims) {
        super(ims, MONITORING_LEVEL1, PermissionActivity.class);
        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            // 開発用のデバッグウィンドウを非表示
            AmplifyConfiguration config = AmplifyConfiguration.builder(mIms.getApplicationContext()).devMenuEnabled(false).build();
            Amplify.configure(config, mIms.getApplicationContext());
            Log.d(TAG, "Initialized Amplify");
            isAmplifyReady = true;
        } catch (AmplifyException failure) {
            Log.e(TAG, "Could not initialize Amplify", failure);
        }
        mDeviceName = "virtualcarDevice";
        mDeviceSerial = "epa";
        mSchemaName = "virtualcardevice";
        setSchema();
        mCookie = IfLinkConnector.EPA_COOKIE_KEY_TYPE + "=" + IfLinkConnector.EPA_COOKIE_VALUE_CONFIG
                + IfLinkConnector.COOKIE_DELIMITER
                + IfLinkConnector.EPA_COOKIE_KEY_TYPE + "=" + IfLinkConnector.EPA_COOKIE_VALUE_ALERT
                + IfLinkConnector.COOKIE_DELIMITER
                + IfLinkConnector.EPA_COOKIE_KEY_TYPE + "=" + IfLinkConnector.EPA_COOKIE_TYPE_VALUE_JOB
                + IfLinkConnector.COOKIE_DELIMITER
                + IfLinkConnector.EPA_COOKIE_KEY_DEVICE + "=" + mDeviceName
                + IfLinkConnector.COOKIE_DELIMITER
                + IfLinkConnector.EPA_COOKIE_KEY_ADDRESS + "=" + IfLinkConnector.EPA_COOKIE_VALUE_ANY;

        mAssetName = "VIRTUALCARDEVICE_EPA";

        // サンプル用：ここでデバイスを登録します。
        // 基本は、デバイスとの接続確立後、デバイスの対応したシリアル番号に更新してからデバイスを登録してください。
        // onUpdateConfigが呼ばれる
        addDevice();
        // 基本は、デバイスとの接続が確立した時点で呼び出します。
        notifyConnectDevice();
    }

    private void taskSubscribe(){
        Log.d(TAG,"taskUpdateSubscribe");
        Amplify.API.query(ModelQuery.get(Vehicle.class,username+":"+vehicleId),
                response->{
                    oldVehicle = response.getData().copyOfBuilder().build();
                },
                error->{}
                );
                subscribe = Amplify.API.subscribe(
                ModelSubscription.onUpdate(Vehicle.class),
                onEstablished -> {
                    Log.d(TAG, "onEstablished:" + onEstablished.toString());
                    showToast("Connection Established");
                },
                onUpdated -> onVehicleUpdated(onUpdated.getData()),
                onFailure -> {
                    Log.d(TAG, "onFailure");
                    showToast("Failed to subscribe");
                },
                () -> Log.d(TAG, "subscription is completed")
        );

    }
    public void onVehicleUpdated(Vehicle vehicle){
        Log.d(TAG,"onVehicleUpdated");
        if(oldVehicle == null){
            oldVehicle = vehicle.copyOfBuilder().build();
            return;
        }
        setupPushData();

        // 設定した車両ID以外はreturn
        if(!vehicle.getId().equals(username+":"+vehicleId)){return;}
        else{showToast(username+":"+vehicleId + "is updated");}
        for(String param: ifTaskList.keySet()){
            switch(param) {
                case "vehicleSpeed":
                    if(oldVehicle == null || !oldVehicle.getVehicleSpeed().equals(vehicle.getVehicleSpeed())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getVehicleSpeed()));
                    }else{
                        break;
                    }
                    break;
                case "hornStatusSound":
                    if(oldVehicle == null || !oldVehicle.getHornStatusSound().equals(vehicle.getHornStatusSound())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getHornStatusSound()));
                    }else{
                        break;
                    }
                    break;
                case "acBlowerMode":
                    if(oldVehicle == null || !oldVehicle.getAcBlowerMode().equals(vehicle.getAcBlowerMode())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getAcBlowerMode()));
                    }else{
                        break;
                    }
                    break;
                case "brakePressure":
                    if(oldVehicle == null || !oldVehicle.getBrakePressure().equals(vehicle.getBrakePressure())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getBrakePressure()));
                    }else{
                        break;
                    }
                    break;
                case "acceleratorPedalOpening":
                    if(oldVehicle == null || !oldVehicle.getAcceleratorPedalOpening().equals(vehicle.getAcceleratorPedalOpening())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getAcceleratorPedalOpening()));
                    }else{
                        break;
                    }
                    break;
                case "wiperFrontControlSetting":
                    if(oldVehicle == null || !oldVehicle.getWiperFrontControlSetting().equals(vehicle.getWiperFrontControlSetting())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getWiperFrontControlSetting()));
                    }else{
                        break;
                    }
                    break;
                case "ignitionStatus":
                    if(oldVehicle == null || !oldVehicle.getIgnitionStatus().equals(vehicle.getIgnitionStatus())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getIgnitionStatus()));
                    }else{
                        break;
                    }
                    break;
                case "acBlowerLevel":
                    if(oldVehicle == null || !oldVehicle.getAcBlowerLevel().equals(vehicle.getAcBlowerLevel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getAcBlowerLevel()));
                    }else{
                        break;
                    }
                    break;
                case "steeringWheelAngle":
                    if(oldVehicle == null || !oldVehicle.getSteeringWheelAngle().equals(vehicle.getSteeringWheelAngle())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getSteeringWheelAngle()));
                    }else{
                        break;
                    }
                    break;
                case "airRecirculationStatusOperation":
                    if(oldVehicle == null || !oldVehicle.getAirRecirculationStatusOperation().equals(vehicle.getAirRecirculationStatusOperation())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getAirRecirculationStatusOperation()));
                    }else{
                        break;
                    }
                    break;
                case "acDriverSettingTemp":
                    if(oldVehicle == null || !oldVehicle.getAcDriverSettingTemp().equals(vehicle.getAcDriverSettingTemp())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getAcDriverSettingTemp()));
                    }else{
                        break;
                    }
                    break;
                case "insideTemp":
                    if(oldVehicle == null || !oldVehicle.getInsideTemp().equals(vehicle.getInsideTemp())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getInsideTemp()));
                    }else{
                        break;
                    }
                    break;
                case "outsideTemp":
                    if(oldVehicle == null || !oldVehicle.getOutsideTemp().equals(vehicle.getOutsideTemp())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getOutsideTemp()));
                    }else{
                        break;
                    }
                    break;
                case "defoggerFrontStatusOperation":
                    if(oldVehicle == null || !oldVehicle.getDefoggerFrontStatusOperation().equals(vehicle.getDefoggerFrontStatusOperation())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDefoggerFrontStatusOperation()));
                    }else{
                        break;
                    }
                    break;
                case "transmissionGearPosition":
                    if(oldVehicle == null || !oldVehicle.getTransmissionGearPosition().equals(vehicle.getTransmissionGearPosition())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getTransmissionGearPosition()));
                    }else{
                        break;
                    }
                    break;
                case "heaterStatusOperation":
                    if(oldVehicle == null || !oldVehicle.getHeaterStatusOperation().equals(vehicle.getHeaterStatusOperation())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getHeaterStatusOperation()));
                    }else{
                        break;
                    }
                    break;
                case "customAmRadioChannel":
                    if(oldVehicle == null || !oldVehicle.getCustomAmRadioChannel().equals(vehicle.getCustomAmRadioChannel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomAmRadioChannel()));
                    }else{
                        break;
                    }
                    break;
                case "customFmRadioChannel":
                    if(oldVehicle == null || !oldVehicle.getCustomFmRadioChannel().equals(vehicle.getCustomFmRadioChannel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomFmRadioChannel()));
                    }else{
                        break;
                    }
                    break;
                case "customAudioVol":
                    if(oldVehicle == null || !oldVehicle.getCustomAudioVol().equals(vehicle.getCustomAudioVol())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomAudioVol()));
                    }else{
                        break;
                    }
                    break;
                case "customAudioMode":
                    if(oldVehicle == null || !oldVehicle.getCustomAudioMode().equals(vehicle.getCustomAudioMode())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomAudioMode()));
                    }else{
                        break;
                    }
                    break;
                case "customMusicStatus":
                    if(oldVehicle == null || !oldVehicle.getCustomMusicStatus().equals(vehicle.getCustomMusicStatus())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomMusicStatus()));
                    }else{
                        break;
                    }
                    break;
                case "doorRightFrontStatusOpen":
                    if(oldVehicle == null || !oldVehicle.getDoorRightFrontStatusOpen().equals(vehicle.getDoorRightFrontStatusOpen())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorRightFrontStatusOpen()));
                    }else{
                        break;
                    }
                    break;
                case "doorLeftFrontStatusOpen":
                    if(oldVehicle == null || !oldVehicle.getDoorLeftFrontStatusOpen().equals(vehicle.getDoorLeftFrontStatusOpen())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorLeftFrontStatusOpen()));
                    }else{
                        break;
                    }
                    break;
                case "doorRightRearStatusOpen":
                    if(oldVehicle == null || !oldVehicle.getDoorRightRearStatusOpen().equals(vehicle.getDoorRightRearStatusOpen())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorRightRearStatusOpen()));
                    }else{
                        break;
                    }
                    break;
                case "doorLeftRearStatusOpen":
                    if(oldVehicle == null || !oldVehicle.getDoorLeftRearStatusOpen().equals(vehicle.getDoorLeftRearStatusOpen())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorLeftRearStatusOpen()));
                    }else{
                        break;
                    }
                    break;
                case "doorTrunkStatusOpen":
                    if(oldVehicle == null || !oldVehicle.getDoorTrunkStatusOpen().equals(vehicle.getDoorTrunkStatusOpen())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorTrunkStatusOpen()));
                    }else{
                        break;
                    }
                    break;
                case "doorRightFrontStatusLock":
                    if(oldVehicle == null || !oldVehicle.getDoorRightFrontStatusLock().equals(vehicle.getDoorRightFrontStatusLock())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorRightFrontStatusLock()));
                    }else{
                        break;
                    }
                    break;
                case "doorLeftFrontStatusLock":
                    if(oldVehicle == null || !oldVehicle.getDoorLeftFrontStatusLock().equals(vehicle.getDoorLeftFrontStatusLock())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorLeftFrontStatusLock()));
                    }else{
                        break;
                    }
                    break;
                case "doorRightRearStatusLock":
                    if(oldVehicle == null || !oldVehicle.getDoorRightRearStatusLock().equals(vehicle.getDoorRightRearStatusLock())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorRightRearStatusLock()));
                    }else{
                        break;
                    }
                    break;
                case "doorLeftRearStatusLock":
                    if(oldVehicle == null || !oldVehicle.getDoorLeftRearStatusLock().equals(vehicle.getDoorLeftRearStatusLock())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorLeftRearStatusLock()));
                    }else{
                        break;
                    }
                    break;
                case "doorTrunkStatusLock":
                    if(oldVehicle == null || !oldVehicle.getDoorTrunkStatusLock().equals(vehicle.getDoorTrunkStatusLock())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getDoorTrunkStatusLock()));
                    }else{
                        break;
                    }
                    break;
                case "hazardLampOperationState":
                    if(oldVehicle == null || !oldVehicle.getHazardLampOperationState().equals(vehicle.getHazardLampOperationState())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getHazardLampOperationState()));
                    }else{
                        break;
                    }
                    break;
                case "lightHighBeamStatusLighting":
                    if(oldVehicle == null || !oldVehicle.getLightHighBeamStatusLighting().equals(vehicle.getLightHighBeamStatusLighting())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getLightHighBeamStatusLighting()));
                    }else{
                        break;
                    }
                    break;
                case "lightHeadStatusLighting":
                    if(oldVehicle == null || !oldVehicle.getLightHeadStatusLighting().equals(vehicle.getLightHeadStatusLighting())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getLightHeadStatusLighting()));
                    }else{
                        break;
                    }
                    break;
                case "turnSignalStatusOperation":
                    if(oldVehicle == null || !oldVehicle.getTurnSignalStatusOperation().equals(vehicle.getTurnSignalStatusOperation())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getTurnSignalStatusOperation()));
                    }else{
                        break;
                    }
                    break;
                case "lampBreakStatusLighting":
                    if(oldVehicle == null || !oldVehicle.getLampBreakStatusLighting().equals(vehicle.getLampBreakStatusLighting())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getLampBreakStatusLighting()));
                    }else{
                        break;
                    }
                    break;
                case "naviDestMeasuringLat":
                    if(oldVehicle == null || !oldVehicle.getNaviDestMeasuringLat().equals(vehicle.getNaviDestMeasuringLat())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getNaviDestMeasuringLat()));
                    }else{
                        break;
                    }
                    break;
                case "naviDestMeasuringLon":
                    if(oldVehicle == null || !oldVehicle.getNaviDestMeasuringLon().equals(vehicle.getNaviDestMeasuringLon())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getNaviDestMeasuringLon()));
                    }else{
                        break;
                    }
                    break;
                case "gpsStatusMeasuringLon":
                    if(oldVehicle == null || !oldVehicle.getGpsStatusMeasuringLon().equals(vehicle.getGpsStatusMeasuringLon())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getGpsStatusMeasuringLon()));
                    }else{
                        break;
                    }
                    break;
                case "gpsStatusMeasuringLat":
                    if(oldVehicle == null || !oldVehicle.getGpsStatusMeasuringLat().equals(vehicle.getGpsStatusMeasuringLat())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getGpsStatusMeasuringLat()));
                    }else{
                        break;
                    }
                    break;
                case "customSeatRightFrontOccupantType":
                    if(oldVehicle == null || !oldVehicle.getCustomSeatRightFrontOccupantType().equals(vehicle.getCustomSeatRightFrontOccupantType())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSeatRightFrontOccupantType()));
                    }else{
                        break;
                    }
                    break;
                case "customSeatRightRearOccupantType":
                    if(oldVehicle == null || !oldVehicle.getCustomSeatRightRearOccupantType().equals(vehicle.getCustomSeatRightRearOccupantType())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSeatRightRearOccupantType()));
                    }else{
                        break;
                    }
                    break;
                case "customSeatLeftFrontOccupantType":
                    if(oldVehicle == null || !oldVehicle.getCustomSeatLeftFrontOccupantType().equals(vehicle.getCustomSeatLeftFrontOccupantType())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSeatLeftFrontOccupantType()));
                    }else{
                        break;
                    }
                    break;
                case "customSeatLeftRearOccupantType":
                    if(oldVehicle == null || !oldVehicle.getCustomSeatLeftRearOccupantType().equals(vehicle.getCustomSeatLeftRearOccupantType())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSeatLeftRearOccupantType()));
                    }else{
                        break;
                    }
                    break;
                case "fuelRemainingPercent":
                    if(oldVehicle == null || !oldVehicle.getFuelRemainingPercent().equals(vehicle.getFuelRemainingPercent())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getFuelRemainingPercent()));
                    }else{
                        break;
                    }
                    break;
                case "customSensorRightFrontLevel":
                    if(oldVehicle == null || !oldVehicle.getCustomSensorRightFrontLevel().equals(vehicle.getCustomSensorRightFrontLevel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSensorRightFrontLevel()));
                    }else{
                        break;
                    }
                    break;
                case "customSensorRightRearLevel":
                    if(oldVehicle == null || !oldVehicle.getCustomSensorRightRearLevel().equals(vehicle.getCustomSensorRightRearLevel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSensorRightRearLevel()));
                    }else{
                        break;
                    }
                    break;
                case "customSensorLeftFrontLevel":
                    if(oldVehicle == null || !oldVehicle.getCustomSensorLeftFrontLevel().equals(vehicle.getCustomSensorLeftFrontLevel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSensorLeftFrontLevel()));
                    }else{
                        break;
                    }
                    break;
                case "customSensorLeftRearLevel":
                    if(oldVehicle == null || !oldVehicle.getCustomSensorLeftRearLevel().equals(vehicle.getCustomSensorLeftRearLevel())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getCustomSensorLeftRearLevel()));
                    }else{
                        break;
                    }
                    break;
                case "timestamp":
                    if(oldVehicle == null || !oldVehicle.getTimestamp().equals(vehicle.getTimestamp())){
                        queueData(ifTaskList.get(param),param,String.valueOf(vehicle.getTimestamp()));
                    }
                    break;
                case "geofence":
                    if(oldVehicle == null || !oldVehicle.getGpsStatusMeasuringLat().equals(vehicle.getGpsStatusMeasuringLat())||!oldVehicle.getGpsStatusMeasuringLon().equals(vehicle.getGpsStatusMeasuringLon())||!oldVehicle.getNaviDestMeasuringLat().equals(vehicle.getNaviDestMeasuringLat())||!oldVehicle.getNaviDestMeasuringLon().equals(vehicle.getNaviDestMeasuringLon())) {
                        float[] distance = new float[3];
                        Location.distanceBetween(vehicle.getGpsStatusMeasuringLat().doubleValue(), vehicle.getGpsStatusMeasuringLon().doubleValue(), vehicle.getNaviDestMeasuringLat().doubleValue(), vehicle.getNaviDestMeasuringLon().doubleValue(), distance);
                        queueData(ifTaskList.get("geofence"), param, String.valueOf(((int) distance[0])));
                    }
                    break;
                default:
                    showToast("unknown param");
                    break;
            }
        }
        pushData();
        oldVehicle = vehicle.copyOfBuilder().build();
    }
    @Override
    public boolean onStartDevice() {
        Log.d(TAG, "onStartDevice");

        return true;
    }


    //If Sample end
    @Override
    public boolean onStopDevice() {
        Log.d(TAG, "onStopDevice");
        if(subscribe != null)subscribe.cancel();
        // デバイスからのデータ送信停止処理を記述してください。

        // 送信停止が別途完了通知を受ける場合には、falseを返してください。
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onJob(final HashMap<String, Object> map) {
        Log.d(TAG,"onJob");
        List<String>updateTarget = new ArrayList<String>();
        for(String param: thenTaskList.keySet()){
            if(map.containsKey(param)){
                // flagあり && flag = 0(なにもしない)
                if(map.containsKey(param+".flag") && map.get(param+".flag").toString().equals("0")){
                    Log.d(TAG,"skip:"+param);
                }
                //
                else{
                    updateTarget.add(param);
                }
            }
        }
        Amplify.API.query(ModelQuery.get(Vehicle.class,username+":"+vehicleId),
                response -> {
                    Log.i(TAG, ((Vehicle) response.getData()).toString());
                    Vehicle.BuildStep step = response.getData().copyOfBuilder().id(username+":"+vehicleId);
                    for(String param:updateTarget){
                        try {
                            switch (param) {
                                case "dummy":
                                    step.dummy(true);
                                    break;

                                case "vehicleSpeed":
                                    step.vehicleSpeed(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "hornStatusSound":
                                    step.hornStatusSound(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "acBlowerMode":
                                    step.acBlowerMode(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "brakePressure":
                                    step.brakePressure(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "acceleratorPedalOpening":
                                    step.acceleratorPedalOpening(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "wiperFrontControlSetting":
                                    step.wiperFrontControlSetting(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "ignitionStatus":
                                    step.ignitionStatus(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "acBlowerLevel":
                                    step.acBlowerLevel(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "steeringWheelAngle":
                                    step.steeringWheelAngle(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "airRecirculationStatusOperation":
                                    step.airRecirculationStatusOperation(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "acDriverSettingTemp":
                                    step.acDriverSettingTemp(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "insideTemp":
                                    step.insideTemp(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "outsideTemp":
                                    step.outsideTemp(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "defoggerFrontStatusOperation":
                                    step.defoggerFrontStatusOperation(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "transmissionGearPosition":
                                    step.transmissionGearPosition(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "heaterStatusOperation":
                                    step.heaterStatusOperation(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customAmRadioChannel":
                                    step.customAmRadioChannel(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "customFmRadioChannel":
                                    step.customFmRadioChannel(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "customAudioVol":
                                    step.customAudioVol(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customAudioMode":
                                    step.customAudioMode(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customMusicStatus":
                                    step.customMusicStatus(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "doorStatusOpen":
                                    String[] doorStatusOpenTargets = map.get("doorStatusOpen.target").toString().split(",",0);
                                    for(String target:doorStatusOpenTargets){
                                        switch (target){
                                            case "rightFront":
                                                step.doorRightFrontStatusOpen(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "leftFront":
                                                step.doorLeftFrontStatusOpen(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "rightRear":
                                                step.doorRightRearStatusOpen(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "leftRear":
                                                step.doorLeftRearStatusOpen(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "trunk":
                                                step.doorTrunkStatusOpen(map.get(param).toString() == "0" ? false : true);
                                        }
                                    }
                                    break;

                                case "doorStatusLock":
                                    String[] doorStatusLockTargets = map.get("doorStatusLock.target").toString().split(",",0);
                                    for(String target:doorStatusLockTargets){
                                        switch (target){
                                            case "rightFront":
                                                step.doorRightFrontStatusLock(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "leftFront":
                                                step.doorLeftFrontStatusLock(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "rightRear":
                                                step.doorRightRearStatusLock(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "leftRear":
                                                step.doorLeftRearStatusLock(map.get(param).toString() == "0" ? false : true);
                                                break;
                                            case "trunk":
                                                step.doorTrunkStatusLock(map.get(param).toString() == "0" ? false : true);
                                        }
                                    }
                                    break;

                                case "doorRightFrontStatusLock":
                                    step.doorRightFrontStatusLock(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "doorLeftFrontStatusLock":
                                    step.doorLeftFrontStatusLock(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "doorRightRearStatusLock":
                                    step.doorRightRearStatusLock(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "doorLeftRearStatusLock":
                                    step.doorLeftRearStatusLock(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "doorTrunkStatusLock":
                                    step.doorTrunkStatusLock(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "hazardLampOperationState":
                                    step.hazardLampOperationState(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "lightHighBeamStatusLighting":
                                    step.lightHighBeamStatusLighting(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "lightHeadStatusLighting":
                                    step.lightHeadStatusLighting(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "turnSignalStatusOperation":
                                    step.turnSignalStatusOperation(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "lampBreakStatusLighting":
                                    step.lampBreakStatusLighting(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "naviDestMeasuringLat":
                                    step.naviDestMeasuringLat(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "naviDestMeasuringLon":
                                    step.naviDestMeasuringLon(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "gpsStatusMeasuringLon":
                                    step.gpsStatusMeasuringLon(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "gpsStatusMeasuringLat":
                                    step.gpsStatusMeasuringLat(Float.parseFloat(map.get(param).toString()));
                                    break;

                                case "customSeatRightFrontOccupantType":
                                    step.customSeatRightFrontOccupantType(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "customSeatRightRearOccupantType":
                                    step.customSeatRightRearOccupantType(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "customSeatLeftFrontOccupantType":
                                    step.customSeatLeftFrontOccupantType(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "customSeatLeftRearOccupantType":
                                    step.customSeatLeftRearOccupantType(map.get(param).toString() == "0" ? false : true);
                                    break;

                                case "fuelRemainingPercent":
                                    step.fuelRemainingPercent(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customSensorRightFrontLevel":
                                    step.customSensorRightFrontLevel(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customSensorRightRearLevel":
                                    step.customSensorRightRearLevel(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customSensorLeftFrontLevel":
                                    step.customSensorLeftFrontLevel(Integer.parseInt(map.get(param).toString()));
                                    break;

                                case "customSensorLeftRearLevel":
                                    step.customSensorLeftRearLevel(Integer.parseInt(map.get(param).toString()));
                                    break;

                                default:
                                    showToast("unknown Buildstep");
                            }
                        }catch (NumberFormatException e){
                            showToast("Formatting Exception:"+ param);
                        }
                    }
                    Vehicle v = step.build();
                    Amplify.API.mutate(
                            ModelMutation.update(v),
                            res -> {
                                Log.d(TAG, "Updated: " + res.getData().toString());
                            },
                            err -> Log.d(TAG, "Update failed:", err)
                    );
                },
                error -> Log.e("MyAmplifyApp", error.toString(), error)
        );




        return false;
    }

    //If Sample start

    /**
     * 「virtualcar」データを送信する.
     * ※サンプルとして実装したメソッドです.
     * このメソッドをデバイスからデータを受信したタイミング等で呼び出せば.
     * ifLink Core側にデータが送信されます.
     *
     * @param data 送信するデータ.
     */
    public void sendData(final String data, final String dataname,final String datatype) {
        // 送信データクリア
        clearData();
        // データの登録.
        addData(new EPAdata(dataname, datatype, String.valueOf(data)));
        // ifLink Coreへデータを送信する.
        notifyRecvData();
    }
    public void pushData(){
        Log.d(TAG,"pushData");
        notifyRecvData();
    }
    public void setupPushData(){
        // 送信データクリア
        clearData();
    }
    public void queueData(String datatype,String dataname,String data){
        String type;
        String val;
        // Graphqlで扱うデータ型をIflinkで扱うデータ型に変換
        if(datatype.equals("int") ||datatype.equals("float")){
            type = datatype;
            if(data == "true" || data == "false"){
                val = data == "false" ? "0" : "1";
            }else {
                val = data;
            }
        }else {
            showToast("unknown graqlqlParams type");
            return;
        }
        Log.d(TAG,"queueData:"+dataname+":"+String.valueOf(val)+":"+type);
        addData(new EPAdata(dataname,type,String.valueOf(val)));
    }


    @Override
    public void enableLogLocal(final boolean enabled) {
        bDBG = enabled;
    }

    @Nullable
    @Override
    protected XmlResourceParser getResourceParser(final Context context) {
        Resources resources = context.getResources();
        if (resources != null) {
            return context.getResources().getXml(R.xml.schema_virtualcardevice);
        } else {
            return null;
        }

    }
    private void login(String username,String password){
        Log.d(TAG,"login with '"+ username+"':'"+vehicleId+"'");
            Amplify.Auth.signIn(
                    username,
                    password,
                    result -> {
                        String text = result.isSignInComplete() ? "Sign in succeeded with '" + username + "'" : "Sign in not complete with '" + username + "'";
                        Log.i(TAG, text);
                        showToast(text);
                        if (subscribe != null) subscribe.cancel();
                        taskSubscribe();
                    },
                    error -> {
                        Log.i(TAG, error.toString());
                        Context ctx = mIms.getApplicationContext();
                        showToast("Sign in failed with '" + username + "'" + " on "+vehicleId);
                    }
            );
        }
    @Override
    protected void onUpdateConfig(@NonNull IfLinkSettings settings) throws IfLinkAlertException {
        Log.d(TAG, "onUpdateConfig"+isAmplifyReady);
        showToast("onUpdateConfig");
        // 設定パラメータを更新する処理を記述してください。
        String usernameKey = mIms.getString(R.string.pref_virtualcardevice_settings_username_key);
        String passwordKey = mIms.getString(R.string.pref_virtualcardevice_settings_password_key);
        String vehicleIdKey = mIms.getString(R.string.pref_virtualcardevice_settings_vehicle_id_key);
        username = settings.getStringValue(usernameKey, "");
        password = settings.getStringValue(passwordKey, "");
        vehicleId = settings.getStringValue(vehicleIdKey,"");
        if(isAmplifyReady){
            if(username == "" || password == "" || vehicleId == ""){
                showToast("config profile at 環境設定 > VirtualCar IMS 設定メニュー");
            }
            else login(username,password);
        }
    }

    @Override
    protected final String[] getPermissions() {
        Log.d(TAG, "getPermissions");
        return new String[]{};
    }

    @Override
    protected void onPermissionGranted() {
        // パーミッションを許可された後の処理を記述してください。
    }


    @Override
    public final boolean checkPathConnection() {
        Log.d(TAG, "checkPathConnection");
        // デバイスとの接続経路(WiFi, BLE, and so on・・・)が有効かをチェックする処理を記述してください。
        // insert check routine for custom connection path
        return true;
    }

    @Override
    public final boolean reconnectPath() {
        Log.d(TAG, "reconnectPath");
        // デバイスとの接続経路(WiFi, BLE, and so on・・・)を有効にする処理を記述してください。
        return true;
    }

    @Override
    public final boolean checkDeviceConnection() {
        Log.d(TAG, "checkDeviceConnection");
        // デバイスとの接続が維持されているかをチェックする処理を記述してください。
        return true;
    }

    @Override
    public final boolean reconnectDevice() {
        Log.d(TAG, "reconnectDevice");
        // デバイスとの再接続処理を記述してください。
        return true;
    }

    @Override
    public final boolean checkDeviceAlive() {
        Log.d(TAG, "checkDeviceAlive");
        // デバイスから定期的にデータ受信が出来ているかをチェックする処理を記述してください。
        return true;
    }

    @Override
    public final boolean resendDevice() {
        Log.d(TAG, "resendDevice");
        // デバイスからのデータ受信を復旧する処理を記述してください。
        return true;
    }
    private final void showToast(String str){
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(mIms, str, Toast.LENGTH_LONG).show();
            }
        });
    }

}
