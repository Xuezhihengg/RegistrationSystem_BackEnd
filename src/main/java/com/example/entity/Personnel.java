package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Getter
@Setter
@TableName("Personnel")
@Schema(name = "Personnel", description = "人员表")
public class Personnel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @Schema(description = "姓名")
    @TableField("personnel_name")
    private String personnelName;

    @Schema(description = "职位")
    @TableField("position")
    private String position;

    @Schema(description = "单位")
    @TableField("unit")
    private String unit;

    @Schema(description = "性别")
    @TableField("gender")
    private String gender;

    @Schema(description = "学历")
    @TableField("edu_background")
    private String eduBackground;

    @Schema(description = "身份证")
    @TableField("identity_card")
    private String identityCard;

    @Schema(description = "电话")
    @TableField("phone")
    private String phone;

    @Schema(description = "照片")
    @TableField("photo")
    private String photo;

    @Schema(description = "密码")
    @TableField("password")
    private String password;
}
