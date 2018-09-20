package com.crud.library.domain.dao;

import com.crud.library.domain.Rents;

public interface CopyRepositoryCustom {

   void updateCopyStatus(final Rents rent, String status);
}