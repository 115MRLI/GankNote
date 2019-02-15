package gank.note.net;

import com.google.gson.annotations.SerializedName;

/**
 * 响应体基础结构
 *
 * @param <T>
 */
public class ResponseModel<T> {
    @SerializedName("code")
    private int code = 0;
    @SerializedName("msg")
    private String message = "";
    @SerializedName("error")
    private boolean error = false;


    private T results;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isSuccess() {
        return code == 1;
    }

    public boolean isError() {
        return error;
    }

    public ResponseModel<T> setError(boolean error) {
        this.error = error;
        return this;
    }

    public T getResults() {
        return results;
    }

    public ResponseModel<T> setResults(T results) {
        this.results = results;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseModel{" + "code=" + code + ", message='" + message + '\'' + ", error=" + error  + ", results=" + results + '}';
    }
}