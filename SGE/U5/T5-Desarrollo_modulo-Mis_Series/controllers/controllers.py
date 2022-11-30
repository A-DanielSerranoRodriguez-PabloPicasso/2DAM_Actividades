# -*- coding: utf-8 -*-
# from odoo import http


# class MisSeries(http.Controller):
#     @http.route('/mis_series/mis_series/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/mis_series/mis_series/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('mis_series.listing', {
#             'root': '/mis_series/mis_series',
#             'objects': http.request.env['mis_series.mis_series'].search([]),
#         })

#     @http.route('/mis_series/mis_series/objects/<model("mis_series.mis_series"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('mis_series.object', {
#             'object': obj
#         })
