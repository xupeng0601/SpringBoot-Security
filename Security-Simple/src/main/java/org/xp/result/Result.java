package org.xp.result;

import lombok.Data;

/**
 * @author xupeng
 * @date 2020/11/30 17:02
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

}
