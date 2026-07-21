using System;
using System.Collections.Generic;
using System.Text;

namespace DataDictionary.Parser.Helpers
{
    public static class Helper
    {
        public static string ProcessString(string str)
        {
            if (string.IsNullOrEmpty(str))
            {
                throw new ArgumentException("Input string cannot be null or empty.", nameof(str));
            }
            // Remove the surrounding quotes
            if (str.Length >= 2 && str[0] == '"' && str[^1] == '"')
            {
                str = str.Substring(1, str.Length - 2);
            }
            // Replace escape characters - \", \\, \/, \b, \f, \n, \r, \t
            //str = str.Replace("\\\"", "\"")
            //   .Replace("\\\\", "\\")
            //   .Replace("\\/", "/")
            //   .Replace("\\b", "\b")
            //   .Replace("\\f", "\f")
            //   .Replace("\\n", "\n")
            //   .Replace("\\r", "\r")
            //   .Replace("\\t", "\t");
            // This does not work for edge case like \\n. That should be \n but it will be new line.
            // That is why this alghorithm is better:
            var sb = new StringBuilder(str.Length);
            for (int i = 0; i < str.Length; i++)
            {
                char c = str[i];
                if (c == '\\' && i + 1 < str.Length)
                {
                    char next = str[i + 1];
                    char? mapped = next switch
                    {
                        '"' => '"',
                        '\\' => '\\',
                        '/' => '/',
                        'b' => '\b',
                        'f' => '\f',
                        'n' => '\n',
                        'r' => '\r',
                        't' => '\t',
                        _ => (char?)null
                    };
                    if (mapped != null)
                    {
                        sb.Append(mapped.Value);
                        i++;     // skips char after '\', so it is not read again
                        continue;
                    }
                }
                sb.Append(c);
            }
            return sb.ToString();

        }
    }
}
