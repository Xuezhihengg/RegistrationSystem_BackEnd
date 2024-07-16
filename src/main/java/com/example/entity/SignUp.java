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
 * 报名表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Getter
@Setter
@TableName("SignUp")
@Schema(name = "SignUp", description = "报名表")
public class SignUp implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @Schema(description = "考试编号")
    @TableField("exam_id")
    private String examId;

    @Schema(description = "审批状态")
    @TableField("status")
    private Integer status;

    @Schema(description = "不同意理由")
    @TableField("reason")
    private String reason;

    @Schema(description = "监考职责")
    @TableField("duty")
    private String duty;

    @Schema(description = "是否被拒绝")
    @TableField("is_reject")
    private Boolean isReject;
}
