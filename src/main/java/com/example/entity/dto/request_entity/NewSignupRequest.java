package com.example.entity.dto.request_entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class NewSignupRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @NotEmpty
    @Schema(description = "考试编号")
    @TableField("exam_id")
    private String examId;

    @NotEmpty
    @Schema(description = "监考职责")
    @TableField("duty")
    private String duty;

    @NotEmpty
    @Schema(description = "被谁邀请")
    @TableField("invited_by")
    private String invitedBy;
}
