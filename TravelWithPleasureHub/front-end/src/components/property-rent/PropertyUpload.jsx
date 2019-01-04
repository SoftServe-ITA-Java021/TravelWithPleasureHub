import React, {Component} from 'react';

class PropertyUpload extends Component {
	constructor(props) {
		super(props);
		this.state = {
			title: null,
			locality: null,
			address: null,
			price: null,
			description: null,
			photos: [],
			fileFormPlaceholder: "Choose photos"
		};
		this.handleFieldChange = this.handleFieldChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleFieldChange = (e) => {
		if (e.target.files) {
			let photos = Array.from(e.target.files);
			let photosNames = photos.map(photo => photo.name + " ");
			this.setState({
				photos: photos,
				fileFormPlaceholder: photosNames
			});
		} else
			this.setState({[e.target.name]: e.target.value});
	};

	handleSubmit = (e) => {
		e.preventDefault();
		let formData = new FormData();
		formData.append('title', this.state.title);
		formData.append('locality', this.state.locality);
		formData.append('address', this.state.address);
		formData.append('price', this.state.price);
		formData.append('description', this.state.description);
		for (let i = 0; i < this.state.photos.length; i++) {
			formData.append('photos', this.state.photos[i]);
		}
		fetch('http://localhost:8080/api/properties', {
			method: "POST",
			body: formData
		})
			.then(response => response.json())
			.then(response => console.log(response))
	};

	render() {
		return (
			<div className="container d-flex justify-content-center">
				<div className="w-75">
					<form onSubmit={this.handleSubmit}>
						<div className="form-group">
							<label htmlFor="property-title-input">Title</label>
							<input type="text" name="title" className="form-control" id="property-title-input" onChange={this.handleFieldChange}
							       placeholder="Flat on the shore"/>
						</div>
						<div className="form-group">
							<label htmlFor="address-input">Locality</label>
							<input type="text" name="locality" className="form-control" id="property-address-input" onChange={this.handleFieldChange}
							       placeholder="London"/>
						</div>
						<div className="form-group">
							<label htmlFor="address-input">Address</label>
							<input type="text" name="address" className="form-control" id="property-address-input" onChange={this.handleFieldChange}
							       placeholder="Main avenue 29"/>
						</div>
						<div className="form-group">
							<label htmlFor="address-input">Price($ per night)</label>
							<input type="number" name="price" className="form-control" id="property-address-input" onChange={this.handleFieldChange}
							       placeholder="200"/>
						</div>
						<div className="form-group">
							<label htmlFor="property-description-input">Description</label>
							<textarea className="form-control" name="description" id="property-description-input"
							          placeholder="Cool flat" onChange={this.handleFieldChange} />
						</div>
						<div className="form-group">
							<div className="custom-file">
								<label className="custom-file-label" htmlFor="property-photos-input">
									{this.state.fileFormPlaceholder}
								</label>
								<input type="file" name="photos" className="custom-file-input" id="property-photos-input"
								       multiple data-show-upload="true" onChange={this.handleFieldChange}/>
							</div>
						</div>
						<button className="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		);
	}
}

export default PropertyUpload;