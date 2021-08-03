package com.fzg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialBlob;
import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User{

    private String name;
    private int age;

}
