package com.crud.library.controller;

public enum CopyStatus {
    RENTED {
        @Override
        public String toString() {
            return "Rented";
        }
    },
    AVAILABLE {
        @Override
        public String toString() {
            return "Available";
        }
    }
}