# IMEI Generator API - Ruby Gem

IMEI Generator creates valid International Mobile Equipment Identity (IMEI) numbers with proper Luhn checksum validation for mobile devices.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_imeigenerator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_imeigenerator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_imeigenerator'

# Initialize the client
client = APIVerve::Imeigenerator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  brand: "Samsung",
  count: 1
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ brand: "Samsung", count: 1 })
  puts response["data"]
rescue APIVerve::Imeigenerator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Imeigenerator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Imeigenerator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 2,
    "brand": "Samsung",
    "imeis": [
      {
        "imei": "358398048517203",
        "tac": "35839804",
        "manufacturer": "Samsung",
        "model": "Galaxy Xcover",
        "serial": "851720",
        "checksum": "3",
        "isValid": true
      },
      {
        "imei": "359040029448038",
        "tac": "35904002",
        "manufacturer": "Samsung",
        "model": "SGH-B130",
        "serial": "944803",
        "checksum": "8",
        "isValid": true
      }
    ]
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/imeigenerator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/imeigenerator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/imeigenerator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
