package cn.pealipala.vhr.model;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/12 19:22
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
