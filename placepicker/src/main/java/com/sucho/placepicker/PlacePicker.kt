package com.sucho.placepicker

import android.app.Activity
import android.content.Intent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

class PlacePicker {

  class IntentBuilder {

    private lateinit var activity: Activity
    private var showLatLong: Boolean = false
    private var latitude: Double = Constants.DEFAULT_LATITUDE
    private var longitude: Double = Constants.DEFAULT_LONGITUDE
    private var zoom: Float = Constants.DEFAULT_ZOOM
    private var addressRequired: Boolean = true
    private var hideMarkerShadow: Boolean = false
    private var markerDrawableRes: Int = -1
    private var markerImageColorRes: Int = -1
    private var fabBackgroundColorRes: Int = -1
    private var primaryTextColorRes: Int = -1
    private var secondaryTextColorRes: Int = -1
    private var mapRawResourceStyleRes: Int = -1
    private var mapType: MapType = MapType.NORMAL
    private var onlyCoordinates: Boolean = false
    private var disableBottomSheetAnimation: Boolean = false
    private var myLocationEnabled: Boolean = false

    fun showLatLong(showLatLong: Boolean) = apply { this.showLatLong = showLatLong }

    fun setLatLong(
      latitude: Double,
      longitude: Double
    ) = apply {
      if (latitude == -1.0 || longitude == -1.0) {
        this.latitude = Constants.DEFAULT_LATITUDE
        this.longitude = Constants.DEFAULT_LONGITUDE
      } else {
        this.latitude = latitude
        this.longitude = longitude
      }
    }

    fun setMapZoom(zoom: Float) = apply { this.zoom = zoom }

    fun setAddressRequired(addressRequired: Boolean) = apply { this.addressRequired = addressRequired }

    fun hideMarkerShadow(hideMarkerShadow: Boolean) = apply { this.hideMarkerShadow = hideMarkerShadow }

    fun setMarkerDrawable(@DrawableRes markerDrawableRes: Int) = apply { this.markerDrawableRes = markerDrawableRes }

    fun setMarkerImageImageColor(@ColorRes markerImageColorRes: Int) = apply { this.markerImageColorRes = markerImageColorRes }

    fun setFabColor(@ColorRes fabBackgroundColor: Int) = apply { this.fabBackgroundColorRes = fabBackgroundColor }

    fun setPrimaryTextColor(@ColorRes primaryTextColor: Int) = apply { this.primaryTextColorRes = primaryTextColor }

    fun setSecondaryTextColor(@ColorRes secondaryTextColorRes: Int) = apply { this.secondaryTextColorRes = secondaryTextColorRes }

    fun setMapRawResourceStyle(@RawRes mapRawResourceStyleRes: Int) = apply { this.mapRawResourceStyleRes = mapRawResourceStyleRes }

    fun setMapType(mapType: MapType) = apply { this.mapType = mapType }

    fun onlyCoordinates(onlyCoordinates: Boolean) = apply { this.onlyCoordinates = onlyCoordinates }

    fun setMyLocationEnabled(myLocationEnabled: Boolean) = apply { this.myLocationEnabled = myLocationEnabled }

    fun build(activity: Activity): Intent {
      this.activity = activity
      val intent = Intent(activity, PlacePickerActivity::class.java)
      intent.putExtra(Constants.ADDRESS_REQUIRED_INTENT, addressRequired)
      intent.putExtra(Constants.SHOW_LAT_LONG_INTENT, showLatLong)
      intent.putExtra(Constants.INITIAL_LATITUDE_INTENT, latitude)
      intent.putExtra(Constants.INITIAL_LONGITUDE_INTENT, longitude)
      intent.putExtra(Constants.INITIAL_ZOOM_INTENT, zoom)
      intent.putExtra(Constants.HIDE_MARKER_SHADOW_INTENT, hideMarkerShadow)
      intent.putExtra(Constants.MARKER_DRAWABLE_RES_INTENT, markerDrawableRes)
      intent.putExtra(Constants.MARKER_COLOR_RES_INTENT, markerImageColorRes)
      intent.putExtra(Constants.FAB_COLOR_RES_INTENT, fabBackgroundColorRes)
      intent.putExtra(Constants.PRIMARY_TEXT_COLOR_RES_INTENT, primaryTextColorRes)
      intent.putExtra(Constants.SECONDARY_TEXT_COLOR_RES_INTENT, secondaryTextColorRes)
      intent.putExtra(Constants.MAP_RAW_STYLE_RES_INTENT, mapRawResourceStyleRes)
      intent.putExtra(Constants.MAP_TYPE_INTENT, mapType)
      intent.putExtra(Constants.ONLY_COORDINATES_INTENT, onlyCoordinates)
      intent.putExtra(Constants.MY_LOCATION_ENABLED, myLocationEnabled)
      return intent
    }
  }

}
