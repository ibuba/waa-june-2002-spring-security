package com.edu.miu.service;

import com.edu.miu.dto.ActivityLogDTO;

import java.util.List;

public interface ActivityLogService {
    public void saveLog(ActivityLogDTO dto);
    public List<ActivityLogDTO> readAll();
}
