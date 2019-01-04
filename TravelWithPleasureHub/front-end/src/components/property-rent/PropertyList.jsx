import React, {Component} from 'react';
import PropertyThumbnail from "./PropertyThumbnail";

class PropertyList extends Component {
	constructor(props) {
		super(props);
		this.state = {
			properties: []
		};
		this.loadProperties = this.loadProperties.bind(this);
	}

	loadProperties = () => {
		fetch('http://localhost:8080/api/properties')
			.then(response => response.json())
			.then(properties => this.setState({properties : properties}))
	};

	componentWillMount() {
		this.loadProperties();
	}


	render() {
		return (
			<div className="container">
				<div className="p-3 bg-light text-white col">
					<div className="row justify-content-center">
						{
							this.state.properties.map(property =>
								<div className="col-4">
									<PropertyThumbnail key={property.id} id={property.id} title={property.title}
									                   price={property.price} />
								</div>
							)
						}
					</div>
				</div>
			</div>
		);
	}
}

export default PropertyList;