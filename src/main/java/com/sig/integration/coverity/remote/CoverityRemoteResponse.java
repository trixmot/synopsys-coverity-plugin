/**
 * sig-coverity
 *
 * Copyright (C) 2018 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sig.integration.coverity.remote;

import java.io.Serializable;

public class CoverityRemoteResponse implements Serializable {
    private final Exception exception;
    private final int exitCode;
    private final String command;

    public CoverityRemoteResponse(String command, final int exitCode) {
        this.command = command;
        this.exitCode = exitCode;
        this.exception = null;
    }

    public CoverityRemoteResponse(String command, final Exception exception) {
        this.command = command;
        this.exitCode = -1;
        this.exception = exception;
    }

    public String getCommand() {
        return command;
    }

    public Exception getException() {
        return exception;
    }

    public int getExitCode() {
        return exitCode;
    }

}
