package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */

@Data
@Builder
@TableName("Examination")
@Schema(name = "Examination", description = "考试表")
public class Examination implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Tolerate
    public Examination() {}

    @Schema(description = "考试编号")
    @TableId("exam_id")
    private String examId;

    @Schema(description = "批次编号")
    @TableField("batch_id")
    private String batchId;

    @Schema(description = "考试名称")
    @TableField("exam_name")
    private String examName;

    @Schema(description = "校区")
    @TableField("campus")
    private String campus;

    @Schema(description = "考试地点")
    @TableField("address")
    private String address;

    @Schema(description = "考试开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @Schema(description = "考试结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @Schema(description = "主监考")
    @TableField("chief_invigilator")
    private String chiefInvigilator;

    @Schema(description = "副监考")
    @TableField("minor_invigilator")
    private String minorInvigilator;
}
