package com.tri.watchservice.service;

import com.tri.watchservice.dto.WatchRequest;
import com.tri.watchservice.entity.Watch;
import java.util.List;

public interface WatchService {

    Watch createWatch(WatchRequest watch);
    List<Watch> getAllWatches();
    Watch updateWatch(Integer id, WatchRequest watch);
    void deleteWatch(Integer id);
}
