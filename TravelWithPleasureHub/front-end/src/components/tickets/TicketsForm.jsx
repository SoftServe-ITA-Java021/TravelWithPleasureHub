import React, {Component} from 'react'
import './style/tickets-form-style.css'

function formatDay() {
    let d = new Date(),
        currentYear = d.getFullYear(),
        currentMonth = '' + d.getMonth() + 1,
        currentDay = '' + d.getDate();
    if (currentDay.length < 2) currentDay = '0' + currentDay;
    return [currentYear, currentMonth, currentDay].join('-');
}

class TicketsForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            tripType: "One way",
            originLocation: "",
            destinationLocation: "",
            departureDate: formatDay(),
            arrivalDate: "",
            adultsOption: 1,
            childrenOption: 0,
            infantsOption: 0,
            travelClass: "Business class"
        };
        this.onTripTypeChange = this.onTripTypeChange.bind(this);
        this.onOriginLocationChange = this.onOriginLocationChange.bind(this);
        this.onDestinationLocationChange = this.onDestinationLocationChange.bind(this);
        this.onDepartureDateChange = this.onDepartureDateChange.bind(this);
        this.onArrivalDateChange = this.onArrivalDateChange.bind(this);
        this.onAdultsOptionChange = this.onAdultsOptionChange.bind(this);
        this.onChildrenOptionChange = this.onChildrenOptionChange.bind(this);
        this.onInfantsOptionChange = this.onInfantsOptionChange.bind(this);
        this.onTravelClassChange = this.onTravelClassChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onTripTypeChange(event) {
        this.setState({tripType: event.target.value})
    }

    onOriginLocationChange(event) {
        this.setState({originLocation: event.target.value})
    }

    onDestinationLocationChange(event) {
        this.setState({destinationLocation: event.target.value})
    }

    onDepartureDateChange(event) {
        this.setState({departureDate: event.target.value})
    }

    onArrivalDateChange(event) {
        this.setState({arrivalDate: event.target.value})
    }

    onAdultsOptionChange(event) {
        this.setState({adultsOption: event.target.value})
    }

    onChildrenOptionChange(event) {
        this.setState({childrenOption: event.target.value})
    }

    onInfantsOptionChange(event) {
        this.setState({infantsOption: event.target.value})
    }

    onTravelClassChange(event) {
        this.setState({travelClass: event.target.value})
    }

    onSubmit(event) {
        let data = new FormData();
        data.append('tripType', this.state.tripType);
        data.append('originLocation', this.state.tripType);
        data.append('destinationLocation', this.state.destinationLocation);
        data.append('departureDate', this.state.departureDate);
        data.append('arrivalDate', this.state.arrivalDate);
        data.append('adultsOption', this.state.adultsOption);
        data.append('childrenOption', this.state.childrenOption);
        data.append('infantsOption', this.state.infantsOption);
        data.append('travelClass', this.state.travelClass);



        event.preventDefault()
    }

    render() {
        return (
            <div id="booking" className="section">
                <div className="section-center">
                    <div className="container">
                        <div className="row">
                            <div className="booking-form">
                                <form>
                                    <div className="form-group">
                                        <div className="form-checkbox">
                                            <label htmlFor="roundtrip">
                                                <input type="radio" id="roundtrip" value={this.state.tripType}
                                                       onChange={this.onTripTypeChange}
                                                       name="flight-type"/>
                                                <span/>Roundtrip
                                            </label>
                                            <label htmlFor="one-way">
                                                <input type="radio" id="one-way" value={this.state.tripType}
                                                       onChange={this.onTripTypeChange}
                                                       name="flight-type"/>
                                                <span/>One-way
                                            </label>
                                            <label htmlFor="multicity">
                                                <input type="radio" id="multicity" value={this.state.tripType}
                                                       onChange={this.onTripTypeChange}
                                                       name="flight-type"/>
                                                <span/>Multicity
                                            </label>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying from</span>
                                                <input className="form-control" type="text"
                                                       value={this.state.originLocation}
                                                       onChange={this.onOriginLocationChange}
                                                       placeholder="City of airport"/>
                                            </div>
                                        </div>
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying to</span>
                                                <input className="form-control" type="text"
                                                       value={this.state.destinationLocation}
                                                       onChange={this.onDestinationLocationChange}
                                                       placeholder="City or airport"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Departing</span>
                                                <input className="form-control" value={this.state.departureDate}
                                                       onChange={this.onDepartureDateChange}
                                                       type="date" required/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Returning</span>
                                                <input className="form-control" value={this.state.arrivalDate}
                                                       onChange={this.onArrivalDateChange}
                                                       type="date" required/>
                                            </div>
                                        </div>
                                        <div className="col-md-2">
                                            <div className="form-group">
                                                <span className="form-label">Adults</span>
                                                <select className="form-control" value={this.state.adultsOption}
                                                        onChange={this.onAdultsOptionChange}>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                        <div className="col-md-2">
                                            <div className="form-group">
                                                <span className="form-label">Children</span>
                                                <select className="form-control" value={this.state.childrenOption}
                                                        onChange={this.onChildrenOptionChange}>
                                                    <option>0</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                        <div className="col-md-2">
                                            <div className="form-group">
                                                <span className="form-label">Infants</span>
                                                <select className="form-control" value={this.state.infantsOption}
                                                        onChange={this.onInfantsOptionChange}>
                                                    <option>0</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Travel class</span>
                                                <select className="form-control" id="travel-class"
                                                        value={this.state.travelClass}
                                                        onChange={this.onTravelClassChange}>
                                                    <option id={0}>Business class</option>
                                                    <option id={1}>Economy class</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-btn">
                                                <button className="submit-btn" onClick={this.onSubmit}>Show flights
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default TicketsForm;