import React, {Component} from 'react'
import './style/tickets-form-style.css'

class TicketsForm extends Component {

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
                                                <input type="radio" id="roundtrip" name="flight-type"/>
                                                <span/>Roundtrip
                                            </label>
                                            <label htmlFor="one-way">
                                                <input type="radio" id="one-way" name="flight-type"/>
                                                <span/>One-way
                                            </label>
                                            <label htmlFor="multicity">
                                                <input type="radio" id="multicity" name="flight-type"/>
                                                <span/>Multicity
                                            </label>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying from</span>
                                                <input className="form-control" type="text"
                                                       placeholder="City of airport"/>
                                            </div>
                                        </div>
                                        <div className="col-md-6">
                                            <div className="form-group">
                                                <span className="form-label">Flying to</span>
                                                <input className="form-control" type="text"
                                                       placeholder="City or airport"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Departing</span>
                                                <input className="form-control" type="date" required/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-group">
                                                <span className="form-label">Returning</span>
                                                <input className="form-control" type="date" required/>
                                            </div>
                                        </div>
                                        <div className="col-md-2">
                                            <div className="form-group">
                                                <span className="form-label">Adults</span>
                                                <select className="form-control">
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
                                                <select className="form-control">
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
                                                <select className="form-control">
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
                                                <select className="form-control" id="travel-class">
                                                    <option>Business class</option>
                                                    <option>Economy class</option>
                                                </select>
                                                <span className="select-arrow"/>
                                            </div>
                                        </div>
                                        <div className="col-md-3">
                                            <div className="form-btn">
                                                <button className="submit-btn">Show flights</button>
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