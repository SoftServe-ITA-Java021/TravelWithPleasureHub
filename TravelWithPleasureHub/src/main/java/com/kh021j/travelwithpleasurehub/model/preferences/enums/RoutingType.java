package com.kh021j.travelwithpleasurehub.model.preferences.enums;

/**
 * If we choose ONE_WAY we need to generate json query only for available one way tickets.
 * If we choose ROUND_TRIP we need to generate json query for available tickets from departure point to destination point and vise versa.
 * If we choose MULTICITY we need to generate json query for available tickers with transfers.
 */

public enum RoutingType {
        ONE_WAY, ROUND_TRIP, MULTICITY
}
