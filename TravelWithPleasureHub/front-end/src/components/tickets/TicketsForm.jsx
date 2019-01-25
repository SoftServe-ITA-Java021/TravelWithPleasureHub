import React, {Component} from 'react'
import './style/tickets-form-style.css'
import './style/style.css'
import img from "./image/kontur-samolyotika.png";

function formatDay() {
    let d = new Date(),
        currentYear = d.getFullYear(),
        currentMonth = '' + d.getMonth() + 1,
        currentDay = '' + d.getDate();
    if (currentDay.length < 2) currentDay = '0' + currentDay;
    return [currentYear, currentMonth, currentDay].join('-');
}

function Flight(props) {
    return (
        <div className="container-fluid">
            <div className="container card">
                <div className="row text-center justify-content center">
                    <div className="col border">
                        <p/>
                        <img className="img"
                             src={props.flight.imageCompany}
                             alt={props.flight.company}/>
                    </div>
                    <div className="col border">
                        <h5 className="text-muted"><p>{props.flight.departureAirport}</p></h5>
                        <h5><p>{props.flight.departureDateTime}</p></h5>
                    </div>
                    <div className="col border">
                        <h5 className="text-muted">Duration: </h5>
                        <h5><p>{props.flight.duration}</p></h5>
                        <img className="img-fluid"
                             src={img}
                             alt="Plane"
                             width={50}
                             height={120}/>
                        <p/>
                    </div>
                    <div className="col border">
                        <h5 className="text-muted"><p>{props.flight.arrivalAirport}</p></h5>
                        <h5><p>{props.flight.arrivalDateTime}</p></h5>
                    </div>
                    <div className="col border">
                        <div className="from text-muted"><h5>From</h5></div>
                        <h4 className="color">{props.flight.price}</h4>
                        <a href={props.flight.link}>
                            <button className="btn btn-info btn-lg">BUY</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    )
}

class TicketsForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            country: "US",
            currency: "USD",
            locale: "en-US",
            originPlace: "",
            destinationPlace: "",
            outboundDate: formatDay(),
            adults: 1,
            children: 0,
            infants: 0,
            cabinType: "economy",

            result: null,

            loading: true
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
        let info = {
            country: this.state.country,
            currency: this.state.currency,
            locale: this.state.locale,
            originPlace: this.state.originPlace,
            destinationPlace: this.state.destinationPlace,
            outboundDate: this.state.outboundDate,
            adults: this.state.adults,
            cabinClass: this.state.cabinClass,
            children: this.state.children,
            infants: this.state.infants
        };

        fetch("http://localhost:8080/api/flights/one-way", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(info)
        })
            .then(res => res.json())
            .then(response => {
                this.setState({result: response})
            })
            .catch(error => console.error('Error: ', error))
        console.log(this.state.result)
        this.setState({loading: false})
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
                                                        onChange={this.onInputChange}>
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
                                                        onChange={this.onInputChange}>
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
                                                        onChange={this.onInputChange}>
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
                                                    /*id="travel-class"*/
                                                        name="cabinClass"
                                                        value={this.state.cabinType}
                                                        onChange={this.onInputChange}>
                                                    <option>business</option>
                                                    <option>economy</option>
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
                                <div>
                                    {/*{this.state.loading || this.state.result !== null ? <div>loading...</div> :
                                        <div>Available Tickets</div>}*/}
                                    <hr/>
                                    <div>
                                        {this.renderFlights()}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    renderFlights() {
        if (this.state.result !== null)
            return this.state.result.map(res => {
                return (
                    <Flight flight={res}
                            key={res.name + Math.random()}/>
                )
            })
    }
}

export default TicketsForm;