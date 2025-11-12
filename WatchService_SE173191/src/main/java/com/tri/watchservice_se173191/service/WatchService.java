package com.tri.watchservice_se173191.service;

import com.tri.watchservice_se173191.dto.WatchRequest;
import com.tri.watchservice_se173191.entity.Watch;
import java.util.List;
import java.util.Optional;

public interface WatchService {

    Watch createWatch(WatchRequest watch);
    List<Watch> getAllWatches();
    Watch updateWatch(Integer id, WatchRequest watch);
    void deleteWatch(Integer id);
}
