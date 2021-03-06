package com.firebase.simplelogin;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Basic JSON http response handler.
 *
 * @author Firebase
 *
 */
class JsonBasicResponseHandler implements ResponseHandler<JSONObject> {

  public JSONObject handleResponse(HttpResponse response) {
    JSONObject result = null;
    if (response == null || response.getStatusLine().getStatusCode() >= 300) {
      return result;
    }
    HttpEntity entity = response.getEntity();
    try {
      if(entity != null) {
        String entityString = EntityUtils.toString(entity);
        System.out.println(entityString);
        result = new JSONObject(entityString);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

}
