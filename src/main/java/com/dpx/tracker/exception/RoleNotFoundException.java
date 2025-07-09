package com.dpx.tracker.exception;


import com.dpx.tracker.constants.ErrorCodes;

public class RoleNotFoundException extends ResourceNotFoundException {
   public RoleNotFoundException(String message) {
       super(message, ErrorCodes.ROLE_NOT_FOUND);
   }
}
