/*
 * Copyright 2019 The FATE Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.ai.eggroll.core.api.grpc.observer;

import com.webank.ai.eggroll.core.model.DelayedResult;

import java.util.concurrent.CountDownLatch;

public class CallerWithSameTypeDelayedResultResponseStreamObserver<R, E> extends BaseCallerWithDelayedResultResponseStreamObserver<R, E, E> {
    public CallerWithSameTypeDelayedResultResponseStreamObserver(CountDownLatch finishLatch, DelayedResult<E> delayedResult) {
        super(finishLatch, delayedResult);
    }

    @Override
    public void onNext(E e) {
        this.delayedResult.setResult(e);
    }
}
