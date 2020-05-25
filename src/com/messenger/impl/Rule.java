package com.messenger.impl;

import com.messenger.impl.OptionalMessenger;

public interface Rule {
  OptionalMessenger matches(final String type, final String message);

  String getType();
}
