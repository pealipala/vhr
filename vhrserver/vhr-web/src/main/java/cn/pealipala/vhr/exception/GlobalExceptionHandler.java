package cn.pealipala.vhr.exception;

import cn.pealipala.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.SQLException;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/2 0:44
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据,操作失败");
        }
        return RespBean.error("其他错误");
    }
}
