declare module '@apiverve/imeigenerator' {
  export interface imeigeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface imeigeneratorResponse {
    status: string;
    error: string | null;
    data: IMEIGeneratorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface IMEIGeneratorData {
      count: number | null;
      brand: null | string;
      imeis: Imei[];
  }
  
  interface Imei {
      imei:         null | string;
      tac:          null | string;
      manufacturer: null | string;
      model:        null | string;
      serial:       null | string;
      checksum:     null | string;
      isValid:      boolean | null;
  }

  export default class imeigeneratorWrapper {
    constructor(options: imeigeneratorOptions);

    execute(callback: (error: any, data: imeigeneratorResponse | null) => void): Promise<imeigeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: imeigeneratorResponse | null) => void): Promise<imeigeneratorResponse>;
    execute(query?: Record<string, any>): Promise<imeigeneratorResponse>;
  }
}
