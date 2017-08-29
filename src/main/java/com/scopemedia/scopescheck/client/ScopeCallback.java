package com.scopemedia.scopescheck.client;

import com.scopemedia.scopescheck.dto.response.ScopeResponse;

/**
 * Created by maikel on 2017-03-27.
 */

public interface ScopeCallback<T extends ScopeResponse> {
    void onScopeResponse(T response);
    void onScopeFailure(Throwable throwable);
}
