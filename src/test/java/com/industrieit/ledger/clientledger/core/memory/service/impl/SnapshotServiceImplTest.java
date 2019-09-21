package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.industrieit.ledger.clientledger.core.memory.model.request.impl.SnapshotRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class SnapshotServiceImplTest {

    @InjectMocks
    private SnapshotServiceImpl snapshotService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSnapshot() {
        long snapshot = snapshotService.snapshot(new SnapshotRequest());
        Assert.assertNotEquals(0L, snapshot);

    }

}
