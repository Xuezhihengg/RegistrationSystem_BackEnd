package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 批次表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Getter
@Setter
@TableName("Batch")
@Schema(name = "Batch", description = "批次表")
public class Batch implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "批次编号")
    @TableId("batch_id")
    private String batchId;

    @Schema(description = "批次名称")
    @TableField("batch_name")
    private String batchName;

    @Schema(description = "报名开始时间")
    @TableField("start_date")
    private LocalDateTime startDate;

    @Schema(description = "报名结束时间")
    @TableField("end_date")
    private LocalDateTime endDate;

    @Schema(description = "描述")
    @TableField("description")
    private String description;

    @Schema(description = "附件")
    @TableField("attachment")
    private String attachment;
}
