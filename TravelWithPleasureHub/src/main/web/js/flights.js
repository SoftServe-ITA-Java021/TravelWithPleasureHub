function Flight(props) {
    return (
        <div className="container-fluid">
            <div className="container card">
                <div className="row text-center justify-content center">
                    <div className="col border">
                        <img className="img"
                             src={props.flight.img}
                             alt={props.flight.name}
                             width={210}
                             height={150}/>
                    </div>
                    <div className="col border">
                        <h5 className="text-muted"><p>{props.flight.origin}</p></h5>
                        <h5><p>{props.flight.departureDateTime}</p></h5>
                    </div>
                    <div className="col border">
                        <h5 className="text-muted">Duration: </h5>
                        <h5><p>{props.flight.duration}</p></h5>
                        <img className="img-fluid"
                             src="img/Kontur-samolyotika_91282.png"
                             alt="Plane"
                             width={50}
                             height={120}/>
                        {/*<h5><p>==============></p></h5>*/}
                    </div>
                    <div className="col border">
                        <h5 className="text-muted"><p>{props.flight.destination}</p></h5>
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

class FlightInfo extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            flights: [
                {
                    name: "Belavia",
                    price: "200$",
                    img: "img/Logo-Belavia.png",
                    origin: "IEV",
                    destination: "BUD",
                    departureDateTime: "25.01.2019 19:00",
                    arrivalDateTime: "26.01.2019 10:00",
                    duration: "15:00",
                    link: "https://by.belavia.by"
                },
                {
                    name: "Turkish Airlines",
                    price: "300$",
                    img: "img/Turkish-Airlines-Logo.png",
                    origin: "IEV",
                    destination: "BUD",
                    departureDateTime: "25.01.2019 19:00",
                    arrivalDateTime: "26.01.2019 10:00",
                    duration: "15:00",
                    link: "https://www.turkishairlines.com/"
                },
                {
                    name: "Singapore Airlines",
                    price: "400$",
                    img: "img/singaporeairlines.png",
                    origin: "IEV",
                    destination: "BUD",
                    departureDateTime: "25.01.2019 19:00",
                    arrivalDateTime: "26.01.2019 10:00",
                    duration: "15:00",
                    link: "https://www.singaporeair.com/"
                },
            ]
        }
    }

    renderFlights() {
        return this.state.flights.map(flight => {
            return (
                <Flight flight={flight}
                        key={flight.name + Math.random()}/>
            )
        })
    }

    render() {
        return (
            <div>
                <h5 className="display-4" align="center">Available Tickets</h5>
                <hr/>
                <div>
                    {this.renderFlights()}
                </div>
            </div>
        )
    }
}

ReactDOM.render(<FlightInfo/>, document.getElementById("root"))
