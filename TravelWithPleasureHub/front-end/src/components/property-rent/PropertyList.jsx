import React, {Component} from 'react';
import PropertyThumbnail from "./PropertyThumbnail";
import {Link} from "react-router-dom";

class PropertyList extends Component {
	constructor(props) {
		super(props);
		this.state = {
			properties: [],
			locality: "",
			address: "",
			checkIn: "",
			checkOut: ""
		};
		this.loadProperties = this.loadProperties.bind(this);
		this.onFieldChange = this.onFieldChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.loadMatchingProperties = this.loadMatchingProperties.bind(this);
	}

	loadProperties = () => {
		fetch('http://localhost:8080/api/properties')
			.then(response => response.json())
			.then(properties => this.setState({properties : properties}))
	};

	onFieldChange = e => {
		this.setState( {[e.target.name]: e.target.value });
		console.log(this.state);
	};

	handleSubmit = e => {
		e.preventDefault();
		this.loadMatchingProperties();
	};

	loadMatchingProperties = () => {
		let formData = new FormData();
		formData.append('locality', this.state.locality);
		formData.append('address', this.state.address);
		formData.append('checkIn', this.state.checkIn);
		formData.append('checkOut', this.state.checkOut);
		fetch('http://localhost:8080/api/properties/search', {
			method: "POST",
			body: formData
		})
			.then(response => response.json())
			// .then(response => console.log(response))
			.then(properties => this.setState({properties : properties}))
	};

	componentWillMount() {
		this.loadProperties();
	}


	render() {
		return (
			<div className="container">
				<h2 className="ml-3 ">Search property you need!</h2>
				<form className="mt-2 ml-3" onSubmit={this.handleSubmit}>
					<div className="form-row">
						<div className="col">
							<label htmlFor="locality">Locality</label>
							<input type="text" className="form-control" placeholder="London" id="locality"
							       name="locality" onChange={this.onFieldChange} required/>
						</div>
						<div className="col">
							<label htmlFor="address">Address</label>
							<input type="text" className="form-control" placeholder="Main street" id="address"
							       name="address" onChange={this.onFieldChange}/>
						</div>
						<div className="col">
							<label htmlFor="check-in">Check in</label>
							<input type="date" className="form-control" id="check-in"
							       name="checkIn" onChange={this.onFieldChange}/>
						</div>
						<div className="col">
							<label htmlFor="check-out">Check out</label>
							<input type="date" className="form-control" id="check-out"
							       name="checkOut" onChange={this.onFieldChange}/>
						</div>
						<div className="d-flex flex-column">
							<button type="submit" className="btn btn-primary mt-auto">Submit</button>
						</div>
					</div>
				</form>
				<div className="p-3 text-white">
					<div className="row justify-content-center">
						{
							this.state.properties.map(property =>
								<div className="col-md-4">
									<PropertyThumbnail key={property.id} id={property.id} title={property.title}
									                   price={property.price} />
								</div>
							)
						}
					</div>
				</div>
				<div className="text-center">
					<Link to='/upload/property'>
						<button type="button" className="mt-5 btn btn-outline-primary w-75">Publish advert of your property</button>
					</Link>
				</div>

			</div>
		);
	}
}

export default PropertyList;