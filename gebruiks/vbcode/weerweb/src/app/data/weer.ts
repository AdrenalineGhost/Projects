export class Weer {
  constructor(private _datum: string, private _temperatuur: number, private _vochtigheid: number, private _bewolkt: number,
              private _omschrijving: string, private _afbeelding: string) {
    this._datum = _datum;
    this._temperatuur = _temperatuur;
    this._vochtigheid = _vochtigheid;
    this._bewolkt = _bewolkt;
    this._omschrijving = _omschrijving;
    this._afbeelding = _afbeelding;
  }

  get afbeelding(): string {
    return this._afbeelding;
  }

  get omschrijving(): string {
    return this._omschrijving;
  }

  get bewolkt(): number {
    return this._bewolkt;
  }

  get vochtigheid(): number {
    return this._vochtigheid;
  }

  get temperatuur(): number {
    return this._temperatuur;
  }

  get datum(): string {
    return this._datum;
  }
}

