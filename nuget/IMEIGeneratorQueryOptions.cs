using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.IMEIGenerator
{
    /// <summary>
    /// Query options for the IMEI Generator API
    /// </summary>
    public class IMEIGeneratorQueryOptions
    {
        /// <summary>
        /// Filter by manufacturer brand (e.g., Samsung, Apple, Nokia)
        /// </summary>
        [JsonProperty("brand")]
        public string Brand { get; set; }

        /// <summary>
        /// Number of IMEIs to generate
        /// </summary>
        [JsonProperty("count")]
        public int? Count { get; set; }
    }
}
