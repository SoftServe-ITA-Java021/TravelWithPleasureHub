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
            country: "US",
            currency: "USD",
            originPlace: "",
            destinationPlace: "",
            outboundDate: formatDay(),
            adults: 1,
            children: 0,
            infants: 0,
            cabinType: "business",

            result: []
        };

        this.onInputChange = this.onInputChange.bind(this);

        this.onTripTypeChange = this.onTripTypeChange.bind(this);
        this.onHandle = this.onHandle.bind(this);
    }

    onInputChange(event) {
        const name = event.target.name;
        this.setState({[name]: event.target.value})
    }

    onTripTypeChange(event) {
        this.setState({tripType: event.target.value})
    }

    onLoad = () => {
        let data = new FormData();
        data.append('country', this.state.country);
        data.append('currency', this.state.currency);
        data.append('locale', this.state.locale);
        data.append('originPlace', this.state.originPlace);
        data.append('destinationPlace', this.state.destinationPlace);
        data.append('outboundDate', this.state.outboundDate);
        data.append('adults', this.state.adults);
        data.append('cabinClass', this.state.cabinType);
        data.append('children', this.state.children);
        data.append('infants', this.state.infants);

        fetch("http://localhost:3000/api/flights/", {
            method: "POST",
            body: data
        })
            .then(response => response.json())
            .then(result => this.setState({result: result}))
    };

    onHandle = (event) => {
        event.preventDefault();
        this.onLoad()
    };

    render() {
        return (
            <div id="booking" className="section">
                <div className="section-center">
                    <div className="container">
                        <div className="row">
                            <div className="booking-form">
                                <form>
                                    <div className="form-group row">
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
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying from</span>
                                                <input className="form-control"
                                                       type="text"
                                                       name="originPlace"
                                                       value={this.state.originPlace}
                                                       onChange={this.onInputChange}
                                                       placeholder="City of airport"/>
                                            </div>
                                        </div>
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying to</span>
                                                <input className="form-control" type="text"
                                                       name="destinationPlace"
                                                       value={this.state.destinationPlace}
                                                       onChange={this.onInputChange}
                                                       placeholder="City or airport"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Departing</span>
                                                <input className="form-control"
                                                       name="outboundDate"
                                                       value={this.state.outboundDate}
                                                       onChange={this.onInputChange}
                                                       type="date" required/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Returning</span>
                                                <input className="form-control"
                                                       name="inboundDate"
                                                       value={this.state.inboundDate}
                                                       onChange={this.onInputChange}
                                                       type="date"/>
                                            </div>
                                        </div>
                                        <div className="col-md-2">
                                            <div className="form-group">
                                                <span className="form-label">Adults</span>
                                                <select className="form-control"
                                                        name="adults"
                                                        value={this.state.adults}
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
                                                <select className="form-control"
                                                        name="children"
                                                        value={this.state.children}
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
                                                <select className="form-control"
                                                        name="infants"
                                                        value={this.state.infants}
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
                                                <select className="form-control"
                                                        id="travel-class"
                                                        name="cabinClass"
                                                        value={this.state.cabinType}
                                                        onChange={this.onTravelClassChange}>
                                                    <option>Business class</option>
                                                    <option>Economy class</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-btn">
                                                <button className="submit-btn" onClick={this.onHandle}>Show flights
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