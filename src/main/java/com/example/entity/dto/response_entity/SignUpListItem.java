package com.example.entity.dto.response_entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class SignUpListItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "考试编号")
    @TableField("exam_id")
    private String examId;

    @Schema(description = "考试名称")
    @TableField("exam_name")
    private String examName;

    @Schema(description = "批次名称")
    @TableField("batch_name")
    private String batchName;

    @Schema(description = "审批状态")
    @TableField("status")
    private Integer status;

    @Schema(description = "监考职责")
    @TableField("duty")
    private String duty;

    @Schema(description = "是否被拒绝")
    @TableField("is_reject")
    private Boolean isReject;
}
