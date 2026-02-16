/// Response models for the IMEI Generator API.

/// API Response wrapper.
class ImeigeneratorResponse {
  final String status;
  final dynamic error;
  final ImeigeneratorData? data;

  ImeigeneratorResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory ImeigeneratorResponse.fromJson(Map<String, dynamic> json) => ImeigeneratorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ImeigeneratorData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the IMEI Generator API.

class ImeigeneratorData {
  int? count;
  String? brand;
  List<ImeigeneratorDataImeisItem>? imeis;

  ImeigeneratorData({
    this.count,
    this.brand,
    this.imeis,
  });

  factory ImeigeneratorData.fromJson(Map<String, dynamic> json) => ImeigeneratorData(
      count: json['count'],
      brand: json['brand'],
      imeis: (json['imeis'] as List?)?.map((e) => ImeigeneratorDataImeisItem.fromJson(e)).toList(),
    );
}

class ImeigeneratorDataImeisItem {
  String? imei;
  String? tac;
  String? manufacturer;
  String? model;
  String? serial;
  String? checksum;
  bool? isValid;

  ImeigeneratorDataImeisItem({
    this.imei,
    this.tac,
    this.manufacturer,
    this.model,
    this.serial,
    this.checksum,
    this.isValid,
  });

  factory ImeigeneratorDataImeisItem.fromJson(Map<String, dynamic> json) => ImeigeneratorDataImeisItem(
      imei: json['imei'],
      tac: json['tac'],
      manufacturer: json['manufacturer'],
      model: json['model'],
      serial: json['serial'],
      checksum: json['checksum'],
      isValid: json['isValid'],
    );
}

class ImeigeneratorRequest {
  String? brand;
  int? count;

  ImeigeneratorRequest({
    this.brand,
    this.count,
  });

  Map<String, dynamic> toJson() => {
      if (brand != null) 'brand': brand,
      if (count != null) 'count': count,
    };
}
