package gank.note.model;

import com.google.gson.annotations.SerializedName;

import gank.note.model.base.BaseModel;

public class GankMenuModel extends BaseModel {


    /**
     * _id : 57c83792421aa97cada9b79d
     * created_at : 2016-09-01T22:13:38.420Z
     * icon : http://ww2.sinaimg.cn/large/610dc034gw1f9sg2pq9ufj202s02s0sj.jpg
     * id : qdaily
     * title : 好奇心日报
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("icon")
    private String icon;
    @SerializedName("id")
    private String menuId;
    @SerializedName("title")
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
