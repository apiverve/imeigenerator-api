declare module '@apiverve/imeigenerator' {
  export interface imeigeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface imeigeneratorResponse {
    status: string;
    error: string | null;
    data: IMEIGeneratorData;
    code?: number;
  }


  interface IMEIGeneratorData {
      count: number;
      brand: string;
      imeis: Imei[];
  }
  
  interface Imei {
      imei:         string;
      tac:          string;
      manufacturer: string;
      model:        string;
      serial:       string;
      checksum:     string;
      isValid:      boolean;
  }

  export default class imeigeneratorWrapper {
    constructor(options: imeigeneratorOptions);

    execute(callback: (error: any, data: imeigeneratorResponse | null) => void): Promise<imeigeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: imeigeneratorResponse | null) => void): Promise<imeigeneratorResponse>;
    execute(query?: Record<string, any>): Promise<imeigeneratorResponse>;
  }
}
