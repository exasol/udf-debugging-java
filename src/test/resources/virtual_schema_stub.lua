-- A minimal Lua virtual schema that allows testing VS interaction.
local cjson = require("cjson");

function report_schema()
    return {
        schemaMetadata = {
            tables = {
                {
                    name = "THE_TABLE",
                    columns = {
                        {
                            name = "THE_VALUE",
                            dataType = {
                                type = "CHAR",
                                size = 9
                            }
                        }
                    }
                }
            }
        }
    }
end

function report_capabilities()
        return {
            capabilities = { "SELECTLIST_PROJECTION", "FILTER_EXPRESSIONS", "FN_PRED_EQUAL", "LITERAL_STRING" }
        }
end

function pushdown(request)
    if (request.filter == nil) then
        return {
            type = "select",
            sql = "SELECT 'Hello VS!'"
        }
    else
        return {
            type = "select",
            sql = "SELECT 'Hello VS!' FROM VS_SCHEMA.ORIGIN_TABLE WHERE THE_VALUE = 'something'"
        }
    end
end

function adapter_call(request_as_json)
    local request = cjson.decode(request_as_json)
    local response;
    if request.type == "createVirtualSchema" or request.type == "refresh" then
        response = report_schema()
    elseif request.type == "dropVirtualSchema" or request.type == "setProperties" then
        response = {}
    elseif request.type == "getCapabilities" then
        response = report_capabilities()
    elseif request.type == "pushdown" then
        response =  pushdown(request.pushdownRequest)
    else
        error("Unsupported adapter request: " .. (request.type or "'nil'"))
    end
    response.type = request.type
    return cjson.encode(response)
end