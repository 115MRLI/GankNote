package gank.note.model;

import com.google.gson.annotations.SerializedName;

import gank.note.model.base.BaseModel;

public class GankCategoriesModel extends BaseModel {

    /**
     * _id : 57c83777421aa97cbd81c74d
     * en_name : wow
     * name : 科技资讯
     * rank : 1
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("en_name")
    private String enName;
    @SerializedName("name")
    private String name;
    @SerializedName("rank")
    private int rank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
