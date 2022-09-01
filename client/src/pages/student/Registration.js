function Registration() {
  return (
    <div className="col-8 offset-2">
      <form>
        <div className="row">
          <div className="mb-3 col-md-12">
            <label for="profilePic" className="form-label">
              Upload Profile Picture
            </label>
            <input className="form-control" type="file" id="profilePic" />
          </div>
        </div>

        <div className="row">
          <div className="mb-3 col-6">
            <label for="firstName" className="form-label">
              First Name
            </label>
            <input type="text" className="form-control" id="firstName" />
          </div>

          <div className="mb-3 col-6">
            <label for="lastName" className="form-label">
              Last Name
            </label>
            <input type="text" className="form-control" id="lastName" />
          </div>
        </div>

        <div className="row">
          <div className="mb-3 col-6">
            <label for="city" className="form-label">
              City
            </label>
            <select className="form-select" id="city">
              <option selected>Select</option>
              <option value="1">Fairfield</option>
              <option value="2">De Moinse</option>
              <option value="3">Berlinton</option>
            </select>
          </div>

          <div className="mb-3 col-6">
            <label for="state" className="form-label">
              State
            </label>
            <select className="form-select" id="city">
              <option selected>Select</option>
              <option value="1">Iowa</option>
              <option value="2">Vergina</option>
              <option value="3">Texas</option>
            </select>
          </div>

          <div className="mb-3 col-6">
            <label for="zip" className="form-label">
              Zip
            </label>
            <input type="number" className="form-control" id="zip" />
          </div>
        </div>

        <div className="row">
          <div className="mb-3 col-md-12">
            <label for="cvfile" className="form-label">
              Upload CV
            </label>
            <input className="form-control" type="file" id="cvfile" />
          </div>
        </div>

        <div className="row">
          <div className="mb-3 col-6">
            <label for="city" className="form-label">
              Major
            </label>
            <select className="form-select" id="city">
              <option selected>Select</option>
              <option value="1">Compro</option>
              <option value="2">MBA</option>
              <option value="3">MSD</option>
            </select>
          </div>

          <div className="mb-3 col-6">
            <label for="gpa" className="form-label">
              GPA
            </label>
            <input type="number" className="form-control" id="gpa" />
          </div>
        </div>

        <div className="row">
          <div className="col-md-12">
            <button type="submit" className="btn btn-primary float-end">
              Register
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default Registration;
