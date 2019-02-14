package gank.note.manager.base;

/**
 * 权限检查监听
 */
public interface OnPermissionListener {
    void result(boolean allGranted);
}