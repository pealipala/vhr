package cn.pealipala.vhr.utils;

import cn.pealipala.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/12 14:44
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
