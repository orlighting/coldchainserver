package com.example.coldchain.server.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Videolink implements Serializable {
    private String deviceId;

    private String videoFront;

    private String videoBack;

    private static final long serialVersionUID = 1L;
}