package com.crud.library.controller;

public enum CopyStatus {
    RENTED {
        @Override
        public String toString() {
            return "rented";
        }
    },
    AVAILABLE {
        @Override
        public String toString() {
            return "available";
        }
    }
}