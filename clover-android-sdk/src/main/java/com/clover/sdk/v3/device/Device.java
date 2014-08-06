/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */


/*
 * Copyright (C) 2013 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clover.sdk.v3.device;

@SuppressWarnings("all")
public final class Device implements android.os.Parcelable, com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {

 /**
   * Unique identifier
  */
  public java.lang.String getId() {
    return cacheGet(CacheKey.id);
  }
 /**
   * Name of the device (if entered)
  */
  public java.lang.String getName() {
    return cacheGet(CacheKey.name);
  }
  public java.lang.String getModel() {
    return cacheGet(CacheKey.model);
  }
  public java.lang.String getOrderPrefix() {
    return cacheGet(CacheKey.orderPrefix);
  }
  public java.lang.String getSerial() {
    return cacheGet(CacheKey.serial);
  }


  private enum CacheKey {
    id {
      @Override
      public Object extractValue(Device instance) {
        return instance.extractId();
      }
    },
    name {
      @Override
      public Object extractValue(Device instance) {
        return instance.extractName();
      }
    },
    model {
      @Override
      public Object extractValue(Device instance) {
        return instance.extractModel();
      }
    },
    orderPrefix {
      @Override
      public Object extractValue(Device instance) {
        return instance.extractOrderPrefix();
      }
    },
    serial {
      @Override
      public Object extractValue(Device instance) {
        return instance.extractSerial();
      }
    },
    ;

    public abstract Object extractValue(Device instance);
  }

  private String jsonString = null;
  private org.json.JSONObject jsonObject = null;
  private android.os.Bundle bundle = null;
  private android.os.Bundle changeLog = null;
  private Object[] cache = null;
  private byte[] cacheState = null;

  private static final byte STATE_NOT_CACHED = 0;
  private static final byte STATE_CACHED_NO_VALUE = 1;
  private static final byte STATE_CACHED_VALUE = 2;

  /**
   * Constructs a new empty instance.
   */
  public Device() { }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public Device(String json) {
    this.jsonString = json;
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public Device(org.json.JSONObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public Device(Device src) {
    if (src.jsonString != null) {
      this.jsonString = src.jsonString;
    } else {
      this.jsonObject = com.clover.sdk.v3.JsonHelper.deepCopy(src.getJSONObject());
    }
  }

  private <T> T cacheGet(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return (T) cache[index];
  }

  private boolean cacheValueIsNotNull(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cache[index] != null;
  }

  private boolean cacheHasKey(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cacheState[index] == STATE_CACHED_VALUE;
  }

  private void cacheRemoveValue(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    cache[index] = null;
    cacheState[index] = STATE_CACHED_NO_VALUE;
  }

  private void cacheMarkDirty(CacheKey key) {
    if (cache != null) {
      int index = key.ordinal();
      cache[index] = null;
      cacheState[index] = STATE_NOT_CACHED;
    }
  }

  private void populateCache(int index) {
    if (cache == null) {
      int size = CacheKey.values().length;
      cache = new Object[size];
      cacheState = new byte[size];
    }

    if (cacheState[index] == STATE_NOT_CACHED) {
      CacheKey key = CacheKey.values()[index];

      if (getJSONObject().has(key.name())) {
        cache[index] = key.extractValue(this);
        cacheState[index] = STATE_CACHED_VALUE;
      } else {
        cacheState[index] = STATE_CACHED_NO_VALUE;
      }
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    try {
      if (jsonObject == null) {
        if (jsonString != null) {
          jsonObject = new org.json.JSONObject(jsonString);
          jsonString = null; // null this so it will be recreated if jsonObject is modified
        } else {
          jsonObject = new org.json.JSONObject();
        }
      }
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }
    return jsonObject;
  }


  @Override
  public void validate() {
    java.lang.String id = getId();
    if (id != null && id.length() > 36) throw new IllegalArgumentException("Maximum string length exceeded for 'id'");

    java.lang.String name = getName();
    if (name != null && name.length() > 127) throw new IllegalArgumentException("Maximum string length exceeded for 'name'");

    java.lang.String model = getModel();
    if (model != null && model.length() > 64) throw new IllegalArgumentException("Maximum string length exceeded for 'model'");

    java.lang.String orderPrefix = getOrderPrefix();
    if (orderPrefix != null && orderPrefix.length() > 1) throw new IllegalArgumentException("Maximum string length exceeded for 'orderPrefix'");

    java.lang.String serial = getSerial();
    if (serial != null && serial.length() > 32) throw new IllegalArgumentException("Maximum string length exceeded for 'serial'");
  }



  private java.lang.String extractId() {
    return getJSONObject().isNull("id") ? null :
      getJSONObject().optString("id");
  }


  private java.lang.String extractName() {
    return getJSONObject().isNull("name") ? null :
      getJSONObject().optString("name");
  }


  private java.lang.String extractModel() {
    return getJSONObject().isNull("model") ? null :
      getJSONObject().optString("model");
  }


  private java.lang.String extractOrderPrefix() {
    return getJSONObject().isNull("orderPrefix") ? null :
      getJSONObject().optString("orderPrefix");
  }


  private java.lang.String extractSerial() {
    return getJSONObject().isNull("serial") ? null :
      getJSONObject().optString("serial");
  }


  /** Checks whether the 'id' field is set and is not null */
  public boolean isNotNullId() {
    return cacheValueIsNotNull(CacheKey.id);
  }

  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'model' field is set and is not null */
  public boolean isNotNullModel() {
    return cacheValueIsNotNull(CacheKey.model);
  }

  /** Checks whether the 'orderPrefix' field is set and is not null */
  public boolean isNotNullOrderPrefix() {
    return cacheValueIsNotNull(CacheKey.orderPrefix);
  }

  /** Checks whether the 'serial' field is set and is not null */
  public boolean isNotNullSerial() {
    return cacheValueIsNotNull(CacheKey.serial);
  }


  /** Checks whether the 'id' field has been set, however the value could be null */
  public boolean hasId() {
    return cacheHasKey(CacheKey.id);
  }

  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'model' field has been set, however the value could be null */
  public boolean hasModel() {
    return cacheHasKey(CacheKey.model);
  }

  /** Checks whether the 'orderPrefix' field has been set, however the value could be null */
  public boolean hasOrderPrefix() {
    return cacheHasKey(CacheKey.orderPrefix);
  }

  /** Checks whether the 'serial' field has been set, however the value could be null */
  public boolean hasSerial() {
    return cacheHasKey(CacheKey.serial);
  }


  /**
   * Sets the field 'id'.
   */
  public Device setId(java.lang.String id) {
    logChange("id");

    try {
      getJSONObject().put("id", id == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(id));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.id);
    return this;
  }

  /**
   * Sets the field 'name'.
   */
  public Device setName(java.lang.String name) {
    logChange("name");

    try {
      getJSONObject().put("name", name == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(name));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.name);
    return this;
  }

  /**
   * Sets the field 'model'.
   */
  public Device setModel(java.lang.String model) {
    logChange("model");

    try {
      getJSONObject().put("model", model == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(model));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.model);
    return this;
  }

  /**
   * Sets the field 'orderPrefix'.
   */
  public Device setOrderPrefix(java.lang.String orderPrefix) {
    logChange("orderPrefix");

    try {
      getJSONObject().put("orderPrefix", orderPrefix == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(orderPrefix));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.orderPrefix);
    return this;
  }

  /**
   * Sets the field 'serial'.
   */
  public Device setSerial(java.lang.String serial) {
    logChange("serial");

    try {
      getJSONObject().put("serial", serial == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(serial));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.serial);
    return this;
  }


  /** Clears the 'id' field, the 'has' method for this field will now return false */
  public void clearId() {
    unlogChange("id");
    getJSONObject().remove("id");
    cacheRemoveValue(CacheKey.id);
  }

  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    unlogChange("name");
    getJSONObject().remove("name");
    cacheRemoveValue(CacheKey.name);
  }

  /** Clears the 'model' field, the 'has' method for this field will now return false */
  public void clearModel() {
    unlogChange("model");
    getJSONObject().remove("model");
    cacheRemoveValue(CacheKey.model);
  }

  /** Clears the 'orderPrefix' field, the 'has' method for this field will now return false */
  public void clearOrderPrefix() {
    unlogChange("orderPrefix");
    getJSONObject().remove("orderPrefix");
    cacheRemoveValue(CacheKey.orderPrefix);
  }

  /** Clears the 'serial' field, the 'has' method for this field will now return false */
  public void clearSerial() {
    unlogChange("serial");
    getJSONObject().remove("serial");
    cacheRemoveValue(CacheKey.serial);
  }


  private void logChange(java.lang.String field) {
    if (changeLog == null) {
      changeLog = new android.os.Bundle();
    }
    changeLog.putString(field, null);
  }

  private void unlogChange(java.lang.String field) {
    if (changeLog != null) {
      changeLog.remove(field);
    }
  }

  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return changeLog != null;
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    changeLog = null;
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public Device copyChanges() {
    Device copy = new Device();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(Device src) {
    if (src.changeLog != null) {
      try {
        // Make a copy of the source so the destination fields are copies
        org.json.JSONObject srcObj = new Device(src).getJSONObject();
        org.json.JSONObject dstObj = getJSONObject();
        for (java.lang.String field : src.changeLog.keySet()) {
          dstObj.put(field, srcObj.get(field));
          logChange(field);
        }
      } catch (org.json.JSONException e) {
        throw new java.lang.IllegalArgumentException(e);
      }
    }
  }


  /**
   * Gets a Bundle which can be used to get and set data attached to this instance. The attached Bundle will be
   * parcelled but not jsonified.
   */
  public android.os.Bundle getBundle() {
    if (bundle == null) {
      bundle = new android.os.Bundle();
    }
    return bundle;
  }

  @Override
  public String toString() {
    String json = jsonString != null ? jsonString : getJSONObject().toString();

    if (bundle != null) {
      bundle.isEmpty(); // Triggers unparcel
    }

    if (changeLog != null) {
      changeLog.isEmpty(); // Triggers unparcel
    }

    return "Device{" +
        "json='" + json + "'" +
        ", bundle=" + bundle +
        ", changeLog=" + changeLog +
        '}';
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
	  com.clover.sdk.v3.JsonParcelHelper.wrap(getJSONObject()).writeToParcel(dest, 0);
    dest.writeBundle(bundle);
    dest.writeBundle(changeLog);
  }

  public static final android.os.Parcelable.Creator<Device> CREATOR = new android.os.Parcelable.Creator<Device>() {
    @Override
    public Device createFromParcel(android.os.Parcel in) {
      Device instance = new Device(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.bundle = in.readBundle(getClass().getClassLoader());
      instance.changeLog = in.readBundle();
      return instance;
    }

    @Override
    public Device[] newArray(int size) {
      return new Device[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<Device> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<Device>() {
    @Override
    public Device create(org.json.JSONObject jsonObject) {
      return new Device(jsonObject);
    }
  };


  public interface Constraints {

    public static final boolean ID_IS_REQUIRED = false;
    public static final long ID_MAX_LEN = 36;

    public static final boolean NAME_IS_REQUIRED = false;
    public static final long NAME_MAX_LEN = 127;

    public static final boolean MODEL_IS_REQUIRED = false;
    public static final long MODEL_MAX_LEN = 64;

    public static final boolean ORDERPREFIX_IS_REQUIRED = false;
    public static final long ORDERPREFIX_MAX_LEN = 1;

    public static final boolean SERIAL_IS_REQUIRED = false;
    public static final long SERIAL_MAX_LEN = 32;

  }

}
