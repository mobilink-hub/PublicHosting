package jp.co.denso.iflink.virtualcar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;

import android.widget.Switch;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
            put("doorStatusOpen", "");
            put("doorStatusLock", "");
            put("doorStatus", "");
        }
    };
    private ApiOperation subscribe;
    private boolean isAmplifyReady = false;

    /**
    apiのURL、仮のmobilinkid、accesstoken
    */
    private OkHttpClient client = new OkHttpClient();
    private String MOBILINK_API_ENDPOINT_URL = "https://llysmz9l26.execute-api.ap-northeast-1.amazonaws.com/staging/v0.1/vehicles/";
    private String MOBILINK_AUTH_URL = "https://w8c9j34ijl.execute-api.ap-northeast-1.amazonaws.com/mobilink_auth_test/dynamodbctl";
    private String mobilinkId; //= "LeOLJrcMp68MHt5n";
    private String x_mobilink_access_token; // = "XVBqnpLwQMkVjKGa";
    private String filename = "IDtoken.txt";
    private File file;
    private String[] ID_token = new String[2];  //mobilinkid,x-mobilink-access-token
    private boolean file_exi = false;

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
        mDeviceName = BuildConfig.APPLICATION_ID + ":virtualcarDevice:" + BuildConfig.VERSION_CODE;
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

        //initializeしないことがあるので現状回避させている
        isAmplifyReady = true;
        // onUpdateConfigが呼ばれる
        addDevice();
        // 基本は、デバイスとの接続が確立した時点で呼び出します。
        notifyConnectDevice();
    }

    private void taskSubscribe(){
        Log.d(TAG,"taskUpdateSubscribe");
        Amplify.API.query(ModelQuery.get(Vehicle.class,username+":"+vehicleId),
                response->{
                    Log.d(TAG, "oldVehicle");
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
                onUpdated -> {
                    Log.d(TAG, "onUpdate");
                    onVehicleUpdated(onUpdated.getData());
                },
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
//        else{showToast(username+":"+vehicleId + " is updated"); }
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
        //pushData();
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
//        // デバイスからのデータ送信停止処理を記述してください。
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
                    Log.d(TAG, param);
                    if (param.equals("doorStatus")) {
                        Log.d(TAG, param);
                        switch (map.get(param+".flag").toString()) {
                            case "1":
                            case "2":
                                param = "doorStatusOpen";
                                break;
                            case "3":
                            case "4":
                                param = "doorStatusLock";
                                break;
                        }
                    }
                    updateTarget.add(param);
                }
            }
        }


        String json;
        List<String> name = new ArrayList<String>();
        List<String> command = new ArrayList<String>();
        List<String> args = new ArrayList<String>();
        for (String param: updateTarget) {
            try {
                switch (param) {
                    case "vehicleSpeed":
                    case "brakePressure":
                    case "wiperFrontControlSetting":
                    case "ignitionStatus":
                    case "steeringWheelAngle":
                    case "transmissionGearPosition":
                    case "lightHeadStatusLighting":
                    case "turnSignalStatusOperation":
                        name.add("cockpit");
                        command.add(param);
                        args.add((String) map.get(param));
                        break;
                    case "hornStatusSound":
                    case "hazardLampOperationState":
                        name.add("cockpit");
                        command.add(param);
                        args.add(map.get(param).toString().equals("0") ? "false" : "true");
                        break;
                    case "acBlowerMode":
                    case "acceleratorPedalOpening":
                    case "acBlowerLevel":
                    case "acDriverSettingTemp":
                    case "insideTemp":
                    case "outsideTemp":
                    case "heaterStatusOperation":
                    case "customAmRadioChannel":
                    case "customFmRadioChannel":
                    case "customAudioVol":
                    case "customAudioMode":
                        name.add("dashboard");
                        command.add(param);
                        args.add((String) map.get(param));
                        break;
                    case "airRecirculationStatusOperation":
                    case "defoggerFrontStatusOperation":
                    case "customMusicStatus":
                        name.add("dashboard");
                        command.add(param);
                        args.add(map.get(param).toString().equals("0") ? "false" : "true");
                        break;
                    case "doorStatusOpen":
                        name.add("door&light");
                        String[] doorStatusOpenTargets = map.get("doorStatus").toString().split(",", 0);
                        for (String target : doorStatusOpenTargets) {
                            switch (target) {
                                case "rightFront":
                                    command.add("doorRightFrontStatusOpen");
                                    args.add(map.get("doorStatus.flag").toString().equals("1") ? "false" : "true");
                                    break;
                                case "leftFront":
                                    command.add("doorLeftFrontStatusOpen");
                                    args.add(map.get("doorStatus.flag").toString().equals("1") ? "false" : "true");
                                    break;
                                case "rightRear":
                                    command.add("doorRightRearStatusOpen");
                                    args.add(map.get("doorStatus.flag").toString().equals("1") ? "false" : "true");
                                    break;
                                case "leftRear":
                                    command.add("doorLeftRearStatusOpen");
                                    args.add(map.get("doorStatus.flag").toString().equals("1") ? "false" : "true");
                                    break;
                                case "trunk":
                                    command.add("doorTrunkStatusOpen");
                                    args.add(map.get("doorStatus.flag").toString().equals("1") ? "false" : "true");
                            }
                        }
                        break;
                    case "doorStatusLock":
                        name.add("door&light");
                        String[] doorStatusLockTargets = map.get("doorStatus").toString().split(",", 0);
                        for (String target : doorStatusLockTargets) {
                            switch (target) {
                                case "rightFront":
                                    command.add("doorRightFrontStatusLock");
                                    args.add(map.get("doorStatus.flag").toString().equals("3") ? "false" : "true");
                                    break;
                                case "leftFront":
                                    command.add("doorLeftFrontStatusLock");
                                    args.add(map.get("doorStatus.flag").toString().equals("3") ? "false" : "true");
                                    break;
                                case "rightRear":
                                    command.add("doorRightRearStatusLock");
                                    args.add(map.get("doorStatus.flag").toString().equals("3") ? "false" : "true");
                                    break;
                                case "leftRear":
                                    command.add("doorLeftRearStatusLock");
                                    args.add(map.get("doorStatus.flag").toString().equals("3") ? "false" : "true");
                                    break;
                                case "trunk":
                                    command.add("doorTrunkStatusLock");
                                    args.add(map.get("doorStatus.flag").toString().equals("3") ? "false" : "true");
                            }
                        }
                        break;
                    case "customSensorRightFrontLevel":
                    case "customSensorRightRearLevel":
                    case "customSensorLeftFrontLevel":
                    case "customSensorLeftRearLevel":
                        name.add("sensor");
                        command.add(param);
                        args.add((String) map.get(param));
                    default:
                        showToast("unknown Buildstep");
                }
                /*未実装
                case "lightHighBeamStatusLighting":
                case "lampBreakStatusLighting":
                case "naviDestMeasuringLat":
                case "naviDestMeasuringLon":
                case "gpsStatusMeasuringLon":
                case "gpsStatusMeasuringLat":
                 */
            } catch (NumberFormatException e) {
                showToast("Formatting Exception:" + param);
            }
        }

        int cmdcnt = name.size();
        if (cmdcnt > 0) {
            json = "{\"items\":[";
            for (int i = 0; i < cmdcnt; i++) {
                json = json + "{ \"name\":\"" + name.get(i) + "\",\"command\":\"" + command.get(i) + "\",\"args\":[\"" + args.get(i) + "\"] },";
            }
            json = json.substring(0, json.length()-1);
            json = json + "]}";
            RequestBody reqBody = RequestBody.create(MediaType.parse("application/json"), json);
            Request req = new Request.Builder()
                    .url(MOBILINK_API_ENDPOINT_URL+ID_token[0])
                    .addHeader("x-mobilink-access-token", ID_token[1])
                    .post(reqBody)
                    .build();
            try {
                Log.d("post", json);
                client.newCall(req).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
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

        Log.d(TAG,"pushData");
        notifyRecvData();
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

    private void login(String username,String password) {
        Log.d(TAG, "login with '" + username + "':'" + vehicleId + "'");
        Amplify.Auth.signIn(
                username,
                password,
                result -> {
                    String text = result.isSignInComplete() ? "Sign in succeeded with '" + username + "'" : "Sign in not complete with '" + username + "'";
                    Log.i(TAG, text);
                    //showToast(text);
                    if (subscribe != null) subscribe.cancel();
                    taskSubscribe();
                },
                error -> {
                    Log.i(TAG, error.toString());
                    Context ctx = mIms.getApplicationContext();
                    showToast("Sign in failed with '" + username + "'" + " on " + vehicleId);
                }
        );
    }


    //mobilinkidが発行済みかチェック
    public class Authid extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String json = "{ \"OperationType\":\"SCAN_MPF\",\"Keys\": {\"id\":\"" + username + ":" + vehicleId + "\",\"password\":\"" + password + "\"}}";
            RequestBody reqBody = RequestBody.create(MediaType.parse("application/json"), json);
            Request req = new Request.Builder()
                    .url(MOBILINK_AUTH_URL)
                    .post(reqBody)
                    .build();
            try {
                Log.d(TAG, "authid connection");
                Response response = client.newCall(req).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return "Connection Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Issuetoken issuetokentask;
            switch (result) {
                case "\"Password is incorrect\"":
                    Log.d(TAG, result);
                    showToast("Password is incorrect. config profile at 環境設定 > VirtualCar IMS 設定メニュー");
                    break;
                case "\"mpf_none\"":
                    Log.d(TAG, result);
                    showToast("Vehicle is None. config profile or issue mobilinkId");
                    break;
                case "Connection Error":
                    showToast("外部通信エラー");
                    break;
                default:
                    Log.d(TAG, result);
                    // 認証情報保持
                    if (file_exi) {
                            // 適切なID保持
                        if (ID_token[0].equals(result.replace("\"", ""))) {
                            Authtoken authtokentask = new Authtoken();
                            authtokentask.execute();
                            // 保持IDと入力IDが異なる、token発行依頼
                        } else {
                            ID_token[0] = result.replace("\"", "");
                            issuetokentask = new Issuetoken();
                            issuetokentask.execute();
                        }
                    } else {  //認証情報なし（インストール後初ログイン）
                        ID_token[0] = result.replace("\"", "");
                        issuetokentask = new Issuetoken();
                        issuetokentask.execute();
                    }
                    break;
            }

        }
    }

    //accesstokenが有効かチェック
    public class Authtoken extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String json = "{ \"OperationType\":\"AUTH\",\"Keys\":{\"x_mobilink_access_token\":\"" + ID_token[1] + "\"}}";
            RequestBody reqBody = RequestBody.create(MediaType.parse("application/json"), json);
            Request req = new Request.Builder()
                    .url(MOBILINK_AUTH_URL)
                    .post(reqBody)
                    .build();
            try {
                Log.d(TAG, "authtoken connection");
                Response response = client.newCall(req).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return "Connection Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equals("Connection Error")) {
                showToast("外部通信エラー");
            } else {
                Log.d("authtokentask", result.replace("\"", ""));
                String result2 = result.replace("\"", "");
                switch (result2) {
                    case "ok":
                        Log.d(TAG, "token ok");
                        showToast("Token authentication completed");
                        login(username,password);
                        break;
                    case "none":
                        Log.d(TAG, "token none");
                        Issuetoken issue = new Issuetoken();
                        issue.execute();
                        break;
                    default:
                        if (result2.length() == 16) {
                            ID_token[1] = result2;
                            try (FileWriter writer = new FileWriter(file)) {
                                writer.write(ID_token[0] + "," + result2);
                                showToast("Token authentication completed");
                                login(username,password);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //多分保持してるtokenがエラ〜メッセージ
                            showToast("authtoken error");
                        }
                }
            }
        }

    }

    //accesstoken新規発行
    public class Issuetoken extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String json = "{ \"OperationType\":\"PUT\",\"Keys\": {\"mobilinkid\":\"" + ID_token[0] + "\"}}";
            RequestBody reqBody = RequestBody.create(MediaType.parse("application/json"), json);
            Request req = new Request.Builder()
                    .url(MOBILINK_AUTH_URL)
                    .post(reqBody)
                    .build();
            try {
                Log.d(TAG, "issuetoken connection");
                Response response = client.newCall(req).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return "Connection Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equals("Connection Error")) {
                showToast("外部通信エラー");
            } else {
                Log.d("issuetask", result);
                ID_token[1] = result.replace("\"", "");
                if (ID_token[1].length() == 16) {
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write(ID_token[0] + "," + ID_token[1]);
                        showToast("Token issuance completed");
                        login(username,password);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    showToast("トークン発行エラー");
                }

            }
        }

    }

    @Override
    protected void onUpdateConfig(@NonNull IfLinkSettings settings) throws IfLinkAlertException {
        Log.d(TAG, "onUpdateConfig");
        showToast("onUpdateConfig");
        // 設定パラメータを更新する処理を記述してください。
        String usernameKey = mIms.getString(R.string.pref_virtualcardevice_settings_username_key);
        String passwordKey = mIms.getString(R.string.pref_virtualcardevice_settings_password_key);
        String vehicleIdKey = mIms.getString(R.string.pref_virtualcardevice_settings_vehicle_id_key);
        username = settings.getStringValue(usernameKey, "");
        password = settings.getStringValue(passwordKey, "");
        vehicleId = settings.getStringValue(vehicleIdKey,"");
        Context context = mIms.getApplicationContext();
        file = new File(context.getFilesDir(), filename);

        String line = null;

        if(isAmplifyReady){
            if(username == "" || password == "" || vehicleId == ""){
                showToast("config profile at 環境設定 > VirtualCar IMS 設定メニュー");
            }
            //else login(username,password);
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                line = br.readLine();
                ID_token = line.split(",");
                Log.d("ID_token", ID_token[0] + ":" + ID_token[1]);
                file_exi = true;
            }
            catch (IOException e) {
                Log.d(TAG, "File None");
                ID_token[0] = "hoge";
                ID_token[1] = "hoge";
                e.printStackTrace();
            }

            Authid authidtask = new Authid();
            authidtask.execute();
        }
        if(username.equals("") || password.equals("") || vehicleId.equals("")){
            showToast("config profile at 環境設定 > VirtualCar IMS 設定メニュー");
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
        //Log.d(TAG, "checkPathConnection");
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
        //Log.d(TAG, "checkDeviceConnection");
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
        //Log.d(TAG, "checkDeviceAlive");
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
