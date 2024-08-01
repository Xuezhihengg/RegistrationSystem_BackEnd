package com.example.entity.dto.request_entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class NewExamRequest  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
}
