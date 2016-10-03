package com.dnsimple;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.dnsimple.response.ListTemplatesResponse;
import com.dnsimple.response.GetTemplateResponse;
import com.dnsimple.response.CreateTemplateResponse;
import com.dnsimple.response.UpdateTemplateResponse;
import com.dnsimple.response.DeleteTemplateResponse;

import com.dnsimple.exception.DnsimpleException;
import com.dnsimple.exception.ResourceNotFoundException;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;

/**
 * Provides access to the DNSimple Templates API.
 *
 * @see https://developer.dnsimple.com/v2/templates
 */
public class Templates {
  private Client client;

  protected Templates(Client client) {
    this.client = client;
  }

  /**
   * Lists the templates in the account.
   *
   * @see https://developer.dnsimple.com/v2/templates/#list
   *
   * @param accountId The account ID
   * @return The list templates response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public ListTemplatesResponse listTemplates(String accountId) throws DnsimpleException, IOException {
    return listTemplates(accountId, null);
  }

  /**
   * Lists the templates in the account.
   *
   * @see https://developer.dnsimple.com/v2/templates/#list
   *
   * @param accountId The account ID
   * @param options A Map of options to pass to the templates API
   * @return The list templates response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public ListTemplatesResponse listTemplates(String accountId, Map<String,Object> options) throws DnsimpleException, IOException {
    HttpResponse response = client.get(accountId + "/templates", options);
    return (ListTemplatesResponse)client.parseResponse(response, ListTemplatesResponse.class);
  }

  /**
   * Get a specific template associated to an account using the templates's ID.
   *
   * @see https://developer.dnsimple.com/v2/templates/#get
   *
   * @param accountId The account ID
   * @param contactId The template ID
   * @return The get template response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public GetTemplateResponse getTemplate(String accountId, String templateId) throws DnsimpleException, IOException {
    HttpResponse response = client.get(accountId + "/templates/" + templateId);
    return (GetTemplateResponse)client.parseResponse(response, GetTemplateResponse.class);
  }

  /**
   * Create a template in the account.
   *
   * @see https://developer.dnsimple.com/v2/templates/#create
   *
   * @param accountId The account ID
   * @param attributes A map of attributes to contruct the template
   * @return The create template response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public CreateTemplateResponse createTemplate(String accountId, Map<String,Object> attributes) throws DnsimpleException, IOException {
    HttpResponse response = client.post(accountId + "/templates", attributes);
    return (CreateTemplateResponse)client.parseResponse(response, CreateTemplateResponse.class);
  }

  /**
   * Update a template in the account.
   *
   * @see https://developer.dnsimple.com/v2/templates/#update
   *
   * @param accountId The account ID
   * @param contactId The template ID
   * @param attributes A map of attributes to update the template
   * @return The update template response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public UpdateTemplateResponse updateTemplate(String accountId, String templateId, Map<String,Object> attributes) throws DnsimpleException, IOException {
    HttpResponse response = client.patch(accountId + "/templates/" + templateId, attributes);
    return (UpdateTemplateResponse)client.parseResponse(response, UpdateTemplateResponse.class);
  }

  /**
   * Delete a template from the account.
   *
   * @see https://developer.dnsimple.com/v2/templates/#delete
   *
   * @param accountId The account ID
   * @param contactId The template ID
   * @return The delete template response
   * @throws DnsimpleException Any API errors
   * @throws IOException Any IO errors
   */
  public DeleteTemplateResponse deleteTemplate(String accountId, String templateId) throws DnsimpleException, IOException {
    HttpResponse response = client.delete(accountId + "/templates/" + templateId);
    return (DeleteTemplateResponse)client.parseResponse(response, DeleteTemplateResponse.class);
  }
}