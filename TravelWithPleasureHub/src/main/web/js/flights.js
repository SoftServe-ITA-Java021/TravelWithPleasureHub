
function Flight(props) {
    return (
        <div className="container-fluid">
            <div className="container card">
                <div className="row text-center justify-content center">
                    <div className="col border">
                        <img className="img-fluid"
                             src={props.flight.img}
                             alt={props.flight.name}
                             width={210}
                             height={150}/>
                    </div>
                    <div className="col border">
                        <h5><p>{props.flight.origin}</p></h5>
                        <h5><p><b>{props.flight.departureDateTime}</b></p></h5>
                    </div>
                    <div className="col border">
                        <h5><p>Duration: <b>{props.flight.duration}</b></p></h5>
                        <h5><p><b>==============></b></p></h5>
                    </div>
                    <div className="col border">
                        <h5><p>{props.flight.destination}</p></h5>
                        <h5><p><b>{props.flight.arrivalDateTime}</b></p></h5>
                    </div>
                    <div className="col border">
                        <div className="price">
                            <div className="from"><h5>From</h5></div>
                            <div className="value">
                                <h5>{props.flight.price}</h5>
                            </div>
                        </div>
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
                <h2 align="center">Available Tickets</h2>
                <hr/>
                <div>
                    {this.renderFlights()}
                </div>
            </div>
        )
    }

   /* componentDidMount() {
        fetch('flights')
            .then(response => response.json())
            .then(state => this.setState({ state }));
    }*/
}

ReactDOM.render(<FlightInfo/>, document.getElementById("root"))




