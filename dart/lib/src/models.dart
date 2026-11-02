/// Response models for the IMEI Generator API.

/// API Response wrapper.
class ImeigeneratorResponse {
  final String status;
  final dynamic error;
  final ImeigeneratorData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  ImeigeneratorResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory ImeigeneratorResponse.fromJson(Map<String, dynamic> json) => ImeigeneratorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ImeigeneratorData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the IMEI Generator API.

class ImeigeneratorData {
  num? count;
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
