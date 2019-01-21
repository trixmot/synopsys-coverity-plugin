/**
 * synopsys-coverity
 *
 * Copyright (C) 2019 Black Duck Software, Inc.
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
package com.synopsys.integration.jenkins.coverity.extensions.buildstep;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import com.synopsys.integration.jenkins.coverity.extensions.CoverityCommonDescriptor;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.util.FormValidation;
import net.sf.json.JSONObject;

public class CommandArguments extends AbstractDescribableImpl<CommandArguments> implements Serializable {
    private static final long serialVersionUID = 3324059940310844285L;
    private final String covBuildArguments;
    private final String covAnalyzeArguments;
    private final String covRunDesktopArguments;
    private final String covCommitDefectsArguments;

    @DataBoundConstructor
    public CommandArguments(final String covBuildArguments, final String covAnalyzeArguments, final String covRunDesktopArguments, final String covCommitDefectsArguments) {
        this.covBuildArguments = covBuildArguments;
        this.covAnalyzeArguments = covAnalyzeArguments;
        this.covRunDesktopArguments = covRunDesktopArguments;
        this.covCommitDefectsArguments = covCommitDefectsArguments;
    }

    public String getCovBuildArguments() {
        return covBuildArguments;
    }

    public String getCovAnalyzeArguments() {
        return covAnalyzeArguments;
    }

    public String getCovRunDesktopArguments() {
        return covRunDesktopArguments;
    }

    public String getCovCommitDefectsArguments() {
        return covCommitDefectsArguments;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<CommandArguments> {
        private transient final CoverityCommonDescriptor coverityCommonDescriptor;

        public DescriptorImpl() {
            super(CommandArguments.class);
            load();
            this.coverityCommonDescriptor = new CoverityCommonDescriptor();
        }

        @Override
        public boolean configure(final StaplerRequest req, final JSONObject formData) throws Descriptor.FormException {
            req.bindJSON(this, formData);
            save();
            return super.configure(req, formData);
        }

        public FormValidation doCheckCovBuildArguments(final @QueryParameter("covBuildArguments") String covBuildArguments) {
            return coverityCommonDescriptor.doCheckCovBuildArguments(covBuildArguments);
        }

        public FormValidation doCheckCovAnalyzeArguments(final @QueryParameter("covAnalyzeArguments") String covAnalyzeArguments) {
            return coverityCommonDescriptor.doCheckCovAnalyzeArguments(covAnalyzeArguments);
        }

        public FormValidation doCheckCovRunDesktopArguments(final @QueryParameter("covRunDesktopArguments") String covRunDesktopArguments) {
            return coverityCommonDescriptor.doCheckCovRunDesktopArguments(covRunDesktopArguments);
        }

        public FormValidation doCheckCovCommitDefectsArguments(final @QueryParameter("covCommitDefectsArguments") String covCommitDefectsArguments) {
            return coverityCommonDescriptor.doCheckCovCommitDefectsArguments(covCommitDefectsArguments);
        }

    }

}