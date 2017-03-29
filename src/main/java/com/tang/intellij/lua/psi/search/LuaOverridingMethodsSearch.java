/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.lua.psi.search;

import com.intellij.psi.search.searches.ExtensibleQueryFactory;
import com.intellij.util.Query;
import com.tang.intellij.lua.psi.LuaClassMethodDef;
import org.jetbrains.annotations.NotNull;

/**
 *
 * Created by tangzx on 2017/3/29.
 */
public class LuaOverridingMethodsSearch extends ExtensibleQueryFactory<LuaClassMethodDef, LuaOverridingMethodsSearch.SearchParameters> {
    private static LuaOverridingMethodsSearch INSTANCE = new LuaOverridingMethodsSearch();

    static class SearchParameters {

        private LuaClassMethodDef method;

        SearchParameters(LuaClassMethodDef methodDef) {

            method = methodDef;
        }

        public LuaClassMethodDef getMethod() {
            return method;
        }
    }

    private LuaOverridingMethodsSearch() {
        super("com.tang.intellij.lua");
    }

    public static Query<LuaClassMethodDef> search(@NotNull LuaClassMethodDef methodDef) {
        return INSTANCE.createUniqueResultsQuery(new SearchParameters(methodDef));
    }
}