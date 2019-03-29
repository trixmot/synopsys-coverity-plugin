/**
 * synopsys-coverity
 *
 * Copyright (c) 2019 Synopsys, Inc.
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
package com.synopsys.integration.jenkins.coverity.steps.remote;

import java.io.Serializable;

import org.jenkinsci.remoting.Role;
import org.jenkinsci.remoting.RoleChecker;

import com.synopsys.integration.exception.IntegrationException;
import com.synopsys.integration.jenkins.coverity.JenkinsCoverityLogger;

import hudson.remoting.Callable;

public abstract class CoverityRemoteCallable<T extends Serializable> implements Callable<T, IntegrationException> {
    private static final long serialVersionUID = -4096882757092525358L;
    protected final JenkinsCoverityLogger logger;

    public CoverityRemoteCallable(final JenkinsCoverityLogger logger) {
        this.logger = logger;
    }

    @Override
    public abstract T call() throws IntegrationException;

    @Override
    public void checkRoles(final RoleChecker checker) throws SecurityException {
        checker.check(this, new Role(this.getClass()));
    }
}
